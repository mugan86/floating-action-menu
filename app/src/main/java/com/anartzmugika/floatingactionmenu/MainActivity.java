package com.anartzmugika.floatingactionmenu;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.MenuItem;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.jaredrummler.android.device.DeviceName;

public class MainActivity extends AppCompatActivity {

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Android Device SDK
        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        System.out.println("Device SDK is: " + SDK_INT);

        //Important: Add to not show "android.os.NetworkOnMainThreadException at android.os.StrictMode$AndroidBlockGuardPolicy.onNetwork"
        // This exception is thrown when application attempts to perform a networking operation in the main thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);


        // Get Device Manufacturer and model without using library
        System.out.println(Device.getDeviceName());

        //Without using library
        System.out.println("Manufacturer: " + Device.getDeviceManuFacturer());
        System.out.println("Product: " + Device.getDeviceProduct());
        System.out.println("Model: " + Device.getDeviceModel());


        //Get Device most important info using 'com.jaredrummler:android-device-names:1.1.2' library
        DeviceName.DeviceInfo info_device = DeviceName.getDeviceInfo(MainActivity.this);
        System.out.println("Manufacturer: " + info_device.manufacturer);
        System.out.println("Model: " + info_device.model);
        System.out.println("Market Name: " + info_device.marketName);
        System.out.println("Code Name: " + info_device.codename);

        //Obtain Device Name model and current SDK
        System.out.println(DeviceName.getDeviceName() + " / SDK: " + SDK_INT);

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked


            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
