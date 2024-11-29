package com.videoclub.videoclub.dto;

import com.videoclub.videoclub.enums.TipoPelicula;
import lombok.Data;

@Data
public class PeliculaDTO {

    private int peliculaId;
    private String titulo;
    private TipoPelicula tipoPelicula;

}
