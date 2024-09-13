package com.example.obdapp;

public class ObdReader {
    public String sendCommand(String command) {
        // Giả lập trả về dữ liệu từ thiết bị OBD-II
        if ("01 0D".equals(command)) {
            return "41 0D 3C";  // Tốc độ 60 km/h
        } else if ("01 0C".equals(command)) {
            return "41 0C 1F A0";  // RPM 2024
        } else if ("01 05".equals(command)) {
            return "41 05 5A";  // Nhiệt độ nước làm mát 50°C
        }
        return "NO DATA";
    }
}
