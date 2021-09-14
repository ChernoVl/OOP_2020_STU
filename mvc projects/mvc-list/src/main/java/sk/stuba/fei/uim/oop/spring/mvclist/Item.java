package sk.stuba.fei.uim.oop.spring.mvclist;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Item {

    private long id;
    private String name;
    private LocalDateTime creationDate;

    public Item(long id, String name) {
        this.id = id;
        this.name = name;
        this.creationDate = LocalDateTime.now();
    }
}