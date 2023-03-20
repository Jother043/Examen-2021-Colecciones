package colecciones.ejercicio1;

import java.util.HashMap;

public class NetPlease {

    //Hashmap donde por cada tema, podemos acceder a las películas de ese tema
    private HashMap<String, PeliculasDeUnTema> mapPeliculas;

    /*
     * Constructor de la clase NetPlease
     */
    public NetPlease() {
        mapPeliculas = new HashMap<String, PeliculasDeUnTema>();

    }

    /**
     * Añade un tema a la lista de temas de NetPlease si no existe ya ese tema en la lista de temas de NetPlease.
     *
     * @param tema
     * @throws NetPleaseException
     */
    public void annadirTema(String tema) throws NetPleaseException {
        //Pasamos el tema a mayúsculas
        tema = tema.toUpperCase();
        //Si el tema ya existe, lanzamos una excepción
        if (mapPeliculas.containsKey(tema)) {
            throw new NetPleaseException("Ya existe ese tema");
        }
        //Si no existe, lo añadimos al hashmap
        mapPeliculas.put(tema, new PeliculasDeUnTema(tema));
    }


    public void addPelicula(String tema, Pelicula pelicula) throws NetPleaseException {
        /*declaramos una variable de tipo PeliculasDeUnTema para poder acceder a los métodos de la clase PeliculasDeUnTema
         * y poder añadir la película al tema correspondiente.
         */
        PeliculasDeUnTema listaPeliculasDeUnTema = mapPeliculas.get(tema);
        //Si no existe el tema, lanzamos una excepción
        if (listaPeliculasDeUnTema == null) {
            throw new NetPleaseException("No existe el tema " + tema);
        }
        //Si existe el tema, añadimos la película al tema correspondiente.
        listaPeliculasDeUnTema.addPelicula(pelicula);
    }

    /**
     * lista todas las películas de todos los temas de NetPlease, lo he cambiado de un void a String para que
     * me devuelva un String.
     */
    public String listadoDeTodasPeliculasDeTodosLosTemas() {
        //Creamos un StringBuilder para poder concatenar las películas de todos los temas.
        StringBuilder sb = new StringBuilder();
        //Recorremos el hashmap con un for each para poder acceder a las películas de cada tema.
        for (PeliculasDeUnTema listaPelisTema : mapPeliculas.values()) {
            //Concatenamos las películas de cada tema.
            sb.append(listaPelisTema).append("\n");
        }
        //Devolvemos el StringBuilder convertido a String.
        return sb.toString();
    }

    /**
     * Borra una película de un tema dado y si no existe el tema o la película, lanza una excepción.
     *
     * @param tema
     * @param titulo
     * @throws NetPleaseException
     */
    public void borrarPeliculaDeUnTema(String tema, String titulo) throws NetPleaseException {

        /*
         * declaramos una variable de tipo PeliculasDeUnTema para poder acceder a los métodos de la clase PeliculasDeUnTema
         * y poder borrar la película del tema correspondiente, ya que se ha guardado en la variable que hemos creado.
         */
        PeliculasDeUnTema listaPeliculasDeUnTema = mapPeliculas.get(tema);
        //Si no existe el tema, lanzamos una excepción
        if (listaPeliculasDeUnTema == null) {
            throw new NetPleaseException("No existe el tema " + tema);
        }
        //Si existe el tema, borramos la película del tema correspondiente.
        listaPeliculasDeUnTema.borrar(titulo);
    }

    /**
     * Devuelve el tema de una película dada.
     *
     * @param titulo
     * @return
     * @throws NetPleaseException
     */
    public String temaDePelicula(String titulo) throws NetPleaseException {
        /*
         * Recorremos el hashmap con un for each para poder acceder a las películas de cada tema y comprobar si existe
         * la película que buscamos.
         */
        for (PeliculasDeUnTema listaPelisTema : mapPeliculas.values()) {
            //Si existe la película, devolvemos el tema de la película.
            if (listaPelisTema.existePelicula(titulo)) {
                //Devuelve el tema de la película.
                return listaPelisTema.getTema();
            }
        }
        //Si no existe la película, lanzamos una excepción.
        return null;
    }


}
