package com.example.contactinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class PhoneActivity extends AppCompatActivity {

    String name, number;
    int radio = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        Button saveButton = findViewById(R.id.button_save);
        Button cancelButton = findViewById(R.id.button_cancel);

        EditText editText_Name = findViewById(R.id.editText_name);
        EditText editText_Phone_Number = findViewById(R.id.editText_phone_number);

        RadioGroup radioGroup = findViewById(R.id.radioGroup_gender);
        ImageView imageView = findViewById(R.id.imageView);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = editText_Name.getText().toString();
                String number = editText_Phone_Number.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("number", number);
                intent.putExtra("gender", radio);

                if ((name.equals("")) || (number.equals(""))) {
                    finish();
                } else {
                    setResult(RESULT_OK, intent);
                }
                finish();

            }
        });


        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radio_female) {
                    imageView.setImageResource(R.drawable.female);
                    radio = 2;
                } else if (checkedId == R.id.radio_male) {
                    imageView.setImageResource(R.drawable.male);
                    radio = 3;
                } else {
                    imageView.setImageResource(R.drawable.unspecified);
                    radio = 1;
                }
            }
        });
    }

    public void onBackPressed() {

    }

}