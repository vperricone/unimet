package edu.unimet.practicalistas;

public class Prueba {

    public static void main(String[] args) {
        
        System.out.println("Practia Lista");
        
        String[][] canciones = {
            {"Bohemian Rhapsody", "Queen", "A Night at the Opera", "354", "Rock"},
            {"Love of My Life", "Queen", "A Night at the Opera", "219", "Rock"},
            {"You're My Best Friend", "Queen", "A Night at the Opera", "170", "Rock"},
            {"Beat It", "Michael Jackson", "Thriller", "258", "Pop"},
            {"Billie Jean", "Michael Jackson", "Thriller", "294", "Pop"},
            {"Thriller", "Michael Jackson", "Thriller", "357", "Pop"},
            {"Smooth Criminal", "Michael Jackson", "Bad", "258", "Pop"},
            {"Smooth Criminal", "Alien Ant Farm", "ANThology", "209", "Rock"},
            {"Yesterday", "The Beatles", "Help!", "125", "Pop"},
            {"Yesterday", "Boyz II Men", "II", "167", "R&B"},
            {"Yesterday", "Enrique Iglesias", "Euphoria", "231", "Pop"},
            {"Help!", "The Beatles", "Help!", "138", "Rock"},
            {"Come Together", "The Beatles", "Abbey Road", "259", "Rock"},
            {"Something", "The Beatles", "Abbey Road", "182", "Rock"},
            {"Hallelujah", "Leonard Cohen", "Various Positions", "279", "Folk"},
            {"Hallelujah", "Jeff Buckley", "Grace", "413", "Rock"},
            {"Hallelujah", "Pentatonix", "A Pentatonix Christmas", "269", "Pop"},
            {"Grace", "Jeff Buckley", "Grace", "322", "Rock"},
            {"Blank Space", "Taylor Swift", "1989", "231", "Pop"},
            {"Style", "Taylor Swift", "1989", "231", "Pop"},
            {"Shake It Off", "Taylor Swift", "1989", "219", "Pop"},
            {"Bad Blood", "Taylor Swift", "1989", "211", "Pop"},
            {"Yellow", "Coldplay", "Parachutes", "269", "Indie"},
            {"Shiver", "Coldplay", "Parachutes", "300", "Indie"},
            {"Fix You", "Coldplay", "X&Y", "294", "Indie"},
            {"Speed of Sound", "Coldplay", "X&Y", "288", "Indie"},
            {"One More Time", "Daft Punk", "Discovery", "320", "Electronic"},
            {"Harder, Better, Faster, Stronger", "Daft Punk", "Discovery", "224", "Electronic"},
            {"Aerodynamic", "Daft Punk", "Discovery", "207", "Electronic"},
            {"One More Time", "Blink-182", "One More Time...", "208", "Punk"},
            {"All the Small Things", "Blink-182", "Enema of the State", "167", "Punk"},
            {"What's My Age Again?", "Blink-182", "Enema of the State", "148", "Punk"},
            {"Stay", "Rihanna", "Unapologetic", "240", "Pop"},
            {"Stay", "The Kid LAROI", "F*ck Love 3", "141", "Pop"},
            {"Stay", "Post Malone", "Beerbongs & Bentleys", "204", "Pop"},
            {"Diamonds", "Rihanna", "Unapologetic", "225", "Pop"},
            {"Umbrella", "Rihanna", "Good Girl Gone Bad", "275", "R&B"},
            {"End of the Road", "Boyz II Men", "Cooleyhighharmony", "350", "R&B"},
            {"I'll Make Love to You", "Boyz II Men", "II", "237", "R&B"},
            {"On Bended Knee", "Boyz II Men", "II", "329", "R&B"},
            {"Radioactive", "Imagine Dragons", "Night Visions", "186", "Rock"},
            {"Demons", "Imagine Dragons", "Night Visions", "177", "Rock"},
            {"Believer", "Imagine Dragons", "Evolve", "204", "Rock"},
            {"Thunder", "Imagine Dragons", "Evolve", "187", "Pop"},
            {"Starboy", "The Weeknd", "Starboy", "230", "R&B"},
            {"I Feel It Coming", "The Weeknd", "Starboy", "269", "Electronic"},
            {"Blinding Lights", "The Weeknd", "After Hours", "200", "Electronic"},
            {"Save Your Tears", "The Weeknd", "After Hours", "215", "Electronic"},
            {"Suzanne", "Leonard Cohen", "Songs of Leonard Cohen", "228", "Folk"},
            {"So Long, Marianne", "Leonard Cohen", "Songs of Leonard Cohen", "338", "Folk"}
        };        
        
        System.out.println("===================================================");
        
        String frase;
        Cancion filtro;
        Cancion cancion;
        int cantidad;
        int indice;
        boolean estaVacia;
        Lista playlistFiltrada;
        Lista playlist;
        
        playlist = new Lista();
        System.out.println("Cargando la playlist...");
        for(int i=0; i<canciones.length; i++) {
            String[] registro = canciones[i];
            String nombre = registro[0];
            String autor = registro[1];
            String album = registro[2];
            int duracion = Integer.decode(registro[3]);
            String genero = registro[4];
            cancion = new Cancion(nombre, autor, album, duracion, genero);
            playlist.agregar(cancion);
        }
        
        System.out.println("--------------------------------------------------");
        
        estaVacia = !playlist.estaVacia();
        System.out.println("La playlist se cargó correctamente?: " + estaVacia);
        
        System.out.println("--------------------------------------------------");
        
        cantidad = playlist.obtenerLongitud();
        System.out.println("Se cargaron " + cantidad + " canciones en la playlist.");
        System.out.println(playlist);
        
        System.out.println("--------------------------------------------------");
        
        cancion = (Cancion) playlist.obtenerPrimero();
        System.out.println("La primera canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
        
        System.out.println("--------------------------------------------------");
        
        cancion = (Cancion) playlist.obtenerUltimo();
        System.out.println("La última canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
        
        System.out.println("--------------------------------------------------");
        
        indice = 3;
        cancion = (Cancion) playlist.obtener(indice);
        System.out.println("La cuarta canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
        
        System.out.println("--------------------------------------------------");
        
        playlist.eliminar(indice);
        System.out.println("Se eliminó la tercera canción.");
       
        System.out.println("--------------------------------------------------");
        
        cantidad = playlist.obtenerLongitud();
        System.out.println("La playlist tiene ahora " + cantidad + " canciones.");
        
        System.out.println("--------------------------------------------------");
        
        cancion = (Cancion) playlist.obtener(indice);
        System.out.println("La cuarta canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
         
        System.out.println("--------------------------------------------------");
        
        frase = "Believer";
        filtro = new Cancion();
        filtro.setNombre(frase);
        cancion = (Cancion) playlist.buscar(filtro);
        System.out.println("Se encontró una canción con el nombre: [" + frase + "]:");
        System.out.println(cancion);
        
        System.out.println("--------------------------------------------------");
        
        frase = "Queen";
        filtro = new Cancion();
        filtro.setAutor(frase);
        playlistFiltrada = playlist.filtrar(filtro);
        System.out.println("Listado de canciones filtradas del autor [" + frase + "]:");
        System.out.println(playlistFiltrada);
        
        System.out.println("--------------------------------------------------");
        
        indice = 0;
        cancion = (Cancion) playlist.obtener(indice);
        System.out.println("La primera canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
        cancion = new Cancion("In My Life", "The Beatles", "Rubber Soul", 146, "Rock");
        playlist.agregarPila(cancion);
        System.out.println("Apilamos una nueva canción en la playlist");
        cancion = (Cancion) playlist.obtener(indice);
        System.out.println("La primera canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
        cantidad = playlist.obtenerLongitud();
        System.out.println("La playlist tiene ahora " + cantidad + " canciones.");
        
        System.out.println("--------------------------------------------------");
        
        indice = cantidad - 1;
        cancion = (Cancion) playlist.obtener(indice);
        System.out.println("La última canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
        cancion = new Cancion("In My Life", "Boyz II Men", "II", 154, "R&B");
        playlist.agregarCola(cancion);
        System.out.println("Encolamos una nueva canción en la playlist");
        cantidad = playlist.obtenerLongitud();
        indice = cantidad - 1;
        cancion = (Cancion) playlist.obtener(indice);
        System.out.println("La última canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
        System.out.println("La playlist tiene ahora " + cantidad + " canciones.");
        
        System.out.println("--------------------------------------------------");
        
        indice = 10;
        cancion = (Cancion) playlist.obtener(indice);
        System.out.println("La décima canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
        cancion = new Cancion("Viva La Vida", "Coldplay", "Viva La Vida", 242, "Indie");
        playlist.agregar(cancion, indice);
        System.out.println("Agregamos una nueva canción en la décima posición.");
        cantidad = playlist.obtenerLongitud();
        cancion = (Cancion) playlist.obtener(indice);
        System.out.println("La décima canción es: [" + cancion.getNombre() + "] de [" + cancion.getAutor() + "]");
        System.out.println("La playlist tiene ahora " + cantidad + " canciones.");
        
        System.out.println("--------------------------------------------------");

        System.out.println("Mostramos la playlist filtrada de forma secuencial:");
        while(playlistFiltrada.siguiente()) {
            System.out.println(playlistFiltrada.obtener());
        }
         
        System.out.println("--------------------------------------------------");
        
        System.out.println("Reiniciamos y volvemos a mostrar la playlist filtrada de forma secuencial:");
        playlistFiltrada.reiniciar();
        while(playlistFiltrada.siguiente()) {
            System.out.println(playlistFiltrada.obtener());
        }
  
         System.out.println("--------------------------------------------------");
        
        System.out.println("Convertimos la playlist filtrada en lista circular y mostramos:");
        playlistFiltrada.reiniciar();
        playlistFiltrada.convertirAListaCircular();
        
        playlistFiltrada.siguiente();
        System.out.println(playlistFiltrada.obtener());
        playlistFiltrada.siguiente();
        System.out.println(playlistFiltrada.obtener());
        playlistFiltrada.siguiente();
        System.out.println(playlistFiltrada.obtener());
        playlistFiltrada.siguiente();
        System.out.println(playlistFiltrada.obtener());
       
        System.out.println("--------------------------------------------------");
        
        System.out.println("Eliminamos la lista circular de la playlist filtrada y mostramos:");
        playlistFiltrada.disolverListaCircular();
        playlistFiltrada.reiniciar();
        while(playlistFiltrada.siguiente()) {
            System.out.println(playlistFiltrada.obtener());
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("Mostramos la playlist:");
        System.out.println(playlist);
        
        System.out.println("--------------------------------------------------");
        
        System.out.println("Ordenamos la playlist en sentido ascendente:");
        playlist.ordenar(true);
        System.out.println(playlist);
 
        System.out.println("--------------------------------------------------");
        
        System.out.println("Ordenamos la playlist en sentido descendente:");
        playlist.ordenar(false);
        System.out.println(playlist);
        
        System.out.println("--------------------------------------------------");
        
        System.out.println("Vaciamos la playlist:");
        playlist.vaciar();
        
        System.out.println("--------------------------------------------------");
        
        estaVacia = playlist.estaVacia();
        System.out.println("La playlist está vacia?: " + estaVacia);
        
        System.out.println("--------------------------------------------------");
        
        cantidad = playlist.obtenerLongitud();
        System.out.println("La playlist tiene " + cantidad + " canciones.");
   
        System.out.println("--------------------------------------------------");
        
        estaVacia = playlistFiltrada.estaVacia();
        System.out.println("La playlist filtrada está vacia?: " + estaVacia);
        
        System.out.println("--------------------------------------------------");
        
        cantidad = playlistFiltrada.obtenerLongitud();
        System.out.println("La playlist filtrada tiene " + cantidad + " canciones.");
        System.out.println(playlistFiltrada);
        
        System.out.println("===================================================");
    }
}
