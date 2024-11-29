package controlador.impl;

import com.videoclub.videoclub.dto.PeliculaDTO;
import com.videoclub.videoclub.enums.TipoPelicula;
import com.videoclub.videoclub.servicio.PeliculaServicio;
import controlador.Obtener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaControlador implements Obtener<PeliculaDTO> {

    private final PeliculaServicio peliculaServicio;

    public PeliculaControlador(PeliculaServicio peliculaServicio) {
        this.peliculaServicio = peliculaServicio;
    }

    @GetMapping
    @Override
    public List<PeliculaDTO> obtenerTodas() {
        return peliculaServicio.obtenerTodasLasPeliculas();
    }

    @GetMapping("/tipo/{tipo}")
    public List<PeliculaDTO> obtenerPorTipoPelicula(@PathVariable TipoPelicula tipoPelicula) {
        return peliculaServicio.obtenerPorTipo(tipoPelicula);
    }

}
