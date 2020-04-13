package com.sample.binding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import com.sample.binding.databinding.ActivityViewModelBinding;

public class ViewModelActivity extends AppCompatActivity {
    private ActivityViewModelBinding binding;
    private UserProfileViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewModelBinding.inflate(getLayoutInflater());
        model = new ViewModelProvider(this).get(UserProfileViewModel.class);
        setContentView(binding.getRoot());

        model.getUserProfile().observe(this, new Observer<UserProfile>() {
            @Override
            public void onChanged(UserProfile userProfile) {
                binding.setUserProfile(userProfile);
            }
        });

        if (model.getUserProfile().getValue() == null) {
            fetchUserData();
        }
    }

    private void fetchUserData() {
        UserProfile userProfile = new UserProfile();
        userProfile.name = "홍길동";
        userProfile.phone = "02) 1111-2222";
        userProfile.address = "서울시 강남구 대치동";
        userProfile.gender = UserProfile.GENDER_MALE;
        model.getUserProfile().setValue(userProfile);
    }

    public void useMobilePhone(View view) {
        UserProfile userProfile = model.getUserProfile().getValue();
        if (userProfile != null) {
            userProfile.phone = "010-1111-2222";
            model.getUserProfile().setValue(userProfile);
        }
    }

    public void useOfficePhone(View view) {
        UserProfile userProfile = model.getUserProfile().getValue();
        if (userProfile != null) {
            userProfile.phone = "02) 222-3333";
            model.getUserProfile().setValue(userProfile);
        }
    }
}
