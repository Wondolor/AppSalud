package com.example.a43031443.appsaludlove;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 43445314 on 8/6/2018.
 */

public class BMIFragment extends Fragment {

    EditText edtAltura;
    EditText edtPeso;
    Button btnCalcularBMI;
    Button btnVolverBMI;
    TextView txtBMI;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
    {
        View VistaADevolver;
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.fragment_bmi, GrupoDeLaVista, false);

        edtAltura = (EditText) VistaADevolver.findViewById(R.id.ingAltura);
        edtPeso = (EditText) VistaADevolver.findViewById(R.id.ingPeso);
        btnCalcularBMI = (Button) VistaADevolver.findViewById(R.id.btnCalcularBMI);
        btnVolverBMI = (Button) VistaADevolver.findViewById(R.id.btnVolverBMI);
        txtBMI = (TextView) VistaADevolver.findViewById(R.id.txtBMI);

        //PrimerBoton
        btnCalcularBMI.setOnClickListener(btnCalcularBMI_Click);
        //SegundoBoton
        btnVolverBMI.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
            }
        });

        return VistaADevolver;
    }

    private View.OnClickListener btnCalcularBMI_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String p = edtPeso.getText().toString(); //Agarramos el texto ingresado sobre el peso
            Double Peso = Double.valueOf(p).doubleValue(); //Lo convertimos a double

            String a = edtAltura.getText().toString(); //Agarramos el texto ingresado sobre la altura
            Double Altura = Double.valueOf(a).doubleValue(); //Lo convertimos a double

            Double ResultadoDouble = Peso/(Altura*Altura); //Guardamos el resultado en una variable
            int Resultado = ResultadoDouble.intValue();

            if (Resultado < 16)
            {
                txtBMI.setText("BMI: " + Resultado + ", usted está desnutrido. Consulte un médico urgentemente.");
            }
            if (Resultado >= 16 && Resultado <18)
            {
                txtBMI.setText("BMI: " + Resultado + ", usted está muy bajo de peso. Se recomienda aumentar.");
            }
            if (Resultado <= 18)
            {
                txtBMI.setText("BMI: " + Resultado + ", usted está con bajo peso. Se recomienda aumentar.");
            }
            if (Resultado > 18 && Resultado <=24)
            {
                txtBMI.setText("BMI: " + Resultado+ ", usted está en un peso saludable.");
            }
            if (Resultado > 24 && Resultado <=29)
            {
                txtBMI.setText("BMI: " + Resultado+ ", usted está con sobrepeso.");
            }
            if (Resultado > 29 && Resultado <=39)
            {
                txtBMI.setText("BMI: " + Resultado+ ", usted está con obesidad.");
            }
            if (Resultado > 39 && Resultado <=42)
            {
                txtBMI.setText("BMI: " + Resultado + ", usted está con con obesidad mórbida.");
            }
            if (Resultado > 42)
            {
                txtBMI.setText("BMI: " + Resultado + ", usted está en un peso extremo. Consulte urgentemente a un médico");
            }
            edtAltura.setText("");
            edtPeso.setText("");

        }
    };


}
