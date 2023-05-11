package Service;

import Model.Leds;
import Model.ListDe;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListDeService {
    static ListDe leds;

    public ListDeService() {
        leds = new ListDe();
    }

    public void addLedToEnd(Leds led) {
        leds.addLed(led);
    }

    public void addLedToStart(Leds led) {
        leds.addLedToStart(led);
    }
    public static void restartLeds(){leds.restartLeds();}
}
