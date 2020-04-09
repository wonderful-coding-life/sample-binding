package com.sample.binding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sample.binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.noBinding.setOnClickListener(this);
        binding.viewBinding.setOnClickListener(this);
        binding.dataBinding.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.noBinding.getId()) {
            Intent intent = new Intent(this, NoBindingActivity.class);
            startActivity(intent);
        } else if (view.getId() == binding.viewBinding.getId()) {
            Intent intent = new Intent(this, ViewBindingActivity.class);
            startActivity(intent);
        } else if (view.getId() == binding.dataBinding.getId()) {
            Intent intent = new Intent(this, DataBindingActivity.class);
            startActivity(intent);
        }
    }
}
