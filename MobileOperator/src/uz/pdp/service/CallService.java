package uz.pdp.service;

import uz.pdp.model.Call;
import uz.pdp.model.SimCard;
import uz.pdp.model.User;
import uz.pdp.model.database.Databese;

public class CallService implements Databese {
    UserService userService = new UserService();

    public boolean call(int receiverId, int userCalling, int time) {
        User currentUser = (User) userService.getById(userCalling);
        for (User user : users) {
            if (user.getId() == receiverId) {
                Call call = new Call();
                call.setUserCollingId(userCalling);
                call.setReceiverId(receiverId);
                call.setSpendingTimeForCall(time);
                if (currentUser.getSimCard().getTariff().getFreeMinutes() >= time) {
                    currentUser.getSimCard().getTariff().setFreeMinutes(currentUser.getSimCard().getTariff().getFreeMinutes() - time);
                } else {

                    currentUser.getSimCard().setBenefitFromCall((time * currentUser.getSimCard().getTariff().getPriceForOneMinute()) + currentUser.getSimCard().getBenefitFromCall());
                    currentUser.getSimCard().setBalance(currentUser.getSimCard().getBalance() - time * currentUser.getSimCard().getTariff().getPriceForOneMinute());
                }
                callHistories.add(call);
                return true;
            }
        }
        return false;
    }

    public void callHistory(int userId) {
        for (Call callHistory : callHistories) {
            if (callHistory != null) {
                if (callHistory.getUserCollingId() == userId) {
                    System.out.println(callHistory);
                }
            }
        }
    }


}
