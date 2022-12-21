package uz.pdp.service;

import uz.pdp.model.MCompany;
import uz.pdp.model.SimCard;
import uz.pdp.model.Tariff;
import uz.pdp.model.User;
import uz.pdp.model.database.Databese;

import java.util.List;

public class SimCardService implements Databese {
    public boolean giveSimCard(MCompany mCompany, Tariff tariff, int userId, int cardNum, int simPassword) {
        SimCard simCard = new SimCard();
        simCard.setmCompany(mCompany);
        simCard.setTariff(tariff);
        simCard.setUserId(userId);
        simCard.setSimCardNumber(cardNum);
        simCard.setSimCardPassword(simPassword);
        simCard.setInActive(true);
        simCards.add(simCard);
        for (User user : users) {
            if (user!=null){
                if (user.getId()==userId){
                    user.setSimCard(simCard);
                }
            }
        }
        return true;
    }

    public boolean changeActive(int pinCod) {
        for (SimCard simCard : simCards) {
            if (simCard != null) {
                if (simCard.getSimCardPassword() == pinCod) {
                    simCard.setInActive(true);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean changePinCode(int cardNum, int oldPassword, int newPassword) {
        for (SimCard simCard : simCards) {
            if (simCard != null) {
                if (simCard.getSimCardNumber() == cardNum && simCard.getSimCardPassword() == oldPassword) {
                    simCard.setSimCardPassword(newPassword);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fillBalance(int simCardPassword, double amount) {
        for (SimCard simCard : simCards) {
            if (simCard != null) {
                if (simCard.getSimCardPassword() == simCardPassword) {
                    simCard.setBalance(simCard.getBalance() + amount);
                    return true;
                }
            }
        }
        return false;
    }

    public SimCard checkUser(int cardNum, int cardPassword) {
        for (SimCard simCard : simCards) {
            if (simCard != null) {
                if (simCard.getSimCardNumber() == cardNum && simCard.getSimCardPassword() == cardPassword) {
                    return simCard;
                }
            }
        }
        return null;
    }

    public void showSimCrd() {
        for (SimCard simCard : simCards) {
            if (simCard != null) {
                System.out.println(simCard);
            }
        }
    }
    public SimCard getById(int userId){
        for (SimCard simCard : simCards) {
            if (simCard!=null){
                if (simCard.getUserId()==userId){
                    return simCard;
                }
            }
        }
        return null;
    }


}
