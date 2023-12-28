package Util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Util {
    public static int getInt(String msg, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while (true){
            System.out.printf("%s 입력 (%d ~ %d) : ", msg, min, max);
            try {
                value = scanner.nextInt();
                if (value < min || value > max) {
                    System.out.println("입력 가능한 범위를 벗어났습니다. 다시 입력해 주세요.");
                    continue;
                }
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("정수값이 아닙니다. 다시 입력해 주세요.");
                scanner.nextLine();
            }
        }
    }

    public static String getValue(String msg) {
        Scanner scanner = new Scanner(System.in);
        String value = "";
        while (true) {
            System.out.printf("%s 입력 : ", msg);
            value = scanner.nextLine();
            if (value.trim().isEmpty()) {
                System.out.println("공백은 입력할 수 없습니다. 다시 입력해 주세요.");
                continue;
            }
            return value;
        }
    }

    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = String.format("%s", sdf.format(System.currentTimeMillis()));
        return date;
    }
}
