package com.reedsolutions.utils;

import java.time.Year;

public class AccountUtils {
    /**
     * This is intended to generate random numbers as account number
     * currentYear concatenateed with random six digits
     *
     */
    public static final String ACCOUNT_EXISTS_CODE="001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already has an account created previously!";
    public static final String ACCOUNT_CREATION_SUCCESS_CODE = "002";
    public static final String ACCOUNT_CREATION_SUCCESS_MESSAGE="Account created successfully!";

    public static String GenerateAccountNumber(){
        Year currentYear = Year.now();
        int min = 100000;
        int max = 999999;

        //generate random between min and max
        int randomNumber = (int)Math.floor(Math.random() *( (max-min + 1) + min));

        //convert both the year and the random number to strings

        String yearString = String.valueOf(currentYear);
        String randomNumberString = String.valueOf(randomNumber);

        StringBuilder accountNumber = new StringBuilder();
        return accountNumber.append(yearString).append(randomNumberString).toString();

    }

}
