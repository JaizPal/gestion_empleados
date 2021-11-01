package com.example.gestion_empleados;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Modificar extends Fragment {

    Button bAtras;
    Button bModificar;
    FragmentTransaction transaction;
    Fragment fragmentoMenu;

    public Modificar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modificar, container, false);
        fragmentoMenu = new Menu();
        transaction = getParentFragmentManager().beginTransaction();

        bAtras = view.findViewById(R.id.botonVolverInModificar);


        setListeners(view);

        return view;
    }

    public void setListeners(View v) {
        bAtras.setOnClickListener(view1 -> irMenu(v));
    }

    public void irMenu(View v) {
        transaction.replace(R.id.fragmentContainerView3, fragmentoMenu);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}