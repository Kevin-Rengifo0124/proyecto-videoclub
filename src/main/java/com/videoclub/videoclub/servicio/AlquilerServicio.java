package com.videoclub.videoclub.servicio;

import com.videoclub.videoclub.dto.AlquilerDTO;
import com.videoclub.videoclub.entidad.Alquiler;
import com.videoclub.videoclub.entidad.Cliente;
import com.videoclub.videoclub.entidad.Pelicula;
import com.videoclub.videoclub.enums.TipoPelicula;
import com.videoclub.videoclub.repositorio.impl.ClienteRepositorio;
import com.videoclub.videoclub.repositorio.impl.PeliculaRepositorio;
import org.springframework.stereotype.Service;
import util.GestionPrecios;

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

    public double realizarAlquiler(AlquilerDTO alquilerDTO) {

        Cliente cliente = clienteRepositorio.obtenerPorId(alquilerDTO.getClienteId());
        Pelicula pelicula = peliculaRepositorio.obtenerPorId(alquilerDTO.getPeliculaId());

        if (cliente != null && pelicula != null) {

            double precio = GestionPrecios.calcularPrecio(pelicula.getTipoPelicula(), alquilerDTO.getDiasAlquiler());
            alquileres.add(new Alquiler((alquileres.size() + 1), cliente, pelicula, alquilerDTO.getDiasAlquiler(), precio));
            cliente.setPuntosFidelizacion(cliente.getPuntosFidelizacion() + (pelicula.getTipoPelicula() == TipoPelicula.NUEVO_LANZAMIENTO ? 2 : 1));
            return precio;
        }
        throw new RuntimeException("Cliente o Película no encontrada");
    }

    public int obtenerPuntosFidelizacion(int clienteId) {
        Cliente cliente = clienteRepositorio.obtenerPorId(clienteId);
        if (cliente != null) {
            return cliente.getPuntosFidelizacion();
        }
        throw new RuntimeException("Cliente no encontrado");
    }
}
