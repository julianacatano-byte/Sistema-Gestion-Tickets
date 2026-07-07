package Estructuras;

import java.util.ArrayList;
import java.util.List;

public class Pila<T> {

    private NodoPila<T> cima;
    private int tamaño;

    public Pila() {
        cima = null;
        tamaño = 0;
    }

    // Agregar un elemento a la pila
    public void push(T dato) {
        NodoPila<T> nuevo = new NodoPila<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamaño++;
    }

    // Eliminar el elemento de la cima
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T dato = cima.dato;
        cima = cima.siguiente;
        tamaño--;

        return dato;
    }

    // Obtener el elemento de la cima sin eliminarlo
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return cima.dato;
    }

    // Saber si la pila está vacía
    public boolean isEmpty() {
        return cima == null;
    }

    // Alias del método anterior (opcional)
    public boolean estaVacia() {
        return isEmpty();
    }

    // Obtener el tamaño de la pila
    public int size() {
        return tamaño;
    }

    // Mostrar todos los elementos de la pila
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }

        NodoPila<T> actual = cima;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    // Retornar todos los elementos en una lista
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