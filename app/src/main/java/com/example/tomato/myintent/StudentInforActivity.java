package com.example.tomato.myintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StudentInforActivity extends AppCompatActivity {

    TextView tvName, tvAddress, tvBirthday, tvGender, tvClass, tvCourse;
    Student student;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_infor);

        setWidget();
        getData();
    }

    private void setWidget() {
        tvName = findViewById(R.id.tv_name);
        tvAddress = findViewById(R.id.tv_address);
        tvBirthday = findViewById(R.id.tv_birthday);
        tvGender = findViewById(R.id.tv_gender);
        tvClass = findViewById(R.id.tv_class);
        tvCourse = findViewById(R.id.tv_course);
    }

    public void getData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(StudentActivity.BUNDLE);
        student = bundle.getParcelable(StudentActivity.PARCELABLE);
        if(student != null){
            tvName.setText(tvName.getText().toString()+"    "+student.getmName().toString());
            tvAddress.setText(tvAddress.getText().toString()+"    "+student.getmAddress().toString());

           Date date = student.getmBirthday();

           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
           String birthday = simpleDateFormat.format(date.getTime()).toString();

           tvBirthday.setText(tvBirthday.getText().toString()+"    "+birthday);

         //   Toast.makeText(this, date+"", Toast.LENGTH_SHORT).show();

            Boolean gender = student.getmGender();
            String textGender="";
            if(gender){
                textGender = "nam";
            }else {
                textGender = "nữ";
            }
            tvGender.setText(tvGender.getText().toString()+"    "+textGender);
            tvClass.setText(tvClass.getText().toString()+"    "+student.getmClass().toString());
            tvCourse.setText(tvCourse.getText().toString()+"    "+student.getmCourse().toString());
        }
    }
}
