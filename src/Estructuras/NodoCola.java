package Estructuras;

import Modelos.Ticket;

public class NodoCola {
    Ticket dato;
    NodoCola siguiente;

    public NodoCola(Ticket dato) {
        this.dato = dato;
    }
}
