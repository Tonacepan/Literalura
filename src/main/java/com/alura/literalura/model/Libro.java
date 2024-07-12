package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Column(name = "idioma", nullable = false)
    private String idioma;

    @Column(name = "descargas")
    private Double numero_Descargas;

    // Constructor
    public Libro() {}

    // Constructor
    public Libro(DatosLibro datosLibro, Autor autor) {
        this.titulo = datosLibro.titulo();
        this.autor = autor;
        this.idioma = datosLibro.idioma().isEmpty() ? "Desconocido" : (String) datosLibro.idioma().get(0).idioma();
        this.numero_Descargas = Double.valueOf(datosLibro.descargas());
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumero_Descargas() {
        return numero_Descargas;
    }

    public void setNumero_Descargas(Double numero_Descargas) {
        this.numero_Descargas = numero_Descargas;
    }

    @Override
    public String toString() {
        return "***Libro***\n" +
                "Titulo= " + titulo + "\n" +
                "Autor " + autor + "\n" +
                "Idioma= " + idioma + "\n" +
                "Descargas= " + numero_Descargas + "\n"+
                "***Libro***";
    }
}

