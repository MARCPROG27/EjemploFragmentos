package com.example.ejemplofragmentos;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ejemplofragmentos.databinding.FragmentPerdedorBinding;


public class PerdedorFragment extends Fragment {

    FragmentPerdedorBinding Mbinding;
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    public PerdedorFragment() {
        // Required empty public constructor
    }


    public static PerdedorFragment newInstance(String param1) {
        PerdedorFragment fragment = new PerdedorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Mbinding = FragmentPerdedorBinding.inflate(inflater, container, false);
        View view = Mbinding.getRoot();

        String try_again_msg = getString(R.string.try_again_msg, mParam1);
        Mbinding.trayAgainTv.setText(try_again_msg);


        Mbinding.tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}