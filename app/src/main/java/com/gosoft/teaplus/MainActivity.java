/** Author : Kien Pham
* Company: One Soft
* Version : Test 001
 * Class : MainActivity
*/
package com.gosoft.teaplus;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.gosoft.flagment.mainac.CartFragment;
import com.gosoft.flagment.mainac.GiftsFragment;
import com.gosoft.flagment.mainac.ProfileFragment;
import com.gosoft.flagment.mainac.StoreFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        GiftsFragment.OnFragmentInteractionListener,
        CartFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,
        StoreFragment.OnFragmentInteractionListener {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading the default fragment
        loadFragment(new StoreFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        toolbar = getSupportActionBar();

        /*BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/

        //toolbar.setTitle("Shop");


    }

    /*private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    toolbar.setTitle("Shop");
                    fragment = new StoreFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_gifts:
                    toolbar.setTitle("My Gifts");
                    fragment = new GiftsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                    toolbar.setTitle("Cart");
                return true;
                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    return true;
            }
            return false;
        }
    };*/

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_shop:
                toolbar.setTitle("Shop");
                fragment = new StoreFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_gifts:
                toolbar.setTitle("My Gifts");
                fragment = new GiftsFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_cart:
                toolbar.setTitle("Cart");
                fragment = new CartFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_profile:
                toolbar.setTitle("Profile");
                fragment = new ProfileFragment();
                loadFragment(fragment);
                return true;
        }
        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
