package com.example.doan_detai6_appbanhangonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnvMenu;
    FrameLayout flContainer;

    HomeFragment homeFragment = new HomeFragment();
    NotificationFragment notificationFragment = new NotificationFragment();
    UserFragment userFragment = new UserFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnvMenu = findViewById(R.id.bnvMenu);

        loadFragment(homeFragment); // load giao diện mặc định

        // Xử lý khi bấm vào menu bất kì
        bnvMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mnuHome:
                        loadFragment(homeFragment);
                        break;

                    case R.id.mnuNotification:
                        loadFragment(notificationFragment);
                        break;

                    case R.id.mnuUser:
                        loadFragment(userFragment);
                        break;
                }
                return true;
            }
        });
    }

    // Load Fragment
    public void loadFragment(Fragment fragment) {
        // giúp thế Fragment vào FrameLayout trên giao diện
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flContainer, fragment);
        transaction.commit();
    }
}