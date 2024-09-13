package com.example.obdapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView speedTextView, rpmTextView, coolantTempTextView;
    private ObdDecoder decoder = new ObdDecoder();
    private ObdReader obdReader = new ObdReader();  // Kết nối giả lập ELM327 hoặc thật

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kết nối với các TextView trên giao diện người dùng
        speedTextView = findViewById(R.id.speedTextView);
        rpmTextView = findViewById(R.id.rpmTextView);
        coolantTempTextView = findViewById(R.id.coolantTempTextView);

        // Lấy dữ liệu và hiển thị thông số
        updateCarData();
    }

    private void updateCarData() {
        String speedData = obdReader.sendCommand("01 0D");
        int speed = decoder.parseSpeed(speedData);
        speedTextView.setText("Speed: " + speed + " km/h");

        String rpmData = obdReader.sendCommand("01 0C");
        int rpm = decoder.parseRPM(rpmData);
        rpmTextView.setText("RPM: " + rpm);

        String coolantTempData = obdReader.sendCommand("01 05");
        int coolantTemp = decoder.parseCoolantTemperature(coolantTempData);
        coolantTempTextView.setText("Coolant Temp: " + coolantTemp + "°C");
    }
}