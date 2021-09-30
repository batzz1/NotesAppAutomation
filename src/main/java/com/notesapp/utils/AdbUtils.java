package com.notesapp.utils;

public class AdbUtils {

    public static void pressBack() {
        String command = "adb shell input keyevent 4";
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
    }

}
