package com.sample.binding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sample.binding.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {
    private ActivityDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataBindingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fetchUserData();
    }

    private void fetchUserData() {
        UserProfile userProfile = new UserProfile();
        userProfile.name = "홍길동";
        userProfile.phone = "02) 1111-2222";
        userProfile.address = "서울시 강남구 대치동";
        userProfile.gender = UserProfile.GENDER_MALE;

        binding.setUserProfile(userProfile);
    }
}
