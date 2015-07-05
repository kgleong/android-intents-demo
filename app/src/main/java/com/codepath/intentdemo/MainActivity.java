package com.codepath.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "name";
    private static final int SET_NAME_REQUEST = 1;
    public static final String CAT = "cat";
    public static final String DOG = "dog";

    private Button btnSetName;
    private TextView tvName;
    private Button btnBrowse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(R.id.tvName);

        btnSetName = (Button) findViewById(R.id.btnSetName);
        btnSetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(NAME, tvName.getText());
                // startActivity(intent);
                Dog dog = new Dog("Fido");
                Cat cat = new Cat("Mimi");

                intent.putExtra(DOG, dog);
                intent.putExtra(CAT, cat);

                startActivityForResult(intent, SET_NAME_REQUEST);
            }
        });

        btnBrowse = (Button) findViewById(R.id.btnBrowse);
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.randomdoggiegenerator.com"));

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SET_NAME_REQUEST) {
            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra(NAME);

                tvName.setText(name);
            }
        }
    }
}
