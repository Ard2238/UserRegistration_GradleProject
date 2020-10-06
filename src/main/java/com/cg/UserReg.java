package com.cg;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserReg {
    private static Scanner sc = new Scanner(System.in);

    /* UC1 -- Validate First Name */
    /* UC2 -- Validate Last Name */
    private boolean validateName(String firstName) {
        return Pattern.matches("[A-Z][a-z]{2,}", firstName);
    }

    /* UC3 -- Validate Email */
    private boolean validateEmail(String email) {
        return Pattern.matches("[a-z]+(.[a-z]+)*@{1}[a-z]+(.co){1}(.[a-z]+)*", email);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the User Registration Program");
        System.out.println("Enter the first name: ");
        String firstName = sc.next();
        System.out.println("Enter the last name: ");
        String lastName = sc.next();
        System.out.println("Enter the email: ");
        String email = sc.next(); sc.nextLine();

        UserReg userReg = new UserReg();
        System.out.println(userReg.validateName(firstName));
        System.out.println(userReg.validateName(lastName));

    }
}
