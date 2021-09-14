package sk.stuba.fei.uim.oop.spring.mvcform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private boolean checkbox;
    private LocalDate date;
    private LocalDateTime dateTime;
    private long number;
    private String text;

}