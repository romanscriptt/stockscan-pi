# Memoria del Sprint 03 · Desarrollo de Interfaces

## 3.4.2 Compilación del artefacto reutilizable

El JAR del componente contiene `ComponenteStockScan`, `StockScanEvent` y `StockScanListener`. El componente usa Swing y la biblioteca estándar de Java, por lo que basta con Java 21 o posterior para utilizarlo. La versión del componente figura en el nombre del JAR y en su manifiesto.

### Compilación

Ejecuta este comando desde la raíz del repositorio con un JDK 21 o posterior y Apache Ant.

```powershell
ant -f StockScanE/StockScanE/build.xml jar-componente
```

La salida es `StockScanE/StockScanE/dist/stockscan-componente-1.0.0.jar`. Para indicar otra versión, añade `-Dstockscan.component.version=VERSION` al comando Ant. En NetBeans también puedes ejecutar el objetivo `jar-componente` desde el menú contextual de `build.xml` en la pestaña **Files**.

Estos comandos guardan la ruta del JAR para la prueba y muestran su contenido.

```powershell
$jar = (Resolve-Path 'StockScanE/StockScanE/dist/stockscan-componente-1.0.0.jar').Path
jar tf $jar
```

El listado debe contener las tres clases y `META-INF/MANIFEST.MF`, además de las entradas de directorio de los paquetes.

### Prueba desde otro proyecto

Guarda el siguiente programa como `DemoStockScan.java` en una carpeta aparte.

```java
import com.stockscan.view.components.ComponenteStockScan;
import com.stockscan.view.events.StockScanListener;
import javax.swing.SwingUtilities;

public class DemoStockScan {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            ComponenteStockScan componente = new ComponenteStockScan();
            StockScanListener oyente = evento ->
                    System.out.println(evento.getCodigo() + " | " + evento.getMensaje());

            componente.addStockScanListener(oyente);
            componente.addStockScanListener(oyente);
            componente.notificarObservadores("ART-02", "Stock actualizado");
            componente.removeStockScanListener(oyente);
            componente.notificarObservadores("ART-03", "Sin oyente");
        });
    }
}
```

Desde esa carpeta, usa la misma sesión de PowerShell para compilar y ejecutar el ejemplo con el JAR como única dependencia del proyecto.

```powershell
javac --release 21 -cp $jar DemoStockScan.java
java -Djava.awt.headless=true -cp ".;$jar" DemoStockScan
```

La prueba con Java 21 produjo una única línea con `ART-02 | Stock actualizado`. Con ello se comprobó la entrega del evento, la supresión de registros duplicados y la retirada del oyente. `jdeps --list-deps` identificó los módulos `java.base` y `java.desktop` como las únicas dependencias del JAR.
