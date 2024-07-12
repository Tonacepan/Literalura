package com.alura.literalura.principal;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Datos;
import com.alura.literalura.model.DatosAutor;
import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal{

    private static final Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    private static final String URL_BASE = "https://gutendex.com/books/";

    public Principal(LibroRepository repositoryLibro, AutorRepository repositoryAutor) {
        this.libroRepository = repositoryLibro;
        this.autorRepository = repositoryAutor;
    }

    public void menu() {
        int opcion = -1;
        while (opcion != 0) {
            String menu = """
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> buscarLibroPorTitulo();
                case 2 -> listarLibrosRegistrados();
                case 3 -> listarAutoresRegistrados();
                case 4 -> listarAutoresVivos();
                case 5 -> manejarMenuIdiomas();
                case 0 -> {
                    System.out.println("Cerrando la aplicación...");
                    System.exit(1);
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = teclado.nextLine();
        String urlString = URL_BASE + "?search=" + titulo;
        String jsonResponse = consumoApi.obtenerDatos(urlString);
        Datos datos = conversor.obtenerDatos(jsonResponse, Datos.class);

        if (datos != null && datos.resultados() != null && !datos.resultados().isEmpty()) {
            DatosLibro datosLibro = datos.resultados().get(0);  // Obtener solo el primer resultado
            DatosAutor datosAutor = datosLibro.autor().get(0);  // Asumimos que siempre hay al menos un autor
            Autor autor = new Autor(datosAutor);
            Libro libro = new Libro(datosLibro, autor);
            autorRepository.save(autor);
            libroRepository.save(libro);
            System.out.println(libro);
        } else {
            System.out.println("No se encontraron resultados.");
        }
    }

    private void listarLibrosRegistrados() {
        libroRepository.findAll().forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        autorRepository.findAll().forEach(System.out::println);
    }

    private void listarAutoresVivos() {
        System.out.println("Ingrese el año:");
        int year = teclado.nextInt();
        teclado.nextLine();
        List<Autor> autoresVivos = autorRepository.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year);
        autoresVivos.forEach(System.out::println);
    }

    private void manejarMenuIdiomas() {
        System.out.println("Ingrese el idioma:");
        String idioma = teclado.nextLine();
        List<Libro> librosPorIdioma = libroRepository.findByIdioma(idioma);
        librosPorIdioma.forEach(System.out::println);
    }
}
