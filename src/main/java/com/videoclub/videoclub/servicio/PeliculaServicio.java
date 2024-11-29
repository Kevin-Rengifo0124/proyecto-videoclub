package com.videoclub.videoclub.servicio;

import com.videoclub.videoclub.dto.PeliculaDTO;
import com.videoclub.videoclub.enums.TipoPelicula;
import com.videoclub.videoclub.repositorio.impl.PeliculaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaServicio {

    private final PeliculaRepositorio peliculaRepositorio;

    public PeliculaServicio(PeliculaRepositorio peliculaRepositorio) {
        this.peliculaRepositorio = peliculaRepositorio;
    }

    public List<PeliculaDTO> obtenerTodasLasPeliculas() {

        return peliculaRepositorio.obtenerTodo().stream()
                .map(pelicula -> {
                    PeliculaDTO peliculaDTO = new PeliculaDTO();
                    peliculaDTO.setPeliculaId(pelicula.getPelicualId());
                    peliculaDTO.setTitulo(pelicula.getTitulo());
                    peliculaDTO.setTipoPelicula(pelicula.getTipoPelicula());
                    return peliculaDTO;
                }).collect(Collectors.toList());

    }

    public List<PeliculaDTO> obtenerPorTipo(TipoPelicula tipoPelicula) {
        return peliculaRepositorio.obtenerPorTipoPelicula(tipoPelicula).stream()
                .map(pelicula -> {
                    PeliculaDTO peliculaDTO = new PeliculaDTO();
                    peliculaDTO.setPeliculaId(pelicula.getPelicualId());
                    peliculaDTO.setTitulo(pelicula.getTitulo());
                    peliculaDTO.setTipoPelicula(pelicula.getTipoPelicula());
                    return peliculaDTO;
                }).collect(Collectors.toList());
    }
}
