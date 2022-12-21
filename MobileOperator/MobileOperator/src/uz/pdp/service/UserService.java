package uz.pdp.service;

import uz.pdp.model.SimCard;
import uz.pdp.model.User;
import uz.pdp.model.database.Databese;

public class UserService implements BaseService, Databese {
    @Override
    public boolean add(String name, String password) {
        for (User user : users) {
            if (user != null) {
                if (user.getName().equals(name)) {
                    return false;
                } else {
                    User user1 = new User();
                    user1.setName(name);
                    user1.setPassword(password);
                    user1.setRole("USER");
                    users.add(user1);
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public void show() {
        for (User user : users) {
            if (user != null) {
                System.out.println(user);
            }
        }
    }

    @Override
    public Object update(int id) {
        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) {
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Object getById(int id) {
        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) {
                    return user;
                }
            }
        }
        return null;
    }


    public User checkAdmin(String name, String password) {
        for (User user : users) {
            if (user != null) {
                if (user.getName().equals(name) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    public int getIdByCardNum(int cardNum, int pinCode) {
        for (SimCard simCard : simCards) {
            if (simCard.getSimCardNumber() == cardNum && simCard.getSimCardPassword() == pinCode) {
                return simCard.getUserId();
            }
        }
        return 0;
    }
}
