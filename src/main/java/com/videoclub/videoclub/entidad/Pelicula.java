package com.videoclub.videoclub.entidad;

import com.videoclub.videoclub.enums.TipoPelicula;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    private int pelicualId;
    private String titulo;
    private TipoPelicula tipoPelicula;

}
