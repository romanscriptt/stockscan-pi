package com.stockscan.view.events;

import java.util.EventObject;

public class StockScanEvent extends EventObject {
// Atributos privados y 'final' para que los datos del evento no se puedan modificar por error

    private final String codigo;
    private final String mensaje;

    public StockScanEvent(Object source, String codigo, String mensaje) {
        // Llamo al constructor padre (EventObject) para guardar quién originó el evento
        super(source);
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
