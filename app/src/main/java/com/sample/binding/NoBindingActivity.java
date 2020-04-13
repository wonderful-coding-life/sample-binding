package com.sample.binding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

/**
 * 일반적으로 데이터를 화면에 표시하는 절차는
 * 1. 각 항목을 표시할 뷰객체의 레퍼런스를 클래스에 선언하고, onCreate 내에서 findViewById로 객체를 레퍼런스에 설정한다
 * 2. 데이터가 준비되면 각 항목별 뷰객체의 레퍼런스를 가지고 setText등응ㄹ 통해 값을 설정한다
 *
 * Here is the general process to display information
 * 1. Declare references in class for each information and assign view object by using findViewById onCreate
 * 2. After fetch information, set value for each information by using setText, etc.
 */

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
