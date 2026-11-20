# Memoria del Sprint 03 · Desarrollo de Interfaces

## 3.4.3 Generación de la documentación técnica

La documentación técnica se entrega como un sitio HTML generado a partir de los comentarios JavaDoc del código fuente. Permite consultar las clases y métodos desde el navegador. En la API de escaneo se pueden consultar el constructor de `ComponenteStockScan`, el registro y la retirada de oyentes, los datos de `StockScanEvent` y el método que invoca `StockScanListener` al recibir un aviso.

### Cómo generar la entrega

Ejecuta este comando desde la raíz del repositorio con JDK 21 y Apache Ant.

```powershell
ant -f StockScanE/StockScanE/build.xml javadoc-entrega
```

El objetivo utiliza la tarea JavaDoc de NetBeans y comprueba los comentarios y las referencias antes de crear `StockScanE/StockScanE/dist/stockscan-javadoc.zip`. En NetBeans se puede ejecutar `javadoc-entrega` desde el menú contextual de `build.xml` en la pestaña **Files**.

### Cómo consultar la documentación

Adjunta `stockscan-javadoc.zip` a la entrega del Sprint 03 DII. Para consultarlo, descomprime el archivo completo y abre `index.html` en el navegador. Desde el índice de clases o el buscador se puede acceder a `ComponenteStockScan`, `StockScanEvent` y `StockScanListener`. Los enlaces de cada página llevan a los constructores, métodos y tipos relacionados.
