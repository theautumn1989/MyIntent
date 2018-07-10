package com.example.tomato.myintent;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Student implements Parcelable {
    private String mName;
    private String mAddress;
    private Date mBirthday;
    private Boolean mGender;
    private String mClass;
    private String mCourse;

    public Student(String mName, String mAddress, Date mBirthday, Boolean mGender, String mClass, String mCourse) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mBirthday = mBirthday;
        this.mGender = mGender;
        this.mClass = mClass;
        this.mCourse = mCourse;
    }


    protected Student(Parcel in) {
        mName = in.readString();
        mAddress = in.readString();

        byte tmpMGender = in.readByte();
        mGender = tmpMGender == 0 ? null : tmpMGender == 1;
        mClass = in.readString();
        mCourse = in.readString();

        mBirthday = new Date(in.readLong());
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public Date getmBirthday() {
        return mBirthday;
    }

    public void setmBirthday(Date mBirthday) {
        this.mBirthday = mBirthday;
    }

    public Boolean getmGender() {
        return mGender;
    }

    public void setmGender(Boolean mGender) {
        this.mGender = mGender;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    public String getmCourse() {
        return mCourse;
    }

    public void setmCourse(String mCourse) {
        this.mCourse = mCourse;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mAddress);
        parcel.writeByte((byte) (mGender == null ? 0 : mGender ? 1 : 2));
        parcel.writeString(mClass);
        parcel.writeString(mCourse);

        parcel.writeLong(mBirthday.getTime());
    }
}
