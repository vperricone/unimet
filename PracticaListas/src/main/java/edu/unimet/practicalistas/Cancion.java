package edu.unimet.practicalistas;

public class Cancion {
    private String nombre;
    private String autor;
    private String album;
    private Integer duracion;
    private String genero;

    public Cancion() {
    }

    public Cancion(String nuevoNombre, String nuevoAutor, String nuevoAlbum, int nuevaDuracion, String nuevoGenero) {
        this.nombre = nuevoNombre;
        this.autor = nuevoAutor;
        this.album = nuevoAlbum;
        this.duracion = nuevaDuracion;
        this.genero = nuevoGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object obj) {
        Cancion otraCancion = (Cancion) obj;
        if (otraCancion == null) return false;
        boolean resultado = false;
        resultado = resultado || (this.getNombre() != null && otraCancion.getNombre() != null && this.getNombre().equalsIgnoreCase(otraCancion.getNombre()));
        resultado = resultado || (this.getAutor() != null && otraCancion.getAutor() != null && this.getAutor().equalsIgnoreCase(otraCancion.getAutor()));
        resultado = resultado || (this.getAlbum() != null && otraCancion.getAlbum() != null && this.getAlbum().equalsIgnoreCase(otraCancion.getAlbum()));
        resultado = resultado || (this.getDuracion() != null && otraCancion.getDuracion() != null && this.getDuracion().equals(otraCancion.getDuracion()));
        resultado = resultado || (this.getGenero() != null && otraCancion.getGenero() != null && this.getGenero().equalsIgnoreCase(otraCancion.getGenero()));
        return resultado;
    }

    @Override
    public String toString() {
        return "Cancion{" + "nombre: " + nombre + ", autor: " + autor + ", album: " + album + ", duracion: " + duracion + ", genero: " + genero + '}';
    }  
}
