package controlador.impl;

import com.videoclub.videoclub.dto.AlquilerDTO;
import com.videoclub.videoclub.servicio.AlquilerServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/alquileres")
public class AlquilerControlador {

    private final AlquilerServicio alquilerServicio;

    public AlquilerControlador(AlquilerServicio alquilerServicio) {
        this.alquilerServicio = alquilerServicio;
    }

    @PostMapping
    public String realizarAlquiler(@RequestBody AlquilerDTO alquilerDTO) {
        double precioTotal = alquilerServicio.realizarAlquiler(alquilerDTO);
        return "Alquiler realizado con éxito. Precio total: $" + precioTotal;
    }
}
