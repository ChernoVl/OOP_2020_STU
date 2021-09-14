package sk.example.exam.domain.componens;

import lombok.Data;

@Data
public abstract class Item {
    private long id;
    private String name;
}
