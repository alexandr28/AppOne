package com.acampdev.borisalexandrcamposrios.appone.Activities;


import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import com.acampdev.borisalexandrcamposrios.appone.Fragments.CotizacionesFragment;
import com.acampdev.borisalexandrcamposrios.appone.Fragments.CuentaFragment;
import com.acampdev.borisalexandrcamposrios.appone.Fragments.MainFragment;
import com.acampdev.borisalexandrcamposrios.appone.Fragments.PendientesFragment;
import com.acampdev.borisalexandrcamposrios.appone.Fragments.ReportesFragment;
import com.acampdev.borisalexandrcamposrios.appone.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        navigationView = (NavigationView) findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.principal:
                        setFragment(0);
                        break;
                    case R.id.cotizaciones:
                        setFragment(1);
                        break;
                    case  R.id.reportes:
                        setFragment(2);
                        break;
                    case R.id.cuenta:
                        setFragment(3);
                        break;
                    case R.id.pendientes:
                        setFragment(4);
                        break;
                    default:
                }

                return false;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        setFragment(0);

    }

    public void setFragment(int pos){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (pos){
            case 0:
                MainFragment fragment = new MainFragment();
                transaction.replace(R.id.fragment,fragment);
                transaction.commit();
                break;
            case 1:
                CotizacionesFragment fragmentCotizaciones = new CotizacionesFragment();
                transaction.replace(R.id.fragment, fragmentCotizaciones);
                transaction.commit();
                break;
            case 2:
                ReportesFragment fragmentReportes = new ReportesFragment();
                transaction.replace(R.id.fragment,fragmentReportes);
                transaction.commit();
                break;
            case 3:
                CuentaFragment fragmentCuenta = new CuentaFragment();
                transaction.replace(R.id.fragment,fragmentCuenta);
                transaction.commit();
                break;
            case 4:
                PendientesFragment fragmentPendientes = new PendientesFragment();
                transaction.replace(R.id.fragment,fragmentPendientes);
                transaction.commit();
                break;
            default:
        }

    }
}
