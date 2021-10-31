package com.example.gestion_empleados;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ver extends Fragment {

    Button bAtras;
    Button bUnoAuno;
    Button bTodos;
    FragmentTransaction transaction;
    Fragment fragmentoMenu;

    public ver() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_ver, container, false);
        fragmentoMenu = new menu();
        transaction = getParentFragmentManager().beginTransaction();
        bAtras = vista.findViewById(R.id.botonAtrasInVer);


        bUnoAuno = vista.findViewById(R.id.botonUnoAuno);

        bTodos = vista.findViewById(R.id.botonTodos);
        setListeners(vista);
        return vista;
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