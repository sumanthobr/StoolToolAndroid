package testData;

import java.util.HashMap;

import static Constants.Constants.*;

public class AntibioticPrescriptions {
    public static HashMap<String,String> getWateryMedicine(){
        HashMap<String,String > medicine=  new HashMap<>();
        medicine.put("Bangladesh","Azithromycin");
        medicine.put("Global","Doxycycline");
        return medicine;
    }
    public static String verifyPrimaryAntibiotic(String age,String dehydrationStatus,String bloody,String country,String pregnant){
        String antibiotic="";
        switch (country){
            case BANGLADESH:
                if(bloody.equalsIgnoreCase("yes")){
                    System.out.println("Bangladesh bloody cases");
                    antibiotic+=getBloodyAntibioticsForBangladeshOrGlobal(age);
                }
                else {
                    System.out.println("Bangladesh watery cases");
                    getWateryAntiboticsForBangladeshOrGlobal(age, dehydrationStatus, pregnant, country);
                }
                break;
            case HAITI:
                if(bloody.equalsIgnoreCase("yes")){
                    System.out.println("Haiti bloody cases");
                    antibiotic+=getBloodyAntibioticsForHaiti(pregnant);
                }
                else {
                    System.out.println("Haiti watery cases");
                    antibiotic+=getWateryAntibioticsForHaiti(age, dehydrationStatus, pregnant);
                }
                break;
            case OTHER:
                if(bloody.equalsIgnoreCase("yes")){
                    System.out.println("Global bloody cases");
                    antibiotic+=getBloodyAntibioticsForBangladeshOrGlobal(age);
                }
                else {
                    System.out.println("Global watery cases");
                    getWateryAntiboticsForBangladeshOrGlobal(age, dehydrationStatus, pregnant, country);
                }
                break;
        }
        return antibiotic;
    }
    public static String getBloodyAntibioticsForBangladeshOrGlobal(String age){
        String bloodyAntibiotic="";
        if(Integer.parseInt(age)<65){
            bloodyAntibiotic+= "Azithromycin";
        }
        else {
            bloodyAntibiotic+= "Ciprofloxacin";
        }
        return bloodyAntibiotic;
    }
    public static String getBloodyAntibioticsForHaiti(String pregnant){
        String bloodyAntibiotic="";
        if(pregnant.equalsIgnoreCase("yes")){
            bloodyAntibiotic+= "Azithromycin";
        }
        else {
            bloodyAntibiotic+= "Ciprofloxacin";
        }
        return bloodyAntibiotic;
    }
    public static String getWateryAntiboticsForBangladeshOrGlobal(String age,String dehydrationStatus,String pregnant,String country){
        String wateryAntibiotic="";
        switch (dehydrationStatus){
            case SEVERE:
                wateryAntibiotic+=getWateryMedicine().get(country);
                break;
            case SOME:
                if(Integer.parseInt(age)<2 || pregnant.equalsIgnoreCase("yes")){
                    wateryAntibiotic+=getWateryMedicine().get(country);
                }
                else{
                    wateryAntibiotic+="None";
                }
                break;
            case No:
                if(pregnant.equalsIgnoreCase("yes")){
                    wateryAntibiotic+="Azithromycin";
                }
                else{
                    wateryAntibiotic+="None";
                }
                break;
            }
        return wateryAntibiotic;
    }
    public static String getWateryAntibioticsForHaiti(String age,String dehydrationStatus,String pregnant){
        String wateryAntibiotic="";
        switch (dehydrationStatus){
            case SEVERE:
                if(Integer.parseInt(age)>7){
                    wateryAntibiotic+="Doxycycline";
                }
                else{
                    wateryAntibiotic="Erythromycin";
                }
                break;
            case SOME:
                if(Integer.parseInt(age)<2){
                    wateryAntibiotic+="Erythromycin";
                }
                else if(pregnant.equalsIgnoreCase("yes")){
                    wateryAntibiotic+="Doxycycline";
                }
                else {
                    wateryAntibiotic+="None";
                }
                break;
            case No:
                 if(pregnant.equalsIgnoreCase("yes")){
                    wateryAntibiotic+="Doxycycline";
                 }
                else {
                    wateryAntibiotic+="None";
                }
                break;
        }
        return  wateryAntibiotic;
    }

}
