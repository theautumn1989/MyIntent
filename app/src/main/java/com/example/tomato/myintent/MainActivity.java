package com.example.tomato.myintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnNext;

    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWidget();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();

                if(name.equals("")){
                    Toast.makeText(MainActivity.this, "please input name !", Toast.LENGTH_SHORT).show();

                }else {
                    Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                    intent.putExtra(NAME, name);
                    startActivity(intent);
                }
            }
        });
    }

    private void setWidget() {
        etName = findViewById(R.id.et_name);
        btnNext = findViewById(R.id.btn_next);
    }
}
