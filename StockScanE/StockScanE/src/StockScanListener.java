
import com.stockscan.view.events.StockScanEvent;
import java.util.EventListener;


public interface StockScanListener extends EventListener {

    /**
     * Método que se ejecuta automáticamente cuando ocurre una acción.
     * @param evento Datos del evento recibido
     */
    void alNotificarAccion(StockScanEvent evento);
}