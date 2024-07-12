package com.alura.literalura.model;

import jakarta.persistence.*;

        import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    private int birthYear;
    private int deathYear;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {
    }

    // Constructor
    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.birthYear = datosAutor.birthYear();
        this.deathYear = datosAutor.deathYear();
    }


    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "\nNombre= " + nombre + '\n' +
                "BirthYear= " + birthYear + '\n' +
                "DeathYear= " + deathYear ;
    }
}

