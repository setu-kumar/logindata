package com.example.flowerstore;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Search2.class);
                startActivity(intent);
               //pass intant



            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //final MenuItem searchItem = menu.findItem(R.id.action_search);
        //final SearchView searchView = (SearchView) searchItem.getActionView();
       // searchView.setOnQueryTextListener(this);

        return true;
    }

   // @Override
   // public boolean onQueryTextChange(String query){
  //      return false;
   // }

    //@Override
   // public boolean onQueryTextSubmit(String query){
     //   return false;
  //  }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(MainActivity.this,Setting.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_logout){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent=new Intent(MainActivity.this,Catogary.class);
            startActivity(intent);
            Log.d("workingg","4444444444444444");
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(MainActivity.this,Mygallery.class);
            startActivity(intent);


        } else if (id == R.id.nav_tools) {

        }else if (id == R.id.cart){
            Intent intent=new Intent(MainActivity.this,Homepage.class);
            startActivity(intent);

        } else if (id == R.id.nav_help) {

            Intent intent=new Intent(MainActivity.this,About.class);
            startActivity(intent);
        }
         else if (id == R.id.nav_share) {
             Intent sendIntent= new Intent();
             sendIntent.setAction(Intent.ACTION_SEND);
             sendIntent.putExtra(Intent.EXTRA_TEXT,"hey check out my app at:https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
             sendIntent.setType("text/plain");
             startActivity(sendIntent);

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
