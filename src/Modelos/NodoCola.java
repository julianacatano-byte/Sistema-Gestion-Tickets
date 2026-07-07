package Modelos;

public class NodoCola {

    Ticket dato;
    NodoCola siguiente;

    public NodoCola(Ticket dato) {
        this.dato = dato;
        this.siguiente = null;
    }

}