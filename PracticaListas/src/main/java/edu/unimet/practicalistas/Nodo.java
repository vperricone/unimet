package edu.unimet.practicalistas;

public class Nodo {

    private Object valor;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(Object nuevoValor) {
        this.valor = nuevoValor;
    }

    public void asignarValor(Object nuevoValor) {
        this.valor = nuevoValor;
    }

    public void asignarSiguiente(Nodo nodoSiguiente) {
        this.siguiente = nodoSiguiente;
    }

    public Object obtenerValor() {
        return this.valor;
    }

    public Nodo obtenerSiguiente() {
        return this.siguiente;
    }
    
    @Override
    public String toString() {
        return valor + " -> "  + (siguiente != null ? "Nodo" : "null");
    }
}
