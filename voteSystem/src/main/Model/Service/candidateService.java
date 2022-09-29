package main.Model.Service;

import main.Model.JavaBean.Candidate;
import main.Utils.DBUtils;

public class candidateService {
    public static void changeStatus(int tId){
        String sql = "update Candidate set available = available ^ 1 where tId = ?";
        DBUtils.update(sql, tId);
    }
    public static void deleteCandidate(int tId){
        String sql = "delete from Candidate where tId = ?";
        DBUtils.update(sql, tId);
    }
    public static void insertCandidate(Candidate candidate){
        String sql = "insert into Candidate(tName, votes, available) values(?, ?, ?)";
        DBUtils.update(sql, candidate.getTName(), 0, 1);
    }
    public static int checkStatus(int tId){
        String sql = "select * from Candidate where tId = ?";
        return DBUtils.queryInstance(Candidate.class, sql, tId).getAvailable();
    }
}
