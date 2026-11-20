package com.stockscan.view.components;

import com.stockscan.view.events.StockScanEvent;
import com.stockscan.view.events.StockScanListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Panel Swing que distribuye notificaciones de StockScan a los oyentes registrados.
 * Registra un oyente con {@link #addStockScanListener(StockScanListener)} para
 * recibir los datos enviados mediante {@link #notificarObservadores(String, String)}.
 *
 * <p>Usa el componente desde el hilo de despacho de eventos de Swing (EDT).</p>
 *
 * @author Álvaro López
 * @version 1.0
 * @see StockScanEvent
 * @see StockScanListener
 */
public class ComponenteStockScan extends JPanel {

    /** Oyentes suscritos, en orden de registro. */
    private final List<StockScanListener> observadores = new ArrayList<>();

    /**
     * Crea un panel con la configuración predeterminada de {@link JPanel}
     * y sin oyentes registrados.
     */
    public ComponenteStockScan() {
        super();
    }

    /**
     * Registra un oyente para recibir las próximas notificaciones.
     * Se ignora la llamada si el oyente es nulo o si ya hay un oyente igual
     * registrado según {@link Object#equals(Object)}.
     *
     * @param listener oyente que recibirá los eventos
     */
    public void addStockScanListener(StockScanListener listener) {
        // Compruebo que no sea nulo y que no esté ya añadido para evitar avisos duplicados
        if (listener != null && !observadores.contains(listener)) {
            observadores.add(listener);
        }
    }

    /**
     * Retira el oyente registrado que coincida según {@link Object#equals(Object)}.
     * La llamada no tiene efecto si el oyente es nulo o no está registrado.
     *
     * @param listener oyente que dejará de recibir eventos
     */
    public void removeStockScanListener(StockScanListener listener) {
        observadores.remove(listener);
    }

    /**
     * Entrega un mismo {@link StockScanEvent} a los oyentes en orden de registro.
     * El panel es el origen del evento. Si no hay oyentes, la llamada termina
     * sin crear el evento.
     *
     * <p>Los oyentes se ejecutan en el hilo de la llamada. Durante la notificación
     * deben evitar registrar o retirar oyentes. Si un oyente lanza una excepción,
     * esta se propaga y se interrumpe la entrega a los oyentes restantes.</p>
     *
     * @param codigo código asociado a la acción, que puede ser {@code null}
     * @param mensaje texto de la notificación, que puede ser {@code null}
     * @throws RuntimeException si un oyente lanza una excepción de este tipo
     */
    public void notificarObservadores(String codigo, String mensaje) {
        // Si nadie está escuchando, salgo directamente y evito trabajo innecesario o errores
        if (observadores.isEmpty()) {
            return;
        }
        // Creo una única instancia del evento pasando este mismo componente como origen
        StockScanEvent evento = new StockScanEvent(this, codigo, mensaje);
        // Recorro la lista de suscriptores y aviso a cada uno llamando a su método
        for (StockScanListener listener : observadores) {
            listener.alNotificarAccion(evento);
        }
    }
}
