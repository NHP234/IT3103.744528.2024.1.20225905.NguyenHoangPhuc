package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

    public static void main(String[] args) {
        String filename = "C:/Users/cuphu/OneDrive/Máy tính/IT3103.744528.2024.1.20225905.NguyenHoangPhuc/OtherProjects/src/hust/soict/hedspi/garbage/test.txt";
        byte[] inputBytes = {0}; // Khởi tạo mảng byte để tránh NullPointerException
        long startTime, endTime;

        try {
            // Read all bytes from the file
            inputBytes = Files.readAllBytes(Paths.get(filename));

            //Nguyen Hoang Phuc 20225905
            startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();

            for (byte b : inputBytes) {
                outputStringBuilder.append((char)b);
            }

            endTime = System.currentTimeMillis();

            System.out.println("Phuc20225905 = " + (endTime - startTime));

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
