package Model;

import exeptions.ListDeException;
import lombok.Data;


@Data
public class ListDe {
    private NodeDE head;
    private int size;
    public void addLed(Leds led) throws ListDeException {
        if (this.head != null) {
            NodeDE temp = this.head;
            while (temp.getNext() != null) {
                if(temp.getData().getId()==led.getId()){
                    throw new ListDeException("400","Ya existe un led con este codigo");
                }
               temp = temp.getNext();
            }
            if(temp.getData().getId()==led.getId()){
                throw new ListDeException("400","Ya existe un led con ese codigo");
            }
            NodeDE newNode = new NodeDE(led);
            temp.setNext(newNode);
            temp.setPrevious(temp);
        } else {
            this.head = new NodeDE(led);
        }
        size++;
    }


    public void addLedToStart(Leds led) {
        NodeDE newNode = new NodeDE(led);
        if (this.head != null) {
            this.head.setPrevious(newNode);
        }
        this.head = newNode;
        size++;
    }


    public void restartLeds() {
        NodeDE temp = this.head;
        while (temp != null) {
            temp.getData().setState(false);
            temp = temp.getNext();
        }
        if (this.head == null) {
        }
    }
    /*

    metodo para encontrar la mitad  de la lista de los leds , primero debo comprobar que en la lista hay datos y no etsa vacia
    pero si tiene datos necesito un contador que me guarde cuantos datos tiene esta lista y este iniciarlo en 0, puedo utilizar
    un while que me recorra toda la lista de leds caundo ya tenga el total de datos que tiene la lista encuentro la mitad de esta
    diviendo esta entre 2 pero si la lista de leds es impar se debe encender el de led del medio y el anterior de este osea se deben encender 2 de estos

     */
    public NodeDE MiddlLeds(Leds led) {
        if (head == null) {
            return null;
        }
        int cont = 0;
        NodeDE actu = head;
        while (actu != null) {
            cont++;
            actu = actu.getNext();
        }
        int middle = cont / 2;
        actu = head;
        for (int i = 0; i < middle; i++) {
            actu = actu.getNext();
        }
        if (size % 2 != 0) {
            NodeDE prev = actu.getPrevious();
            if (prev != null) {
                prev.getData().setState(true);
            }
            actu.getData().setState(true);
        }
        return actu;
    }
}
