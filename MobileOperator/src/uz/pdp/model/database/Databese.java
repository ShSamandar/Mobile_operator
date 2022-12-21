package uz.pdp.model.database;

import uz.pdp.model.*;

import java.util.ArrayList;
import java.util.List;

public interface Databese {
    List <User> users=new ArrayList<>();
    List<SimCard> simCards=new ArrayList<>();
    List<MCompany> mCompanies=new ArrayList<>();
    List <Tariff> tariffs=new ArrayList<>();
    List<Call> callHistories=new ArrayList<>();
    List<Internet> spentMb =new ArrayList<>();
    List<SMS> sentSMS =new ArrayList<>();
}
