package main.Model.JavaBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    private int rId;
    private String account;
    private String password;
    private String type;
    private int borrowingTimes;
}
