package colecciones.ejercicio1;

public class Principal {

	public static void main(String[] args) {

		NetPlease netPlease=new NetPlease();
		PeliculasDeUnTema peliculasDeUnTema = new PeliculasDeUnTema("COMEDIA");

		try {
			netPlease.annadirTema("COMEDIA");
			netPlease.annadirTema("TRAGI-COMEDIA");
			netPlease.annadirTema("DRAMA");
			netPlease.addPelicula("COMEDIA", new Pelicula("BAJO EL MISMO TECHO", 2019));
			System.out.println(peliculasDeUnTema.buscarPeliculaPorTitulo("BAJO EL MISMO TECHO"));
			peliculasDeUnTema.borrar("BAJO EL MISMO TECHO");

		} catch (NetPleaseException e) {
			System.err.println(e.getMessage());
		}
	}
}
