package uz.pdp.service;

import uz.pdp.model.SimCard;
import uz.pdp.model.database.Databese;

public class Benefit implements Databese {
    double allBenefitFromCall;
    double  allBenefitFromInternet;
    double  allBenefitFromSMS;
    public double allBenefitFromCall(){
        for (SimCard simCard : simCards) {
            if (simCard!=null){
                if (simCard.getBenefitFromCall()!=0){
              return   allBenefitFromCall+= simCard.getBenefitFromCall();
                }
            }
        }
        return 0;
    }
    public double allBenefitFromInternet(){
        for (SimCard simCard : simCards) {
            if (simCard!=null){
                if (simCard.getBenefitFromMb()!=0){
                 return    allBenefitFromInternet+= simCard.getBenefitFromMb();
                }
            }
        }
        return 0;
    }
    public double allBenefitFromSMS(){
        for (SimCard simCard : simCards) {
            if (simCard!=null){
                if (simCard.getBenefitFromSMS()!=0){
                   return allBenefitFromSMS+= simCard.getBenefitFromSMS();
                }
            }
        }
        return 0;
    }

}
