package edu.unimet.practicalistas;

public class ListaPlantilla<T> {

    private NodoPlantilla<T> primerNodoPlantilla;
    private NodoPlantilla<T> ultimoNodoPlantilla;
    private NodoPlantilla<T> nodoActual;
    private int longitud;

    public int obtenerLongitud() {
        return this.longitud;
    }

    private NodoPlantilla obtenerNodoPlantilla(int indice) {
        NodoPlantilla retorno = null;
        if (indice >= 0 && indice < this.obtenerLongitud()) {
            NodoPlantilla aux = this.primerNodoPlantilla;
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

    public T obtener(int indice) {
        T retorno = null;
        if (indice >= 0 && indice < this.longitud) {
            NodoPlantilla aux = this.primerNodoPlantilla;
            for (int i = 0; i < indice; i++) {
                if (aux !=null) {
                    aux = aux.obtenerSiguiente();
                }
            }
            if (aux != null) {
                retorno = (T) aux.obtenerValor();
            }
        }
        return (T) retorno;
    }

    public void agregar(T valor, int indice) {
        NodoPlantilla nuevoNodoPlantilla = new NodoPlantilla(valor);
        if (this.longitud == 0) {
            this.primerNodoPlantilla = nuevoNodoPlantilla;
            this.ultimoNodoPlantilla = nuevoNodoPlantilla;
        } else {
            int ultimoIndice = this.longitud - 1;
            int indiceAnterior = indice - 1;
            if (indice <= 0) {
                nuevoNodoPlantilla.asignarSiguiente(this.primerNodoPlantilla);
                this.primerNodoPlantilla = nuevoNodoPlantilla;
            } else if (indice >= ultimoIndice) {
                this.ultimoNodoPlantilla.asignarSiguiente(nuevoNodoPlantilla);
                this.ultimoNodoPlantilla = nuevoNodoPlantilla;
            } else {
                NodoPlantilla nodoAnterior = this.obtenerNodoPlantilla(indiceAnterior);
                nuevoNodoPlantilla.asignarSiguiente(nodoAnterior.obtenerSiguiente());
                nodoAnterior.asignarSiguiente(nuevoNodoPlantilla);
            }
        }
        this.longitud++;
    }

    public void agregar(T valor) {
        this.agregarCola(valor);
    }

    public void agregarCola(T valor) {
        NodoPlantilla nuevoNodoPlantilla = new NodoPlantilla(valor);
        if (this.longitud == 0) {
            this.primerNodoPlantilla = nuevoNodoPlantilla;
            this.ultimoNodoPlantilla = nuevoNodoPlantilla;
        } else {
            this.ultimoNodoPlantilla.asignarSiguiente(nuevoNodoPlantilla);
            this.ultimoNodoPlantilla = nuevoNodoPlantilla;
        }
        this.longitud++;
    }

    public void agregarPila(T valor) {
        NodoPlantilla nuevoNodoPlantilla = new NodoPlantilla(valor);
        if (this.longitud == 0) {
            this.primerNodoPlantilla = nuevoNodoPlantilla;
            this.ultimoNodoPlantilla = nuevoNodoPlantilla;
        } else {
            nuevoNodoPlantilla.asignarSiguiente(this.primerNodoPlantilla);
            this.primerNodoPlantilla = nuevoNodoPlantilla;
        }
        this.longitud++;
    }

    public void eliminar(int indice) {
        if (indice == 0) {
            this.primerNodoPlantilla = this.primerNodoPlantilla.obtenerSiguiente();
        } else if (indice == this.longitud - 1) {
            NodoPlantilla nodoAnterior = this.obtenerNodoPlantilla(indice - 1);
            nodoAnterior.asignarSiguiente(null);
            this.ultimoNodoPlantilla = nodoAnterior;
        } else {
            NodoPlantilla nodoAnterior = this.obtenerNodoPlantilla(indice - 1);
            NodoPlantilla nodoSolicitado = this.obtenerNodoPlantilla(indice);
            nodoAnterior.asignarSiguiente(nodoSolicitado.obtenerSiguiente());
        }
        this.longitud--;
    }

    public T buscar(T valorConsulta) {
        if (valorConsulta != null) {
            for (int indice = 0; indice < this.longitud; indice++) {
                T valor = this.obtener(indice);
                if (valor != null && valor.equals(valorConsulta)) {
                    return this.obtener(indice);
                }
            }
        }
        return null;
    }

    public ListaPlantilla<T> filtrar(T valorConsulta) {
        ListaPlantilla<T> listaFiltrada = new ListaPlantilla();
        if (valorConsulta != null) {
            for (int indice = 0; indice < this.longitud; indice += 1) {
                T valor = this.obtener(indice);
                if (valor != null && valor.equals(valorConsulta)) {
                    listaFiltrada.agregar(valor);
                }
            }
        }
        return listaFiltrada;
    }

    public boolean siguiente() {
        if (this.nodoActual == null) {
            this.nodoActual = primerNodoPlantilla;
            return true;
        } else {
            NodoPlantilla aux = this.nodoActual;
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

    public T obtener() {
        if (this.nodoActual == null) {
            return null;
        } else {
            return this.nodoActual.obtenerValor();
        }
    }

    public T obtenerPrimero() {
        if (this.primerNodoPlantilla == null) {
            return null;
        } else {
            return this.primerNodoPlantilla.obtenerValor();
        }
    }

    public T obtenerUltimo() {
        if (this.ultimoNodoPlantilla == null) {
            return null;
        } else {
            return this.ultimoNodoPlantilla.obtenerValor();
        }
    }

    public void reiniciar() {
        this.nodoActual = null;
    }

    public void vaciar() {
        this.longitud = 0;
        this.primerNodoPlantilla = null;
        this.ultimoNodoPlantilla = null;
        this.nodoActual = null;
    }

    public void convertirAListaCircular() {
        this.ultimoNodoPlantilla.asignarSiguiente(primerNodoPlantilla);
    }

    public void disolverListaCircular() {
        this.ultimoNodoPlantilla.asignarSiguiente(null);
    }

    public void ordenar(boolean ascendente) {
        boolean estaOrdenado = false;
        int penultimo = this.longitud-1;
        while(!estaOrdenado) {
            estaOrdenado = true;
            for (int indice=0; indice<=penultimo; indice++) {
                int indiceSiguiente = indice+1;
                int indiceAnterior = indice-1;
                NodoPlantilla nodo1 = this.obtenerNodoPlantilla(indice);
                NodoPlantilla nodo2 = this.obtenerNodoPlantilla(indiceSiguiente);
                if (nodo1 != null && nodo2 != null) {
                    T valor1 = (T) nodo1.obtenerValor();
                    T valor2 = (T) nodo2.obtenerValor();
                    if (valor1 != null && valor2 != null) {
                        int comparacion = valor1.toString().compareTo(valor2.toString());
                        boolean condicion1 = ascendente && comparacion > 0;
                        boolean condicion2 = !ascendente && comparacion < 0;
                        if (condicion1 || condicion2){
                            estaOrdenado = false;
                            if (indice == 0) {
                                NodoPlantilla nodoSiguente = nodo2.obtenerSiguiente();
                                this.primerNodoPlantilla = nodo2;
                                nodo2.asignarSiguiente(nodo1);
                                nodo1.asignarSiguiente(nodoSiguente);
                            } else if (indice == penultimo) {
                                NodoPlantilla nodoAnterior = this.obtenerNodoPlantilla(indiceAnterior);
                                nodoAnterior.asignarSiguiente(nodo2);
                                nodo2.asignarSiguiente(nodo1);
                                nodo1.asignarSiguiente(null);
                                this.ultimoNodoPlantilla = nodo1;
                            } else {
                                NodoPlantilla nodoAnterior = this.obtenerNodoPlantilla(indiceAnterior);
                                NodoPlantilla nodoSiguiente = nodo2.obtenerSiguiente();
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
            T valor = this.obtener(i);
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
