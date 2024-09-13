package com.example.obdapp;

public class ObdDecoder {
    public int parseSpeed(String hexData) {
        String[] bytes = hexData.split(" ");
        if (bytes.length > 2) {
            return Integer.parseInt(bytes[2], 16);
        }
        return 0;
    }

    public int parseRPM(String hexData) {
        String[] bytes = hexData.split(" ");
        if (bytes.length > 3) {
            int A = Integer.parseInt(bytes[2], 16);
            int B = Integer.parseInt(bytes[3], 16);
            return ((A * 256) + B) / 4;
        }
        return 0;
    }

    public int parseCoolantTemperature(String hexData) {
        String[] bytes = hexData.split(" ");
        if (bytes.length > 2) {
            return Integer.parseInt(bytes[2], 16) - 40;
        }
        return 0;
    }

    // Các hàm giải mã khác nếu cần
}
