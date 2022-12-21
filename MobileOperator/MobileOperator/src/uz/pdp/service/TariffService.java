package uz.pdp.service;

import uz.pdp.model.MCompany;
import uz.pdp.model.SimCard;
import uz.pdp.model.Tariff;
import uz.pdp.model.database.Databese;

public class TariffService implements Databese ,BaseService {
public  boolean addTariff(String name , MCompany mCompany, double priceForMonth,
    int freeMinutes, int freeMB, int freeSMS, double priceForOneMinute,
    double priceForOneMB, double priceForOneSMS)
{
                Tariff tariff1 =new Tariff();
                tariff1.setName(name);
                tariff1.setmCompany(mCompany);
                tariff1.setPriceForMonth(priceForMonth);
                tariff1.setFreeMinutes(freeMinutes);
                tariff1.setFreeMB(freeMB);
                tariff1.setFreeSMS(freeSMS);
                tariff1.setPriceForOneMinute(priceForOneMinute);
                tariff1.setPriceForOneMB(priceForOneMB);
                tariff1.setPriceForOneSMS(priceForOneSMS);
                tariffs.add(tariff1);
                return true;
}

    @Override
    public boolean add(String name, String password) {
        return false;
    }

    @Override
    public void show() {
        for (Tariff tariff : tariffs) {
            if (tariff!=null){
                System.out.println(tariff);
            }
        }
    }

    @Override
    public Object update(int id) {
        for (Tariff tariff : tariffs) {
            if (tariff!=null){
                if (tariff.getId()==id){
                    return tariff;
                }
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        for (Tariff tariff : tariffs) {
            if (tariff!=null){
                if (tariff.getId()==id){
                    tariffs.remove(tariff);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object getById(int id) {
        for (Tariff tariff : tariffs) {
            if (tariff!=null){
                if (tariff.getId()==id){
                    return tariff;
                }
            }
        }
        return null;
    }
    public void showCurrentUserTariff(int userId){
        for (SimCard simCard : simCards) {
            if (simCard!=null){
                if (simCard.getUserId()==userId){
                    System.out.println(simCard.getTariff());
                }
            }
        }
    }
}
