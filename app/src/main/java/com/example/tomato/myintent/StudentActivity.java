package com.example.tomato.myintent;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgCalender;
    private TextView tvName, tvBirthday;
    private EditText etAddress, etClass, etCourse;
    private RadioButton rbtnMale, rbtnFemale;
    private Button btnSave;
    private boolean status = true;
    private Calendar calendar;

    public static final String PARCELABLE = "parcelable";
    public static final String BUNDLE = "bundle";
    public static final int REQUET_CODE = 1989;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        setWidget();
        setEvent();
        getData();
    }

    private void setEvent() {
        btnSave.setOnClickListener(this);
        imgCalender.setOnClickListener(this);
    }

    private void setWidget() {
        tvName = findViewById(R.id.tv_name);
        etAddress = findViewById(R.id.et_address);
        tvBirthday = findViewById(R.id.tv_birthday);
        etClass = findViewById(R.id.et_class);
        etCourse = findViewById(R.id.et_course);
        rbtnFemale = findViewById(R.id.rbtn_female);
        rbtnMale = findViewById(R.id.rbtn_male);
        btnSave = findViewById(R.id.btn_save);
        imgCalender = findViewById(R.id.img_calender);
    }

    private void getData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME);
        tvName.setText(name);
        // Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    private void setBirthday() {
        calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int mouth1 = calendar.get(Calendar.MONTH);
        int year1 = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // các thông số ở trên đã trả về các tham số ngày tháng năm
                calendar.set(year, month, dayOfMonth);    // phải có câu lệnh này không thì câu lệnh phía dưới mặc định trả về thời gian hiện tại
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                tvBirthday.setText(simpleDateFormat.format(calendar.getTime()));
                status = false;
            }
        }, year1, mouth1, date);

        datePickerDialog.show();
    }

    private void saveData() {
        String name = tvName.getText().toString();
        String address = etAddress.getText().toString();

        Boolean gender = false;
        if (rbtnMale.isChecked()) {
            gender = true;
        }
        String mclass = etClass.getText().toString();
        String course = etCourse.getText().toString();

        if(status  || address.equals("") || mclass.equals("") || course.equals("")){
            Toast.makeText(this, "Please input infomation student !", Toast.LENGTH_SHORT).show();
        }else {
            Date birthday = calendar.getTime();
            Student student = new Student(name, address, birthday, gender, mclass, course);
            Intent intent = new Intent(StudentActivity.this, StudentInforActivity.class);

            Bundle bundle = new Bundle();
            bundle.putParcelable(PARCELABLE, student);
            intent.putExtra(BUNDLE, bundle);

            startActivity(intent);
        }







    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_calender:
                setBirthday();
                break;
            case R.id.btn_save:
                saveData();
                break;
            default:
                break;
        }
    }


}
