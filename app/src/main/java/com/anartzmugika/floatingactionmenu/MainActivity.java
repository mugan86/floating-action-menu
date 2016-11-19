package com.anartzmugika.floatingactionmenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.jaredrummler.android.device.DeviceName;

public class MainActivity extends AppCompatActivity {

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;

    private TextView info_device;

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

        //Obtain Device Name model and current SDK
        System.out.println(DeviceName.getDeviceName() + " / SDK: " + SDK_INT);

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        info_device = (TextView) findViewById(R.id.info_device);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Without using library

                // Get Device Manufacturer and model without using library
                System.out.println(Device.getDeviceName());

                String html = "<h1>Device properties without using library<h1>" +
                        "<p>\"Manufacturer: \"" + Device.getDeviceManuFacturer() + "</p>" +
                        "<p>\"Product: \"" + Device.getDeviceProduct() + "</p>" +
                        "<p>\"Model: \"" + Device.getDeviceModel() + "</p>" +
                        "Some text";
                addContentToShowinLayout(html);
                materialDesignFAM.close(true);

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                //Get Device most important info using 'com.jaredrummler:android-device-names:1.1.2' library
                DeviceName.DeviceInfo info_device = DeviceName.getDeviceInfo(MainActivity.this);

                String html = "<h1>Device properties with using library<h1>" +
                        "<p>\"Manufacturer: \"" + info_device.manufacturer + "</p>" +
                        "<p>\"Market name: \"" + info_device.marketName + "</p>" +
                        "<p>\"Model: \"" + info_device.model + "</p>" +
                        "<p>\"Codename: \"" + info_device.codename + "</p>" +
                        "Some text";
                addContentToShowinLayout(html);
                materialDesignFAM.close(true);
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                sendEmail("Contact with Anartz!");
                materialDesignFAM.close(true);
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

    private void addContentToShowinLayout(String info)
    {
        info_device.setText(Html.fromHtml(info));
    }

    private void sendEmail(String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mugan86@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent);}
    }
}
