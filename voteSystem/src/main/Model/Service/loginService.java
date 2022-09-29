package main.Model.Service;

import main.Model.JavaBean.Voter;
import main.Utils.DBUtils;
import org.junit.Test;

public class loginService {
    public static boolean login(Voter voter){
        String sql = "select account, password from Voter where account = ? and password = ?";
        Voter v = DBUtils.queryInstance(Voter.class, sql, voter.getAccount(), voter.getPassword());
        if(v == null){
            return false;
        }
        else{
            return true;
        }
    }
}
