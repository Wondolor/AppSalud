package com.example.a43031443.appsaludlove;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 43445314 on 8/6/2018.
 */

public class TestAlcoholemia2Fragment extends Fragment {

    boolean Sexo;
    int Peso;
    Spinner TipoBebida;
    Spinner MedidaBebida;
    Spinner CantidadBebida;
    Button btnCalcularAlcohol;
    TextView Respuesta;
    Button btnVolverAlcohol1;
    Double Graduacion;
    Double Mililitros;
    int Cantidad;
    Double GramosAlcohol;
    Double BAC;
    Double ConstanteSexo;
    String Conduccion;
    ArrayList<String> CantidadBebidaArray;
    int i;
    String CantidadBebidaValor;
    String MedidaBebidaValor;
    String TipoBebidaValor;
    String ValorMedidaBebida;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos) {
        Log.d ("TestAlcoholemia2Frag", "Comienza el onCreate");

        Log.d ("TestAlcoholemia2Frag", "Declaro la variable que tendra la vista");
        View VistaADevolver;
        Log.d ("TestAlcoholemia2Frag", "Le asigno el layout inflado");
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.fragment_test_alcoholemia_2, GrupoDeLaVista, false);


        Log.d ("TestAlcoholemia2Frag", "Referencio sus elementos");
        TipoBebida = (Spinner) VistaADevolver.findViewById(R.id.TipoBebida);
        CantidadBebida = (Spinner) VistaADevolver.findViewById(R.id.CantidadBebida);
        MedidaBebida = (Spinner) VistaADevolver.findViewById(R.id.MedidaBebida);
        btnCalcularAlcohol = (Button) VistaADevolver.findViewById(R.id.btnCalcularAlcohol);
        btnVolverAlcohol1 = (Button) VistaADevolver.findViewById(R.id.btnVolverAlcohol1);
        Respuesta = (TextView) VistaADevolver.findViewById(R.id.Respuesta);

        Log.d ("TestAlcoholemia2Frag", "Obtengo datos desde la Activity");
        MainActivity ActividadAnfitriona;
        ActividadAnfitriona = (MainActivity) getActivity();
        Sexo = ActividadAnfitriona.ObtenerMasculinidad();
        Peso = ActividadAnfitriona.ObtenerPesoGlobal();
        Log.d ("TestAlcoholemia2Frag", "Sexo = " + Sexo + " - Peso " + Peso);

        Log.d ("TestAlcoholemia2Frag", "Spinner TipoBebida: le pongo el adaptador");
        String[] ValorTipoBebida = {"Vino", "Cerveza", "Champagne", "Ginebra", "Brandy", "Sidra", "Whiskey", "Vodka", "Ron", "Pisco", "Sake", "Hidromiel", "Tequila", "Fernet"};
        TipoBebida.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, ValorTipoBebida));

        Log.d ("TestAlcoholemia2Frag", "Spinner MedidaBebida: le pongo el adaptador");
        String[] ValorMedidaBebida = {"Copa Chica (100ml)", "Copa Grande (200ml)", "Pinta (473ml)", "Shot (50ml)", "Vaso (250ml)", "Petaca (200ml)"};
        MedidaBebida.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, ValorMedidaBebida));

        Log.d ("TestAlcoholemia2Frag", "Spinner CantidadBebida: le pongo el adaptador");
        CantidadBebidaArray = new ArrayList<>();
        i = 0;
        while (i < 20) {
            CantidadBebidaArray.add("'" + i + "'");
            i++;
        }
        CantidadBebida.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, CantidadBebidaArray));

        Log.d ("TestAlcoholemia2Frag", "Programación del boton Calcular");
        btnCalcularAlcohol.setOnClickListener(btnCalcularAlcohol_Click);

        Log.d ("TestAlcoholemia2Frag", "Programacion del boton Volver");
        btnVolverAlcohol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d ("TestAlcoholemia2Frag", "Boton Volver: Entro y voy al TestAlcoholemiaFragment");

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new TestAlcoholemiaFragment()).commit();
            }
        });
        Log.d ("TestAlcoholemia2Frag", "Devuelvo la vista");
        return VistaADevolver;
    }

    private View.OnClickListener btnCalcularAlcohol_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Log.d ("TestAlcoholemia2Frag", "Boton Calcular: Entro");

            Log.d ("TestAlcoholemia2Frag", "Boton Calcular: Obtengo el valor de los spinners");
            TipoBebidaValor = TipoBebida.getSelectedItem().toString();
            MedidaBebidaValor = MedidaBebida.getSelectedItem().toString();
            CantidadBebidaValor = CantidadBebida.getSelectedItem().toString();
            Cantidad = Integer.parseInt(CantidadBebidaValor);

            Log.d ("TestAlcoholemia2Frag", "Boton Calcular: TipoBebidaValor: me fijo el valor");
            switch (TipoBebidaValor)
            {
                case "Vino":
                    Log.d("AlPresionar","Se selecciono vino");
                    Graduacion = 13.0;
                    break;
                case "Cerveza":
                    Graduacion = 5.5;
                    break;
                case "Champagne":
                    Graduacion = 13.0;
                    break;
                case "Ginebra":
                    Graduacion = 40.0;
                    break;
                case "Brandy":
                    Graduacion = 38.0;
                    break;
                case "Sidra":
                    Graduacion = 5.0;
                    break;
                case "Whiskey":
                    Graduacion = 40.0;
                    break;
                case "Vodka":
                    Graduacion = 40.0;
                    break;
                case "Ron":
                    Graduacion = 40.0;
                    break;
                case "Pisco":
                    Graduacion = 42.0;
                    break;
                case "Sake":
                    Graduacion = 15.0;
                    break;
                case "Hidromiel":
                    Graduacion = 15.0;
                    break;
                case "Tequila":
                    Graduacion = 40.0;
                    break;
                case "Fernet":
                    Graduacion = 38.0;
                    break;
            }

            Log.d ("TestAlcoholemia2Frag", "Boton Calcular: MedidaBebidaValor: me fijo el valor");
            switch (MedidaBebidaValor)
            {
                case "Copa Chica (100ml)":
                    Log.d("AlPresionar","Se selecciono copa chica");
                    Mililitros = 100.0;
                    break;
                case "Copa Grande (200ml)":
                    Mililitros = 200.0;
                    break;
                case "Pinta (473ml)":
                    Mililitros = 473.0;
                    break;
                case "Shot (50ml)":
                    Mililitros = 50.0;
                    break;
                case "Vaso (250ml)":
                    Mililitros = 250.0;
                    break;
                case "Petaca (200ml)":
                    Mililitros = 200.0;
                    break;
            }

            GramosAlcohol = ((Graduacion * Mililitros * Cantidad) / 100) * 0.789;
            Log.d ("TestAlcoholemia2Frag", "Boton Calcular: Gramos alcohol: " + GramosAlcohol);

            Peso = Peso*1000;

            Log.d ("TestAlcoholemia2Frag", "Peso: " + Peso);

            if (Sexo == true)
            {
                Log.d ("TestAlcoholemia2Frag", "Boton Calcular: Se que es hombre");
                ConstanteSexo = 0.68;
            }
            else
            {
                Log.d ("TestAlcoholemia2Frag", "Boton Calcular: Se que es mujer");
                ConstanteSexo = 0.55;
            }


            BAC = (GramosAlcohol / (Peso * ConstanteSexo)) * 1000;
            Log.d ("TestAlcoholemia2Frag", "Boton Calcular: BAC: " + BAC);

            if (BAC == 0)
            {
                Log.d ("TestAlcoholemia2Frag", "Boton Calcular: BAC = 0");
                Conduccion = "Puede conducir";
            }
            else if (BAC > 0 && BAC < 0.5)
            {
                Log.d ("TestAlcoholemia2Frag", "Boton Calcular: BAC > 0 y < 0.5");
                Conduccion = "Conduzca con moderación";
            }
            else if (BAC >= 0.5 && BAC < 3)
            {
                Log.d ("TestAlcoholemia2Frag", "Boton Calcular: BAC > 0.5 y < 3");
                Conduccion = "Usted NO puede conducir. ";
            }
            else if (BAC >= 3)
            {
                Log.d ("TestAlcoholemia2Frag", "Boton Calcular: BAC > 3");
                Conduccion = "Usted NO puede conducir. Se encuentra en estado CRÍTICO. Necesita atención médica urgente.";
            }
            Log.d ("TestAlcoholemia2Frag", "Muestro la respuesta");
            Respuesta.setText("Usted consumió " + GramosAlcohol + " gramos de alcohol puro. Hay en su cuerpo " + BAC + " gramos/litro de sangre. " + Conduccion);

        }
    };
}

