package main.Model.Service;

import main.Model.JavaBean.Candidate;
import main.Model.JavaBean.Voter;
import main.Utils.DBUtils;

import java.util.List;

public class voterService {
    public static final int pageSize = 3;
    public static List<Voter> queryListVoterPagination(int pageIndex){
        String sql = "select top " + pageSize + " * from Voter where account not in (select top " + pageSize * (pageIndex - 1) + " account from Voter)";
        return DBUtils.queryList(Voter.class, sql);
    }
    public static int getVoterPageCnt(){
        String sql = "select * from Voter";
        List<Voter> list = DBUtils.queryList(Voter.class, sql);
        if(list.size() / pageSize == 0){
            return 0;
        }
        else{
            return list.size() / pageSize + 1;
        }
    }
}
