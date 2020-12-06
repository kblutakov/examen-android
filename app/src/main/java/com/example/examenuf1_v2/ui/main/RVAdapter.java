package com.example.examenuf1_v2.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenuf1_v2.Classes.Ingres;
import com.example.examenuf1_v2.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ingresUnit> {

    public static class ingresUnit extends RecyclerView.ViewHolder {
        TextView cost;
        TextView descr;

        ingresUnit(View itemView) {
            super(itemView);
            descr = (TextView)itemView.findViewById(R.id.txt_ingr_descripcio);
            cost = (TextView)itemView.findViewById(R.id.txt_ingr_preu);
        }
    }

    @Override
    public void onBindViewHolder(ingresUnit iUnit, int i) {
        iUnit.descr.setText(ingresos.get(i).getDescripcio());
        iUnit.cost.setText(ingresos.get(i).getCost()+ " €");
    }

    @NonNull
    @Override
    public ingresUnit onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ingres_unit, viewGroup, false);
        ingresUnit iU = new ingresUnit(v);
        return iU;
    }

    List<Ingres> ingresos;
    RVAdapter(){
    }

    @Override
    public int getItemCount() {
        return ingresos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void updateList(List<Ingres> ingresos){
        this.ingresos = ingresos;
        notifyDataSetChanged();
    }
}
