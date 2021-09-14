package sk.stuba.fei.uim.oop.spring.mvcvalidation;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class Item {

    @Min(0)
    private long id;
    @NotNull
    @Size(min = 1)
    private String name;
    @NotNull
    @PastOrPresent
    private LocalDateTime creationDate;

    public Item(long id, String name) {
        this.id = id;
        this.name = name;
        this.creationDate = LocalDateTime.now();
    }
}