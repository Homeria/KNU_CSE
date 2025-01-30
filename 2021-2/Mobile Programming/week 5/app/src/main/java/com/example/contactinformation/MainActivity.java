package com.example.contactinformation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.button);
        Button exitButton = findViewById(R.id.button_exit);

        container = findViewById(R.id.contact_linearLayout);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addContact(v);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showExitMessage();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU) {

            if (resultCode == RESULT_OK) {

                String name = data.getStringExtra("name");
                String number = data.getStringExtra("number");
                int radio = data.getIntExtra("gender", 1);

                ViewGroup container = findViewById(R.id.contact_linearLayout);
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.phone_info, container, false);

                ImageView viewGroupImageView = viewGroup.findViewById(R.id.imageView);
                TextView viewGroupName = viewGroup.findViewById(R.id.textView_name);
                TextView viewGroupNumber = viewGroup.findViewById(R.id.textView_phone_number);
                Button callButton = viewGroup.findViewById(R.id.button_call);

                if (radio == 3) {
                    viewGroupImageView.setImageResource(R.drawable.male);
                } else if (radio == 2) {
                    viewGroupImageView.setImageResource(R.drawable.female);
                } else {
                    viewGroupImageView.setImageResource(R.drawable.unspecified);
                }

                viewGroupName.setText(name);
                viewGroupNumber.setText(number);

                callButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + number));
                        startActivity(intent);
                    }
                });
                container.addView(viewGroup);
            }
        }
    }

    protected void addContact(View v) {
        Intent intent = new Intent(this, PhoneActivity.class);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }


    private void showExitMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Would like to exit the App?");
        builder.setPositiveButton("YES, EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("NO, CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onBackPressed() {

    }


}