package com.example.ejemplofragmentos;

import android.os.Bundle;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import com.example.ejemplofragmentos.databinding.FragmentFiguratriviaBinding;

public class FiguratriviaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String name;
    private int choice; // opcion seleccionada

    private FragmentFiguratriviaBinding binding;

    public FiguratriviaFragment() {
        // Required empty public constructor
    }


    public static FiguratriviaFragment newInstance(String mName) {
        FiguratriviaFragment fragment = new FiguratriviaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFiguratriviaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String greeting = getString(R.string.greeting, name);
        binding.tvName.setText(greeting);

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radiobutton = binding.radioGroup.findViewById(checkedId);
                int index = binding.radioGroup.indexOfChild(radiobutton);
                switch (index) {
                    case 0:
                        choice = 0;
                        break;
                    case 1:
                        choice = 1;
                        break;
                    case 2:
                        choice = 2;
                        break;
                    case 3:
                        choice = 3;
                        break;
                    case 4:
                        choice = 4;
                        break;
                    default:
                        choice = 5;
                        break;
                }

            }
        });

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice == 2) {
                    irAlGanador(name);

                } else {
                    irAlPerdedor(name);
                }
            }
        });

    }


    private void irAlGanador(String name) {
        GanadorFragment ganadorFragment = GanadorFragment.newInstance(name);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment, ganadorFragment,
                GanadorFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }


    private void irAlPerdedor(String name) {
        PerdedorFragment perdedorFragment = PerdedorFragment.newInstance(name);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.content_fragment, perdedorFragment,
                PerdedorFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}