package com.aluracursos.literactura.literactura.Principal;

import com.aluracursos.literactura.literactura.model.Datos;
import com.aluracursos.literactura.literactura.model.DatosLibros;
import com.aluracursos.literactura.literactura.model.Libros;
import com.aluracursos.literactura.literactura.repository.LibrosRepository;
import com.aluracursos.literactura.literactura.service.ConsumoApi;
import com.aluracursos.literactura.literactura.service.ConveriteDatos;

import java.util.*;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private  static final String URL= "https://gutendex.com//books";
    private ConsumoApi consumoApi= new ConsumoApi();
    private ConveriteDatos conversor = new ConveriteDatos();
    private LibrosRepository respository;
    private List<DatosLibros> libros = new ArrayList<>();
    private  List<Libros> Libros;
    private Optional<Libros> librosBuscados;



        public Datos muestraElMenu() {
            var opcion = -1;
            while (opcion != 0) {
                var menu = """
                        Eliga la Opocion a traves de su numero
                                1 - Buscar por titulo
                                2 - listar libros registrados
                                3 - listar autores registrados
                                4 - listar autores vivos en un determinado año
                                5 - Listar libros por idioma
                                0 -  salir
                          """;
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        buscarPorTitulo();
                        break;
                    case 2:
                      mostrarLibrosRegistrados();
                        break;
                    case 3:
                        mostrarPorAutoresRegistrados();
                        break;
                    case 4:
                        mostrarAutoresVivos();
                        break;
                    case 5:
                        mostrarLibrosPorIdioma();
                        break;

                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            }
            return null;
        }

    private void mostrarLibrosPorIdioma() {
        System.out.println("Escribe el idioma del libro de la cual desea");
    }

    private void mostrarAutoresVivos() {
        mostrarLibrosRegistrados();
        var nombreIdioma = teclado.nextLine();
        librosBuscados = respository.findByTituloContainsIgnoreCase(nombreIdioma);

        }

    private void mostrarPorAutoresRegistrados() {
        System.out.println("Escribe el nombre del libro de la cual desea");
        var nombreLibro = teclado.nextLine();
        librosBuscados = respository.findByTituloContainsIgnoreCase(nombreLibro);

        if(librosBuscados.isPresent()){
            System.out.println("La libro Buscada es: " + librosBuscados.get());
        }else {
            System.out.println("Libro no encontrada");
        }
    }

    private void mostrarLibrosRegistrados() {
        Libros = respository.findAll();

        Libros.stream()
               // .sorted(Comparator.comparing(Libros::getGenero))
                .forEach(System.out::println);
    }

    private DatosLibros getDatosLibros(){
     System.out.println("Escribe el nombre de la libros que deseas buscar");
     var tituloLibro = teclado.nextLine();
     var json = consumoApi.obtenerDatos(URL+"?search=" +tituloLibro.replace(" ", "+"));
     System.out.println(json);
     DatosLibros datos = conversor.obtenerDatos(json, DatosLibros.class);
     return datos;
 }
    private void buscarPorTitulo() {
        DatosLibros datos = getDatosLibros();
        Libros libros =new Libros(datos);
        respository.save(libros);
        // datosSeries.add(datos);

        System.out.println(datos);
    }

}
