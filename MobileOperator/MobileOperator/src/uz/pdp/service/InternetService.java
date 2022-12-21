package uz.pdp.service;

import uz.pdp.model.Internet;
import uz.pdp.model.User;
import uz.pdp.model.database.Databese;

public class InternetService implements Databese {
    UserService userService = new UserService();
    public boolean spendMb(int userId, int usedInternet, String usedPlace){
        User currentUser = (User) userService.getById(userId);
        Internet internet =new Internet();
        internet.setSpenderId(userId);
        internet.setSpentPlace(usedPlace);
        internet.setSpentMb(usedInternet);
        if (currentUser.getSimCard().getTariff().getFreeMB() >= usedInternet) {
            currentUser.getSimCard().getTariff().setFreeMB(currentUser.getSimCard().getTariff().getFreeMB() - usedInternet);
        } else {

            currentUser.getSimCard().setBenefitFromMb((usedInternet * currentUser.getSimCard().getTariff().getPriceForOneMB()) + currentUser.getSimCard().getBenefitFromMb());
            currentUser.getSimCard().setBalance(currentUser.getSimCard().getBalance() - usedInternet * currentUser.getSimCard().getTariff().getPriceForOneMB());
        }
        spentMb.add(internet);
        return true;
    }



    public void historySpentMb(int userId){
        for (Internet internet : spentMb) {
            if (internet!=null){
                if (internet.getSpenderId()==userId){
                    System.out.println(internet);
                }
            }
        }
    }
}
