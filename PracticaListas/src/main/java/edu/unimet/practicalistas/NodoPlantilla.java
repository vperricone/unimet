package edu.unimet.practicalistas;

public class NodoPlantilla<T> {

    private T valor;
    private NodoPlantilla siguiente;

    public NodoPlantilla() {
    }

    public NodoPlantilla(T nuevoValor) {
        this.valor = nuevoValor;
    }

    public void asignarValor(T nuevoValor) {
        this.valor = nuevoValor;
    }

    public void asignarSiguiente(NodoPlantilla nodoSiguiente) {
        this.siguiente = nodoSiguiente;
    }

    public T obtenerValor() {
        return this.valor;
    }

    public NodoPlantilla obtenerSiguiente() {
        return this.siguiente;
    }
    
    @Override
    public String toString() {
        return valor + " -> "  + (siguiente != null ? "Nodo" : "null");
    }
}
