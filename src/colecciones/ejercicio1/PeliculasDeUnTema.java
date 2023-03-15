package colecciones.ejercicio1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

        if (pelicula.getAnnoEstreno() > MIN_ANNO || pelicula.getAnnoEstreno() < MAX_ANNO) {
            throw new NetPleaseException("No puedes añadir una pelicula de antes de :" + MIN_ANNO + " ni madespues de " + MAX_ANNO)
        }
        listaPeliculasDeUnTema.add(pelicula);
    }

    public void borrarLasPeliculasDeUnAnno(int anno) throws NetPleaseException {

        Pelicula peliculaBorrada = null;
        Iterator<Pelicula> itPelicula = listaPeliculasDeUnTema.iterator();

        while (itPelicula.hasNext()) {
            Pelicula pelicula = itPelicula.next();
            if (pelicula.getAnnoEstreno() == anno) {
                peliculaBorrada = pelicula;
                itPelicula.remove();
            }
        }

        if (peliculaBorrada == null) {
            throw new NetPleaseException("No hay peliculas de ese año para borrar");
        }
    }

    public void annadirOpinionAPelicula(String tituloPelicula, Opinion opinion) throws NetPleaseException {

        boolean peliculaEncontrada = false;
        for (Pelicula p : listaPeliculasDeUnTema) {
            if (p.getTitulo().equals(tituloPelicula)) {
                p.annadirOpinion(opinion);
                peliculaEncontrada = true;
            }
        }

        if(!peliculaEncontrada){
            throw new NetPleaseException("No ha encontrado peliculas con ese nombre");
        }
    }

    public List<Pelicula> listadoDePeliculasOrdenadasPorMediaDeOpiniones() {
        return null;

    }


    public List<Pelicula> listaPeliculasDondeIntervieneUnActor(String actor) {

        return null;
    }

    public Pelicula buscarPeliculaPorTitulo(String titulo) {

        return null;
    }

    public boolean borrar(String titulo) {
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


}
