package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeDE {
    private Leds data;
    private NodeDE next;
    private NodeDE previous;

    public NodeDE(Leds data) {
        this.data = data;
    }
}
