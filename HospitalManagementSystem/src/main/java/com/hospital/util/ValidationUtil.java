package com.hospital.util;

public class ValidationUtil {

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidBloodGroup(String bloodGroup) {
        return bloodGroup.matches("^(A|B|AB|O)[+-]$");
    }
}
