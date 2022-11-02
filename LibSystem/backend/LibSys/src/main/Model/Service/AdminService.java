package main.Model.Service;

import main.Model.JavaBean.Admin;
import main.Utils.DBUtils;

import java.util.List;

public class AdminService {
    public Admin getAdminByAccount(String account){
        String sql = "select * from Admin where account = ?";
        return DBUtils.queryInstance(Admin.class, sql, account);
    }

    public List<Admin> getAdminList(){
        String sql = "select * from Admin";
        return DBUtils.queryList(Admin.class, sql);
    }

    public void updateAdminListById(int aId, String account, String password){
        String sql = "update Admin set account = ? password = ? where aId = ?";
        DBUtils.update(sql, account, password, aId);
    }
}
