package com.example.gestion_empleados;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class buscar extends Fragment {

    Button bAtras;
    FragmentTransaction transaction;
    Fragment fragmentoMenu;
    public buscar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buscar, container, false);
        bAtras = view.findViewById(R.id.botonAtrasInBuscar);
        fragmentoMenu = new menu();
        transaction = getParentFragmentManager().beginTransaction();
        setListeners(view);
        return view;
    }

    public void setListeners(View v) {
        bAtras.setOnClickListener(view -> irMenu(view));
    }

    public void irMenu(View v) {
        transaction.replace(R.id.fragmentContainerView3, fragmentoMenu);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}