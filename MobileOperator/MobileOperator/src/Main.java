import uz.pdp.model.MCompany;
import uz.pdp.model.SimCard;
import uz.pdp.model.Tariff;
import uz.pdp.model.User;
import uz.pdp.model.database.Databese;
import uz.pdp.service.*;

import java.util.Scanner;

public class Main implements Databese {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static UserService userService = new UserService();
    static TariffService tariffService = new TariffService();
    static SimCardService simCardService = new SimCardService();
    static MCompanyService mCompanyService = new MCompanyService();
    static CallService callService = new CallService();
    static InternetService internetService = new InternetService();
    static SmsService smsService = new SmsService();
    static SimCard simCard = new SimCard();
    static Benefit benefit =new Benefit();
    static int currentUserId;

    public static void main(String[] args) {
        User user5 = new User("123", "123", "ADMIN");
        users.add(user5);
        User user = new User("samandar", "123", "USER");
        users.add(user);
        int var7 = 10;
        while (var7 != 0) {
            userService.show();
            System.out.println();
            System.out.println("1.LogIn Admin 2.LogIn User, 3. Registration 0. EXIT");
            var7 = scannerInt.nextInt();
            switch (var7) {
                case 1 -> {
                    adminLogin();
                }
                case 2 -> {
                    userLogin();
                }
                case 3 -> {
                    registration();
                }
                case 0 -> {
                }
            }
        }
    }


    private static void adminLogin() {

        System.out.print("enter username ");
        String name = scannerStr.nextLine();
        System.out.print("enter password ");
        String password = scannerStr.nextLine();
        User user = userService.checkAdmin(name, password);
        if (user != null) {
            if (user.getRole().equals("ADMIN")) {
                int var5 = 10;
                while (var5 != 0) {
                    System.out.println("1.Mobile Company 2. Tariff 3. SimCad 4. benefit 0.back");
                    var5 = scannerInt.nextInt();
                    switch (var5) {
                        case 1 -> { // mobile company
                            mCompany();
                        }
                        case 2 -> { // tariff
                            tariff();
                        }
                        case 3 -> {// sim card
                            simCard();
                        }
                        case 4 -> { //benefit
                            benefit();
                        }
                        case 0 -> {
                        }
                    }
                }
            }
        } else {
            System.out.println("Admin not found");
        }
    }


    private static void userLogin() {

        System.out.print("Enter SimCard Number ");
        int cardNum = scannerInt.nextInt();
        System.out.print("Enter SimCard PinCode ");
        int pinCode = scannerInt.nextInt();
        SimCard simCard = simCardService.checkUser(cardNum, pinCode);
        if (simCard != null) {
            currentUserId = userService.getIdByCardNum(cardNum, pinCode);
            int var0 = 10;
            while (var0 != 0) {
                System.out.println("1. Call 2. Internet 3.SMS 4. Change  pin code 5. FillBalance 6. show tariff 0. Back");
                var0 = scannerInt.nextInt();
                switch (var0) {
                    case 1 -> { // call
                        call();
                    }
                    case 2 -> {
                        internet();
                    }
                    case 3 -> {
                        SMS();
                    }
                    case 4 -> {
                        changePin();
                    }
                    case 5 -> {
                        fillBalance();
                    }
                    case 6 -> {
                        tariffService.showCurrentUserTariff(currentUserId);
                    }
                    case 0 -> {
                    }
                }
            }
        } else {
            System.out.println("Sim card not found ");
        }
    }


    private static void call() {
        int var = 10;
        while (var != 0) {
            System.out.println("1.call someone 2. call history");
            var = scannerInt.nextInt();
            switch (var) {
                case 1 -> {
                    userService.show();
                    System.out.print("enter receiverId for call ");
                    int receiverId = scannerInt.nextInt();
                    System.out.print("how many minutes do you want to talk  ");
                    int time = scannerInt.nextInt();
                    System.out.println(callService.call(receiverId, currentUserId, time));
                }
                case 2 -> {
                    callService.callHistory(currentUserId);
                }
                case 0 -> {
                }
            }
        }

    }

