package com.cg;

import java.util.Scanner;
import java.util.regex.Matcher;
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

    /*UC4 -- Validate Mobile Number */
    private boolean validateMobile(String number) {
        return Pattern.matches("[0-9]{2}\\s[0-9]{10}", number);
    }

    /* UC5 -- Validate Password
     * Rule 1. Minimum 8 characters
     * Rule 2. At least one Upper Case character
     * Rule 3. At least one numeric character
     * Rule 4. Exactly one special character
     * */
    private boolean validatePassword(String password) {
        if(Pattern.matches("(?=.*\\d)(?=.*[A-Z])(?=.*[\\S]).{8,}", password)){
            String splchar = "[\\W]";
            Pattern pat = Pattern.compile(splchar);
            Matcher mat = pat.matcher(password);
            int count = 0;
            while(mat.find()) {count++ ; }
            if(count == 1) {
                System.out.println("Valid Password");
                return true;
            }
        }
        System.out.println("Invalid Password.");
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the User Registration Program");
        System.out.println("Enter the first name: ");
        String firstName = sc.next();
        System.out.println("Enter the last name: ");
        String lastName = sc.next();
        System.out.println("Enter the email: ");
        String email = sc.next(); sc.nextLine();
        System.out.println("Enter the Mobile Number: ");
        String number = sc.nextLine();
        System.out.println("Enter the Password: ");
        String password = sc.next();

        UserReg userReg = new UserReg();
        System.out.println(userReg.validateName(firstName));
        System.out.println(userReg.validateName(lastName));
        System.out.println(userReg.validateEmail(email));
        System.out.println(userReg.validateMobile(number));
        System.out.println(userReg.validatePassword(password));

    }
}
