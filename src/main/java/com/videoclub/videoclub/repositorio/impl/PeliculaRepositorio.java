package com.videoclub.videoclub.repositorio.impl;

import com.videoclub.videoclub.entidad.Pelicula;
import com.videoclub.videoclub.enums.TipoPelicula;
import com.videoclub.videoclub.repositorio.Gestion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class PeliculaRepositorio implements Gestion<Pelicula> {

    private final List<Pelicula> peliculas = new ArrayList<>();
    private final Random random = new Random();

    public PeliculaRepositorio() {
        peliculas.add(new Pelicula(generarRandomId(), "Mohana", TipoPelicula.NUEVO_LANZAMIENTO));
        peliculas.add(new Pelicula(generarRandomId(), " DEDPOOL", TipoPelicula.NORMAL));
        peliculas.add(new Pelicula(generarRandomId(), "TITANIC", TipoPelicula.VIEJA));

    }

    @Override
    public List<Pelicula> obtenerTodo() {
        return peliculas;
    }

    @Override
    public Pelicula obtenerPorId(int peliculaId) {
        return peliculas.stream().filter(pelicula -> pelicula.getPelicualId() == peliculaId).findFirst().orElse(null);
    }

    @Override
    public int generarRandomId() {
        return random.nextInt(9000) + 1000;
    }

    public List<Pelicula> obtenerPorTipoPelicula(TipoPelicula tipoPelicula) {
        return peliculas.stream().filter(pelicula -> pelicula.getTipoPelicula().equals(tipoPelicula)).collect(Collectors.toList());
    }


}