    private static void internet() {
        int var2 = 10;
        while (var2 != 0) {
            System.out.println("2. enter internet  2. history");
            var2 = scannerInt.nextInt();
            switch (var2) {
                case 1 -> {
                    System.out.print("how many MB you want to use ");
                    int spendedMb = scannerInt.nextInt();
                    System.out.print("which site you want to visit ");
                    String usedPlace = scannerStr.nextLine();
                    System.out.println(internetService.spendMb(currentUserId, spendedMb, usedPlace));
                }
                case 2 -> {
                    internetService.historySpentMb(currentUserId);
                }
                case 0 -> {
                }
            }
        }
    }

    private static void SMS() {

        int var3 = 10;
        while (var3 != 0) {
            System.out.println("2. send sms  2. sms history");
            var3 = scannerInt.nextInt();
            switch (var3) {
                case 1 -> {
                    userService.show();
                    System.out.print("enter receiver id ");
                    int receiverId = scannerInt.nextInt();
                    System.out.println("enter massage ");
                    String massage = scannerStr.nextLine();
                    System.out.println(smsService.sendSMS(receiverId, currentUserId, massage));
                }
                case 2 -> {
                    smsService.historySms(currentUserId);
                }
                case 0 -> {
                }
            }
        }
    }

    private static void fillBalance() {
        System.out.print("enter pin code for fill balance ");
        int pinCode = scannerInt.nextInt();
        System.out.print("enter amount  ");
        double amount = scannerInt.nextDouble();
        System.out.println(simCardService.fillBalance(pinCode, amount));
    }

    private static void changePin() {
        System.out.print("enter sim card number ");
        int cardNum = scannerInt.nextInt();
        System.out.print("enter sim old pin code ");
        int oldPin = scannerInt.nextInt();
        System.out.print("enter sim new pin code ");
        int newPin = scannerInt.nextInt();
        System.out.println(simCardService.changePinCode(cardNum, oldPin, newPin));
    }

    private static void registration() {
        System.out.print("enter name ");
        String name = scannerStr.nextLine();
        System.out.print("enter password ");
        String password = scannerStr.nextLine();
        if (userService.add(name, password)) {
            System.out.println("User added");
        } else System.out.println("this user name already have ");
    }


    private static void mCompany() {
        int var = 10;
        while (var != 0) {
            System.out.println("1. Add company 2. Show companies 3. Update company 4. Delete company 0.back");
            var = scannerInt.nextInt();
            switch (var) {
                case 1 -> {
                    System.out.print(" enter name ");
                    String name = scannerStr.nextLine();
                    MCompany mCompany1 = new MCompany();
                    mCompany1.setName(name);
                    mCompanies.add(mCompany1);
                    System.out.println("company added");
                }
                case 2 -> {
                    mCompanyService.show();
                }
                case 3 -> {
                    System.out.print("enter company id ");
                    int id = scannerInt.nextInt();
                    MCompany updateCompany = (MCompany) mCompanyService.update(id);
                    if (updateCompany != null) {
                        System.out.println("enter name ");
                        updateCompany.setName(scannerStr.nextLine());
                    } else {
                        System.out.println("company not found ");
                    }
                }
                case 4 -> {
                    System.out.print("enter company id ");
                    int id = scannerInt.nextInt();
                    System.out.println(mCompanyService.delete(id));
                }
                case 0 -> {
                }
            }
        }
    }

