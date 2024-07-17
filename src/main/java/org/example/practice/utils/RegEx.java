package org.example.practice.utils;

import java.util.regex.Pattern;

public class RegEx {
    static final String PASSPORTREGEX = "\\d{10}";
    static final String AUTONUMBERREGEX = "[abekmhopctyx]\\d{3}(?<!000)[abekmhopctyx]{2}\\d{2,3}";

    static public boolean isValidPassport(String passport){
        Pattern pasportPattern = Pattern.compile(PASSPORTREGEX);
        return pasportPattern.matcher(passport).matches();
    }
    static public boolean isValidAutoNumber(String number){
        Pattern pasportPattern = Pattern.compile(AUTONUMBERREGEX);
        return pasportPattern.matcher(number).matches();
    }
}
