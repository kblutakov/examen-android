package com.example.examenuf1_v2.Classes;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.examenuf1_v2.Classes.Ingres;

import java.util.ArrayList;
import java.util.List;

public class ViewModel_Ingresos extends ViewModel {

    MutableLiveData<List<Ingres>> ingresos = new MutableLiveData<List<Ingres>>();

    public LiveData<List<Ingres>>getIngresos(){
        return ingresos;
    }

    public void setIngresos(List<Ingres> ingresos) {
        this.ingresos.setValue(ingresos);
    }

    public void addIngres(Ingres ingr){
        ArrayList<Ingres> temp = (ArrayList) ingresos.getValue();
        temp.add(ingr);
        ingresos.setValue(temp);
    }
}