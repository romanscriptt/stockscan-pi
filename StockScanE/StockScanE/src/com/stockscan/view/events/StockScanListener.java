package com.stockscan.view.events;

import java.util.EventListener;

/**
 *
 * @author Álvaro López
 * @version 1.0
 */
public interface StockScanListener extends EventListener {

    /**
     * Método que se ejecuta automáticamente cuando ocurre una acción.
     *
     * @param evento Datos del evento recibido.
     */
    void alNotificarAccion(StockScanEvent evento);
}