package edu.unimet.practicalistas;

public class NodoDobleEnlazado {

    private Object valor;
    private NodoDobleEnlazado anterior;
    private NodoDobleEnlazado siguiente;

    public NodoDobleEnlazado() {
    }

    public NodoDobleEnlazado(Object nuevoValor) {
        this.valor = nuevoValor;
    }

    public void asignarValor(Object nuevoValor) {
        this.valor = nuevoValor;
    }

    public void asignarAnterior(NodoDobleEnlazado nodoAnterior) {
        this.anterior = nodoAnterior;
    }
        
    public void asignarSiguiente(NodoDobleEnlazado nodoSiguiente) {
        this.siguiente = nodoSiguiente;
    }

    public Object obtenerValor() {
        return this.valor;
    }

    public NodoDobleEnlazado obtenerAnterior() {
        return this.anterior;
    }
        
    public NodoDobleEnlazado obtenerSiguiente() {
        return this.siguiente;
    }
    
    @Override
    public String toString() {
        return valor + " -> "  + (anterior != null ? "Nodo :: " : "null  ::") + (siguiente != null ? "Nodo" : "null");
    }
}
