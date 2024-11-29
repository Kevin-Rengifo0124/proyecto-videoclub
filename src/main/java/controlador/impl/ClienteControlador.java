package controlador.impl;

import com.videoclub.videoclub.entidad.Cliente;
import com.videoclub.videoclub.repositorio.impl.ClienteRepositorio;
import controlador.Obtener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador implements Obtener<Cliente> {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteControlador(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @GetMapping
    @Override
    public List<Cliente> obtenerTodas() {
        return clienteRepositorio.obtenerTodo();
    }
}
