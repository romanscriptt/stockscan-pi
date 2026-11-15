package com.stockscan.view.components;

import com.stockscan.view.events.StockScanEvent;
import com.stockscan.view.events.StockScanListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class ComponenteStockScan extends JPanel {
// Lista privada donde guardo todos los controladores/paneles que se han suscrito
    private final List<StockScanListener> observadores = new ArrayList<>();

    public void addStockScanListener(StockScanListener listener) {
        // Compruebo que no sea nulo y que no esté ya añadido para evitar avisos duplicados
        if (listener != null && !observadores.contains(listener)) {
            observadores.add(listener);
        }
    }

    public void removeStockScanListener(StockScanListener listener) {
        observadores.remove(listener);
    }

    public void notificarObservadores(String codigo, String mensaje) {
        // Si nadie está escuchando, salgo directamente y evito trabajo innecesario o errores
        if (observadores.isEmpty()) {
            return;
        }
        // Creo una única instancia del evento pasando 'this' (este mismo componente) como origen
        StockScanEvent evento = new StockScanEvent(this, codigo, mensaje);
        // Recorro la lista de suscriptores y aviso a cada uno llamando a su método
        for (StockScanListener listener : observadores) {
            listener.alNotificarAccion(evento);
        }
    }
}