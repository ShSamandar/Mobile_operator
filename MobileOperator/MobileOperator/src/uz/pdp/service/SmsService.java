package uz.pdp.service;

import uz.pdp.model.SMS;
import uz.pdp.model.User;
import uz.pdp.model.database.Databese;

public class SmsService implements Databese {
    UserService userService=new UserService();
    public  void historySms(int senderId){

        for (SMS sentSMS : sentSMS) {
            if (sentSMS !=null){
                if (sentSMS.getSenderId()==senderId){
                    System.out.println(sentSMS);
                }
            }
        }
    }

    public boolean sendSMS(int receiverId, int senderId,String massage){
        User currentUser = (User) userService.getById(senderId);
        for (User user : users) {
            if (user!=null){
                if (user.getId()==receiverId){
                    SMS sms=new SMS();
                    sms.setSenderId(senderId);
                    sms.setReceiverId(receiverId);
                    sms.setMassage(massage);
                    if (currentUser.getSimCard().getTariff().getFreeSMS() >= 1) {
                        currentUser.getSimCard().getTariff().setFreeSMS(currentUser.getSimCard().getTariff().getFreeSMS() - 1);
                    } else {

                        currentUser.getSimCard().setBenefitFromSMS((1 * currentUser.getSimCard().getTariff().getPriceForOneSMS()) + currentUser.getSimCard().getBenefitFromSMS());
                        currentUser.getSimCard().setBalance(currentUser.getSimCard().getBalance() - 1 * currentUser.getSimCard().getTariff().getPriceForOneSMS());
                    }
                    sentSMS.add(sms);
                    return true;
                }
            }
        }
        return false;
    }
}
