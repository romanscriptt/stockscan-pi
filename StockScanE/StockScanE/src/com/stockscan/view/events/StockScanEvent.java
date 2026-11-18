package com.stockscan.view.events;

import java.util.EventObject;

/**
 *
 * @author Álvaro López
 * @version 1.0
 */
public class StockScanEvent extends EventObject {

    private final String codigo;
    private final String mensaje;

    /**
     * Crea un nuevo evento con el origen, el código del producto y un mensaje.
     *
     * @param source  Componente que lanza el evento.
     * @param codigo  Código del artículo o ubicación.
     * @param mensaje Texto explicativo de lo que ha pasado.
     */
    public StockScanEvent(Object source, String codigo, String mensaje) {
        super(source);
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    /**
     * Devuelve el código del elemento.
     *
     * @return El código en texto.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el mensaje de la notificación.
     *
     * @return El mensaje en texto.
     */
    public String getMensaje() {
        return mensaje;
    }
}