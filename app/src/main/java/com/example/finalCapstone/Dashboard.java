package com.example.finalCapstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//the main screen after opening the application

public class Dashboard extends AppCompatActivity {

    BottomNavigationView bnview;
    String ROOT_FRAGMENT_TAG = "home_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent i = getIntent();
        bnview=findViewById(R.id.DashboardBottomNavigation);

        onLoad(new HomeFragment(),0 );
        //for selecting different navigation button different fragments will get loaded
        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                            onLoad(new HomeFragment(),0);
                            break;
                    case R.id.nav_fav:
                        onLoad(new FavFragment(),1);
                        break;
                    case R.id.nav_add:
                        onLoad(new AddIngredientsFragment(),1);
                        break;
                    case R.id.nav_profile:
                        onLoad(new ProfileFragment(),1);



                }
                return true;
            }
        });


    }
    //this is the onload method that will load the respective fragment when the fragment object is given
    void onLoad(Fragment fragment,int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag==0) {
            ft.replace(R.id.container, fragment);
            fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);
        }
        else {
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
    }
//    @Override
//    public void onBackPressed() {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
//        if (backStackEntryCount > 1) {
//            fragmentManager.popBackStack();
//        } else {
//            super.onBackPressed();
//        }
//    }
}