package com.videoclub.videoclub.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alquiler {

    private int alquilerId;
    private Cliente cliente;
    private Pelicula pelicula;
    private int diasAlquiler;
    private double precioTotal;

}
