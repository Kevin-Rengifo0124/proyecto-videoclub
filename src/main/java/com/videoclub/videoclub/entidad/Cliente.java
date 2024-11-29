package com.videoclub.videoclub.entidad;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {

    private int clienteId;
    private String nombreCompleto;
    private int puntosFidelizacion;

    public Cliente(int clienteId, String nombreCompleto) {
        this.clienteId = clienteId;
        this.nombreCompleto = nombreCompleto;
        this.puntosFidelizacion = 0;
    }
}
