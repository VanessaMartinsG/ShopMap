package com.example.prototipo_shop;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import com.example.prototipo_shop.ShoppingDAO;
import com.example.prototipo_shop.ShoppingValue;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ShoppingDAO shoppingdao = new ShoppingDAO(this);


        //shoppingdao.drop();
        ShoppingValue shoppingvalue = new ShoppingValue();
        shoppingvalue.setNome("Shopping Salvador");
        shoppingvalue.setFav("0");
        shoppingdao.CadastrarShop("Shopping Salvador","0");
        shoppingdao.close();
/*
        ShoppingValue shoppingvalue2 = new ShoppingValue();
        shoppingvalue2.setNome("Shopping da Bahia");
        shoppingvalue2.setFav(0);
        shoppingdao.CadastrarShop(shoppingvalue2);


        ShoppingValue shoppingvalue3 = new ShoppingValue();
        shoppingvalue3.setNome("Shopping Bella Vista");
        shoppingvalue3.setFav(0);
        shoppingdao.CadastrarShop(shoppingvalue3);
        shoppingdao.close();*/

        if(checkAndRequestPermissions()){
        }
        getSupportActionBar().hide();

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView,navController);

    }

    private boolean checkAndRequestPermissions() {
        // int permissionSendMessage = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
         int locationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int diskPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //int cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        List<String> listPermissionsNeeded = new ArrayList<>();
         if (locationPermission != PackageManager.PERMISSION_GRANTED) {
              listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
          }
        //  if (permissionSendMessage != PackageManager.PERMISSION_GRANTED) {
        // listPermissionsNeeded.add(Manifest.permission.SEND_SMS);
        //  }
        if (diskPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        //if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
       //     listPermissionsNeeded.add(Manifest.permission.CAMERA);
        //}
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;

    }

}