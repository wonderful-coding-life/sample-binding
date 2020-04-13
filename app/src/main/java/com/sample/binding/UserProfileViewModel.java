package com.sample.binding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {
    private MutableLiveData<UserProfile> userProfileMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<UserProfile> getUserProfile() {
        return userProfileMutableLiveData;
    }
}
