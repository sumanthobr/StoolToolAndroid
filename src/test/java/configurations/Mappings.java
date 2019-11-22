package configurations;

import java.util.HashMap;

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
}