    private static void tariff() {
        int var = 10;
        while (var != 0) {
            System.out.println("1. Add tariff  2. Show tariffs 3. Update tariff 4. Delete tariff ");
            var = scannerInt.nextInt();
            switch (var) {
                case 1 -> {
                    System.out.print("enter  tariff name ");
                    String name = scannerStr.nextLine();
                    mCompanyService.show();
                    System.out.print(" enter company id ");
                    int id = scannerInt.nextInt();
                    MCompany mCompany1 = (MCompany) mCompanyService.getById(id);
                    System.out.print(" price for month ");
                    double forMonth = scannerInt.nextDouble();
                    System.out.print(" enter free minutes  ");
                    int freeMinutes = scannerInt.nextInt();
                    System.out.print(" enter free MB  ");
                    int freeMB = scannerInt.nextInt();
                    System.out.print(" enter free SMS  ");
                    int freeSMS = scannerInt.nextInt();
                    System.out.print(" price for one minute ");
                    double priceForOneMin = scannerInt.nextDouble();
                    System.out.print(" price for one MB ");
                    double priceForOneMB = scannerInt.nextDouble();
                    System.out.print(" price for one SMS ");
                    double priceForOneSMS = scannerInt.nextDouble();
                    System.out.println(tariffService.addTariff(name, mCompany1, forMonth, freeMinutes, freeMB, freeSMS,
                            priceForOneMin, priceForOneMB, priceForOneSMS));

                }
                case 2 -> {
                    tariffService.show();
                }
                case 3 -> {
                    System.out.print("enter tariff id ");
                    int id = scannerInt.nextInt();
                    Tariff tariff = (Tariff) tariffService.getById(id);
                    if (tariff != null) {
                        System.out.print("enter tariff  name ");
                        String name = scannerStr.nextLine();
                        tariff.setName(name);
                        System.out.print("price for month ");
                        double forMonth = scannerInt.nextDouble();
                        tariff.setPriceForMonth(forMonth);
                        System.out.print("enter free minutes  ");
                        int freeMinutes = scannerInt.nextInt();
                        tariff.setFreeMinutes(freeMinutes);
                        System.out.print("enter free MB  ");
                        int freeMB = scannerInt.nextInt();
                        tariff.setFreeMB(freeMB);
                        System.out.print("enter free SMS  ");
                        int freeSMS = scannerInt.nextInt();
                        tariff.setFreeSMS(freeSMS);
                        System.out.print(" price for one minute ");
                        double priceForOneMin = scannerInt.nextDouble();
                        tariff.setPriceForOneMinute(priceForOneMin);
                        System.out.print(" price for one MB ");
                        double priceForOneMB = scannerInt.nextDouble();
                        tariff.setPriceForOneMB(priceForOneMB);
                        System.out.print(" price for one SMS ");
                        double priceForOneSMS = scannerInt.nextDouble();
                        tariff.setPriceForOneSMS(priceForOneSMS);
                    } else {
                        System.out.println("tariff not fount ");
                    }
                }
                case 4 -> {
                    System.out.print("enter TariffId for delete tariff ");
                    tariffService.delete(scannerInt.nextInt());
                }
                case 0 -> {
                }
            }
        }
    }

    private static void simCard() {
        int var = 10;
        while (var != 0) {
            System.out.println("1. Give Sim card 2. Open blocked simCard 3.show simCard");
            var = scannerInt.nextInt();
            switch (var) {
                case 1 -> {
                    mCompanyService.show();
                    System.out.print("enter company id ");
                    MCompany mCompany = (MCompany) mCompanyService.getById(scannerInt.nextInt());
                    tariffService.show();
                    System.out.print("enter tariff id ");
                    Tariff tariff = (Tariff) tariffService.getById(scannerInt.nextInt());
                    userService.show();
                    System.out.print("enter user id ");
                    int userId = scannerInt.nextInt();
                    System.out.print("enter  sim card number ");
                    int simCardNum = scannerInt.nextInt();
                    System.out.print("enter sim card pin code ");
                    int pinCode = scannerInt.nextInt();
                    System.out.println(simCardService.giveSimCard(mCompany, tariff, userId, simCardNum, pinCode));
                }
                case 2 -> {
                    System.out.print(" enter sim card pinCode ");
                    int pinCode = scannerInt.nextInt();
                    System.out.println(simCardService.changeActive(pinCode));
                }
                case 3 -> {
                    simCardService.showSimCrd();
                }
                case 0 -> {
                }
            }
        }
    }

    private static void benefit() {
        int var = 10;
        while (var != 0) {
            System.out.println("1. Benefit from call 2. Benefit from Internet 3.Benefit from SMS 0.back");
            var = scannerInt.nextInt();
            switch (var) {
                case 1 -> {

                    System.out.println(benefit.allBenefitFromCall() + " sum");
                }
                case 2 -> {
                    System.out.println(benefit.allBenefitFromInternet() + " sum");
                }
                case 3 -> {
                    System.out.println(benefit.allBenefitFromSMS() + " sum");
                }
                case 0 -> {
                }
            }
        }
    }
}