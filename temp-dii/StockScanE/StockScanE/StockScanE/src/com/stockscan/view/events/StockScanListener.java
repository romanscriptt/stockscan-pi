package com.stockscan.view.events;

import java.util.EventListener;

public interface StockScanListener extends EventListener {

    void alNotificarAccion(StockScanEvent evento);
}