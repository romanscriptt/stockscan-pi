# StockScan SGA — Sistema de Gestión de Almacenes Inteligente

<p align="center">
  <img width="966" height="526" alt="StockScan SGA Banner" src="https://github.com/user-attachments/assets/afc83056-1f43-4044-ab8c-5843eee5c4ff" />
</p>

<p align="center">
  <b>Proyecto Intermodular — 2º DAM (Desarrollo de Aplicaciones Multiplataforma)</b><br>
  Gestión de stock en tiempo real mediante escaneo inteligente para hostelería, e-commerce y distribución.
</p>

<p align="center">
  <img src="https://skillicons.dev/icons?i=java,sqlite,git,github,idea,vscode" height="50" />
  <img src="https://cdn.simpleicons.org/openjdk/430098" height="50" alt="OpenJDK" />
  <img src="https://cdn.simpleicons.org/junit5/25A162" height="50" alt="JUnit5" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Sprint-Sprint%202%20(Completado)-27AE60?style=flat-square" alt="Sprint 2">
  <img src="https://img.shields.io/badge/JDK-21-blue?style=flat-square" alt="Java 21">
  <img src="https://img.shields.io/badge/GUI-FlatLaf%20%2F%20Swing-informational?style=flat-square" alt="FlatLaf">
  <img src="https://img.shields.io/badge/Database-SQLite-green?style=flat-square" alt="SQLite">
  <img src="https://img.shields.io/badge/License-Proprietary-red?style=flat-square" alt="Licencia">
</p>

> **Ecosistema StockScan SGA:** Este repositorio aloja el **Proyecto Integrado (PI)** (arquitectura global, persistencia SQLite, seguridad con jBCrypt, auditorías legales y documentación de sprints). Para consultar el desarrollo específico de interfaces gráficas, *Design Tokens* y gestión de eventos de bajo nivel en Java Swing, visita el repositorio complementario: **[StockScan SGA — Desarrollo de Interfaces (DII)](https://github.com/romanscriptt/stockscan-dii)**.

---

## Descripción del Sistema

StockScan SGA es una solución multiplataforma orientada al control y gestión inteligente de inventarios en tiempo real. Diseñado para optimizar la operativa en sectores como hostelería, comercio electrónico y distribución logística, el sistema permite la identificación automatizada de productos en estanterías a través de dispositivos móviles y de escritorio, reduciendo los tiempos de auditoría y eliminando los errores de rotura de stock.

---

## Funcionalidades Principales

- **Escáner Inteligente de Stock:** Identificación inmediata de productos y cajas en estanterías mediante lectura óptica con la cámara del dispositivo.
- **Chat Interno y Comunicación:** Canal directo de mensajería en tiempo real entre administradores, supervisores y operarios de almacén o camareros.
- **Agenda, Tareas y Check-in:** Control integral de turnos de trabajo, asignación de tareas operativas y registro digital de asistencia.
- **Arquitectura Multi-sector:** Configuración flexible adaptada a las necesidades específicas de restaurantes, almacenes logísticos y tiendas online.
- **Arquitectura Offline-First:** Persistencia local garantizada con sincronización en segundo plano para trabajar sin interrupciones en zonas de baja cobertura.

---

## Estado del Proyecto

| Hito / Sprint | Estado | Entregables Clave |
| :--- | :---: | :--- |
| **Sprint 1** | **Completado** | Definición de requisitos, diagrama de casos de uso, arquitectura base del sistema y prototipo inicial. |
| **Sprint 2** | **Completado** | Implementación del módulo visual (Java Swing + FlatLaf), base de datos SQLite con jBCrypt, auditorías de accesibilidad (WCAG 2.1 / UNE-EN 301 549), RGPD y viabilidad legal. |
| **Sprint 3** | **Planificado** | Integración del motor de escaneo, comunicación en tiempo real del chat y pruebas de integración finales. |

---

## Stack Tecnológico

- **Lenguaje Principal:** Java SE (JDK 21)
- **Interfaz Gráfica (GUI):** Java Swing + FlatLaf (Look & Feel Moderno / HiDPI)
- **Persistencia & Base de Datos:** SQLite (SQLite JDBC Driver)
- **Seguridad & Cifrado:** jBCrypt (Hashing de contraseñas de operarios)
- **Iconografía & UI Assets:** Lucide Icons / FontAwesome
- **Testing & Calidad:** JUnit 5

---

## Estructura del Repositorio

```text
stockscan-pi/
├── .github/
│   └── PULL-REQUEST_TEMPLATE/     # Plantillas estandarizadas para revisión de código (PRs)
├── docs/
│   └── Memorias/                  # Documentación técnica, memorias de Sprints y auditorías legales
├── .gitignore                     # Reglas de exclusión de archivos compilados y temporales
└── README.md                      # Documentación general del Proyecto Integrado
