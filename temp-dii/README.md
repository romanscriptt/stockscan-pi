<div align="center">

# StockScan SGA (SCAN ALMACÉN)

**Sistema de Gestión de Almacén (SGA) Modular, Escalable y de Alto Rendimiento**

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/UI-Java_Swing-007396?style=for-the-badge&logo=java&logoColor=white)
![NetBeans](https://img.shields.io/badge/IDE-Apache_NetBeans-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white)
![Sprint 1](https://img.shields.io/badge/Sprint_1-Completado-27AE60?style=for-the-badge)
![Sprint 2](https://img.shields.io/badge/Sprint_2-Completado-27AE60?style=for-the-badge)

</div>

---

## QUIÉNES SOMOS

Somos un equipo multidisciplinar de desarrolladores e ingenieros de software orientados al diseño de sistemas industriales. Nos especializamos en la optimización de procesos operativos mediante **interfaces de alta usabilidad (UI/UX)**, arquitecturas desacopladas y reducción drástica de la carga cognitiva en entornos de trabajo exigentes.

| Miembro del Equipo | Perfil en GitHub |
| :--- | :--- |
| **Álvaro López** | [@romanscriptt](https://github.com/romanscriptt)|
| **Carmen Monge** | [@carmenmonge25](https://github.com/carmenmonge25) |
| **Elena Sáez** | [@elenasaez25](https://github.com/elenasaez25) |
| **Ángel Luis Sánchez** | [@angelluissanchez25](https://github.com/angelluissanchez25) |

---

## EL PROBLEMA REAL QUE RESOLVEMOS

En la logística industrial actual, la ineficiencia operativa rara vez se debe a la falta de esfuerzo humano; proviene de herramientas de software deficientes:

1. **Interfaces saturadas e ineficientes:** Más del 65% de las pérdidas operativas y errores de stock ocurren por el uso de software anticuado y de difícil lectura[cite: 2, 4].
2. **Pérdida de tiempo operativa:** Hasta un **40% del tiempo de trabajo** de los operarios se desperdicia interactuando con pantallas complejas y confirmando datos manualmente.
3. **Fatiga visual y errores de selección:** Entornos con poco contraste y flujos rígidos provocan errores constantes en las fases de *picking* y *packing*.

---

## NUESTRA SOLUCIÓN: STOCKSCAN SGA

**StockScan SGA** aborda directamente la raíz del problema mediante:

- **Sistemas de Tokens Semánticos:** Paleta de contraste extremo y retroalimentación cromática inmediata (Verde = Éxito, Rojo = Conflicto, Ámbar = Alerta) calibrados para pantallas industriales (HiDPI / PDA).
- **Minimización de Carga Cognitiva:** Flujos de interacción simplificados que reducen el tiempo de escaneo e identificación a menos de 2 segundos.
- **Confirmación y Validación en Tiempo Real:** Cero margen de error en el control de stock e historial de movimientos, con respuesta instantánea mediante eventos de ratón, foco y teclado.

---

## EVOLUCIÓN DEL PROYECTO (SPRINT 1 Y SPRINT 2)

### Sprint 1 — Análisis, Diseño UI/UX y Arquitectura Base
Durante el **Sprint 1**, establecimos las bases operativas, visuales y arquitectónicas del sistema:
- **Caracterización de Usuarios y Flujos (UX):** Definición de *User Personas* (*Operario*, *Supervisor*, *Administrador*) y mapeo de flujos críticos de trabajo.
- **Prototipado e Interfaz (UI HiDPI):** Maquetación completa en Figma y definición del sistema de *Design Tokens* (colores semánticos, jerarquía tipográfica y componentes reutilizables).
- **Arquitectura MVC + DAO:** Estructuración desacoplada en capas (`View`, `Controller`, `Model` y `DAO`) para facilitar la escalabilidad y el mantenimiento.
- **Gestión Ágil:** Planificación del backlog y seguimiento mediante **GitHub Projects (Tablero Kanban)**.

### Sprint 2 — Construcción de Vistas e Interactividad de Bajo Nivel
Durante el **Sprint 2**, trasladamos el diseño a código funcional en **Java Swing (Apache NetBeans)**:
- **Implementación Integral de Vistas (`com.stockscan.view.pages`):** Construcción de las pantallas operativas (`Login`, `DashboardPanel`, `MapaAlmacenPanel`, `StockPanel`, `EtiquetasPanel`, `TrazabilidadPanel`, `AlertasPanel`, `EquipoPanel`, `AgendaPanel` y `ChatPanel`).
- **Eventos de Bajo Nivel (`MouseAdapter`, `FocusAdapter`, `KeyAdapter`):** Implementación de retroalimentación visual al pasar el cursor (`HAND_CURSOR`), gestión de *placeholders* y bordes de foco al navegar con `Tab`, y filtrado en tiempo real mediante teclado.
- **Control de Estado sin Duplicidad:** Validación de pulsación y liberación en ratón y teclado para evitar disparos accidentales o repetidos en controles críticos.
- **Pruebas Aisladas y Documentación Técnica:** Verificación independiente de cada vista sobre el *Event Dispatch Thread* (`EventQueue.invokeLater`) y redacción de las memorias técnicas en `docs/sprints/`[cite: 1].

---

## ESTRUCTURA DEL REPOSITORIO

```text
Grupo4-DII-Proyecto/
├── StockScanE/                        # Proyecto principal Java Swing (Apache NetBeans)[cite: 2, 4]
│   ├── src/
│   │   └── com/stockscan/
│   │       └── view/pages/            # Vistas modulares y listeners de bajo nivel
│   ├── build.xml                      # Script de compilación Ant[cite: 3]
│   └── nbproject/                     # Configuración del proyecto NetBeans
├── docs/                              # Documentación técnica del proyecto[cite: 1, 2, 4]
│   ├── sprints/                       # Memorias detalladas de cada Sprint[cite: 1]
│   ├── analisis_y_backlog.md          # Análisis funcional y backlog[cite: 1]
│   └── desarrollo_mvc.md              # Especificación de arquitectura MVC[cite: 1, 3]
├── .gitignore                         # Exclusión de archivos temporales y compilados[cite: 1, 2, 4]
└── README.md                          # Visión general del proyecto[cite: 1, 2, 4]
