package com.example.ejemplofragmentos;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.ejemplofragmentos.databinding.FragmentPlantillaTitulosBinding;


public class PlantillaTitulosFragment extends Fragment {

    private FragmentPlantillaTitulosBinding binding;

    public PlantillaTitulosFragment() {
        // Required empty public constructor
    }

    public static PlantillaTitulosFragment newInstance() {
        PlantillaTitulosFragment fragment = new PlantillaTitulosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPlantillaTitulosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.etPerson.getText().toString().isEmpty()) {
                    agregarFiguratriviaFragment(binding.etPerson.getText().toString());
                } else {
                    Toast.makeText(getContext(), "Debes escribir un mensaje",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void agregarFiguratriviaFragment(String name) {
        FiguratriviaFragment figuraTriviaFragment = FiguratriviaFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, figuraTriviaFragment,
                        FiguratriviaFragment.class.getSimpleName())
                .addToBackStack(null);
        fragmentTransaction.commit();
    }

}
