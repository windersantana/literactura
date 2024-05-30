package com.aluracursos.literactura.literactura.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class <T> clase);
}
