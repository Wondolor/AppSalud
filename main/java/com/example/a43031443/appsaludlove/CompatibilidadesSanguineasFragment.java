package com.example.a43031443.appsaludlove;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 43031443 on 8/6/2018.
 */

public class CompatibilidadesSanguineasFragment extends Fragment {

    Spinner ingPrimerValor;
    RadioButton radPositivoUno;
    RadioButton radDonar;
    Spinner ingSegundoValor;
    RadioButton radPositivoDos;
    Button btnCalcularCompatibilidad;
    Button btnVolverCompatibilidadesSanguineas;
    TextView MostrarRespuesta;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        View VistaADevolver;
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.fragment_compatibilidades_sanguineas, GrupoDeLaVista, false);

        ingPrimerValor = (Spinner) VistaADevolver.findViewById(R.id.ingPrimerValor);
        radPositivoUno = (RadioButton) VistaADevolver.findViewById(R.id.radPositivo1);
        radDonar = (RadioButton) VistaADevolver.findViewById(R.id.radDonar);
        ingSegundoValor = (Spinner) VistaADevolver.findViewById(R.id.ingSegundoValor);
        radPositivoDos = (RadioButton) VistaADevolver.findViewById(R.id.radPositivo2);
        btnCalcularCompatibilidad = (Button) VistaADevolver.findViewById(R.id.btnCalcularCompatibilidad);
        btnVolverCompatibilidadesSanguineas = (Button) VistaADevolver.findViewById(R.id.btnVolverCompatibilidadesSanguineas);
        MostrarRespuesta = (TextView) VistaADevolver.findViewById(R.id.txtMostrarCompatibilidad);

        String[] PrimerValor = {"A", "B", "AB", "0"};
        ingPrimerValor.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, PrimerValor));

        String[] SegundoValor = {"A", "B", "AB", "0"};
        ingSegundoValor.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, SegundoValor));

        //PrimerBoton
        btnCalcularCompatibilidad.setOnClickListener(btnCalcularCompatibilidad_Click);
        //SegundoBoton
        btnVolverCompatibilidadesSanguineas.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
            }
        });

        return VistaADevolver;
    }

    private View.OnClickListener btnCalcularCompatibilidad_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {

            //Obtenemos el valor del primer spinner
            String PrimerValor = ingPrimerValor.getSelectedItem().toString();

            //Obtenemos el valor del segundo spinner
            String SegundoValor = ingSegundoValor.getSelectedItem().toString();

            //Averiguamos si el primer valor es positivo
            boolean Positividad1 = radPositivoUno.isChecked();


            //Averiguamos si el segundo valor es positivo
            boolean Positividad2 = radPositivoDos.isChecked();

            //Averiguamos si quiere donar o no
            boolean Donacion = radDonar.isChecked();



            boolean Respuesta = false;

            if(Donacion == true) {

                if (Positividad1 == true)
                {
                    switch (PrimerValor)
                    {
                        case "A": //PRIMER VALOR: A+
                            if (Positividad2 == true)
                            {
                                switch (SegundoValor) {
                                    case "A":
                                        Respuesta = true; //SI
                                        break;

                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            break;
                        case "B": //PRIMER VALOR: B+
                            if (Positividad2 == true) {
                                switch (SegundoValor) {
                                    case "B":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            break;
                        case "AB": //PRIMER VALOR: AB+
                            if (Positividad2 == true)
                            {
                                switch (SegundoValor)
                                {
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            break;
                        case "0": //PRIMER VALOR: 0+
                            if (Positividad2 == true)
                            {
                                switch (SegundoValor) {
                                    case "A":
                                        Respuesta = true; //SI
                                        break;
                                    case "B":
                                        Respuesta = true; //SI
                                        break;
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                    case "0":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            break;
                    }

                }
                else
                {
                    switch (PrimerValor) {
                        case "A": //PRIMER VALOR: A-
                            if (Positividad2 == true)
                            {
                                switch (SegundoValor)
                                {
                                    case "A":
                                        Respuesta = true; //SI
                                        break;
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            else
                            {
                                switch (SegundoValor)
                                {
                                    case "A":
                                        Respuesta = true; //SI
                                        break;
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                }
                                break;
                            }
                            break;
                        case "B": //PRIMER VALOR: B-
                            if (Positividad2 == true)
                            {
                                switch (SegundoValor)
                                {
                                    case "B":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            else
                            {
                                switch (SegundoValor) {
                                    case "B":
                                        Respuesta = true; //SI
                                        break;
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            break;
                        case "AB": //PRIMER VALOR: AB-
                            if (Positividad2 == true)
                            {
                                switch (SegundoValor)
                                {
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            else
                            {
                                switch (SegundoValor)
                                {
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            break;
                        case "0": //PRIMER VALOR: 0-
                            if (Positividad2 == true) {
                                switch (SegundoValor) {
                                    case "A":
                                        Respuesta = true; //SI
                                        break;
                                    case "B":
                                        Respuesta = true; //SI
                                        break;
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                    case "0":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            else
                            {
                                switch (SegundoValor) {
                                    case "A":
                                        Respuesta = true; //SI
                                        break;
                                    case "B":
                                        Respuesta = true; //SI
                                        break;
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                    case "0":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            break;
                    }

                }
                if (Respuesta == true)
                {
                    MostrarRespuesta.setText("Puede donar");

                }
                else
                {
                    MostrarRespuesta.setText("No puede donar");
                }
            }
            else
            {

                if (Positividad1 == true)
                {
                    switch (PrimerValor)
                    {
                        case "A": //PRIMER VALOR: A+
                            if (Positividad2 == true)
                            {
                                switch (SegundoValor) {
                                    case "A":
                                        Respuesta = true; //SI
                                        break;
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                    case "0":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            else
                            {
                                switch (SegundoValor) {
                                    case "A":
                                        Respuesta = true; //SI
                                        break;
                                    case "0":
                                        Respuesta = true; //SI
                                        break;
                                }
                                break;
                            }
                            break;
                        case "B": //PRIMER VALOR: B+
                            if (Positividad2 == true) {
                                switch (SegundoValor) {
                                    case "B":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "0":
                                        Respuesta = true;
                                        break; //SÍ
                                }
                            }
                            else
                            {
                                switch (SegundoValor) {
                                    case "B":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "0":
                                        Respuesta = true;
                                        break; //SÍ
                                }
                            }
                            break;
                        case "AB": //PRIMER VALOR: AB+
                            if (Positividad2 == true) {
                                switch (SegundoValor) {
                                    case "A":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "B":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                    case "0":
                                        Respuesta = true;
                                        break; //SÍ
                                }
                            }
                            else
                            {
                                switch (SegundoValor) {
                                    case "A":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "B":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "AB":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "0":
                                        Respuesta = true;
                                        break; //SÍ
                                }
                            }
                            break;
                        case "0": //PRIMER VALOR: 0+
                            if (Positividad2 == true)
                            {
                                switch (SegundoValor)
                                {
                                    case "0":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            else
                            {
                                switch (SegundoValor)
                                {
                                    case "0":
                                        Respuesta = true;
                                        break; //SÍ
                                }
                            }
                            break;
                    }

                }
                else
                {
                    switch (PrimerValor) {
                        case "A": //PRIMER VALOR: A-
                            if (Positividad2 == false)
                            {
                                switch (SegundoValor)
                                {
                                    case "A":
                                        Respuesta = true; //SI
                                        break;
                                    case "0":
                                        Respuesta = true;
                                        break; //SÍ
                                }
                            }
                            break;
                        case "B": //PRIMER VALOR: B-
                            if (Positividad2 == false)
                            {
                                switch (SegundoValor) {
                                    case "B":
                                        Respuesta = true; //SI
                                        break;
                                    case "0":
                                        Respuesta = true;
                                        break; //SÍ
                                }
                            }
                            break;
                        case "AB": //PRIMER VALOR: AB-
                            if (Positividad2 == false)
                            {
                                switch (SegundoValor)
                                {
                                    case "A":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "B":
                                        Respuesta = true;
                                        break; //SÍ
                                    case "AB":
                                        Respuesta = true; //SI
                                        break;
                                    case "0":
                                        Respuesta = true;
                                        break; //SÍ
                                }
                            }
                            break;
                        case "0": //PRIMER VALOR: 0-
                            if (Positividad2 == false)
                            {
                                switch (SegundoValor)
                                {
                                    case "0":
                                        Respuesta = true; //SI
                                        break;
                                }
                            }
                            break;
                    }

                }
                if (Respuesta == true)
                {
                    MostrarRespuesta.setText("Puede recibir");
                }
                else
                {
                    MostrarRespuesta.setText("No puede recibir");
                }
            }

        }
    };


}