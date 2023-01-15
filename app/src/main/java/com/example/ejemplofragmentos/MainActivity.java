package com.example.ejemplofragmentos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.ejemplofragmentos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        agregarTitulosFragment();
    }

    private void agregarTitulosFragment() {
        PlantillaTitulosFragment plantillaTitulosFragment = PlantillaTitulosFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .add(binding.contentFragment.getId(), plantillaTitulosFragment,
                        PlantillaTitulosFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}