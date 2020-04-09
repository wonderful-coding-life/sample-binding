package com.sample.binding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sample.binding.databinding.ActivityViewBindingBinding;

public class ViewBindingActivity extends AppCompatActivity {

    private ActivityViewBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBindingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        binding.name.setText(userProfile.name);
        binding.phone.setText(userProfile.phone);
        binding.address.setText(userProfile.address);
        if (userProfile.gender == UserProfile.GENDER_MALE) {
            binding.gender.setText("남성");
        } else {
            binding.gender.setText("여성");
        }
    }
}
