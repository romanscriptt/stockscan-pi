# Análisis de Información y Planificación del Proyecto

Este documento recoge el análisis funcional, la definición de usuarios y la gestión del backlog para el sistema **StockScan (SCAN ALMACÉN)**.

---

## 1. Identificación del Público Objetivo (Issue #9)

Para garantizar una usabilidad adaptada al entorno logístico, se establecen tres arquetipos de usuario:

### 1.1. Operario de Almacén (Mozo)
* **Requisitos:** Interfaz con alto contraste visual, fuentes monospaciadas para lectura rápida de ubicaciones (`PAS-XX-EST-XX`) y confirmación al escaneo de códigos de barras en tiempo inferior a 1000 ms.
* **Puntos de dolor:** Tareas repetitivas y errores de digitación manual.

### 1.2. Supervisor de Stock
* **Requisitos:** Vista panorámica mediante Badges visuales de estado (*En stock* `#27AE60`, *Stock bajo* `#F39C12`, *Sin stock* `#E74C3C`), filtros rápidos por categoría (*Ferretería*, *Electrónica*, *EPI*, *Consumibles*) y alertas de reabastecimiento.

### 1.3. Administrador del Sistema
* **Requisitos:** Mantenimiento de catálogo y trazabilidad de operaciones.

---

## 2. Objetivos Principales de la Interfaz (Issue #10)

* **Prototipado y Diseño:** Sistema de diseño unificado maquetado en Figma bajo el color primario `#1B4F72`.
* **Rendimiento:** Tiempos de respuesta fluidos al escaneo síncrono/asíncrono de entradas.

---

## 3. Sprint Backlog (Issue #16)

Selección de tareas priorizadas para la presente iteración:
1. Documentación de arquitectura MVC e interfaz gráfica.
2. Maquetación Swing en NetBeans (`MainFrame`, `JTable`, Renderers).
3. Conexión de eventos e interacción de controladores.

---

## 4. Referencias (Formato IEEE)

[1] ISO/IEC/IEEE, "Systems and software engineering — Software life cycle processes," ISO/IEC/IEEE 12207:2017, 2017.  
[2] StockScan Team, "StockScan SGA Interface Design System," Figma, 2026. [Online]. Available: https://www.figma.com/make/fVgbUMpu9QaXt6AXwhjVY5/StockScan-SGA-Interface-Design. [Accessed: Sep. 29, 2026].