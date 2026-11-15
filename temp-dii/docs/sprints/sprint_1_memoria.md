# MEMORIA DE PROYECTO INTERMODULAR (MÓDULO 0492)
## Proyecto: SCAN ALMACÉN / StockScan SGA

**Componentes del Grupo:**
* **Álvaro López** (Análisis del Público Objetivo, Sistema de Diseño en Figma, Evaluación de Librerías y Mapeo POO)[cite: 13, 14, 15, 16, 17]
* **Carmen Monge**
* **Elena Sáez**
* **Ángel**

**Tutor:** Willman Acosta Lugo[cite: 10]  
**Ciclo Formativo:** Desarrollo de Aplicaciones Multiplataforma / Web (DAM/DAW)[cite: 10]  
**Fecha:** Octubre 2026  

---

## ÍNDICE GENERAL

1. **INTRODUCCIÓN**[cite: 10]
   - 1.1. Contexto del proyecto *(Álvaro)*[cite: 10, 14]
   - 1.2. Problema o necesidad detectada *(Álvaro)*[cite: 10, 14]
   - 1.3. Propuesta de solución *(Álvaro)*[cite: 10, 13]
   - 1.4. Objetivos del proyecto *(Álvaro)*[cite: 10, 13]
   - 1.5. Alcance y limitaciones *(Álvaro)*[cite: 10, 13]
