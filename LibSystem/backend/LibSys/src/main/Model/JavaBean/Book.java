package main.Model.JavaBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int bId;
    private String ISBN;
    private String type;
    private double price;
    private String publisher;
    private String bookName;
}
