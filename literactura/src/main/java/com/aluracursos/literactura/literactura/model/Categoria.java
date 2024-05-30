package com.aluracursos.literactura.literactura.model;

public enum Categoria {
    ACCION ("Action","Acción"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy","Comedia"),
    DRAMA("Drama", "Drama"),
    CRIMEN("Crime", "Crimen");


    private String categoriaOmdb;
    private  String categoriaEspanol;

    Categoria (String categoriaOmdb,  String categoriaEspanol){
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaEspanol =categoriaEspanol;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoría encontrada: " + text);
    }

    public static Categoria fromEspanol(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoría encontrada: " + text);
    }
}
