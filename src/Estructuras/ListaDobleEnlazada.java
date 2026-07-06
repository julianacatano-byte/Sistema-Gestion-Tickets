package Estructuras;

import Modelos.Ticket;
import java.util.ArrayList;
import java.util.List;

public class ListaDobleEnlazada {
    private Nodo<Ticket> cabeza; //primer nodo de la lista
    private Nodo<Ticket> cola;// ultimo nodo de la lista
    //agregar un ticket al final de la lista
    public void agregar(Ticket ticket) {
        Nodo<Ticket> nuevo = new Nodo<>(ticket); //aqui se crea el nuevo nodo
        if (cabeza == null) {// si la lista esta vacia entonces:
            cabeza = nuevo;// el nuevo es la cabeza
            cola = nuevo;// y el nuevo tambien es la cola
        } else { //si hay elementos entonces
            cola.setSiguiente(nuevo); //el ultimo nodo apunta al nuevo
            nuevo.setAnterior(cola); // el nuevo apunta al anterior
            cola = nuevo; // el nuevo ahora es la cola
        }
    }
    //Busca un ticket por su numero de ID y que este en estado "En atencion"
    public Ticket buscar(int id) {
        Nodo<Ticket> actual = cabeza; // empieza a buscar desde la cabeza
        while (actual != null) { //recorre hasta el final de la lista
            if (actual.getDato().getId() == id && actual.getDato().getEstado().equals("En atencion")) {
                return actual.getDato(); // lo encontro entonces lo devuelve
            }
            actual = actual.getSiguiente(); //pasa al siguiente
        }
        return null; // en otro caso, no encontro nada
    }
    //Cambiar la prioridad de un ticket que ya esta en la lista
    public void cambiarPrioridad(Ticket ticket, String nuevaPrioridad) {

        ticket.setPrioridad(nuevaPrioridad); // solo actualiza el dato o la prioridad, da lo mismo
    }
   // elimina un ticket de la lista y devolveria true si lo elimina
    public boolean eliminar(Ticket ticket) {
        if (cabeza == null)
            return false; // en caso de que la lista este vacia, no habria nada que eliminar

        Nodo<Ticket> actual = cabeza;
        while (actual != null) {
            if (actual.getDato() == ticket) { //Encontro el nodo con ese ticket
                //1 caso: es el unico nodo en la lista
                if (actual == cabeza && actual == cola) {
                    cabeza = null;
                    cola = null;
                } // 2 caso: es el primer nodo, es decir la cabeza
                else if (actual == cabeza) {
                    cabeza = actual.getSiguiente(); // la cabeza ahora es el segundo
                    cabeza.setAnterior(null); // la nueva cabeza no tiene anterior
                } // 3 caso: es el ultimo nodo, es decir la cola
                else if (actual == cola) {
                    cola = actual.getAnterior(); //la cola ahora es el penultimo
                    cola.setSiguiente(null); // la nueva cola no tiene siguiente
                } else { // 4 caso: esta en medio de dos nodos
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return true; // ticket eliminido
            }
            actual = actual.getSiguiente(); //sigue buscando
        }
        return false; // no pudo encontrar el ticket
    }
    // devuelve la lista normal ordenada desde cabeza hasta cola
    public List<Ticket> recorrerInicioFin() {
        List<Ticket> lista = new ArrayList<>();
        Nodo<Ticket> actual = cabeza;
        while (actual != null) {
            lista.add(actual.getDato()); // agrega el ticket a la lista
            actual = actual.getSiguiente();
        }
        return lista;
    }
    // devuelve una lista normal ordenada desde la cola hasta la cabeza
    public List<Ticket> recorrerFinInicio() {
        List<Ticket> lista = new ArrayList<>();
        Nodo<Ticket> actual = cola;
        while (actual != null) {
            lista.add(actual.getDato()); // agrega el ticket a la lista
            actual = actual.getAnterior();
        }
        return lista;
    }
    // avisa si la lista esta vacia o no
    public boolean estaVacia() {

        return cabeza == null;
    }
}
