package configurations;

import java.util.HashMap;

import static Constants.Constants.*;

public class Mappings {
    public static HashMap<String,String > wateryAntibiotics(){
        HashMap<String,String> an= new HashMap<String, String>();
        an.put("Bangladesh","antibiotic:Azithromycin");
        an.put("Haiti","antibiotic:Erythromycin; doxycycline (> 8)");
        an.put("Other","antibiotic:Doxycycline");
        return an;
    }
    public static HashMap<String,String > bloodyAntibiotics(){
        HashMap<String,String> an= new HashMap<String, String>();
        an.put("Bangladesh","antibiotic:Azithromycin; ciprofloxacin (> 65)");
        an.put("Haiti","antibiotic:Ciprofloxacin");
        an.put("Other","antibiotic:Azithromycin; ciprofloxacin (> 65)");
        return an;
    }
    public static HashMap<String,String > weightEstimation(){
        HashMap<String,String > we=new HashMap<>();
        we.put("Bangladesh","Method-Percentile: 5th (F) and 3rd (M)");
        we.put("Haiti","Method-Percentile: 50th");
        we.put("Other","Method-Percentile: 50th");
        return we;
    }
    public static String getWateryAntibiotic(String country){
        String antibiotic= wateryAntibiotics().get(country);
        return antibiotic.split(":")[1];
    }
    public static String getBloodyAntibiotic(String country){
        String antibiotic= bloodyAntibiotics().get(country);
        return antibiotic.split(":")[1];
    }
    public static String getCountryWeightEstimate(String country){
        String method= weightEstimation().get(country);
        return method.split("-")[1];
    }
    public static HashMap<String,String> fluidType(){
        HashMap<String,String > fl=new HashMap<>();
        fl.put("Severe","type:IV");
        fl.put("Some","type:ORS");
        fl.put("No","type:No Fluids");
        return fl;
    }
    public static String getFluidType(String status){
        String fluidType= fluidType().get(status);
        return fluidType.split(":")[1];
    }
    public static String verifyPrimaryAntibiotic(String age,String dehydrationStatus,String watery,String bloody,String country){
        String antibiotic="";
        switch (country){
            case BANGLADESH:
                switch(bloody){
                    case "yes":
                        System.out.println("Bloody cases........");
                        antibiotic+=getFirstAntibiotic(age, dehydrationStatus, bloody, watery);
                        break;
                    case "no":
                        System.out.println("Watery cases........");
                        antibiotic+= getFirstAntibiotic(age, dehydrationStatus, bloody, watery);
                        break;
                }
            case HAITI:
                switch (dehydrationStatus){
                    case SEVERE:
                    case SOME:
                    case No:
                }
            case OTHER:
                switch (dehydrationStatus){
                    case SEVERE:
                    case SOME:
                    case No:
                }
        }
     return antibiotic;
    }
    public static String getFirstAntibiotic(String age,String dehydrationStatus,String bloody,String watery){
        String antibiotic="";
        switch (dehydrationStatus){
            case SEVERE:
                if(watery.equalsIgnoreCase("yes") && bloody.equalsIgnoreCase("no")){
                    antibiotic= antibiotic+"Azithromycin";
                }
                else if((watery.equalsIgnoreCase("yes") || watery.equalsIgnoreCase("no"))&& bloody.equalsIgnoreCase("yes")){
                    System.out.println("Bloody case");
                    if(Integer.parseInt(age)>64){
                        antibiotic= antibiotic+"Ciprofloxacin";
                    }
                    else {
                        antibiotic= antibiotic+"Azithromycin";
                    }
                }
                break;
            case SOME:
                if(watery.equalsIgnoreCase("yes") && bloody.equalsIgnoreCase("no") && Integer.parseInt(age)<2){
                    antibiotic= antibiotic+"Azithromycin";
                }
                else{
                    antibiotic= antibiotic+"None";
                }
                break;
            case No:
                antibiotic=antibiotic+"None";
                break;
        }
        return antibiotic;
    }
}
