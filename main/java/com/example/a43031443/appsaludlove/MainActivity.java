package com.example.a43031443.appsaludlove;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    FragmentManager AdministradorDeFragments;
    FragmentTransaction TransaccionesDeFragment;

    //ALCOHOLEMIA
    int PesoGlobal;
    boolean MasculinoGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId())
                    {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();

                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_calendar:
                            selectedFragment = new CalendarFragment();
                            break;
                        case R.id.nav_user:
                            selectedFragment = new UserFragment();
                            break;

                    }

                    /*if (false){
                        CompatibilidadesSanguineasFragment xxx = new CompatibilidadesSanguineasFragment();
                        xxx.setDatos("anitasdas");

                    }*/
                    AdministradorDeFragments = getSupportFragmentManager();
                    TransaccionesDeFragment = AdministradorDeFragments.beginTransaction();
                    TransaccionesDeFragment.replace(R.id.fragment_container, selectedFragment);
                    TransaccionesDeFragment.commit();
                    return true;
                }
            };

            public void DatosAlcoholemia1 (int Peso, Boolean Masculino)
            {
                Log.d ("MainActivity", "DatosAlcoholemia: Se recibieron los datos " + Peso + " y " + Masculino);
                PesoGlobal = Peso;
                MasculinoGlobal = Masculino;

                Log.d ("MainActivity", "DatosAlcoholemia: Instancio el fragment de TestAlcoholemia2");
                TestAlcoholemia2Fragment miFragment;
                miFragment = new TestAlcoholemia2Fragment();

                Log.d ("MainActivity", "DatosAlcoholemia: Inicio una transacion de fragment");
                TransaccionesDeFragment = AdministradorDeFragments.beginTransaction();

                Log.d ("MainActivity", "DatosAlcoholemia: Alojo el fragment en el holder");
                TransaccionesDeFragment.replace(R.id.fragment_container, miFragment);

                Log.d ("MainActivity", "DatosAlcoholemia: Finalizo la transaccion");
                TransaccionesDeFragment.commit();



            }
    public int ObtenerPesoGlobal ()
    {
        return PesoGlobal;
    }

    public boolean ObtenerMasculinidad ()
    {
        return MasculinoGlobal;
    }

}