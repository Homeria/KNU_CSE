package com.example.counting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    Thread serviceThread;
    boolean serviceIsRunning;
    boolean serviceIsFirst;
    boolean serviceIsInterrupted;

    Thread countThread;
    boolean countIsRunning;
    boolean countIsFirst;
    boolean countIsInterrupted;

    boolean hasText;

    int serviceInterval;
    int countInterval;
    int count;
    String editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = "";

        serviceInterval = 0;
        serviceIsRunning = false;
        serviceIsFirst = true;
        serviceIsInterrupted = false;

        countInterval = 0;
        count = 0;
        countIsRunning = false;
        countIsFirst = true;
        countIsInterrupted = false;

        findViewById(R.id.btn_ServiceOn).setOnClickListener(v -> {

            serviceInterval = getCheckedRadioButton();
            editText = getEditText();
            hasText = editTextHasText();
            count = 0;


            if(!serviceIsRunning) {
                Log.d(TAG, "Start Service");
            }
            if(serviceIsFirst) {
                serviceIsFirst = false;
                serviceIsRunning = true;
                serviceThread = new Thread(()-> {
                    try {
                        while(true){
                            if(hasText) {
                                Log.d(TAG, "Content = " + editText + ", interval = " + serviceInterval + "ms");
                            }
                            Thread.sleep(serviceInterval);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                serviceThread.start();
            } else {
                serviceIsRunning = true;
                if(serviceIsInterrupted) {
                    serviceIsInterrupted = false;
                    serviceThread = new Thread(()-> {
                        try {
                            while(true){
                                if(hasText) {
                                    Log.d(TAG, "Content = " + editText + ", interval = " + serviceInterval + "ms");
                                    Thread.sleep(serviceInterval);
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    serviceThread.start();
                }
            }
        });

        findViewById(R.id.btn_ServiceOff).setOnClickListener(v -> {
            if(serviceIsRunning) {
                Log.d(TAG, "Stop Service");
                serviceIsRunning = false;
                if(hasText) {
                    if(countIsRunning) {
                        countIsRunning = false;
                        countThread.interrupt();
                        countIsInterrupted = true;
                    }
                    serviceThread.interrupt();
                    serviceIsInterrupted = true;
                }
            }
        });


        findViewById(R.id.btn_CountOn).setOnClickListener(v -> {

            if(serviceIsRunning) {

                countInterval = getCheckedRadioButton();

                if(countIsFirst) {
                    countIsFirst = false;
                    countIsRunning = true;
                    countThread = new Thread(()-> {
                        try {
                            while(true){
                                Log.d(TAG, "Count = " + count + ", interval = " + countInterval + "ms");
                                count++;
                                Thread.sleep(countInterval);

                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    countThread.start();
                } else {
                    count = 0;
                    countIsRunning = true;
                    if (countIsInterrupted) {
                        countIsInterrupted = false;
                        countThread = new Thread(() -> {
                            try {
                                while (true) {
                                    Log.d(TAG, "Count = " + count + ", interval = " + countInterval + "ms");
                                    count++;
                                    Thread.sleep(countInterval);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                        countThread.start();
                    }
                }
            }


        });

        findViewById(R.id.btn_CountOff).setOnClickListener(v -> {
            if(countIsRunning) {
                countIsRunning = false;
                countThread.interrupt();
                countIsInterrupted = true;
            }
        });



    }

    private boolean editTextHasText() {
        String text = getEditText();
        if(text.length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    private String getEditText() {
        EditText textEdit = findViewById(R.id.textEdit);
        return textEdit.getText().toString();
    }


    private int getCheckedRadioButton() {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radio_100: return 100;
            case R.id.radio_300: return 300;
            case R.id.radio_500: return 500;
            case R.id.radio_1000: return 1000;
            default: return -1;
        }
    }

}