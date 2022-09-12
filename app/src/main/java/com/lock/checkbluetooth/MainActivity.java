package com.lock.checkbluetooth;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Short.MIN_VALUE;

public class MainActivity extends AppCompatActivity {
    public static int bluethooth_request_code=1;
    private BluetoothAdapter BTAdapter = BluetoothAdapter.getDefaultAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(receiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));


        /*Button boton = (Button) findViewById(R.id.button1);
        TextView rssi_msg = (TextView) findViewById(R.id.textView1);

        if (!BTAdapter.isEnabled()){
            rssi_msg.setText("Turn on Bluetooth");
        }
        else{
            rssi_msg.setText("Turn off Bluetooth");
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, bluethooth_request_code);
        }
        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (!BTAdapter.isEnabled()){
                    BTAdapter.enable();

                    *//*int rssi = Integer.parseInt(BluetoothDevice.EXTRA_RSSI.toString());*//*
                    *//*registerReceiver(receiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));*//*
                    registerReceiver(receiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));
                    *//*String name = BluetoothDevice.EXTRA_NAME;
                    TextView rssi_msg = (TextView) findViewById(R.id.textView1);*//*
                    String devicename=BTAdapter.getName().toString();
                    Toast.makeText(getApplicationContext(),"Device name is"+devicename,Toast.LENGTH_LONG).show();
                }
            }
        });*/


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private final BroadcastReceiver receiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                int rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, MIN_VALUE);
                String name = intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
                TextView rssi_msg = (TextView) findViewById(R.id.textView1);
                rssi_msg.setText(rssi_msg.getText() + name + " => " + rssi + "dBm\n");

            }
        }
    };
}