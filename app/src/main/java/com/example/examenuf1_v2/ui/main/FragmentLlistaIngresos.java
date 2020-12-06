package com.example.examenuf1_v2.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.examenuf1_v2.Classes.Ingres;
import com.example.examenuf1_v2.Classes.ViewModel_Ingresos;
import com.example.examenuf1_v2.R;

import java.util.List;


public class FragmentLlistaIngresos extends Fragment {


    private ViewModel_Ingresos vmIngresos;

    public FragmentLlistaIngresos() {
        // Required empty public constructor
    }

    public static FragmentLlistaIngresos newInstance() {
        FragmentLlistaIngresos fragment = new FragmentLlistaIngresos();
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
        //View
        View root = inflater.inflate(R.layout.fragment_llista_ingresos, container, false);

        //Recycler
        RecyclerView rv = (RecyclerView)root.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        final RVAdapter rva = new RVAdapter();
        rv.setAdapter(rva);

        //actualitzacio de dades
        final TextView resultat = root.findViewById(R.id.txt_result);
        vmIngresos.getIngresos().observe(this, new Observer<List<Ingres>>() {
            @Override
            public void onChanged(List<Ingres> ingres) {
                rva.updateList(ingres);

                //resultat d'ingresos
                int sum = 0;
                for(int i = 0; i < vmIngresos.getIngresos().getValue().size(); i++){
                    sum += vmIngresos.getIngresos().getValue().get(i).getCost();
                }
                resultat.setText(sum + "");
            }
        });





        //return
        return root;
    }

}
