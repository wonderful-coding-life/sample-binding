package com.sample.binding;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.sample.binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void showNoBinding(View view) {
        Intent intent = new Intent(this, NoBindingActivity.class);
        startActivity(intent);
    }

    public void showViewBinding(View view) {
        Intent intent = new Intent(this, ViewBindingActivity.class);
        startActivity(intent);
    }

    public void showDataBinding(View view) {
        Intent intent = new Intent(this, DataBindingActivity.class);
        startActivity(intent);
    }

    public void showLiveData(View view) {
        Intent intent = new Intent(this, LiveDataActivity.class);
        startActivity(intent);
    }
}
