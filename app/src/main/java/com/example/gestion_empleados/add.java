package com.example.gestion_empleados;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class add extends Fragment {

	Button bAtras, bAdd;
	EditText apellidoInput, departamentoInput, salarioInput;

	FragmentTransaction transaction;
	Fragment fragmentoMenu;

	Context context;

	public add() {
		// Required empty public constructor
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_add, container, false);
		transaction = getParentFragmentManager().beginTransaction();
		fragmentoMenu = new menu();
		context = container.getContext();
		bAdd = view.findViewById(R.id.botonAddInAdd);
		bAtras = view.findViewById(R.id.botonVolverInAdd);
		apellidoInput = view.findViewById(R.id.editTextApellidoInAdd);
		departamentoInput = view.findViewById(R.id.editTextDepartamentoInAdd);
		salarioInput = view.findViewById(R.id.editTextSalarioInAdd);

		setListeners(view);
		return view;
	}

	public void setListeners(View v) {
		bAdd.setOnClickListener(view -> addEmpleado(view));
		bAtras.setOnClickListener(view -> irMenu(view));
	}

	public void irMenu(View v) {
		transaction.replace(R.id.fragmentContainerView3, fragmentoMenu);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	private void addEmpleado(View v) {
		DataBaseEmpleados db = new DataBaseEmpleados(context);
        boolean success = db.addEmpleado(apellidoInput.getText().toString().trim(),
                departamentoInput.getText().toString().trim(),
                Double.parseDouble(salarioInput.getText().toString().trim()));
        if(success) {
			Toast.makeText(context, "Empleado añadido", Toast.LENGTH_SHORT).show();
		} else {
        	Toast.makeText(context, "Se ha producido un error", Toast.LENGTH_SHORT).show();
		}
	}
}