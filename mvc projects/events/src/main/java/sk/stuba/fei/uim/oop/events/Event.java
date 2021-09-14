package sk.stuba.fei.uim.oop.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Event<T> {

    private T source;
}
