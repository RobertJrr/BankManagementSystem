package dev.lpa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private int age;
    private String DOB;
    private String socialSec;

    public Person(String name, int age, String DOB, String socialSec){

        if(validateDOB(DOB) && validateSocialSec(socialSec)){
            this.DOB = DOB;
            this.socialSec = socialSec;
            this.name = name;
            this.age = age;
            System.out.println("Person information is valid. Thank you!");
        } else{
            System.out.println("Invalid information, cannot create");
        }
    }

    private static boolean validate(String type, String info){
        boolean isValid = false;
        if(type.equals("DOB")){
            isValid = validateDOB(info);
        } else if(type.equals("socialSec")){
            isValid =  validateSocialSec(info);
        }
        return isValid;
    }

    private static boolean validateDOB(String DOB){
        Pattern pattern = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
        Matcher matcher = pattern.matcher(DOB);
        return matcher.matches();
    }

    private static boolean validateSocialSec(String socialSec){
        Pattern pattern = Pattern.compile("[0-9]{3}-[0-9]{2}-[0-9]{4}");
        Matcher matcher = pattern.matcher(socialSec);
        return matcher.matches();
    }


}
