package com.example.biolizard.drawermenu;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {
    private Bundle data;
    private DrawerLayout dl;
    private MainFragment mainFragment;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    public static final String KEY = "KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout) findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return onMenuItemPressed(item);


            }
        });


        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMain);
    }

    private boolean onMenuItemPressed(@NonNull MenuItem item) {
        int id = item.getItemId();

        changeText((String) item.getTitle());
        dl.closeDrawers();

        switch (id) {
            case R.id.account:
                Toast.makeText(MainActivity.this, "My Account", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mycart:
                Toast.makeText(MainActivity.this, "My Cart", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.new_game:
                Toast.makeText(MainActivity.this, "item1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(MainActivity.this, "item2", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return true;
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (t.onOptionsItemSelected(item)) {

            return true;
        }
        else {

           onMenuItemPressed(item);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second_menu, menu);
        return true;
    }

    @Override
    public void changeText(String texto) {
        mainFragment.updateView(texto);
    }
}
