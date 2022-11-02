package main.Model.JavaBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    private String lName;
    private String address;
    private Date establishmentTime;
    private String director;
    private String phoneNumber;
}
