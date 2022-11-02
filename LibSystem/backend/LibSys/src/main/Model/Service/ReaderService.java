package main.Model.Service;

import main.Model.JavaBean.Reader;
import main.Utils.DBUtils;

import java.util.List;

public class ReaderService {
    public List<Reader> getReaderList(){
        String sql = "select * from Reader";
        return DBUtils.queryList(Reader.class, sql);
    }

    public void updateReaderListById(int rId, String account, String password, String type, int borrowingTimes){
        System.out.println("更新了");
        String sql = "update Reader set account = ?, password = ?, type = ?, borrowingTimes = ? where rId = ?";
        DBUtils.update(sql, account, password, type, borrowingTimes, rId);
    }
}
