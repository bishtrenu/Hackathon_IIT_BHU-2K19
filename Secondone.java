package com.example.shiva.cureall;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;



public class Secondone extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout mDrawerLayout;
    public static int listposition;
    public static int listposition1;
    private DrawerLayout drawerLayout;
    int backButtonCount = 0;
    Button button;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondone);
        Toolbar tool = findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        ActionBar actionbar = getSupportActionBar();


        actionbar.setHomeAsUpIndicator(R.drawable.icon_nav);
        drawerLayout = findViewById(R.id.drawer);
        NavigationView nav = findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, tool, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener((toggle));
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new home()).commit();
            nav.setCheckedItem(R.id.home);
        }
        actionbar.setDisplayHomeAsUpEnabled(true);


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {

                }

            }
        };
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new home()).commit();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new profile_fragment()).commit();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.out:
                ProgressDialog.show(this, "Logging Out", "Wait a moment...");
                mAuth.signOut();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new contact_fragment()).commit();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.rate:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ratting()).commit();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;

        }
        return true;
    }


    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
    /*@Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{


            if(backButtonCount >= 1)
            {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
                backButtonCount++;
            }
        }
    }*/
}



