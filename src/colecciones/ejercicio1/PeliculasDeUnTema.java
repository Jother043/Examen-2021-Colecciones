package colecciones.ejercicio1;

import java.util.*;
import java.util.stream.Collectors;

public class PeliculasDeUnTema {

    private static final int MIN_ANNO = 1895;
    private static final int MAX_ANNO = 2023;
    private String tema;
    private LinkedList<Pelicula> listaPeliculasDeUnTema;

    public PeliculasDeUnTema(String tema) {
        this.tema = tema;
        listaPeliculasDeUnTema = new LinkedList<Pelicula>();
    }

    public String getTema() {
        return getTema();
    }

    public void addPelicula(Pelicula pelicula) throws NetPleaseException {

        if (listaPeliculasDeUnTema.contains(pelicula)) {
            throw new NetPleaseException("No se puede añadir la misma película");
        }

        if (pelicula.getAnnoEstreno() < MIN_ANNO || pelicula.getAnnoEstreno() > MAX_ANNO) {
            throw new NetPleaseException("No puedes añadir una pelicula de antes de :" + MIN_ANNO + " ni una después de " + MAX_ANNO);
        }
        listaPeliculasDeUnTema.add(pelicula);
    }

    public void borrarLasPeliculasDeUnAnno(int anno) throws NetPleaseException {

//        Pelicula peliculaBorrada = null;
//        Iterator<Pelicula> itPelicula = listaPeliculasDeUnTema.iterator();

        listaPeliculasDeUnTema.stream().filter(x -> x.getAnnoEstreno() != anno).collect(Collectors.toCollection(LinkedList::new));
//        while (itPelicula.hasNext()) {
//            Pelicula pelicula = itPelicula.next();
//            if (pelicula.getAnnoEstreno() == anno) {
//                peliculaBorrada = pelicula;
//                itPelicula = null;
//            }
//        }

//        if (peliculaBorrada == null) {
//            throw new NetPleaseException("No hay películas de ese año para borrar");
//        }
    }

    public void annadirOpinionAPelicula(String tituloPelicula, Opinion opinion) throws NetPleaseException {

        boolean peliculaEncontrada = false;
        for (Pelicula p : listaPeliculasDeUnTema) {
            if (p.getTitulo().equals(tituloPelicula)) {
                p.annadirOpinion(opinion);
                peliculaEncontrada = true;
            }
        }

        if (!peliculaEncontrada) {
            throw new NetPleaseException("No ha encontrado peliculas con ese nombre");
        }
    }

    public List<Pelicula> listadoDePeliculasOrdenadasPorMediaDeOpiniones() {

        return listaPeliculasDeUnTema.stream()
                .sorted((x1, x2) -> Double.compare(x1.mediaDeOpiniones(), x2.mediaDeOpiniones()))
                .toList();
    }

    /**
     * Este método devuelve una lista de películas de las películas que contenga el actor que le pasamos por parámetro.
     * @param actor
     * @return listaPeliculasDondeIntervieneUnActor
     */
    public List<Pelicula> listaPeliculasDondeIntervieneUnActor(String actor) {
        /*
         Devuelve una lista de películas de las películas que contenga el actor que le pasamos por parámetro.
         */
        return listaPeliculasDeUnTema.stream()
                .filter(x -> x.getActores().contains(actor))
                .toList();
    }

    /**
     * Este método devuelve una película de la lista de películas de un tema buscada por su título
     * y devuelve null si no la encuentra.
     * @param titulo
     * @return películas
     */
    public Pelicula buscarPeliculaPorTitulo(String titulo) {

        // Recorremos la lista de películas de un tema
        for (Pelicula p : listaPeliculasDeUnTema) {
            // Si el título de la película es igual al título que le pasamos por parámetro
            if (p.getTitulo().equals(titulo)) {
                // Devolvemos la película
                return p;
            }
        }
        // Si no la encuentra, devuelve null
        return null;
    }

    /**
     * Borra una pelicula de la lista de peliculas de un tema y devuelve true si la ha borrado
     * y false si no la ha borrado porque no la ha encontrado en la lista de peliculas de un tema.
     * @param titulo
     * @return
     */
    public boolean borrar(String titulo) {
        for (Pelicula p : listaPeliculasDeUnTema) {
            if (p.getTitulo().equals(titulo)) {
                listaPeliculasDeUnTema.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tema == null) ? 0 : tema.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PeliculasDeUnTema other = (PeliculasDeUnTema) obj;
        if (tema == null) {
            if (other.tema != null)
                return false;
        } else if (!tema.equals(other.tema))
            return false;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tema " + tema + "\n");
        for (Pelicula pelicula : listaPeliculasDeUnTema) {
            sb.append(pelicula + "\n");
        }
        return sb.toString();
    }

    public boolean existePelicula(String titulo) {
        return listaPeliculasDeUnTema.stream().anyMatch(pelicula -> pelicula.getTitulo().equals(titulo));
    }
}
