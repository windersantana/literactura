package com.aluracursos.literactura.literactura.model;

import jakarta.persistence.*;

import java.util.stream.DoubleStream;

@Entity
@Table(name ="libros")
public class Libros {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long Id;
    @Column(unique = true)
    private String titulo;
    private double evaluacion;
    private String poster;
    @Enumerated(EnumType.STRING)
    private String actores;
    private Categoria genero;

    public Libros(DatosLibros datos) {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }
}
