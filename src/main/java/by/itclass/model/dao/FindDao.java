package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.ClassFind;
import by.itclass.model.sevices.FindService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.AppConst.*;

public class FindDao {
    public static final String SELECT_FIND = "SELECT vendor , model FROM laptop WHERE vendor LIKE ? OR model LIKE ? " +
            "UNION SELECT vendor , model FROM tv WHERE vendor LIKE ? OR model LIKE ?";

    private static FindDao dao;
    private static FindService service;

    public FindDao() {
       ConnectionManager.init();
    }

    public static FindDao getInstance(){
       return dao == null ? new FindDao() : dao;
    }

    public List<ClassFind> resultFind(String str){
        String str1 = "%"+str+"%";
        List<ClassFind> resultFind = new ArrayList<>();
        try(var cn = ConnectionManager.getConnection();
        var ps = cn.prepareStatement(SELECT_FIND)) {
            ps.setString(1,str1);
            ps.setString(2,str1);
            ps.setString(3,str1);
            ps.setString(4,str1);
            var rs = ps.executeQuery();
            while (rs.next()){
                var vendor = rs.getString(VENDOR_PARAM);
                var model = rs.getString(MODEL_PARAM);
                var rsFind = new ClassFind(vendor , model);
                resultFind.add(rsFind);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultFind;
    }

}
