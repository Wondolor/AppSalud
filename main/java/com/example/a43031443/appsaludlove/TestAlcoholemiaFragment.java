package com.example.a43031443.appsaludlove;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 43445314 on 8/6/2018.
 */

public class TestAlcoholemiaFragment extends Fragment
{
    RadioButton radHombre;
    EditText ingPeso;
    Button btnIngresarBebidas;
    Button btnVolverAlcohol1;
    int Peso;
    Spinner Edad;
    ArrayList<String> Edades;
    MainActivity ActividadAnfitriona;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        View VistaADevolver;
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.fragment_test_alcoholemia, GrupoDeLaVista, false);

        radHombre = (RadioButton) VistaADevolver.findViewById(R.id.radHombre);
        ingPeso = (EditText) VistaADevolver.findViewById(R.id.ingPeso);
        Peso = Integer.parseInt(ingPeso.getText().toString());
        btnIngresarBebidas = (Button) VistaADevolver.findViewById(R.id.btnIngresarBebidas);
        btnVolverAlcohol1 = (Button) VistaADevolver.findViewById(R.id.btnVolverAlcohol1);
        Edad = (Spinner) VistaADevolver.findViewById(R.id.Edad);

        Edades = new ArrayList<>();
        int i = 13;
        while (i < 100)
        {
            Edades.add("'" +i+ "'");
            i++;
        }

        ArrayAdapter<String> Adaptador;
        Adaptador = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, Edades);
        Adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        Edad.setAdapter(Adaptador);

        //PrimerBoton
        btnIngresarBebidas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            ActividadAnfitriona = (MainActivity) getActivity();
            ActividadAnfitriona.DatosAlcoholemia1(Peso, radHombre.isChecked());
            }
        });
        //SegundoBoton
        btnVolverAlcohol1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
            }
        });

        return VistaADevolver;
    }

}
