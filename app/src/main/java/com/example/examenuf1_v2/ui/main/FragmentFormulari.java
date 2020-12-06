package com.example.examenuf1_v2.ui.main;

import android.net.Uri;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

import com.example.examenuf1_v2.Classes.*;
import com.example.examenuf1_v2.R;

public class FragmentFormulari extends Fragment {

    private ViewModel_Ingresos vmIngresos;

    public FragmentFormulari() {
        // Required empty public constructor
    }

    public static FragmentFormulari newInstance() {
        FragmentFormulari fragment = new FragmentFormulari();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vmIngresos = ViewModelProviders.of(getActivity()).get(ViewModel_Ingresos.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_formulari, container, false);

        final EditText descr = root.findViewById(R.id.input_descr);
        final EditText cost = root.findViewById(R.id.input_value);
        final Button desp = root.findViewById(R.id.btn_desp);
        final Button ingr = root.findViewById(R.id.btn_ingr);

        //onClick de despeses
        desp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "Falta omplir quantitat." ,Toast.LENGTH_SHORT);
                //afegir entitat
                Ingres temp = new Ingres();
                temp.setDescripcio(descr.getText().toString());
                //comprovar si hi ha preu
                if(!cost.getText().toString().equals("")){
                    temp.setCost(Integer.parseInt(cost.getText().toString())*-1);
                    vmIngresos.addIngres(temp);
                }else
                    toast.show();

                //afegir-la en View Model

            }
        });
        //onClick de ingresos
        ingr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "Falta omplir quantitat." ,Toast.LENGTH_SHORT);
                //afegir entitat
                Ingres temp = new Ingres();
                temp.setDescripcio(descr.getText().toString());
                //comprovar si hi ha preu
                if(!cost.getText().toString().equals("")){
                    temp.setCost(Integer.parseInt(cost.getText().toString()));
                    vmIngresos.addIngres(temp);
                }else
                    toast.show();
            }
        });
        return root;
    }
}
