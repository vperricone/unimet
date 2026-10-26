package edu.unimet.practicalistas;

public class ListaDobleEnlazada {

    private NodoDobleEnlazado primerNodo;
    private NodoDobleEnlazado ultimoNodo;
    private NodoDobleEnlazado nodoActual;
    private int longitud;

    public int obtenerLongitud() {
        return this.longitud;
    }

    private NodoDobleEnlazado obtenerNodo(int indice) {
        NodoDobleEnlazado retorno = null;
        if (indice >= 0 && indice < this.obtenerLongitud()) {
            NodoDobleEnlazado aux = this.primerNodo;
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
            NodoDobleEnlazado aux = this.primerNodo;
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
        NodoDobleEnlazado nuevoNodo = new NodoDobleEnlazado(valor);
        if (this.longitud == 0) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            int ultimoIndice = this.longitud - 1;
            int indiceAnterior = indice - 1;
            if (indice <= 0) {
                this.primerNodo.asignarAnterior(nuevoNodo);
                nuevoNodo.asignarSiguiente(this.primerNodo);
                this.primerNodo = nuevoNodo;
            } else if (indice >= ultimoIndice) {
                nuevoNodo.asignarAnterior(this.ultimoNodo);
                this.ultimoNodo.asignarSiguiente(nuevoNodo);
                this.ultimoNodo = nuevoNodo;
            } else {
                NodoDobleEnlazado nodoAnterior = this.obtenerNodo(indiceAnterior);
                nuevoNodo.asignarSiguiente(nodoAnterior.obtenerSiguiente());
                nodoAnterior.asignarSiguiente(nuevoNodo);
                nuevoNodo.asignarAnterior(nodoAnterior);
            }
        }
        this.longitud++;
    }

    public void agregar(Object valor) {
        this.agregarCola(valor);
    }

    public void agregarCola(Object valor) {
        NodoDobleEnlazado nuevoNodo = new NodoDobleEnlazado(valor);
        if (this.longitud == 0) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            this.ultimoNodo.asignarSiguiente(nuevoNodo);
            nuevoNodo.asignarAnterior(this.ultimoNodo);
            this.ultimoNodo = nuevoNodo;
            
        }
        this.longitud++;
    }

    public void agregarPila(Object valor) {
        NodoDobleEnlazado nuevoNodo = new NodoDobleEnlazado(valor);
        if (this.longitud == 0) {
            this.primerNodo = nuevoNodo;
            this.ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.asignarSiguiente(this.primerNodo);
            this.primerNodo.asignarAnterior(nuevoNodo);
            this.primerNodo = nuevoNodo;
        }
        this.longitud++;
    }

    public void eliminar(int indice) {
        if (indice == 0) {
            this.primerNodo = this.primerNodo.obtenerSiguiente();
            this.primerNodo.asignarAnterior(null);
        } else if (indice == this.longitud - 1) {
            NodoDobleEnlazado nodoAnterior = this.obtenerNodo(indice - 1);
            nodoAnterior.asignarSiguiente(null);
            this.ultimoNodo = nodoAnterior;
        } else {
            NodoDobleEnlazado nodoAnterior = this.obtenerNodo(indice - 1);
            NodoDobleEnlazado nodoSolicitado = this.obtenerNodo(indice);
            NodoDobleEnlazado nodoSiguiente = nodoSolicitado.obtenerSiguiente();
            nodoSiguiente.asignarAnterior(nodoAnterior);
            nodoAnterior.asignarSiguiente(nodoSiguiente);
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

    public ListaDobleEnlazada filtrar(Object valorConsulta) {
        ListaDobleEnlazada listaFiltrada = new ListaDobleEnlazada();
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
            NodoDobleEnlazado aux = this.nodoActual;
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

        public boolean anterior() {
        if (this.nodoActual == null) {
            this.nodoActual = primerNodo;
            return true;
        } else {
            NodoDobleEnlazado aux = this.nodoActual;
            if (aux != null) {
                aux = aux.obtenerAnterior();
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
                NodoDobleEnlazado nodo1 = this.obtenerNodo(indice);
                NodoDobleEnlazado nodo2 = this.obtenerNodo(indiceSiguiente);
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
                                NodoDobleEnlazado nodoSiguente = nodo2.obtenerSiguiente();
                                this.primerNodo = nodo2;
                                nodo2.asignarSiguiente(nodo1);
                                nodo1.asignarSiguiente(nodoSiguente);
                                nodoSiguente.asignarAnterior(nodo1);
                                nodo1.asignarAnterior(nodo2);
                            } else if (indice == penultimo) {
                                NodoDobleEnlazado nodoAnterior = this.obtenerNodo(indiceAnterior);
                                nodoAnterior.asignarSiguiente(nodo2);
                                nodo2.asignarSiguiente(nodo1);
                                nodo1.asignarSiguiente(null);
                                nodo1.asignarAnterior(nodo2);
                                this.ultimoNodo = nodo1;
                            } else {
                                NodoDobleEnlazado nodoAnterior = this.obtenerNodo(indiceAnterior);
                                NodoDobleEnlazado nodoSiguiente = nodo2.obtenerSiguiente();
                                nodoAnterior.asignarSiguiente(nodo2);
                                nodo2.asignarSiguiente(nodo1);
                                nodo1.asignarSiguiente(nodoSiguiente);
                                nodoSiguiente.asignarAnterior(nodo1);
                                nodo1.asignarAnterior(nodo2);
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
