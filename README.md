<div align="center">

<!-- PEGA AQUÍ LA LÍNEA <img src="..."> DE TU LOGO ACTUAL -->

# StockScan SGA — Sistema de Gestión de Almacenes Inteligente

**Gestión de stock en tiempo real mediante escaneo inteligente para hostelería, e-commerce y distribución.**

<p>
  <img src="https://skillicons.dev/icons?i=java,sqlite,git,github,idea,vscode" height="50" alt="Stack Tecnológico StockScan SGA" />
</p>

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![UI](https://img.shields.io/badge/UI-Java%20Swing%20%2B%20Design%20Tokens-007396?style=for-the-badge&logo=java&logoColor=white)](#)
[![Database](https://img.shields.io/badge/SQLite-Persistencia%20Local-003B57?style=for-the-badge&logo=sqlite&logoColor=white)](https://www.sqlite.org/)
[![Architecture](https://img.shields.io/badge/Arquitectura-MVC%20%2B%20DAO-2EA44F?style=for-the-badge)](#)
[![Sprint](https://img.shields.io/badge/Estado-Sprint%2003%20En%20Curso-success?style=for-the-badge)](#)

*Proyecto Intermodular (PI) y Desarrollo de Interfaces (DII) — 2º DAM (Desarrollo de Aplicaciones Multiplataforma)*

[Índice de Documentación](docs/README.md) · [Arquitectura MVC](docs/general/desarrollo_mvc.md) · [Backlog](docs/general/analisis_y_backlog.md) · [Código Fuente](StockScanE/)

</div>

---

## Descripción del Proyecto

En entornos de alta rotación como la hostelería, el comercio electrónico o la logística de distribución, el control manual del inventario genera roturas de stock, pérdidas económicas y una elevada carga operativa para el personal.

**StockScan SGA** nace como una solución de escritorio robusta y ágil diseñada para digitalizar la trazabilidad del almacén. Mediante un flujo basado en **escaneo inteligente, arquitectura desacoplada (MVC + DAO) e interfaces optimizadas bajo criterios UI/UX de baja carga cognitiva**, la aplicación registra movimientos en tiempo real y automatiza el control de existencias.

> **Flujo operativo central:**  
> `Escanear / Seleccionar artículo` ➔ `Registrar movimiento (Entrada / Salida)` ➔ `Actualizar stock en SQLite` ➔ `Disparar alertas de reposición`

---

## Ejemplo de Funcionamiento: El Problema Real vs. Solución StockScan SGA

### El Problema en la Operativa Diaria (Antes de StockScan)
En un negocio de hostelería y distribución en pleno servicio (viernes a las 21:30 h), el almacén sufre tres fallos críticos cuando se gestiona de forma manual o con hojas de cálculo desactualizadas:
1. **Stock fantasma:** El sistema dice que quedan 10 kg de café o 3 sacos de harina, pero al ir a buscarlos el estante está vacío porque nadie apuntó las salidas del turno anterior.
2. **Roturas de stock en hora punta:** El personal descubre que falta mercancía esencial cuando ya no hay margen para reponerla, paralizando platos o pedidos de *delivery*.
3. **Pedidos a ciegas y falta de trazabilidad:** Se compra de más (generando mermas y caducidades) o de menos, sin saber qué operario retiró el producto ni en qué franja horaria se consumió.

---

### Cómo lo Resuelve StockScan SGA en Tiempo Real
Con **StockScan SGA**, cada movimiento en el almacén se registra al instante mediante escaneo o atajos rápidos, actualizando el inventario en SQLite y disparando alertas visuales automáticas antes de llegar a cero:

| Referencia | Artículo | Stock Inicial | Movimiento Registrado | Operario / Turno | Stock Final | Respuesta Automática de StockScan |
| :--- | :--- | :---: | :---: | :--- | :---: | :--- |
| `SKU-101` | Café en Grano Arábica 1kg | 15 uds | `-11 uds` (Salida Barra) | `op_carlos` · 18:10 | **4 uds** | **Alerta Preventiva (< 5 uds):** Aviso visual en panel para incluir en pedido de mañana |
| `SKU-412` | Harina de Fuerza 25kg | 3 uds | `-3 uds` (Salida Obrador) | `op_lucia` · 19:45 | **0 uds** | **Bloqueo y Alerta Crítica:** Marca artículo agotado y notifica reposición urgente |
| `SKU-204` | Aceite de Oliva Virgen Extra 5L | 8 uds | `+12 uds` (Recepción) | `op_elena` · 20:05 | **20 uds** | **Stock Restablecido:** Cierra alerta previa y actualiza valoración de inventario |
| `SKU-309` | Envases Biodegradables Pack 50 | 30 uds | `-5 uds` (Salida Delivery) | `op_carlos` · 21:20 | **25 uds** | **Stock Óptimo:** Movimiento auditado sin fricción en menos de 2 segundos |

### Impacto Directo en el Negocio
- **Cero stock fantasma:** Lo que muestra la pantalla coincide al 100 % con la estantería física.
- **Anticipación a la rotura:** Las alertas por umbral mínimo avisan *antes* de quedarse sin existencias, no cuando ya es tarde.
- **Auditoría completa:** Cada entrada o salida queda vinculada a un usuario, fecha y hora exacta, eliminando pérdidas desconocidas.

---

## Funcionalidades Principales

### Gestión de Inventario y Catálogo
- Alta, edición, consulta y baja lógica de productos con validación de integridad.
- Clasificación por categorías, proveedores, ubicaciones y umbrales de stock mínimo.
- Búsqueda instantánea y filtrado dinámico en tiempo real.

### Escaneo Inteligente y Movimientos
- Registro ágil de **entradas de mercancía**, **salidas por consumo** y **ajustes de inventario**.
- Soporte de atajos de teclado y gestión de eventos de bajo nivel para operar sin depender exclusivamente del ratón.
- Recálculo automático de existencias y generación de alertas visuales según el nivel de criticidad.

### Interfaz UI/UX y Design Tokens
- Sistema visual unificado basado en **Design Tokens** (paleta semántica, jerarquía tipográfica y espaciado consistente).
- Diseño orientado a la **reducción de carga cognitiva** en entornos de trabajo exigentes.
- Feedback visual inmediato ante errores de validación, confirmaciones y estados críticos de stock.

### Persistencia y Trazabilidad (SQLite + DAO)
- Almacenamiento relacional ligero, autónomo y sin dependencias externas complejas mediante **SQLite**.
- Histórico completo de operaciones para auditoría y control de mermas.

---

## Arquitectura y Estructura del Repositorio

El sistema implementa el patrón **Modelo-Vista-Controlador (MVC)** combinado con **Data Access Objects (DAO)** para aislar completamente la interfaz gráfica de las reglas de negocio y de las consultas SQL:

```text
┌─────────────────────────────────────────────────────────────┐
│                    CAPA DE PRESENTACIÓN                     │
│        Java Swing · Vistas Modulares · Design Tokens        │
└──────────────────────────────┬──────────────────────────────┘
                               │ Eventos de usuario / Listeners
┌──────────────────────────────▼──────────────────────────────┐
│                     CAPA DE CONTROLADOR                     │
│       Coordinación de Flujos · Validaciones · Eventos       │
└──────────────────────────────┬──────────────────────────────┘
                               │ Objetos de Dominio (DTO/Model)
┌──────────────────────────────▼──────────────────────────────┐
│                   CAPA DE ACCESO A DATOS                    │
│              Patrón DAO · Consultas Parametrizadas          │
└──────────────────────────────┬──────────────────────────────┘
                               │ JDBC
┌──────────────────────────────▼──────────────────────────────┐
│                     BASE DE DATOS SQLite                    │
│         Productos · Movimientos · Usuarios · Alertas        │
└─────────────────────────────────────────────────────────────┘
