package com.cg;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserReg {
    private static Scanner sc = new Scanner(System.in);

    private String firstName, lastName,email,number,password;
    public UserReg(String firstName, String lastName, String email, String number, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.password = password;
    }

    public boolean initializeDetails() {
        boolean checkFName = validateName(firstName);
        boolean checkLName = validateName(lastName);
        boolean checkEMail = validateEmail(email);
        boolean checkMobile = validateMobile(number);
        boolean checkPass = validatePassword(password);
        System.out.println(checkFName? "Valid First Name." : "Invalid First Name.");
        System.out.println(checkLName? "Valid Last Name." : "Invalid Last Name.");
        System.out.println(checkEMail? "Valid Email." : "Invalid Email.");
        System.out.println(checkMobile? "Valid Mobile Number" : "Invalid Mobile Number");
        System.out.println(checkPass? "Valid Password." : "Invalid Password.");
        if( checkFName && checkLName && checkEMail && checkMobile && checkPass) {
            System.out.println("User Registered Successfully.");
            return true;
        }
        else {
            System.out.println("One or more fields are incorrect. Registration Unsuccessful.");
            return false;
        }
    }

    /* UC1 -- Validate First Name */
    /* UC2 -- Validate Last Name */
    public boolean validateName(String Name) {
        return Pattern.matches("[A-Z][a-z]{2,}", Name);
    }

    /* UC3 -- Validate Email */
    public boolean validateEmail(String email) {
        return Pattern.matches("[a-z]+([.][a-zA-Z0-9]+)*([_][a-zA-Z0-9]+)*([\\-][a-zA-Z0-9]+)*([0-9]+)*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,}([.][A_Za-z]{2,})?", email);
    }

    /*UC4 -- Validate Mobile Number */
    public boolean validateMobile(String number) {
        return Pattern.matches("[0-9]{2}\\s[0-9]{10}", number);
    }

    /* UC5 -- Validate Password
     * Rule 1. Minimum 8 characters
     * Rule 2. At least one Upper Case character
     * Rule 3. At least one numeric character
     * Rule 4. Exactly one special character
     * */
    public boolean validatePassword(String password) {
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

        UserReg userReg = new UserReg(firstName, lastName, email, number, password);
        userReg.initializeDetails();
        sc.close();

    }
}
