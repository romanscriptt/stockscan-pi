package com.stockscan.view.components;

import com.stockscan.view.events.StockScanEvent;
import com.stockscan.view.events.StockScanListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Álvaro López
 * @version 1.0
 */
public class ComponenteStockScan extends JPanel {

    // Lista privada donde guardo todos los controladores que se han suscrito
    private final List<StockScanListener> observadores = new ArrayList<>();

    /**     
     * @param listener 
     */
    public void addStockScanListener(StockScanListener listener) {
        // Compruebo que no sea nulo y que no esté ya añadido para evitar avisos duplicados
        if (listener != null && !observadores.contains(listener)) {
            observadores.add(listener);
        }
    }

    /**     
     * @param listener Observador que se quiere borrar.
     */
    public void removeStockScanListener(StockScanListener listener) {
        observadores.remove(listener);
    }

    /**
     * Avisa a todos los observadores registrados enviándoles el código y el mensaje.
     *
     * @param codigo  Código del artículo.
     * @param mensaje Mensaje de aviso.
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