package com.acampdev.borisalexandrcamposrios.appone.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import com.acampdev.borisalexandrcamposrios.appone.Adapters.NotesAdapter;
import com.acampdev.borisalexandrcamposrios.appone.POJOS.Note;
import com.acampdev.borisalexandrcamposrios.appone.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment{

    RecyclerView recyclerView;
    List<Note> noteList;
    NotesAdapter adapter;
    FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_layout,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        initializedData();
        adapter = new NotesAdapter(getActivity().getApplicationContext(), noteList);
        recyclerView.setAdapter(adapter);

        fab= (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                final EditText editText= new EditText(getActivity());
                editText.setBackgroundColor(Color.GRAY);
                alert.setMessage("Add Element");
                alert.setTitle("Add Title");
                alert.setView(editText);

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public  void  onClick(DialogInterface dialogInterface, int i){
                        i=1;
                        noteList.add(new Note(i++, editText.getText().toString(),"Lo que sea"));
                        adapter.notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();

            }
        });
    }

    public void initializedData(){
        noteList = new ArrayList<>();
        noteList.add(new Note(1,"Inicial","Primeras cuotas para pago"));
        noteList.add(new Note(2,"Segunda Evaluación","Segunda Evaluación cuotas para pago"));
        noteList.add(new Note(3,"Resolución Pagos","Resolución Pagos imprimir documentos"));
        noteList.add(new Note(4,"Estados de Cuenta","Estados de Cuenta imprimir reportes"));
        noteList.add(new Note(5,"Registro de Deudas","Registro de Deudas impresion de movimientos y pagos"));
        noteList.add(new Note(6,"Inicial Auto","Primeras cuotas para pago"));
        noteList.add(new Note(7,"Inicial Departamento","Inicial Departamento imprimir cronograma cuotas para pago"));
        noteList.add(new Note(8,"Cancelación de Deuda","Cancelación de Deuda imprimir documentos de conclusion"));
        noteList.add(new Note(9,"Presentacion Informe","Presentacion Informe de ultimos proyectos"));
        noteList.add(new Note(10,"Tributación","Ultimos Pagos y recibos de no adeudos"));
        noteList.add(new Note(11,"Manejo de Errores","Manejo de Errores Reportes Mensuales en informes detallados"));
        noteList.add(new Note(12,"Nuevos Proyectos","Nuevos Proyectos folio web para mostrar mis habilidades"));
        noteList.add(new Note(13,"Viajes Constancia","Constancias de facturas y biaticos por viajes"));
        noteList.add(new Note(14,"Informe Celulares","Informe Celulares de gastos del mes detallados"));
        noteList.add(new Note(15,"Tasas Financiación","Tasas Financiación ultimas novedades y excelentes tasas acorde al mercado"));



    }
}
