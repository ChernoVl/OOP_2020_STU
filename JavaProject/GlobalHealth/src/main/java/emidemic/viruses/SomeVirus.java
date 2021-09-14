package emidemic.viruses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SomeVirus implements Virus {
    private int curability = 14; //day
}
