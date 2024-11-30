package controlador.impl;

import com.videoclub.videoclub.dto.AlquilerDTO;
import com.videoclub.videoclub.servicio.AlquilerServicio;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/alquileres")
public class AlquilerControlador {

    private final AlquilerServicio alquilerServicio;

    public AlquilerControlador(AlquilerServicio alquilerServicio) {
        this.alquilerServicio = alquilerServicio;
    }

    @PostMapping
    public String realizarAlquiler(@RequestBody(required = true) AlquilerDTO alquilerDTO) {
        if (alquilerDTO.getClienteId() <= 0 || alquilerDTO.getPeliculaId() <= 0 || alquilerDTO.getDiasAlquiler() <= 0) {
            throw new IllegalArgumentException("Todos los campos deben ser válidos y mayores a 0.");
        }
        double precioTotal = alquilerServicio.realizarAlquiler(alquilerDTO);
        return "Alquiler realizado con éxito. Precio total: $" + precioTotal;
    }

    @GetMapping("/puntos-fidelizacion/{clienteId}")
    public String obtenerPuntosFidelizacion(@PathVariable int clienteId) {
        int puntos = alquilerServicio.obtenerPuntosFidelizacion(clienteId);
        return "El cliente con ID " + clienteId + " tiene " + puntos + " puntos de fidelización.";
    }
}
