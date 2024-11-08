package com.example.kizhapkinzadanie6;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kizhapkinzadanie6.databinding.ActivityMain4Binding;
import com.example.kizhapkinzadanie6.databinding.ActivityMain5Binding;

public class MainActivity5 extends AppCompatActivity {

    ActivityMain5Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        replaceFragment(new HomeFragment());
        View bottomNav2 = findViewById(R.id.btv2);
        binding.btv2.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home_menu) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.receipt_menu) {
                replaceFragment(new ReceiptFragment());
            } else if (item.getItemId() == R.id.profile_menu) {
                replaceFragment(new ProfileFragment());
            } else if (item.getItemId() == R.id.favorites_menu) {
                replaceFragment(new FavoritesFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl2, fragment).commit();
    }
}