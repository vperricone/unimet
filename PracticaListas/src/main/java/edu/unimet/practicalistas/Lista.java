package edu.unimet.practicalistas;

public class Lista {

    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private Nodo nodoActual;
    private int longitud;

    public int obtenerLongitud() {
        return this.longitud;
    }

    private Nodo obtenerNodo(int indice) {
        Nodo retorno = null;
        if (indice >= 0 && indice < this.obtenerLongitud()) {
            Nodo aux = this.primerNodo;
            for (int i = 0; i < indice; i++) {
                if (aux != null) {
                    aux = aux.obtenerSiguiente();
                }
            }
            retorno = aux;
        }
        return retorno;
    }

    public boolean estaVacia() {
        return this.longitud == 0;
    }

    public Object obtener(int indice) {
        Object retorno = null;
        if (indice >= 0 && indice < this.longitud) {
            Nodo aux = this.primerNodo;
            for (int i = 0; i < indice; i++) {
                if (aux !=null) {
                    aux = aux.obtenerSiguiente();
                }
            }
            if (aux != null) {
                retorno = aux.obtenerValor();
            }
        }
        return retorno;
    }

    public void agregar(Object valor, int indice) {
        Nodo nuevoNodo = new Nodo(valor);
        if (this.longitud == 0) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            int ultimoIndice = this.longitud - 1;
            int indiceAnterior = indice - 1;
            if (indice <= 0) {
                nuevoNodo.asignarSiguiente(this.primerNodo);
                this.primerNodo = nuevoNodo;
            } else if (indice >= ultimoIndice) {
                this.ultimoNodo.asignarSiguiente(nuevoNodo);
                this.ultimoNodo = nuevoNodo;
            } else {
                Nodo nodoAnterior = this.obtenerNodo(indiceAnterior);
                nuevoNodo.asignarSiguiente(nodoAnterior.obtenerSiguiente());
                nodoAnterior.asignarSiguiente(nuevoNodo);
            }
        }
        this.longitud++;
    }

    public void agregar(Object valor) {
        this.agregarCola(valor);
    }

    public void agregarCola(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (this.longitud == 0) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            this.ultimoNodo.asignarSiguiente(nuevoNodo);
            this.ultimoNodo = nuevoNodo;
        }
        this.longitud++;
    }

    public void agregarPila(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (this.longitud == 0) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.asignarSiguiente(this.primerNodo);
            this.primerNodo = nuevoNodo;
        }
        this.longitud++;
    }

    public void eliminar(int indice) {
        if (indice == 0) {
            this.primerNodo = this.primerNodo.obtenerSiguiente();
        } else if (indice == this.longitud - 1) {
            Nodo nodoAnterior = this.obtenerNodo(indice - 1);
            nodoAnterior.asignarSiguiente(null);
            this.ultimoNodo = nodoAnterior;
        } else {
            Nodo nodoAnterior = this.obtenerNodo(indice - 1);
            Nodo nodoSolicitado = this.obtenerNodo(indice);
            nodoAnterior.asignarSiguiente(nodoSolicitado.obtenerSiguiente());
        }
        this.longitud--;
    }

    public Object buscar(Object valorConsulta) {
        if (valorConsulta != null) {
            for (int indice = 0; indice < this.longitud; indice++) {
                Object valor = this.obtener(indice);
                if (valor != null && valor.equals(valorConsulta)) {
                    return this.obtener(indice);
                }
            }
        }
        return null;
    }

    public Lista filtrar(Object valorConsulta) {
        Lista listaFiltrada = new Lista();
        if (valorConsulta != null) {
            for (int indice = 0; indice < this.longitud; indice += 1) {
                Object valor = this.obtener(indice);
                if (valor != null && valor.equals(valorConsulta)) {
                    listaFiltrada.agregar(valor);
                }
            }
        }
        return listaFiltrada;
    }

    public boolean siguiente() {
        if (this.nodoActual == null) {
            this.nodoActual = primerNodo;
            return true;
        } else {
            Nodo aux = this.nodoActual;
            if (aux != null) {
                aux = aux.obtenerSiguiente();
            }
            if (aux == null) {
                return false;
            } else {
                this.nodoActual = aux;
                return true;
            }
        }
    }

    public Object obtener() {
        if (this.nodoActual == null) {
            return null;
        } else {
            return this.nodoActual.obtenerValor();
        }
    }

    public Object obtenerPrimero() {
        if (this.primerNodo == null) {
            return null;
        } else {
            return this.primerNodo.obtenerValor();
        }
    }

    public Object obtenerUltimo() {
        if (this.ultimoNodo == null) {
            return null;
        } else {
            return this.ultimoNodo.obtenerValor();
        }
    }

    public void reiniciar() {
        this.nodoActual = null;
    }

    public void vaciar() {
        this.longitud = 0;
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.nodoActual = null;
    }

    public void convertirAListaCircular() {
        this.ultimoNodo.asignarSiguiente(primerNodo);
    }

    public void disolverListaCircular() {
        this.ultimoNodo.asignarSiguiente(null);
    }

    public void ordenar(boolean ascendente) {
        boolean estaOrdenado = false;
        int penultimo = this.longitud-1;
        while(!estaOrdenado) {
            estaOrdenado = true;
            for (int indice=0; indice<=penultimo; indice++) {
                int indiceSiguiente = indice+1;
                int indiceAnterior = indice-1;
                Nodo nodo1 = this.obtenerNodo(indice);
                Nodo nodo2 = this.obtenerNodo(indiceSiguiente);
                if (nodo1 != null && nodo2 != null) {
                    Object valor1 = nodo1.obtenerValor();
                    Object valor2 = nodo2.obtenerValor();
                    if (valor1 != null && valor2 != null) {
                        int comparacion = valor1.toString().compareTo(valor2.toString());
                        boolean condicion1 = ascendente && comparacion > 0;
                        boolean condicion2 = !ascendente && comparacion < 0;
                        if (condicion1 || condicion2){
                            estaOrdenado = false;
                            if (indice == 0) {
                                Nodo nodoSiguente = nodo2.obtenerSiguiente();
                                this.primerNodo = nodo2;
                                nodo2.asignarSiguiente(nodo1);
                                nodo1.asignarSiguiente(nodoSiguente);
                            } else if (indice == penultimo) {
                                Nodo nodoAnterior = this.obtenerNodo(indiceAnterior);
                                nodoAnterior.asignarSiguiente(nodo2);
                                nodo2.asignarSiguiente(nodo1);
                                nodo1.asignarSiguiente(null);
                                this.ultimoNodo = nodo1;
                            } else {
                                Nodo nodoAnterior = this.obtenerNodo(indiceAnterior);
                                Nodo nodoSiguiente = nodo2.obtenerSiguiente();
                                nodoAnterior.asignarSiguiente(nodo2);
                                nodo2.asignarSiguiente(nodo1);
                                nodo1.asignarSiguiente(nodoSiguiente);
                            }                        
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < this.longitud; i++) {
            Object valor = this.obtener(i);
            if (valor != null) {
                String registro = valor.toString();
                resultado.append(registro);
                resultado.append("\r\n");
            } else {
                resultado.append("null\r\n");
            }
        }
        return resultado.toString();
    }
}
