<div align="center">

<!-- PEGA AQUÍ LA LÍNEA <img src="..."> DE TU LOGO ACTUAL -->

# StockScan SGA — Sistema de Gestión de Almacenes Inteligente

**Gestión de stock en tiempo real mediante escaneo inteligente para hostelería, e-commerce y distribución.**

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![UI](https://img.shields.io/badge/UI-Java%20Swing%20%2B%20Design%20Tokens-007396?style=for-the-badge&logo=java&logoColor=white)](#)
[![Database](https://img.shields.io/badge/SQLite-Persistencia%20Local-003B57?style=for-the-badge&logo=sqlite&logoColor=white)](https://www.sqlite.org/)
[![Architecture](https://img.shields.io/badge/Arquitectura-MVC%20%2B%20DAO-2EA44F?style=for-the-badge)](#)
[![Sprint](https://img.shields.io/badge/Estado-Sprint%2008%20Completado-success?style=for-the-badge)](#)

*Proyecto Intermodular (PI) y Desarrollo de Interfaces (DII) — 2º DAM (Desarrollo de Aplicaciones Multiplataforma)*

[📚 Índice de Documentación](docs/README.md) · [ Arquitectura MVC](docs/general/desarrollo_mvc.md) · [ Backlog](docs/general/analisis_y_backlog.md) · [💻 Código Fuente](StockScanE/)

</div>

---

## 📖 Descripción del Proyecto

En entornos de alta rotación como la hostelería, el comercio electrónico o la logística de distribución, el control manual del inventario genera roturas de stock, pérdidas económicas y una elevada carga operativa para el personal.

**StockScan SGA** nace como una solución de escritorio robusta y ágil diseñada para digitalizar la trazabilidad del almacén. Mediante un flujo basado en **escaneo inteligente, arquitectura desacoplada (MVC + DAO) e interfaces optimizadas bajo criterios UI/UX de baja carga cognitiva**, la aplicación registra movimientos en tiempo real y automatiza el control de existencias.

> **Flujo operativo central:**  
> `Escanear / Seleccionar artículo` ➔ `Registrar movimiento (Entrada / Salida)` ➔ `Actualizar stock en SQLite` ➔ `Disparar alertas de reposición`

---

## 💡 Ejemplo de Funcionamiento en un Caso Real

Imaginemos el almacén diario de un establecimiento de hostelería y distribución gestionado con **StockScan SGA**:

| Referencia | Artículo | Stock Inicial | Movimiento | Tipo | Stock Final | Estado del Sistema |
| :--- | :--- | :---: | :---: | :--- | :---: | :--- |
| `SKU-101` | Café en Grano Arábica 1kg | 15 uds | `-11 uds` | Salida (Sala) | **4 uds** |  **Alerta: Stock Mínimo (< 5)** |
| `SKU-204` | Aceite de Oliva Virgen Extra 5L | 8 uds | `+12 uds` | Entrada (Proveedor) | **20 uds** | **Stock Óptimo** |
| `SKU-309` | Envases Biodegradables Pack 50 | 30 uds | `-5 uds` | Salida (Delivery) | **25 uds** |  **Stock Óptimo** |
| `SKU-412` | Harina de Fuerza 25kg | 3 uds | `-3 uds` | Salida (Obrador) | **0 uds** | **Crítico: Sin Existencias** |

Cada operación queda persistida con marca temporal y usuario responsable, permitiendo auditar consumos y anticipar pedidos antes de que se produzca una rotura de stock.

---

##  Funcionalidades Principales

###  Gestión de Inventario y Catálogo
* Alta, edición, consulta y baja lógica de productos con validación de integridad.
* Clasificación por categorías, proveedores, ubicaciones y umbrales de stock mínimo.
* Búsqueda instantánea y filtrado dinámico en tiempo real.

###  Escaneo Inteligente y Movimientos
* Registro ágil de **entradas de mercancía**, **salidas por consumo** y **ajustes de inventario**.
* Soporte de atajos de teclado y gestión de eventos de bajo nivel para operar sin depender exclusivamente del ratón.
* Recálculo automático de existencias y generación de alertas visuales según el nivel de criticidad.

###  Interfaz UI/UX y Design Tokens
* Sistema visual unificado basado en **Design Tokens** (paleta semántica, jerarquía tipográfica y espaciado consistente).
* Diseño orientado a la **reducción de carga cognitiva** en entornos de trabajo exigentes.
* Feedback visual inmediato ante errores de validación, confirmaciones y estados críticos de stock.

###  Persistencia y Trazabilidad (SQLite + DAO)
* Almacenamiento relacional ligero, autónomo y sin dependencias externas complejas mediante **SQLite**.
* Histórico completo de operaciones para auditoría y control de mermas.

---

##  Arquitectura y Estructura del Repositorio

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
```

###  Organización del Proyecto

```text
stockscan-sga/
├── StockScanE/                 # Código fuente completo de la aplicación Java
├── docs/                       # Documentación técnica y académica unificada
│   ├── README.md               # Índice maestro de navegación por Sprints
│   ├── general/                # Análisis de mercado, Backlog y arquitectura MVC
│   ├── images/                 # Capturas de compilación, diagramas y certificados
│   └── sprints/                # Seguimiento incremental (Sprint 01 – Sprint 08)
│       └── sprint-XX/
│           ├── dii/            # Memoria y coevaluación (Desarrollo de Interfaces)
│           └── pi/             # Memoria y coevaluación (Proyecto Intermodular)
├── .github/                    # Plantillas de Pull Requests y flujo colaborativo
└── README.md                   # Presentación general del proyecto
```

---

##  Equipo y Metodología Scrum

El desarrollo se organiza de forma iterativa mediante **Scrum**, integrando los entregables de **Desarrollo de Interfaces (DII)** y **Proyecto Intermodular (PI)** en ciclos incrementales de trabajo:

| Miembro del Equipo | Perfil GitHub | Responsabilidades Clave |
| :--- | :--- | :--- |
| **Álvaro López** | [@romanscriptt](https://github.com/romanscriptt) | Arquitectura MVC/DAO, integración de eventos y gestión de repositorio |
| **Carmen Monge** | [@carmenmonge25](https://github.com/carmenmonge25) | Diseño UI/UX, implementación de vistas Swing y documentación |
| **Elena Sáez** | [@elenasaez25](https://github.com/elenasaez25) | Lógica de negocio, persistencia SQLite y control de calidad |
| **Ángel Luis Sánchez** | [@angelluissanchez25](https://github.com/angelluissanchez25) | Desarrollo de módulos operativos, pruebas funcionales y Scrum |

### 🔄 Ciclo de Trabajo en Cada Sprint

```text
Product Backlog ──▶ Sprint Planning ──▶ Desarrollo & Daily Scrum ──▶ Sprint Review & Retrospectiva
```

* **Flujo Git:** La rama `main` mantiene siempre una versión estable y compilable. Las nuevas funcionalidades se desarrollan en ramas dedicadas y se integran mediante **Pull Requests** revisados por el equipo usando nuestra plantilla estandarizada.
* **Seguimiento:** Gestión ágil centralizada en el tablero Kanban **StockScan SGA** (`GitHub Projects`) con trazabilidad mediante *Issues*.

---

##  Stack Tecnológico

* **Lenguaje:** Java 21 (JDK 21)
* **Interfaz Gráfica:** Java Swing + Sistema propio de Design Tokens
* **Base de Datos:** SQLite (JDBC)
* **Patrones de Diseño:** MVC (Modelo-Vista-Controlador) + DAO (Data Access Object)
* **Entornos de Desarrollo:** Apache NetBeans / IntelliJ IDEA
* **Control de Versiones y Gestión:** Git, GitHub Projects & GitHub Issues

---

## Instalación y Ejecución Local

1. **Clona el repositorio unificado:**
   ```bash
   git clone [https://github.com/romanscriptt/stockscan-sga.git](https://github.com/romanscriptt/stockscan-sga.git)
   ```
2. **Abre el proyecto en tu IDE:**
   * Importa la carpeta **`StockScanE`** desde **Apache NetBeans** o **IntelliJ IDEA**.
   * Verifica que el proyecto utiliza **JDK 21** y que el conector JDBC de **SQLite** está cargado en las librerías.
3. **Ejecuta la aplicación:**
   * Lanza la clase principal (`Main`) desde el IDE. La base de datos SQLite se inicializará automáticamente en local.

---

##  Roadmap del Proyecto

- [x] Análisis de requisitos, estudio de mercado y definición del *Product Backlog*
- [x] Diseño de arquitectura desacoplada (MVC + DAO) y modelado de base de datos SQLite
- [x] Sistema de identidad visual, *Design Tokens* y prototipado de pantallas
- [x] Implementación de autenticación (`VistaLogin`) y control de acceso
- [x] Gestión completa de inventario (CRUD de productos y categorías)
- [x] Integración de eventos de bajo nivel y atajos de teclado para escaneo rápido
- [x] Unificación de repositorios (DII + PI) y documentación técnica con Javadoc
- [ ] Módulo avanzado de informes estadísticos y exportación de auditorías
- [ ] Batería completa de pruebas unitarias e integración (JUnit 5)
- [ ] Empaquetado final ejecutable (`v1.0.0`) y defensa del proyecto
