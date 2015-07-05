package com.codepath.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    private EditText etUserInput;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etUserInput = (EditText) findViewById(R.id.etName);
        String message = getIntent().getStringExtra(MainActivity.NAME);
        etUserInput.setText(message);

        TextView tvPetNames = (TextView) findViewById(R.id.tvPetNames);
        Dog dog = getIntent().getParcelableExtra(MainActivity.DOG);
        Cat cat = (Cat) getIntent().getSerializableExtra(MainActivity.CAT);
        String petNames = "Dog name: " + dog.getName() + " Cat name: " + cat.getName();
        tvPetNames.setText(petNames);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String name = etUserInput.getText().toString();
            Intent intent = new Intent();
            intent.putExtra(MainActivity.NAME, name);

            setResult(RESULT_OK, intent);
            finish();
            }
        });
    }
}
