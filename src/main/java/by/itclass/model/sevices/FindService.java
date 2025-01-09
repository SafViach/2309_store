package by.itclass.model.sevices;

import by.itclass.model.dao.FindDao;
import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.ClassFind;

import java.util.List;

public class FindService {
    private static FindService service;
    private FindDao dao;

    public FindService() {
        dao = FindDao.getInstance();
    }

    public static FindService getInstance(){
        return service == null ? new FindService() : service;
    }

    public List<ClassFind> getFind(String str){
        return dao.resultFind(str);
    }
}
