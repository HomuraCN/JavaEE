package main.Model.Service;

import main.Model.JavaBean.Voter;
import main.Utils.DBUtils;

public class registerService {
    public static boolean checkAccountExist(Voter voter){
        String sql = "select account from Voter where account = ?";
        Voter v = DBUtils.queryInstance(Voter.class, sql, voter.getAccount());
        if(v == null){
            register(voter);
            return false;
        }
        else{
            return true;
        }
    }

    public static void register(Voter voter){
        String sql = "insert into Voter(account, password) values(?, ?)";
        DBUtils.update(sql, voter.getAccount(), voter.getPassword());
    }
}
