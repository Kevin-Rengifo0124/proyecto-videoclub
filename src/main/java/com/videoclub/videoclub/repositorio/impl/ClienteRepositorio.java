package com.videoclub.videoclub.repositorio.impl;

import com.videoclub.videoclub.entidad.Cliente;
import com.videoclub.videoclub.repositorio.Gestion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ClienteRepositorio implements Gestion<Cliente> {

    private final List<Cliente> clientes = new ArrayList<>();
    private final Random random = new Random();

    public ClienteRepositorio() {
        clientes.add(new Cliente(generarRandomId(), "Kevin Rengifo"));
        clientes.add(new Cliente(generarRandomId(), "Stiven Ospina"));
        clientes.add(new Cliente(generarRandomId(), "Valentina Henao"));
    }

    @Override
    public List<Cliente> obtenerTodo() {
        return clientes;
    }

    @Override
    public Cliente obtenerPorId(int clienteId) {
        return clientes.stream().filter(cliente -> cliente.getClienteId() == clienteId).findFirst().orElse(null);
    }

    @Override
    public int generarRandomId() {
        return random.nextInt(50) + 1;
    }
}
