package com.sample.binding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;

import com.sample.binding.databinding.ActivityLiveDataBinding;

public class LiveDataActivity extends AppCompatActivity {
    private ActivityLiveDataBinding binding;
    private MutableLiveData<UserProfile> userProfileMutableLiveData = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLiveDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userProfileMutableLiveData.observe(this, new Observer<UserProfile>() {
            @Override
            public void onChanged(UserProfile userProfile) {
                binding.setUserProfile(userProfile);
            }
        });

        if (userProfileMutableLiveData.getValue() == null) {
            fetchUserData();
        }
    }

    private void fetchUserData() {
        UserProfile userProfile = new UserProfile();
        userProfile.name = "홍길동";
        userProfile.phone = "02) 1111-2222";
        userProfile.address = "서울시 강남구 대치동";
        userProfile.gender = UserProfile.GENDER_MALE;
        userProfileMutableLiveData.setValue(userProfile);
    }

    public void useMobilePhone(View view) {
        UserProfile userProfile = userProfileMutableLiveData.getValue();
        if (userProfile != null) {
            userProfile.phone = "010-1111-2222";
            userProfileMutableLiveData.setValue(userProfile);
        }
    }

    public void useOfficePhone(View view) {
        UserProfile userProfile = userProfileMutableLiveData.getValue();
        if (userProfile != null) {
            userProfile.phone = "02) 222-3333";
            userProfileMutableLiveData.setValue(userProfile);
        }
    }
}
