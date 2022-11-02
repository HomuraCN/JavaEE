package main.Model.Service;

import main.Model.JavaBean.Library;
import main.Utils.DBUtils;

import java.util.List;

public class LibraryService {
    public List<Library> getLibraryInfo(){
        String sql = "select * from Library";
        return DBUtils.queryList(Library.class, sql);
    }
}