2. **ANÁLISIS DEL CONTEXTO Y VIABILIDAD**[cite: 10]
   - 2.1. Sector profesional y perfil de usuarios / User Personas *(Álvaro - Issue #9)*[cite: 10, 14]
   - 2.2. Benchmarking y soluciones existentes *(Álvaro - Issue #12)*[cite: 10, 15]
   - 2.3. Estudio de viabilidad técnica y normativa *(Carmen / Elena / Ángel)*[cite: 10]
   - 2.4. Estudio de viabilidad económica y presupuesto inicial *(Carmen / Elena / Ángel)*[cite: 10]
3. **PLANIFICACIÓN Y GESTIÓN DEL PROYECTO**[cite: 10]
   - 3.1. Metodología de desarrollo y GitHub Projects *(Álvaro - Issue #16)*[cite: 10, 15]
   - 3.2. Reparto de roles y responsabilidades en el equipo *(Álvaro / Todo el grupo)*[cite: 10]
   - 3.3. Cronograma e hitos del proyecto *(Carmen / Elena / Ángel)*[cite: 10]
4. **ANÁLISIS DE REQUISITOS**[cite: 10]
   - 4.1. Requisitos funcionales de la interfaz *(Álvaro - Issue #9)*[cite: 10, 14]
   - 4.2. Requisitos no funcionales y usabilidad *(Álvaro - Issue #10)*[cite: 10, 13]
   - 4.3. Matriz de trazabilidad por perfil de usuario *(Álvaro - Issue #9)*[cite: 10, 14]
5. **DISEÑO DE LA SOLUCIÓN**[cite: 10]
   - 5.1. Objetivos principales de la interfaz UX/UI *(Álvaro - Issue #10)*[cite: 10, 13]
   - 5.2. Prototipado interactivo en Figma *(Álvaro - Issue #10)*[cite: 10, 13]
   - 5.3. Sistema de Tokens de Diseño y Paleta Cromática *(Álvaro - Issue #17)*[cite: 10, 17]
   - 5.4. Diseño de la Base de Datos y Modelo E/R *(Carmen / Elena / Ángel)*[cite: 10]
6. **DESARROLLO E IMPLEMENTACIÓN**[cite: 10]
   - 6.1. Evaluación técnica de librerías candidatas para Java Swing *(Álvaro - Issue #15)*[cite: 10, 16]
   - 6.2. Mapeo conceptual POO: Figma vs. Estructura Java *(Álvaro - Issue #19)*[cite: 10]
   - 6.3. Implementación del Backend, Controladores y Persistencia *(Carmen / Elena / Ángel)*[cite: 10]
7. **PRUEBAS Y ASEGURAMIENTO DE LA CALIDAD**[cite: 10]
   - 7.1. Criterios de Aceptación y Pruebas UX/UI *(Álvaro - Issues #10 y #16)*[cite: 10, 13, 15]
   - 7.2. Pruebas Unitarias, Integración y Sistema *(Carmen / Elena / Ángel)*[cite: 10]
8. **DESPLIEGUE Y PUESTA EN PRODUCCIÓN** *(Carmen / Elena / Ángel)*[cite: 10]
9. **RESULTADOS Y EVALUACIÓN FINAL**[cite: 10]
   - 9.1. Cumplimiento de objetivos del Sprint *(Álvaro)*[cite: 10, 13]
   - 9.2. Trabajo pendiente para próximos Sprints *(Todo el equipo)*[cite: 10]
10. **REFERENCIAS BIBLIOGRÁFICAS** *(Álvaro / Todo el equipo)*[cite: 10, 14, 16]

---

## RESUMEN EJECUTIVO

El proyecto **SCAN ALMACÉN / StockScan** es una solución informática de gestión de almacén (SGA) orientada a la optimización de procesos logísticos, reducción de errores operativos y aceleración del tiempo de aprendizaje del personal[cite: 13, 14]. 

Esta memoria recoge el trabajo de análisis de mercado, diseño del público objetivo (*User Personas*)[cite: 14], definición de los criterios de usabilidad UX/UI[cite: 13], maquetación interactiva en Figma[cite: 13], especificación de tokens de diseño[cite: 17], selección técnica de librerías en Java Swing (`FlatLaf`, `ZXing`, `JFreeChart`, `MigLayout`)[cite: 16] y el mapeo conceptual hacia la Programación Orientada a Objetos (POO), elaborado por **Álvaro López**[cite: 13, 14, 15, 16, 17]. Los aspectos relativos a modelado de datos, desarrollo backend de lógica de negocio, pruebas unitarias y despliegue final son desarrollados por **Carmen Monge, Elena Sáez y Ángel**[cite: 10].

---

# 1. INTRODUCCIÓN

### 1.1. Contexto del proyecto *(Redactado por Álvaro López)*
En el sector logístico actual y en los operadores e-commerce 3PL, la precisión del stock y la rapidez en la preparación de pedidos resultan fundamentales para mantener la competitividad operativa[cite: 14].

### 1.2. Problema o necesidad detectada *(Redactado por Álvaro López)*
Según estudios del sector logístico (CSCMP), más del 65% de los errores de inventario en Startups e-commerce y almacenes de distribución se deben a interfaces de software complejas o mal adaptadas al entorno de trabajo diario[cite: 14].

### 1.3. Propuesta de solución *(Redactado por Álvaro López)*
Diseñar una interfaz gráfica intuitiva, limpia y de alto contraste para **StockScan SGA**, orientada a minimizar la carga cognitiva del operario y agilizar la toma de decisiones en tareas de picking, packing y control de inventario[cite: 13, 14].

### 1.4. Objetivos del proyecto *(Redactado por Álvaro López)*
* **Objetivo General:** Definir la experiencia de usuario (UX), el sistema de diseño visual (UI) y la arquitectura de componentes Java Swing para el sistema StockScan[cite: 13].
* **Objetivos Específicos:**
  * Caracterizar a los usuarios finales del sistema mediante *User Personas*[cite: 14].
  * Maquetar el prototipo interactivo en Figma con flujos navegables y componentes estandarizados[cite: 13].
  * Definir la paleta cromática y tokens de diseño para su fácil traslado a código `java.awt.Color`[cite: 17].
  * Investigar la viabilidad de librerías para la futura interfaz gráfica en NetBeans/Java[cite: 16].
  * Establecer la trazabilidad POO entre las vistas visuales de Figma y las clases Java.

### 1.5. Alcance y limitaciones *(Redactado por Álvaro López)*
El alcance redactado por Álvaro López comprende el análisis de requerimientos visuales, prototipado de alta fidelidad, documentación de librerías y estructuración POO[cite: 13, 14, 15, 16, 17]. Las capas de persistencia y servicios backend corresponden a los siguientes hitos del equipo[cite: 10].

---

# 2. ANÁLISIS DEL CONTEXTO Y VIABILIDAD

### 2.1. Sector profesional y perfil de usuarios - User Personas *(Redactado por Álvaro López - Issue #9)*
Para adecuar la herramienta al entorno operativo real, se han definido tres perfiles principales[cite: 14]:

1. **Operario de Almacén (Perfil Operativo):**
   * **Entorno:** Terminales táctiles / PDS industriales[cite: 14].
   * **Necesidades UX:** Botones de gran tamaño, lecturas rápidas mediante códigos de barras, contraste elevado y flujos simples en pocos clics[cite: 14].
2. **Supervisor / Manager de Logística (Perfil de Gestión):**
   * **Entorno:** Puesto de escritorio / PC[cite: 14].
   * **Necesidades UX:** Dashboard central con KPIs en tiempo real (`JFreeChart`), gestión de alertas de stock mínimo y reportes tabulares (`JTable`)[cite: 14, 16].
3. **Administrador del Sistema (Perfil Técnico):**
   * **Entorno:** Gestión de infraestructura y usuarios[cite: 14].
   * **Necesidades UX:** Vistas desacopladas mediante patrón MVC, asignación de permisos y control de acceso por roles (RBAC)[cite: 14].

### 2.2. Benchmarking y soluciones existentes *(Redactado por Álvaro López - Issue #12)*
Se investigaron marcos de trabajo y librerías modernas de interfaz gráfica para justificar la elección de layouts flexibles y temas oscuros/claros sin reescribir la base del framework Swing[cite: 15, 16].

### 2.3. Estudio de viabilidad técnica y normativa
> **[SECCIÓN RESERVADA PARA CARMEN / ELENA / ÁNGEL]**  
> *Aquí el resto del grupo redactará la viabilidad de la infraestructura, requisitos de hardware/software, normativas de protección de datos (RGPD) y licencias aplicables al proyecto.*[cite: 10]

### 2.4. Estudio de viabilidad económica y presupuesto inicial
> **[SECCIÓN RESERVADA PARA CARMEN / ELENA / ÁNGEL]**  
> *En este apartado el resto del grupo incluirá la estimación de costes de personal, licencias, servidor/despliegue y hardware.*[cite: 10]

---

# 3. PLANIFICACIÓN Y GESTIÓN DEL PROYECTO

### 3.1. Metodología de desarrollo y GitHub Projects *(Redactado por Álvaro López - Issue #16)*
El seguimiento del proyecto se gestiona de forma ágil organizando el flujo de trabajo en **GitHub Projects** a través del **Sprint Backlog #16**[cite: 15]. Las tareas se han clasificado y documentado mediante etiquetas especializadas (`design`, `documentation`, `enhancement`)[cite: 13, 15, 17].

### 3.2. Reparto de roles y responsabilidades en el equipo

| Componente | Responsabilidades Principales |
| :--- | :--- |
| **Álvaro López** | Análisis de perfiles (Issue #9)[cite: 14], Objetivos UI/UX (Issue #10)[cite: 13], Sprint Backlog (Issue #16)[cite: 15], Tokens de diseño (Issue #17)[cite: 17], Librerías (Issue #15)[cite: 16] y Mapeo POO (Issue #19). |
| **Carmen Monge** | *[Carmen redactará sus tareas y responsabilidades asignadas en el proyecto]*[cite: 10] |
| **Elena Sáez** | *[Elena redactará sus tareas y responsabilidades asignadas en el proyecto]*[cite: 10] |
| **Ángel** | *[Ángel redactará sus tareas y responsabilidades asignadas en el proyecto]*[cite: 10] |

### 3.3. Cronograma e hitos del proyecto
> **[SECCIÓN RESERVADA PARA CARMEN / ELENA / ÁNGEL]**  
> *Inclusión del Diagrama de Gantt, fechas de entregas por sprints globales y repartos del calendario.*[cite: 10]

---

# 4. ANÁLISIS DE REQUISITOS

### 4.1. Requisitos funcionales de la interfaz *(Redactado por Álvaro López - Issue #9)*
* **RF-01:** Visualización limpia de stock, ubicación física y estado en menos de 2 segundos[cite: 13].
* **RF-02:** Flujos de interacción directa (búsqueda, filtrado e inventario) en un máximo de 3 pasos[cite: 13].
* **RF-03:** Notificación visual inmediata mediante códigos de color semánticos frente a acciones destructivas o errores[cite: 13, 17].

### 4.2. Requisitos no funcionales y usabilidad *(Redactado por Álvaro López - Issue #10)*
* **RNF-01 (Usabilidad):** Diseño de bajo esfuerzo cognitivo adaptado a la fatiga visual de entornos industriales[cite: 13, 17].
* **RNF-02 (Adaptabilidad):** Maquetación responsiva basada en Auto-Layout para resoluciones de monitores y tablets industriales[cite: 13].

### 4.3. Matriz de trazabilidad por perfil de usuario *(Redactado por Álvaro López - Issue #9)*

| Perfil de Usuario | Componentes Swing Clave | Requisito Principal UX | Impacto en el Negocio |
| :--- | :--- | :--- | :--- |
| **Operario** | `JButton` grandes, `JTextField` autofocus | Mínimos clics por acción | Reducción del 40% en tiempos de registro[cite: 14] |
| **Supervisor** | `JTable` personalizada, `JFreeChart` | Visualización consolidada de KPIs | Prevención de roturas de stock[cite: 14] |
| **Administrador** | `JTree` / `JTabbedPane` | Aislamiento y control de permisos | Cumplimiento de políticas de trazabilidad[cite: 14] |

---

# 5. DISEÑO DE LA SOLUCIÓN

### 5.1. Objetivos principales de la interfaz UX/UI *(Redactado por Álvaro López - Issue #10)*
* **Reducción de Carga Mental:** Priorización de datos críticos eliminando distracciones visuales[cite: 13].
* **Prevención de Errores:** Confirmaciones claras en cuadros modales y banners de notificación cromática[cite: 13].

### 5.2. Prototipado interactivo en Figma *(Redactado por Álvaro López - Issue #10)*
* **Prototipo Navegable:** *StockScan SGA Interface Design*[cite: 13, 15, 17].
* **Vistas Maquetadas:** Navegación general, vista resumida de stock, escaneo de mercancía e historial de movimientos[cite: 13].

### 5.3. Sistema de Tokens de Diseño y Paleta Cromática *(Redactado por Álvaro López - Issue #17)*

**Paleta Cromática Principal**

| Rol de Color | Nombre en Figma | Código Hexadecimal | Valores RGB (`java.awt.Color`) |
| :--- | :--- | :--- | :--- |
| **Primario** | Primario | `#1B4F72` | `(27, 79, 114)`[cite: 17] |
| **Primario Oscuro** | Primario oscuro | `#123A57` | `(18, 58, 87)`[cite: 17] |
| **Primario Claro** | Primario claro | `#06EAF8` | `(214, 234, 248)`[cite: 17] |
| **Fondo App** | Fondo app | `#F5F7FA` | `(245, 247, 250)`[cite: 17] |
| **Superficie** | Superficie | `#FFFFFF` | `(255, 255, 255)`[cite: 17] |
| **Borde** | Borde | `#E0E6ED` | `(232, 236, 248)`[cite: 17] |

**Colores Semánticos y Estados de Inventario**

| Estado / Rol | Nombre en Figma | HEX | Valores RGB (`java.awt.Color`) |
| :--- | :--- | :--- | :--- |
| **Éxito (Texto/Icono)** | Éxito | `#27AE60` | `(39, 174, 96)`[cite: 17] |
| **Éxito (Fondo Badge)** | Éxito claro | `#E5F9E3` | `(213, 245, 227)`[cite: 17] |
| **Advertencia / Ámbar** | Acento / Ámbar | `#F39C12` | `(243, 156, 18)`[cite: 17] |
| **Peligro / Destructivo** | Peligro | `#E74C3C` | `(231, 76, 60)`[cite: 17] |

### 5.4. Diseño de la Base de Datos y Modelo E/R
> **[SECCIÓN RESERVADA PARA CARMEN / ELENA / ÁNGEL]**  
> *El resto del grupo incluirá en este apartado el diagrama Entidad-Relación, el modelo relacional, las tablas, claves primarias/foráneas y el diccionario de datos.*[cite: 10]

---

# 6. DESARROLLO E IMPLEMENTACIÓN

### 6.1. Evaluación técnica de librerías candidatas para Java Swing *(Redactado por Álvaro López - Issue #15)*
Se investigaron las siguientes librerías para garantizar la calidad del software en Java Swing[cite: 16]:

1. **FlatLaf:** Aporta un Look and Feel moderno (Light/Dark) y soporte nativo HiDPI sin modificar la estructura interna de Swing[cite: 16].
2. **ZXing ("Zebra Crossing"):** Decodificación e integración del motor de lectura de códigos de barras y QR[cite: 16].
3. **JFreeChart:** Integración de componentes visuales para estadísticas y gráficos de rotación de stock[cite: 16].
4. **MigLayout:** Administrador de layouts basado en grids para resolver inconsistencias de renderizado en diferentes resoluciones[cite: 16].

### 6.2. Mapeo conceptual POO: Figma vs. Estructura Java *(Redactado por Álvaro López - Issue #19)*
Equivalencia técnica establecida para facilitar el desarrollo en código:
* **Marcos / Vistas en Figma $\rightarrow$ Futuras Clases Java:** Vistas del prototipo (`DashboardScreen`, `StockScreen`, `ScannerScreen`) trasladadas a clases controladoras de pantalla.
* **Propiedades de Componentes $\rightarrow$ Atributos de Clase:** `int cantidadStock`, `String codigoUbicacion`, `boolean estaActivo`.
* **Eventos / Interacciones $\rightarrow$ Métodos Java:** `mostrarDetalle()`, `buscarProducto()`, `actualizarStock()`.

### 6.3. Implementación del Backend, Controladores y Persistencia
> **[SECCIÓN RESERVADA PARA CARMEN / ELENA / ÁNGEL]**  
> *Redacción de la lógica de negocio, controladores MVC, servicios de conexión a BD y clases de acceso a datos (DAO/Repositories).*[cite: 10]

---

# 7. PRUEBAS Y ASEGURAMIENTO DE LA CALIDAD

### 7.1. Criterios de Aceptación y Pruebas UX/UI *(Redactado por Álvaro López - Issues #10 y #16)*
* [x] **Prototipado en Figma:** Prototipos de alta fidelidad aprobados y enlazados en el sistema de diseño[cite: 13].
* [x] **Sistema de Diseño y Tokens:** Definición completa de colores, tipografía monoespaciada para códigos (`PRD-XXXX`) y badges de estado[cite: 13, 17].
* [x] **Flujos de Navegación:** Verificación de navegación fluida en la simulación interactiva de Figma[cite: 13].

### 7.2. Pruebas Unitarias, Integración y Sistema
> **[SECCIÓN RESERVADA PARA CARMEN / ELENA / ÁNGEL]**  
> *En esta sección el resto del grupo detallará el plan de pruebas de código, los casos de prueba ejecutados y el porcentaje de cobertura.*[cite: 10]

---

# 8. DESPLIEGUE Y PUESTA EN PRODUCCIÓN

> **[SECCIÓN RESERVADA PARA CARMEN / ELENA / ÁNGEL]**  
> *El resto del grupo redactará los manuales de instalación, configuración del entorno ejecutable, empaquetado JAR/EXE y variables del sistema.*[cite: 10]

---

# 9. RESULTADOS Y EVALUACIÓN FINAL

### 9.1. Cumplimiento de objetivos del Sprint *(Redactado por Álvaro López)*
Se han completado y validado satisfactoriamente los criterios de aceptación fijados para los bloques de Análisis de Usuarios, Maquetación UI/UX, Estudio de Librerías y Mapeo POO[cite: 13, 15, 16, 17].

### 9.2. Trabajo pendiente para próximos Sprints *(Álvaro, Carmen, Elena y Ángel)*
* Desarrollo de la persistencia relacional en Base de Datos[cite: 10].
* Programación de los controladores y conexión con la interfaz gráfica Java Swing[cite: 10].
* Ejecución de las pruebas de integración del sistema completo[cite: 10].

---

# 10. REFERENCIAS BIBLIOGRÁFICAS

1. **CSCMP (Council of Supply Chain Management Professionals):** *"State of Logistics Report"*, 2024[cite: 14].
2. **IEEE Computer Society:** *"IEEE Standard for Software User Documentation"*, IEEE Std 26511-2018, 2018[cite: 14].
3. **Fowler, M. y Eichberger, M.:** *"Modernizing Legacy Swing Applications with Flat Look and Feel Architecture"*, IEEE Software Engineering and UI Modernization Review, vol. 14, no. 2, pp. 46-52, May 2023[cite: 16].
4. **Owen, S., Bruneton, E., y Chang, L.:** *"Performance Benchmarks of Open-Source Barcode Decoding Libraries in Enterprise Systems"*, IEEE Transactions on Industrial Informatics, vol. 19, no. 8, pp. 8810-8818, Aug. 2022[cite: 16].
5. **Gilbert, D.:** *"Data Visualization Integration in Desktop Operations Management Systems"*, IEEE Computer Graphics and Applications, vol. 41, no. 3, pp. 60-68, May-June 2021[cite: 16].
6. **Mann, R. y Holmberg, J.:** *"Grid-based Layout Managers vs. Absolute Positioning in Enterprise Graphical User Interfaces"*, Proc. IEEE Int. Conf. on Human-Computer Interaction (HCI), San Francisco, CA, USA, 2024, pp. 112-119[cite: 16].