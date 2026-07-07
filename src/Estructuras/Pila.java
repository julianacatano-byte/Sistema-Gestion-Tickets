package Estructuras;

import java.util.ArrayList;
import java.util.List;

public class Pila<T> {
    private NodoPila<T> cima;

    public void push(T dato) {
        NodoPila<T> nuevo = new NodoPila<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public T pop() {
        if (cima == null) return null;
        T dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    public T peek() {
        return (cima != null) ? cima.dato : null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public List<T> getTodos() {
        List<T> lista = new ArrayList<>();
        NodoPila<T> actual = cima;
        while (actual != null) {
            lista.add(actual.dato);
            actual = actual.siguiente;
        }
        return lista;
    }
}
