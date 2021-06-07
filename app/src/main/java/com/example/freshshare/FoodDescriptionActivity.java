package com.example.freshshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;


public class FoodDescriptionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    private Intent intent;
    public TextView name;
    public TextView about;
    public ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.activity_food_description);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view_description);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        intent = getIntent();
        Bundle b = intent.getExtras();

        name = findViewById(R.id.foodName);
        about = findViewById(R.id.foodDescription);
        image = findViewById(R.id.foodImage);

        if(b != null) {
            if (b.containsKey(Constants.KEY_NAME)
                    && b.containsKey(Constants.KEY_ABOUT)
                    && b.containsKey(Constants.KEY_URL)) {
                name.setText(b.getString(Constants.KEY_NAME));
                about.setText(b.getString(Constants.KEY_ABOUT));
                Picasso.get().load(b.getString(Constants.KEY_URL)).into(image);
            }
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent_home = new Intent(this, MainActivity.class);
                startActivity(intent_home);
                break;

            case R.id.nav_sign_up:
                Intent intent_sign_up = new Intent(this, SignUpActivity.class);
                startActivity(intent_sign_up);
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
