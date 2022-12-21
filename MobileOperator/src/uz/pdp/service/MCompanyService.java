package uz.pdp.service;

import uz.pdp.model.MCompany;
import uz.pdp.model.database.Databese;

import java.util.List;

public class MCompanyService implements Databese ,BaseService {

//    public MCompany addMCompany(String name){
//        for (MCompany mCompany : mCompanies) {
//                if (mCompany.getName().equals(name)){
//                    return null;
//                }
//        }
//        return null;
//    }

    @Override
    public boolean add(String name, String password) {
        return false;
    }

    @Override
    public void show() {
        for (MCompany mCompany : mCompanies) {
            if (mCompany!=null){
                System.out.println(mCompany);
            }
        }
    }

    @Override
    public Object update(int id) {
        for (MCompany mCompany : mCompanies) {
            if (mCompany!=null){
                if (mCompany.getId()==id) {
                    return mCompany;
                }
            }
        }
        return null;
    }
    @Override
    public boolean delete(int id) {
        for (MCompany mCompany : mCompanies) {
            if (mCompany!=null){
                if (mCompany.getId()==id)
                {
                    mCompanies.remove(mCompany);
                    return true;
                }
            }
        }
        return false;
}

    @Override
    public Object getById(int id) {
        for (MCompany mCompany : mCompanies) {
            if (mCompany!=null){
                if (mCompany.getId()==id)
                {
                  return   mCompany;

                }
            }
        }
        return null;
    }
}

