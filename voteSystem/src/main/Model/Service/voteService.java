package main.Model.Service;

import main.Model.JavaBean.Candidate;
import main.Model.JavaBean.Voter;
import main.Utils.DBUtils;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class voteService {

    private static final int pageSize = 3;

    public static List<Candidate> queryListPagination(int pageIndex){
        String sql = "select top " + pageSize + " tId, tName, votes from Candidate where tId not in (select top " + pageSize * (pageIndex - 1) + " tId from Candidate)";
        return DBUtils.queryList(Candidate.class, sql);
    }

    public static int getCandidatePageCnt(){
        String sql = "select * from Candidate";
        List<Candidate> list = DBUtils.queryList(Candidate.class, sql);
        if(list.size() / pageSize == 0){
            return 0;
        }
        else{
            return list.size() / pageSize + 1;
        }
    }

    public static boolean vote(int tId, String account){
        String sql1 = "select * from Voter where account = ?";
        Voter voter = DBUtils.queryInstance(Voter.class, sql1, account);
        Date currentDate = new Date(System.currentTimeMillis());
        if(voter.getVoteTime() != null && currentDate.toString().equals(voter.getVoteTime().toString())){
            return false;
        }
        else{
            String sql2 = "update Voter set voteTime = ? where account = ?";
            DBUtils.update(sql2, currentDate, account);
            String sql3 = "update Candidate set votes = votes + 1 where tId = ?";
            DBUtils.update(sql3, tId);
            return true;
        }
    }

    @Test
    public void test1(){
        Date date1 = new Date(System.currentTimeMillis());
        Date date2 = new Date(System.currentTimeMillis());
        if(date1.toString().equals(date2.toString())){
            System.out.println(true);
        }
    }
}
