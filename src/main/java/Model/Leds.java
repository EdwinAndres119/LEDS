package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalTime;
@Data
@AllArgsConstructor
public class Leds {
    private int id;
    private boolean state;
    private LocalTime dateOn;
    private LocalTime dateOff;
}

