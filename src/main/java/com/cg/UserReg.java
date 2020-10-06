package com.cg;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserReg {
    private static Scanner sc = new Scanner(System.in);

    /* UC1 -- Validate First Name */
    private boolean validateName(String firstName) {
        return Pattern.matches("[A-Z][a-z]{2,}", firstName);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the User Registration Program");
        System.out.println("Enter the first name: ");
        String firstName = sc.next();

        UserReg userReg = new UserReg();
        System.out.println(userReg.validateName(firstName));

    }
}
