package com.videoclub.videoclub.repositorio;

import com.videoclub.videoclub.entidad.Pelicula;

import java.util.List;

public interface Gestion<T> {

    List<T> obtenerTodo();

    T obtenerPorId(int id);

    int generarRandomId();
}
