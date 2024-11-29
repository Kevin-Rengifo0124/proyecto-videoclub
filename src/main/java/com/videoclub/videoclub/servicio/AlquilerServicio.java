package com.videoclub.videoclub.servicio;

import com.videoclub.videoclub.dto.AlquilerDTO;
import com.videoclub.videoclub.entidad.Alquiler;
import com.videoclub.videoclub.entidad.Cliente;
import com.videoclub.videoclub.entidad.Pelicula;
import com.videoclub.videoclub.repositorio.impl.ClienteRepositorio;
import com.videoclub.videoclub.repositorio.impl.PeliculaRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlquilerServicio {

    private final PeliculaRepositorio peliculaRepositorio;
    private final ClienteRepositorio clienteRepositorio;
    private final List<Alquiler> alquileres = new ArrayList<>();

    public AlquilerServicio(PeliculaRepositorio peliculaRepositorio, ClienteRepositorio clienteRepositorio) {
        this.peliculaRepositorio = peliculaRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    public void realizarAlquiler(AlquilerDTO alquilerDTO){

        Cliente cliente = clienteRepositorio.obtenerPorId(alquilerDTO.getClienteId());
        Pelicula pelicula = peliculaRepositorio.obtenerPorId(alquilerDTO.getPeliculaId());

        if (cliente != null && pelicula != null){

        }
    }
}
