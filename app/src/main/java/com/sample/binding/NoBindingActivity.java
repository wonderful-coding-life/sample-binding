package com.sample.binding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NoBindingActivity extends AppCompatActivity {

    private TextView nameView;
    private TextView phoneView;
    private TextView addressView;
    private TextView genderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_binding);

        nameView = findViewById(R.id.name);
        phoneView = findViewById(R.id.phone);
        addressView = findViewById(R.id.address);
        genderView = findViewById(R.id.gender);

        fetchUserData();
    }

    private void fetchUserData() {
        UserProfile userProfile = new UserProfile();
        userProfile.name = "홍길동";
        userProfile.phone = "02) 1111-2222";
        userProfile.address = "서울시 강남구 대치동";
        userProfile.gender = UserProfile.GENDER_MALE;

        updateUser(userProfile);
    }

    private void updateUser(UserProfile userProfile) {
        nameView.setText(userProfile.name);
        phoneView.setText(userProfile.phone);
        addressView.setText(userProfile.address);
        if (userProfile.gender == UserProfile.GENDER_MALE) {
            genderView.setText("남성");
        } else {
            genderView.setText("여성");
        }
    }
}
