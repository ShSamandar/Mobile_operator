package uz.pdp.service;

import java.util.List;

public interface BaseService {
    boolean add(String name,String password);
    void  show();
    Object update(int id);
    boolean delete(int id);
    Object getById(int id);

}
