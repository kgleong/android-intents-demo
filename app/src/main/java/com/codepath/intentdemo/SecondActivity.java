package com.codepath.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SecondActivity extends AppCompatActivity {

    private EditText etUserInput;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etUserInput = (EditText) findViewById(R.id.etName);
        String currentName = getIntent().getStringExtra(MainActivity.NAME);
        etUserInput.setText(currentName);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String updatedName = etUserInput.getText().toString();
            Intent intent = new Intent();
            intent.putExtra(MainActivity.NAME, updatedName);

            setResult(RESULT_OK, intent);
            finish();
            }
        });
    }
}
