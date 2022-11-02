package main.Model.Service;

import main.Model.JavaBean.RB;
import main.Utils.DBUtils;

import java.util.List;

public class RBService {
    public void insertRB(int rbId, int rId, int bId){
        String sql = "insert into RB(rbId, rId, bId) values(?, ?, ?)";
        DBUtils.update(sql, rbId, rId, bId);
    }

    public void deleteRBByRIdAndBId(int rId, int bId){
        String sql = "delete from RB where rId = ? and bId = ?";
        DBUtils.update(sql, rId, bId);
    }
    public List<RB> getRBList(){
        String sql = "select * from RB";
        return DBUtils.queryList(RB.class, sql);
    }
}
