# Memoria final Sprint 2 – StockScan SGE


## **Componentes del Grupo y coevaluación:**
- **Álvaro López** 90%  
- **Carmen Monge** 90%  
- **Elena Sáez** 90%  
- **Ángel Luis** 90%

**Tutor:** Willman Acosta Lugo  
**Ciclo Formativo:** Desarrollo de Aplicaciones Multiplataforma (DAM)  
**Fecha:** 30/10/2026
  
## 1. Análisis y planificación

Fase inicial del proyecto. Se estudia el problema, qué necesitan los usuarios y qué soluciones existen ya, y con ello se definen los requisitos, el alcance y la organización del trabajo (tareas, responsables y plazos). Lo que se decide aquí marca el resto de fases.

### 1.1. Analizar requisitos de usabilidad y accesibilidad

## 1. ¿Qué es la usabilidad?[2]
La usabilidad permite que los usuarios puedan alcanzar sus objetivos con los mejores resultados posibles con el mínimo esfuerzo posible, navegando por la aplicación de forma sencilla y eficaz.

## 2. ¿Qué es la accesibilidad?[2]
La accesibilidad consiste en brindar a la mayoría de usuarios un fácil acceso a nuestra página independientemente de las circunstancias de cada usuario, ya esté en otro país, hable otro idioma, o disponga de discapacidad visual, motriz, auditiva, cognitiva...  
 

## 3. Requisitos de usabilidad (RU):

- **RU-01: Navegación intuitiva**[3].
La aplicación deberá disponer de un navegador claro, que permita encontrar las secciones principales sin crear confusión.

- **RU-02: Facilidad de uso**[3].
Las acciones principales deberán ser fáciles de identificar y realizar, sin añadir pasos innecesarios que dificulten dicha acción. Además de hacer siempre visibles las opciones en la aplicación, de forma que el usuario no tenga que recordar dónde se encuentra cada opción.[1]

- **RU-03: Claridad y consistencia visual**[3].
La aplicación deberá mantener una apariencia y un comportamiento coherentes. Los botones, menús, iconos y textos deberán ser fáciles de reconocer. Manteniendo un diseño sencillo y minimalista aumenta la claridad y el entendimiento, haciendo que el usuario se enfoque en lo importante[1].

- **RU-04: Prevención y corrección de errores**[3].
La aplicación deberá prevenir errores siempre que sea posible y mostrar mensajes claros que expliquen el problema de forma que el usuario lo pueda entender y cómo solucionarlo. Trabajar con un diseño sencillo y fácil de usar ayuda a prevenir errores por parte del usuario[1].

- **RU-05: Adaptación a dispositivos**[3].
La interfaz deberá adaptarse a los tamaños de pantalla sin pérdida de información ni de funcionalidad.

- **RU-06: Eficiencia y rendimiento percibido**[3].
Las acciones frecuentes deberán requerir un esfuerzo razonable y la interfaz deberá proporcionar respuesta visible como respuesta a cualquier acción del usuario, los estados de ejecución, para mantener al usuario informado de lo que está ocurriendo en todo momento[1]. Ofrecer atajos de teclado para agilizar la navegación para adaptarse tanto a los usuarios expertos como a los principiantes[1].

- **RU-07: Ayuda y documentación**[1].
En caso de que el usuario necesite ayuda la información debe ser fácil de localizar, en la cual, explique los pasos necesarios sin ser demasiado extensa.


### 3.1. ¿Cómo medir el cumplimiento de los requisitos de usabilidad (RU)?
La evaluación de la usabilidad se realizará mediante pruebas con usuarios representativos, observación de las tareas, medición de tiempos, registro de errores y cuestionarios de satisfacción. Estos métodos permiten evaluar la eficacia, la eficiencia y la satisfacción con las que los usuarios alcanzan sus objetivos al utilizar la aplicación de escritorio, siguiendo el marco de evaluación de la norma ISO 9241-11:2018 [5].

Para que los resultados sean verificables, se propone definir indicadores cuantificables y criterios de aceptación antes de realizar las pruebas. Los porcentajes y tiempos siguientes son objetivos propuestos para el proyecto, no valores obligatorios establecidos por las normas citadas [5], [6].


#### 3.1.1. Indicadores y métodos de evaluación [5], [6]
 | Requisito | ¿Cómo se mide? | Criterio de aceptación propuesto | 
 |---|---|---| 
 | RU-01: Navegación intuitiva | Porcentaje de usuarios que encuentran una sección y completan una tarea sin ayuda. | Al menos el 90% completa las tareas de navegación sin ayuda. | 
 | RU-02: Facilidad de uso | Porcentaje de tareas principales completadas correctamente y número de pasos necesarios. | Al menos el 90% completa correctamente las tareas principales sin ayuda. | 
 | RU-03: Claridad y consistencia visual | Inspección de botones, menús, iconos, etiquetas y patrones de interacción en las distintas ventanas | El 100% de los elementos principales inspeccionados sigue las convenciones visuales definidas para la aplicación. | 
 | RU-04: Prevención y corrección de errores | Número de errores producidos durante las tareas y porcentaje de errores corregidos correctamente tras mostrar un mensaje | El 100% de los errores críticos contemplados en las pruebas dispone de una respuesta comprensible y un procedimiento de corrección. | 
 | RU-05: Adaptación a dispositivos | Comprobación de la interfaz con diferentes resoluciones, escalas de pantalla y configuraciones del sistema operativo compatibles | El 100% de las tareas principales sigue siendo realizable en todas las configuraciones compatibles probadas, sin pérdida de funciones ni información esencial. | 
 | RU-06: Eficiencia y rendimiento  | Medición del tiempo de respuesta, duración de las tareas frecuentes, disponibilidad de indicadores de progreso y funcionamiento de los atajos de teclado. | Al menos el 90% de las acciones frecuentes cumple el tiempo objetivo definido y todas las acciones que lo requieren informan de su estado. | 
 | RU-07: Ayuda y documentación | Porcentaje de usuarios que localizan la ayuda y resuelven una duda mediante sus instrucciones | Al menos el 90% encuentra la ayuda y resuelve correctamente las tareas de consulta propuestas. | 

Los métodos de evaluación han sido por elaboración propia a partir de los conceptos de eficacia, eficiencia y satisfacción de la [ISO
9241-11](https://cdn.standards.iteh.ai/samples/63500/33c2670a5a7564f298f02bbd65721a181/ISO-9241-11-2018.pdf), y de las prácticas de pruebas de accesibilidad e interacción descritas en la [Guía para la aplicación de las WCAG 2 a las tecnologías de la información y la comunicación no web (WCAG2ICT)](https://www.w3.org/TR/wcag2ict/). Los umbrales son propuestas del proyecto.

#### 3.1.2. Fórmulas para calcular los resultados
Los siguientes indicadores permiten registrar los resultados de las pruebas de usabilidad de forma objetiva [5], [6].

1. **Porcentaje de tareas completadas correctamente** [5]
Éxito (%) = (Tareas completadas correctamente / Total de tareas intentadas) x 100

2. **Tiempo medio de realización** [5]
Tiempo medio de realización = Sumatorio de los tiempos empleados para cada intento / Número total de intentos válidos

3. **Tasa de errores** [5], [6]
Tasa de errores (%) = (Errores registrados / Oportunidades de error) x 100

4. **Satisfacción del usuario** [5]
Se puede utilizar un cuestionario posterior a las pruebas con una escala de 1 a 5, donde 1 significa «muy insatisfecho» y 5 «muy satisfecho». La puntuación media se obtiene sumando las valoraciones y dividiendo el resultado entre el número de respuestas. 
La escala es una propuesta de evaluación del proyecto, no un umbral normativo.


#### 3.1.3. Procedimiento para evaluar la usabilidad
1. Seleccionar las tareas principales de la aplicación, como iniciar una operación, consultar información, modificar datos o guardar un resultado, según las funciones que realmente ofrezca el programa [5].
2. Pedir a varios usuarios representativos que realicen las tareas sin recibir instrucciones que revelen directamente la solución [5].
3. Registrar el éxito, el tiempo, los errores, las solicitudes de ayuda y las dificultades observadas durante cada tarea [5].
4. Comparar los resultados con los criterios de aceptación definidos para cada requisito RU [5].
5. Corregir los problemas detectados y repetir las pruebas para comprobar si las modificaciones mejoran los resultados [5], [6].

La aplicación se considerará conforme con un requisito de usabilidad cuando alcance su criterio de aceptación y existan evidencias registradas que permitan verificarlo. Si no se alcanza el umbral, el requisito deberá marcarse como no conforme o pendiente de corrección [5], [6].



## 4. Requisitos de accesibilidad (RA):
- **RA-01: Percepción visual**[4].  
Los textos, iconos, controles y demás elementos importantes deberán poder distinguirse con claridad. La información no dependerá exclusivamente del color.  

- **RA-02: Navegación por teclado**[4].  
Todas las funcionalidades deberán poder utilizarse mediante teclado, sin depender exclusivamente de un ratón o de gestos táctiles.

- **RA-03: Compatibilidad con tecnologías de apoyo**[4].  
Los controles y contenidos deberán proporcionar nombres, funciones y estados identificables por tecnologías de asistencia, como los lectores de pantalla.
 
- **RA-04: Alternativas para contenidos multimedia**[4].  
Los contenidos audiovisuales deberán ofrecer alternativas accesibles para las personas que no puedan escuchar o ver toda la información.
 
- **RA-05: Comprensión del contenido**[4].  
Los textos, instrucciones, menús y mensajes deberán ser claros, comprensibles y consistentes, evitando tecnicismos innecesarios y ambigüedades.
 
- **RA-06: Interacción accesible**[4].  
Los controles deberán poder activarse sin exigir movimientos precisos o gestos complejos. Se evitarán acciones que puedan provocar activaciones accidentales.
 
- **RA-07: Ampliación y adaptación del contenido**[4]  
El contenido deberá seguir siendo utilizable cuando las personas amplíen el texto o necesiten modificar la presentación de la interfaz.


### 4.1. ¿Cómo medir el cumplimiento de los requisitos de accesibilidad (RA)?
La accesibilidad de una aplicación de escritorio se evaluará comprobando que las personas con distintas capacidades puedan percibir la información, utilizar los controles, comprender los mensajes y completar las operaciones disponibles. Para ello, se combinarán inspecciones técnicas, pruebas manuales, herramientas de evaluación y pruebas con tecnologías de asistencia [6], [7].

Como referencia técnica, se utilizará la guía WCAG2ICT, que explica cómo interpretar los criterios de accesibilidad WCAG para programas informáticos y otros productos tecnológicos que no son páginas web. También se tendrán en cuenta los requisitos aplicables al software de la norma EN 301 549 [6], [7]. 

#### 4.1.1. Indicadores y métodos de evaluación [6], [7], [8]
 | Requisito | ¿Cómo se mide? | Criterio de aceptación propuesto | 
 |---|---|---| 
 | RU-01: Percepción visual | Medir el contraste de textos y controles, revisar la legibilidad de iconos y comprobar que la información no se comunica únicamente mediante colores. | Todos los elementos relevantes cumplen los niveles de contraste definidos para el proyecto y disponen de señales adicionales cuando el color transmite información. | 
 | RU-02: Navegación por teclado | Recorrer todas las ventanas y funciones utilizando exclusivamente el teclado. Comprobar el orden del foco, los atajos y la activación de controles. | El 100% de las funciones principales puede ejecutarse mediante teclado, sin bloqueos de navegación. | 
 | RU-03: Compatibilidad con tecnologías de apoyo | Inspeccionar los nombres, roles, estados y descripciones de los controles con herramientas de accesibilidad y probar las operaciones con un lector de pantalla compatible. | El 100% de los controles principales proporciona información accesible y permite completar las tareas previstas con la tecnología de asistencia seleccionada. | 
 | RU-04: Alternativas para contenidos multimedia | Revisar los contenidos audiovisuales incorporados a la aplicación, comprobando subtítulos, transcripciones o descripciones cuando correspondan. | Todos los contenidos multimedia informativos disponen de las alternativas que necesitan para transmitir su información esencial. | 
 | RU-05: Comprensión del contenido | Revisar las etiquetas, instrucciones, mensajes de error y textos de ayuda. Realizar pruebas de comprensión con usuarios. | El 100% de los mensajes críticos es comprensible y permite identificar la acción necesaria para continuar o resolver el problema. | 
 | RU-06: Interacción accesible  | Comprobar el tamaño y la facilidad de activación de los controles, el comportamiento de las acciones accidentales y la disponibilidad de alternativas a los gestos complejos. | Todas las operaciones principales pueden realizarse sin exigir movimientos precisos o gestos complejos innecesarios. | 
 | RU-07: Ampliación y adaptación del contenido | Aumentar el tamaño del texto y modificar las opciones de escala y visualización compatibles con el sistema operativo. | El 100% de las tareas principales sigue siendo realizable, sin que se oculten controles, se recorten textos esenciales o se pierda información. | 

Elaboración propia a partir de [WCAG2ICT](https://www.w3.org/TR/wcag2ict/), [EN 301 549](https://www.etsi.org/deliver/etsi_en/301500_301599/301549/03.02.01_60/en_301549v030201p.pdf) y las [recomendaciones de pruebas de accesibilidad para aplicaciones de escritorio](https://www.w3.org/WAI/WCAG22/Understanding/contrast-minimum.html). Los porcentajes y condiciones de aceptación son objetivos propuestos para el proyecto, no umbrales universales impuestos por esas referencias.

#### 4.1.2. Métricas específicas de accesibilidad
Para comprobar los resultados, se propone registrar las siguientes métricas durante las pruebas de la aplicación de escritorio [6], [8].

1. **Cobertura de funciones accesibles mediante teclado**
Cobertura (%) = (Funciones utilizadas con teclado / Total de funciones evaluadas) x 100

El resultado será del 100 % cuando todas las funciones evaluadas puedan utilizarse mediante teclado, siempre que no exista una excepción justificada por la propia naturaleza de la operación [6].

2. **Porcentaje de controles identificables por tecnologías de asistencia**
Identificación (%) = (Controles con información accesible correcta / Total de controles inspeccionados) x 100

Para considerar correcto un control, se comprobará que la tecnología de asistencia puede identificar su nombre, función y estado cuando corresponda, así como transmitir los cambios relevantes [7], [8].

3. **Cumplimiento del contraste visual**
Se medirá la relación de contraste entre el texto o elemento visual y su fondo, cuando el criterio correspondiente sea aplicable. Como referencia para texto normal, WCAG establece una relación mínima de 4,5:1 en el nivel AA. Para texto grande, el mínimo es 3:1. Estos valores se aplicarán como referencia técnica a los elementos pertinentes de la aplicación de escritorio, teniendo en cuenta las condiciones y excepciones correspondientes de WCAG2ICT [6], [9].

4. **Porcentaje de tareas completadas con tecnologías de asistencia**
Éxito accesible (%) = (Tareas completadas con asistencia / Total de tareas evaluadas) x 100

Las pruebas se realizarán con un lector de pantalla compatible y, cuando corresponda, otras tecnologías de apoyo. Se anotarán las tareas completadas, los bloqueos y la información que no haya sido anunciada correctamente [6], [8].

5. **Porcentaje de tareas completadas tras ampliar el contenido**
Éxito con ampliación (%) = (Tareas completadas tras ampliar el contenido / Total de tareas evaluadas) x 100

Se comprobará que la ampliación de texto y los ajustes de escala compatibles con el entorno de escritorio no impidan acceder a controles ni comprender la información [6], [8].

#### 4.1.3. Procedimiento para evaluar la accesibilidad
1. **Inspección técnica:** revisar los controles de la interfaz mediante herramientas de evaluación para detectar nombres ausentes, estados incorrectos y otros problemas de accesibilidad [8].
2. **Prueba de teclado:** recorrer las ventanas, los cuadros de diálogo, los menús y las operaciones principales sin utilizar el ratón [6], [8].
3. **Prueba visual:** comprobar el contraste, la legibilidad, la dependencia del color y el comportamiento de la interfaz al ampliar el contenido [6], [9].
4. **Prueba con tecnologías de asistencia:** ejecutar tareas habituales con un lector de pantalla compatible y comprobar que los controles y sus estados se anuncian correctamente [8].
5. **Revisión de contenidos y mensajes:** comprobar que las instrucciones, los errores y las alternativas multimedia proporcionan la información necesaria para utilizar la aplicación [6].
6. **Registro y corrección:** documentar cada problema con su requisito asociado, los pasos para reproducirlo, la gravedad, la evidencia obtenida y el resultado de la nueva prueba después de corregirlo [8].

La aplicación se considerará conforme con un requisito de accesibilidad cuando supere las pruebas aplicables, cumpla los criterios de aceptación definidos y disponga de evidencias documentadas [6], [8].

## 5. Tareas para comprobar el cumplimiento:  
- [ ] Revisar las tareas principales
- [ ] Realizar pruebas con usuarios
- [ ] Comprobar la navegación por teclado
- [ ] Revisar el contraste y la ampliación
- [ ] Probar con tecnologías de asistencia
- [ ] Registrar y corregir problemas

## 6. Referencias:
[1] Lugo, Willman Acosta. «\x5bDAM\x5dUsabilidad2026». 13 de octubre de 2026. https://docs.google.com/presentation/d/1RENkac6LJWCK7VsLMN4KRsrvTlCqjNoHPTaZd8lSTQw.
[2] Arsys. «Usabilidad y accesibilidad: diferencias e importancia | Blog de Arsys». Accedido 20 de octubre de 2026. https://www.arsys.es/blog/usabilidad-vs-accesibilidad.
[3] Initiative (WAI), W3C Web Accessibility. «Accessibility, Usability, and Inclusion». Web Accessibility Initiative (WAI). Accedido 21 de octubre de 2026. https://www.w3.org/WAI/fundamentals/accessibility-usability-inclusion/.
[4] Initiative (WAI), W3C Web Accessibility. «Accessibility Principles». Web Accessibility Initiative (WAI). Accedido 22 de octubre de 2026. https://www.w3.org/WAI/fundamentals/accessibility-principles/.
[5] «ISO-9241-11-2018.pdf». ISO-9241-11-2018.pdf. Accedido 30 de octubre de 2026. https://cdn.standards.iteh.ai/samples/63500/33c2670a5a7564f298f02bbd65721a181/ISO-9241-11-2018.pdf.
[6] «Guidance on Applying WCAG 2 to Non-Web Information and Communications Technologies (WCAG2ICT)». Accedido 30 de octubre de 2026. https://www.w3.org/TR/wcag2ict/.
[7] «ETSI EN 301 549 - V3.2.1 - Accessibility requirements for ICT products and services». en_301549v030201p.pdf. Accedido 30 de octubre de 2026. https://github.com/user-attachments/files/34161053/en_301549v030201p.pdf.
[8] GrantMeStrength. «Accessibility Testing - Windows Apps». Accedido 30 de octubre de 2026. https://learn.microsoft.com/en-us/windows/apps/design/accessibility/accessibility-testing.
[9] Contrast (Minimum) (Level AA). s. f. Accedido 30 de octubre de 2026. https://www.w3.org/WAI/WCAG22/Understanding/contrast-minimum.html.

### 1.2. Definir estándares y pautas de accesibilidad

## 1. Investigación y adopción de marcos globales (WCAG)


### 1.1. Marco principal 
El W3C recomienda utilizar la versión más reciente de WCAG, por ello utilizaremos como marco principal las Web Content Accessibility Guidelines (WCAG) 2.2, nivel AA, publicadas por el World Wide Web Consortium (W3C), como referencia de accesibilidad. Estas directrices proporcionan criterios verificables para mejorar la accesibilidad de los contenidos y las aplicaciones web, por lo que la utilizaremos siendo interpretada mediante Guidance on Applying WCAG 2 to Non-Web Information and Communications Technologies (WCAG2ICT) para su aplicación al software de escritorio. También se utilizará EN 301 549 como referencia técnica europea, especialmente su capítulo 11, dedicado a los requisitos de accesibilidad del software [1], [2], [6], [11].


### 1.2. Estándares de referencia
Se utilizarán los siguientes estándares y documentos como base del proyecto:

- **WCAG 2.2** [2]
Se utilizará como referencia para definir los criterios de accesibilidad relacionados con la percepción, la interacción, la comprensión y la compatibilidad.

- **WCAG2ICT** [6]
Se utilizará para interpretar los criterios WCAG en el contexto de una aplicación de escritorio, sin asumir que todas las condiciones propias de otros entornos son aplicables literalmente.

- **EN 301 549** [11]
Se consultará para establecer los requisitos técnicos europeos pertinentes para el software con interfaz de usuario, incluidas las características de accesibilidad y la interoperabilidad con tecnologías de asistencia.
La norma EN 301 549 V3.2.1 contempla requisitos específicos para software que no forma parte de una página ni está integrado en ella, recogidos en el capítulo 11.


#### 1.2.1. ¿Qué contiene WCAG 2?[1]
Las WCAG 2.2 tienen 13 directrices. Las directrices están organizadas bajo 4 principios, conocidos por las siglas POUR: 
- **Perceptible:** la información no puede ser invisible a todos los sentidos del usuario
- **Operable:** la interfaz no puede requerir interacciones que el usuario no pueda realizar
- **Comprensible:** la información y el manejo no pueden ir más allá del entendimiento del usuario
- **Robusto:** el contenido debe ser interpretado de forma fiable por una amplia variedad de aplicaciones de usuario, incluyendo tecnologías de asistencia  

Para cada directriz, existen criterios de éxito comprobables . Los criterios de éxito pueden ser de tres niveles: 
- A
- AA
- AAA


#### 1.2.2. WCAG 2.2 
Las WCAG 2.2 se publicaron el 5 de octubre de 2023 y una actualización se publicó el 12 de diciembre de 2024. Estas añaden 9 criterios de éxito, especificados en la [sección Novedades de WCAG 2.2](https://www.w3.org/WAI/standards-guidelines/wcag/new-in-22/) . Esta versión está diseñada para ser compatible con versiones anteriores, por lo que el contenido cumple con la WCAG de versiones anteriores [1].


#### 1.2.3. Nivel AA
Este es el estándar legal y comercial exigido en la mayoría de normativas internacionales (como la directiva europea EN 301 549) [1].


#### 1.2.4. WCAG2ICT
Tal y como nos advierte en la [Descripción general de WCAG2ICT](https://www.w3.org/WAI/standards-guidelines/wcag/non-web-ict/):
WCAG2ICT es una nota informativa del W3C, no es normativa ni establece requisitos. Proporciona orientación sobre la aplicación de los principios, directrices y criterios de éxito de WCAG 2 a documentos y software que no son web. WCAG2ICT se desarrolló para ofrecer una interpretación autorizada de cómo se puede aplicar WCAG 2 en diferentes contextos [7].


#### 1.2.5. ISO/IEC 40500, EAA, EN 301 549
WCAG 2.2 es una norma aprobada por la Organización Internacional de Normalización (ISO): ISO/IEC 40500:2025. Para cumplir con la Ley Europea de Accesibilidad (EAA), la mayoría de las organizaciones utilizan las WCAG y la norma europea EN 301 549: Requisitos de accesibilidad para productos y servicios de TIC. La cual utiliza las WCAG 2.2. [11].


### 1.3. Requisitos concretos de accesibilidad que se adoptarán
Los siguientes requisitos se utilizarán como criterios de diseño y validación, tomando como referencia los criterios de WCAG 2.2 que correspondan y su interpretación para software de escritorio [2], [6], [11].

- [ ] **Contraste visual:** el texto normal deberá alcanzar una relación de contraste mínima de 4,5:1 y el texto grande, de 3:1, salvo las excepciones contempladas en el estándar [2].
- [ ] **Uso del color:** ningún estado del inventario, aviso o error se comunicará únicamente mediante colores; se incorporarán etiquetas textuales u otras señales perceptibles [2], [11].
- [ ] **Acceso mediante teclado:** todas las funciones principales podrán utilizarse sin ratón y el foco tendrá un orden lógico y visible [2], [6].
- [ ] **Ampliación y legibilidad:** se permitirá aumentar el texto o se garantizará la compatibilidad con los mecanismos de ampliación de la plataforma sin perder información o funcionalidad, conforme a los requisitos aplicables [2], [11].
- [ ] **Nombres accesibles:** los botones, campos, opciones, tablas y demás controles tendrán nombres y estados identificables por las tecnologías de asistencia [6], [11].
- [ ] **Prevención y corrección de errores:** los formularios identificarán los datos incorrectos y proporcionarán instrucciones para corregirlos [2], [6].
- [ ] **Interacción accesible:** las acciones no dependerán exclusivamente de arrastrar elementos, de gestos complejos o de una precisión motora elevada cuando existan alternativas viables [2], [6].
- [ ] **Compatibilidad:** los componentes de la interfaz expondrán su función, nombre, estado y valor a través de los mecanismos de accesibilidad compatibles con la plataforma elegida [6], [11].


## 2. Declaración de pautas de diseño visual y de interacción (UI/UX)
Las pautas de diseño visual y de interacción se aplicarán a las ventanas, barras de herramientas, menús, tablas, formularios y cuadros de diálogo del SGA, con el objetivo de reducir los errores operativos y facilitar el uso de la aplicación por personas con distintas capacidades [6], [11].


### 2.1. Pautas de diseño visual
| Elemento | Norma de diseño | 
|---|---| 
| **Tipografía** [2], [11] | Utilizar fuentes legibles, tamaños adecuados y jerarquías claras de títulos, subtítulos y texto. | 
| **Contraste** [2], [11] | Mantener una relación mínima de 4,5:1 en texto normal y 3:1 en texto grande. | 
| **Colores** [2], [11] | No utilizar el color como único indicador de estado. Acompañar los estados con texto o iconos comprensibles. | 
| **Iconografía** [6], [11] | Utilizar iconos reconocibles y acompañarlos de etiquetas cuando su significado no sea evidente. | 
| **Distribución** [6], [11] | Separar los elementos relacionados y evitar interfaces sobrecargadas. | 
| **Configuración visual** [8], [11]  | Respetar las preferencias de contraste y garantizar que la interfaz funcione con distintos tamaños de pantalla y con ampliación del texto. | 
| **Foco** [2], [11] | Mostrar claramente qué botón, campo o enlace está seleccionado al navegar con teclado. | 

Las pautas sobre contraste y uso del color se fundamentan en los criterios de WCAG y en las recomendaciones de Microsoft para aplicaciones de escritorio que deben respetar las preferencias de visualización del sistema [2], [8].


### 2.2. Pautas de interacción
Se adoptarán las siguientes reglas para garantizar que las operaciones del SGA sean accesibles, coherentes y previsibles [2], [6], [11].

- **Navegación por teclado:** todas las acciones principales deben poder realizarse sin ratón, utilizando Tab, Mayús + Tab, Intro, Espacio y las teclas de dirección cuando corresponda. 
- **Orden de navegación:** el foco seguirá un orden coherente con la estructura visual y funcional de la pantalla.
- **Atajos de teclado:** las operaciones frecuentes podrán disponer de atajos, que deberán documentarse y no interferir con los comandos habituales de la plataforma. Tomaremos los [atajos de teclado de Windows](https://support.microsoft.com/es-es/accessibility/windows/keyboard-shortcuts-in-windows) como referencia [3].
- **Consistencia:** los botones, enlaces, menús y formularios mantendrán una apariencia y un comportamiento consistentes.
- **Áreas de interacción:** los objetivos de clic o toque cumplirán el mínimo de 24 × 24 píxeles CSS de WCAG 2.2 AA, salvo las excepciones contempladas en el estándar. Siempre que sea viable, se utilizarán áreas mayores.
- **Confirmación de acciones críticas:** antes de operaciones sensibles, como eliminar registros o confirmar determinados movimientos de inventario, se ofrecerá una confirmación o una posibilidad de revisión cuando corresponda.
- **Mensajes de estado:** las confirmaciones, alertas y errores se comunicarán mediante texto y, cuando proceda, de forma programáticamente detectable por tecnologías de asistencia.
- **Movimiento:** se evitarán animaciones innecesarias y se respetarán las preferencias del sistema para reducir el movimiento.
- **Autenticación accesible:** los mecanismos de inicio de sesión no dependerán de pruebas cognitivas innecesarias ni impedirán el uso de gestores de contraseñas y funciones de autocompletado.
- **Prevención de errores:** se distinguirán las acciones destructivas de las habituales y se facilitará la corrección de los datos antes de confirmar operaciones relevantes.

Estas pautas siguen los principios de operabilidad y comprensión de WCAG2ICT, junto con las recomendaciones técnicas sobre navegación por teclado y acceso programático a los controles de escritorio [2], [6], [11].


### 2.3. Aplicación a los componentes específicos del SGA [2], [6], [11]

**Tablas de inventario**
- Mantener el orden de lectura comprensible.
- Las tablas tendrán encabezados identificables y una estructura que permita comprender la relación entre cada producto y sus datos.
- Las columnas mostrarán nombres comprensibles, como «Código», «Descripción», «Unidades disponibles» y «Ubicación».
- Los estados del stock se identificarán con texto y no exclusivamente con colores.
- La selección de filas y la ejecución de acciones estarán disponibles mediante teclado.

**Formularios de productos y movimientos**
- Indicar los campos obligatorios antes del envío.
- Conservar los datos introducidos cuando se produzca un error.
- Cada campo dispondrá de una etiqueta que identifique el dato solicitado.
- Las instrucciones indicarán las unidades y el formato esperado.
- Los errores se relacionarán con el campo correspondiente y explicarán cómo solucionarlos.
- La confirmación de la operación indicará el resultado del movimiento registrado

**Estados de pedidos y stock**
- Diferenciar los avisos importantes de la información secundaria.
- Comunicar los cambios de estado de forma accesible.
- Los estados del pedido se presentarán con etiquetas textuales claras, no solo colores.
- Las operaciones críticas permitirán revisar los datos antes de confirmarse.
- Las acciones estarán disponibles mediante controles que puedan manejarse con teclado.


### 2.4. Pautas específicas para las distintas discapacidades
Las siguientes medidas para el SGA traducen los principios de accesibilidad a decisiones concretas de diseño de una aplicación de escritorio [2], [6], [8], [11].

- **Visual:** 
Contraste suficiente, ampliación de texto, foco visible, nombres accesibles y compatibilidad con lectores de pantalla.
- **Auditiva:** 
No utilizar señales sonoras como único medio para comunicar alertas o cambios de estado. Ofrecer mensajes visuales y textuales equivalentes.
- **Motora:** 
Permitir la navegación mediante teclado, evitar operaciones que requieran precisión excesiva y ofrecer alternativas a las acciones de arrastrar.
- **Cognitiva:** 
Utilizar instrucciones claras, mantener una organización consistente, prevenir errores y comunicar cómo corregirlos.

Estas medidas constituyen requisitos de diseño para el proyecto, su cumplimiento deberá verificarse mediante pruebas sobre la aplicación implementada y las tecnologías de asistencia compatibles [6], [11].


## 3. Investigación y adopción de estándares de desarrollo y código
El término front-end se entenderá como la capa de presentación e interacción de la aplicación de escritorio: ventanas, controles, componentes visuales, navegación y comunicación con las tecnologías de asistencia de la plataforma [6], [11].


### 3.1. Estándares técnicos de implementación
Se adoptarán las siguientes reglas de desarrollo, teniendo en cuenta que la implementación concreta dependerá de la tecnología de escritorio elegida por el equipo [6], [9], [11].

1. Controles nativos y semántica. Se priorizarán los controles estándar de Windows cuando cumpla con las necesidades funcionales, ya que inventar o diseñar elementos gráficos totalmente nuevos pueden requerir trabajo adicional para exponer correctamente sus propiedades de accesibilidad [9].

2. Nombres accesibles. Cada botón, campo, casilla, opción y control interactivo tendrá un nombre accesible que describa su finalidad. Se evitarán nombres vacíos, ambiguos o formados únicamente por códigos internos [6], [9], [11].

3. Propiedades de accesibilidad. Los componentes expondrán, cuando corresponda, su nombre, rol o tipo, estado, valor, selección y posibilidad de interacción a través de los mecanismos de accesibilidad de la plataforma [6], [9], [11].

4. Gestión del foco. El código garantizará que el foco pueda desplazarse mediante teclado, que no quede atrapado accidentalmente en un componente y que se gestione correctamente al abrir y cerrar ventanas o diálogos [2], [6].

5. Controles personalizados. Si se desarrollan tablas, selectores, botones u otros controles propios, se implementarán las interfaces o proveedores de accesibilidad que requiera la tecnología utilizada [9].

6. Formularios y validación. Los campos tendrán etiquetas, indicaciones de obligatoriedad, restricciones de entrada y mensajes de error accesibles. Los errores no se comunicarán únicamente mediante cambios de color [2], [6], [11].

7. Estados dinámicos. Las actualizaciones del stock, los cambios de pedido y las confirmaciones se expondrán a las tecnologías de asistencia mediante los mecanismos adecuados de la plataforma [6], [9], [11].

8. Preferencias de visualización. La interfaz evitará imponer colores que anulen las preferencias de contraste del sistema y se comprobará su comportamiento con los ajustes de visualización que corresponda [8], [11].


### 3.2. Herramientas de pruebas para Windows
Estas son recomendaciones de herramientas específicas para comprobar que la aplicación cumple los requisitos de accesibilidad [10], [12].

- **Accessibility Insights for Windows [12]:** 
Inspeccionar los elementos de la interfaz y detectar problemas frecuentes de accesibilidad.
- **Inspect (Windows SDK) [10]:** 
Consultar las propiedades, los nombres y los patrones de control expuestos mediante UI Automation.
- **Narrador de Windows [10]:** 
Comprobar que los controles, las tablas y los mensajes se leen correctamente.
- **UI Accessibility Checker (AccChecker) [10]:**
Verificar requisitos de accesibilidad y detectar errores en la implementación.
- **UIA Verify [10]:**
Realizar pruebas manuales y automatizadas de la implementación de UI Automation.


## 4. Investigación y desarrollo de pautas de contenido y redacción (Copywriting)
Los textos del SGA deben facilitar que los usuarios comprendan qué está sucediendo, qué acciones pueden realizar y cómo solucionar posibles errores. Se utilizará un lenguaje claro, directo y consistente, siguiendo las recomendaciones del W3C sobre accesibilidad cognitiva y las pautas de diseño de contenido orientadas a las necesidades de los usuarios [4], [5].


### 4.1. Reglas de redacción accesible [5]
| Aspecto	| Regla que se adoptará | Ejemplo | 
|---|---|---|
| **Claridad** | Usar frases cortas y vocabulario habitual | «Añadir producto» en lugar de «Proceder a la incorporación de una nueva referencia» | 
| **Consistencia** | Utilizar siempre el mismo término para una misma acción.	| Usar «Registrar entrada» en todas las pantallas correspondientes. | 
| **Botones** | Explicar la acción que se realizará | «Guardar cambios» en lugar de «Aceptar» | 
| **Errores** | Indicar qué ha ocurrido y cómo corregirlo | «Introduce una cantidad mayor que cero» | 
| **Confirmaciones** | Comunicar el resultado de la operación | «Entrada registrada correctamente» | 
| **Enlaces** | Utilizar textos descriptivos | «Consultar inventario» en lugar de «Haz clic aquí» | 
| **Instrucciones** | Se utilizarán frases directas y se indicará el formato esperado. | «Introduce el código del producto que aparece en su etiqueta» | 
| **Información técnica** | Explicar los términos especializados cuando sea necesario | «Stock disponible: unidades que pueden utilizarse o prepararse para un pedido» | 
| **Mensajes críticos** | Se describirán las consecuencias de las operaciones importantes. | «Vas a eliminar el producto P-104. Revisa la información antes de continuar». | 
| **Abreviaturas** | Se evitarán las abreviaturas poco conocidas o se explicarán la primera vez que aparezcan. | Explicar «SKU» como «código identificador del producto» si se utiliza en la aplicación. | 

Estas reglas se adoptan como convenciones editoriales del proyecto, basadas en las pautas de comprensión y prevención de errores de WCAG y en las recomendaciones de W3C para personas con discapacidades cognitivas y de aprendizaje [2], [4], [6].


### 4.2. Pautas de accesibilidad cognitiva
Se adoptarán las siguientes reglas para mejorar la comprensión y reducir la carga cognitiva durante el uso del SGA [4], [6]:

- Utilizar títulos descriptivos que permitan identificar la finalidad de cada ventana.
- Organizar las operaciones complejas en pasos claros y consecutivos.
- Evitar las dobles negaciones, las frases ambiguas y los mensajes que no indiquen cómo actuar.
- Mantener los nombres de los controles y la ubicación de las funciones consistentes.
- Mostrar las unidades de medida y los formatos esperados en los campos correspondientes.
- Facilitar la revisión de los datos antes de ejecutar operaciones importantes.
- Conservar los datos válidos cuando se produzca un error de formulario, siempre que sea técnicamente viable.
- Evitar que la comprensión de una alerta dependa de conocimientos especializados que no se hayan explicado previamente.

Estas pautas constituyen criterios de redacción y diseño que deberán revisarse mediante pruebas de comprensión y tareas representativas de la gestión del almacén [4], [6].


## 5. Lista de comprobación final
La siguiente lista servirá para revisar el cumplimiento de la tarea durante el diseño y el desarrollo del SGA.

**Estándares WCAG**
- [ ] Se ha definido WCAG 2.2 AA como objetivo de accesibilidad.
- [ ] Se han identificado los criterios WCAG2ICT aplicables al SGA.
- [ ] Se han revisado los requisitos normativos que puedan resultar aplicables.

**Diseño visual e interacción**
- [ ] Se han establecido reglas de contraste, color, tipografía y foco visible.
- [ ] Se ha definido la navegación por teclado y el orden de interacción.
- [ ] Se han especificado las pautas para tablas, formularios y operaciones críticas.
- [ ] Se han definido medidas para discapacidades visuales, auditivas, motoras y cognitivas.

**Estándares de desarrollo y código**
- [ ] Se han definido los requisitos de nombres y propiedades accesibles.
- [ ] Se han establecido pautas de foco, teclado y controles personalizados.
- [ ] Se han identificado los mecanismos de accesibilidad de la plataforma de escritorio.
- [ ] Se han definido herramientas y procedimientos de prueba.

**Contenido y redacción**
- [ ] Se han definido reglas para botones, errores, confirmaciones e instrucciones.
- [ ] Se ha establecido una terminología consistente para el SGA.
- [ ] Se han creado ejemplos de mensajes accesibles.
- [ ] Se han establecido criterios de revisión de comprensión y claridad.


## 6. Referencias
[1] W. W. A. Initiative (WAI), «WCAG 2 Overview», Web Accessibility Initiative (WAI). Accedido: 27 de octubre de 2026. [En línea]. Disponible en: https://www.w3.org/WAI/standards-guidelines/wcag/
[2] «Web Content Accessibility Guidelines (WCAG) 2.2». Accedido: 27 de octubre de 2026. [En línea]. Disponible en: https://www.w3.org/TR/WCAG22/
[3] «Métodos abreviados de teclado de Windows | Microsoft Support». Accedido: 27 de octubre de 2026. [En línea]. Disponible en: https://support.microsoft.com/es-es/accessibility/windows/keyboard-shortcuts-in-windows
[4] «Making Content Usable for People with Cognitive and Learning Disabilities». Accedido: 27 de octubre de 2026. [En línea]. Disponible en: https://www.w3.org/TR/coga-usable/
[5] «Understand content design». Accedido: 27 de octubre de 2026. [En línea]. Disponible en: https://guidance.publishing.service.gov.uk/writing-to-gov-uk-standards/plan-manage-content/understand-content-design/
[6] «Guidance on Applying WCAG 2 to Non-Web Information and Communications Technologies (WCAG2ICT)». Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://www.w3.org/TR/wcag2ict-22/
[7] W. W. A. Initiative (WAI), «WCAG2ICT Overview», Web Accessibility Initiative (WAI). Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://www.w3.org/WAI/standards-guidelines/wcag/non-web-ict/
[8] GrantMeStrength, «Accessibility Best Practices - Win32 apps». Accedido: 29 de octubre de 2026. [En línea]. Disponible en: https://learn.microsoft.com/en-us/windows/win32/winauto/accessibility-best-practices
[9] GrantMeStrength, «UI Automation - Win32 apps». Accedido: 29 de octubre de 2026. [En línea]. Disponible en: https://learn.microsoft.com/en-us/windows/win32/winauto/entry-uiauto-win32
[10] GrantMeStrength, «Accessibility testing - Windows apps». Accedido: 29 de octubre de 2026. [En línea]. Disponible en: https://learn.microsoft.com/en-us/windows/apps/design/accessibility/accessibility-testing
[11] «EN 301 549 - V3.2.1 - Accessibility requirements for ICT products and services». s. f. Accedido 29 de octubre de 2026. https://www.etsi.org/deliver/etsi_en/301500_301599/301549/03.02.01_20/en_301549v030201a.pdf.
[12] «Accessibility Insights». Accedido: 29 de octubre de 2026. [En línea]. Disponible en: https://accessibilityinsights.io/

### 1.3. Seleccionar métricas y herramientas de auditoría

## 1. Selección de las métricas
Las métricas de calidad deben seleccionarse en función de los objetivos del producto, su contexto de uso y los riesgos que se pretende detectar, no basta con recopilar un gran número de indicadores, sino que es necesario priorizar los que aporten información útil para la toma de decisiones [2]. Para este SGA se proponen cuatro dimensiones de evaluación: calidad del software, rendimiento, usabilidad y accesibilidad [1], [2], [3], [4].


### 1.1. Métricas de calidad del software [2], [3]
La calidad del software puede evaluarse mediante indicadores relacionados con los defectos, la cobertura de pruebas, la complejidad del código, la estabilidad y el cumplimiento de los requisitos funcionales. En un SGA de escritorio, estas métricas son especialmente relevantes porque los errores en operaciones de inventario pueden producir diferencias entre las existencias registradas y las reales. Para ello, hemos seleccionado los siguientes Key Performance Indicator (KPI), indicando el método de cálculo/medición y la aplicación que tiene en el SGA:

 | KPI seleccionado | Método de cálculo o medición | Aplicación al SGA | 
 |---|---|---| 
 | 1. Disponibilidad del sistema | ((Tiempo total - Tiempo de inactividad) / Tiempo total) x 100 | Medir el porcentaje de tiempo durante el que el SGA está operativo. Permite comprobar si los operarios pueden consultar existencias, registrar entradas y preparar pedidos durante la jornada. | 
 | 2. Tiempo de respuesta | Calcular el tiempo transcurrido entre una petición y la respuesta del sistema. Registrar la media y el [percentil 95 (P95)](#4-Glosario). | Evaluar cuánto tarda el SGA en mostrar el stock de un artículo, localizar una ubicación, etc. | 
 | 3.Tasa de errores | (Solicitudes fallidas / Solicitudes totales) x 100 | Detectar fallos en consultas de inventario, confirmaciones de movimientos, generación de etiquetas o integración con otros sistemas. | 
 | 4. Uso de CPU | (Tiempo de CPU utilizado / Tiempo de CPU disponible) x 100 | Identificar sobrecargas del servidor cuando varios operarios realizan movimientos de stock o preparan pedidos simultáneamente. | 
 | 5. Consumo de memoria | (Memoria utilizada / Memoria disponible) x 100 | Detectar un consumo excesivo de memoria que pueda provocar lentitud, bloqueos o interrupciones del SGA. | 
 | 6. Tasa de solicitudes | Número de solicitudes recibidas / Intervalo de tiempo | Medir las operaciones que procesa el SGA por segundo o minuto y comprobar si soporta los picos de actividad de recepción y expedición. | 
 | 7. Cobertura de pruebas | (Elementos de código ejecutados por pruebas / Elementos de código totales) x 100 | Comprobar qué proporción del código está cubierta por pruebas automatizadas, especialmente en los módulos de inventario, reservas de stock y preparación de pedidos. | 
 | 8. Densidad de defectos| (Solicitudes fallidas / Solicitudes totales) x 100 | Identificar módulos del SGA que concentran más errores y priorizar su revisión. Se deben comparar módulos de tamaño y complejidad similares. | 
 | 9. Tasa de fallos en producción | Incidentes atribuibles al software en producción / Periodo de observación | Cuantificar los fallos que afectan al almacén una vez implantada una versión: errores al descontar existencias, pedidos duplicados o movimientos no registrados. | 
 | 10. Ratio de defectos abiertos y cerrados | (Defectos cerrados / Defectos abiertos al inicio) x 100 | Controlar si el equipo de mantenimiento está resolviendo las incidencias del SGA al ritmo necesario y si se acumulan errores pendientes. | 
 | 11. Complejidad ciclomática | Contar los caminos lógicos independientes de un bloque de código mediante análisis estático (sin ejecutar). | Detectar funciones demasiado complejas, por ejemplo, las que calculan rutas de preparación, reglas de reposición o asignación de ubicaciones, y que resultan difíciles de probar y mantener. | 
 | 12. Tiempo de resolución de incidencias | Sumatorio del tiempo desde la apertura hasta el cierre / Incidencias cerradas | Medir cuánto tarda el equipo técnico en resolver problemas que afectan a la operativa del almacén y establecer prioridades según su impacto. | 
 | 13. Satisfacción del usuario [(CSAT)](#4-Glosario) | (Respuestas satisfechas / Respuestas válidas) x 100 | Evaluar la percepción de los operarios y supervisores sobre la facilidad de uso, la claridad de los mensajes y la rapidez del SGA. | 
 | 14. [Índice Apdex](#4-Glosario) | (Usuarios satisfechos + ([Usuarios tolerantes](#4-Glosario) / 2)) / Total muestras | Valorar si los tiempos de respuesta de las operaciones habituales del SGA ofrecen una experiencia aceptable. Los umbrales de satisfacción y tolerancia deben definirse previamente. | 
 | 15. Tasa de adopción de funcionalidades | (Usuarios objetivo que utilizan una funcionalidad / Usuarios objetivo) x 100 | Comprobar si se utilizan funciones. | 

La tasa de pruebas funcionales superadas y la tasa de errores críticos permitirán evaluar el cumplimiento de los requisitos del SGA. La densidad de defectos y la cobertura de pruebas aportarán información sobre la calidad técnica, mientras que los defectos reabiertos ayudarán a valorar la efectividad de las correcciones.


#### 1.1.1. Cómo interpretar los resultados [2], [3]
Los valores objetivo deben ajustarse a las necesidades reales del almacén. Como ejemplo inicial de objetivos internos, se podrían establecer los siguientes:
- **Disponibilidad:** al menos el 99,5% mensual.
- **Tiempo de respuesta P95:** inferior a 2 segundos para operaciones habituales.
- **Tasa de errores:** inferior al 1% de las solicitudes.
- **Cobertura de pruebas:** al menos el 80% del código, priorizando las funcionalidades críticas.
- **Tasa de fallos en producción:** tendencia descendente tras cada versión.
- **Satisfacción del usuario:** al menos el 80% de respuestas satisfactorias.

Estos valores son objetivos orientativos iniciales propuestos para el SGA, no umbrales establecidos obligatorios. Deben validarse mediante pruebas de carga, análisis de riesgos y necesidades operativas.


### 1.2. Métricas de rendimiento [1], [3]
El rendimiento de una aplicación puede evaluarse mediante el tiempo de respuesta, el consumo de CPU y memoria, la disponibilidad, la tasa de errores y la capacidad de procesar operaciones bajo distintas cargas de trabajo. En una aplicación de escritorio SGA, estas métricas deben medirse durante la ejecución del programa y al realizar operaciones representativas con datos de prueba.

 | KPI seleccionado | Método de cálculo o medición | Aplicación al SGA | 
 |---|---|---| 
 | 1. Uso de CPU | (Tiempo de CPU utilizado / Tiempo de CPU disponible) x 100 | Detectar sobrecargas cuando numerosos operarios consultan el inventario o procesan pedidos simultáneamente. | 
 | 2. Uso de memoria RAM | (Memoria RAM utilizada / Memoria RAM disponible) x 100 | Identificar si el SGA consume demasiada memoria al cargar grandes inventarios, generar informes o mantener numerosas sesiones abiertas. | 
 | 3. Disponibilidad del sistema (uptime) | (Tiempo operativo / Tiempo total del periodo) x 100 | Verificar que el SGA está accesible durante las horas de actividad del almacén y detectar interrupciones que paralicen las operaciones. | 
 | 4. Latencia | Tiempo transcurrido entre el envío de una petición y el inicio de su respuesta, medido en milisegundos. | Medir el retraso de comunicación entre los terminales de radiofrecuencia, los dispositivos móviles y el servidor del SGA. | 
 | 5. Tiempo medio de respuesta | Sumatorio de los tiempo de respuesta / Número de solicitudes respondidas | Comprobar cuánto tarda el sistema en consultar un artículo, confirmar una recepción o registrar un movimiento de inventario. | 
 | 6. Percentil 95 del tiempo de respuesta (P95) | Ordenar los tiempos de respuesta y obtener el valor por debajo del cual se encuentra el 95% de las observaciones. | Detectar lentitud que afecta a una parte de los operarios aunque el tiempo medio de respuesta sea bajo. Es útil en periodos de máxima actividad. | 
 | 7. Tasa de solicitudes | Número de solicitudes recibidas / Tiempo transcurrido | Medir la carga de trabajo que recibe el SGA y comprobar si soporta los picos de consultas, movimientos de stock y preparación de pedidos. | 
 | 8. Volumen de datos por solicitud | Bytes procesados / Número de solicitudes | Detectar consultas de inventario o informes que transfieren demasiados datos y ralentizan la aplicación o la red del almacén. | 
 | 9. Tasa de errores | (Solicitudes fallidas / Solicitudes totales) x 100 | Identificar errores al registrar entradas, confirmar pedidos, consultar existencias o comunicarse con el ERP. | 
 | 10. Índice de satisfacción Apdex | (Usuarios satisfechos + (Usuarios tolerantes / 2)) / Total muestras | Evaluar si los tiempos de respuesta del SGA resultan aceptables para los operarios, utilizando umbrales definidos para cada operación. | 
 | 11. Rendimiento de la recolección de basura (Garbage Collection) | Medir el porcentaje de tiempo dedicado a la recolección de basura, la duración de las pausas y su frecuencia mediante las herramientas de monitorización del entorno de ejecución. | Detectar pausas o consumo excesivo de CPU que provoquen bloqueos temporales en aplicaciones SGA desarrolladas sobre entornos con gestión automática de memoria, como en el caso de Java | 
 | 12. Número de usuarios concurrentes | Contar las sesiones activas simultáneamente durante un intervalo y relacionarlas con los tiempos de respuesta y la tasa de errores. | Verificar que el SGA puede atender a los operarios de recepción, inventario, preparación, etc, sin degradar su rendimiento. | 

El tiempo de respuesta, el consumo de CPU y el consumo de memoria permiten identificar problemas de eficiencia. El p95 complementa el promedio, ya que muestra el comportamiento de las operaciones más lentas, mientras que la tasa de errores permite relacionar el rendimiento con la estabilidad de la aplicación. Se recomienda registrar tanto la mediana como el p95 de los tiempos de respuesta, además de repetir cada operación varias veces.


#### 1.2.1. Cómo interpretar los resultados [1], [3]
Los objetivos cuantitativos deberán establecerse según las necesidades del almacén. Como punto de partida, se podría fijar los siguientes objetivos:
- **Disponibilidad:** al menos el 99,5%.
- **Tiempo de respuesta P95:** inferior a 2 segundos para operaciones habituales.
- **Tasa de errores:** inferior al 1%.

Estos valores son objetivos orientativos iniciales propuestos para el SGA, no umbrales establecidos obligatorios. Deben validarse mediante pruebas de carga, análisis de riesgos y necesidades operativas.


### 1.3. Métricas de usabilidad [2], [5]
La usabilidad se evalúa teniendo en cuenta la eficacia con la que los usuarios alcanzan sus objetivos, la eficiencia con la que realizan las tareas y su satisfacción durante el uso del producto, de acuerdo con el marco conceptual de ISO 9241-11:2018. En un SGA de escritorio, la evaluación debe centrarse en tareas habituales de los operarios y responsables de almacén, como localizar un producto, registrar una entrada, consultar existencias o preparar un pedido.

 | KPI seleccionado | Método de cálculo o medición | Aplicación al SGA | 
 |---|---|---| 
 | 1. Tasa de éxito de las tareas | (Tareas completadas correctamente / Total de tareas intentadas) x 100 | Medir el porcentaje de operarios que completan correctamente tareas como registrar una recepción, localizar una mercancía o preparar un pedido. | 
 | 2. Tiempo medio de realización de tareas | Sumatorio del tiempo empleado en cada tarea / Número de tareas completadas | Medir cuánto tarda un operario en registrar una entrada, realizar un inventario o confirmar una expedición. Un menor tiempo puede indicar mayor eficiencia si se mantiene la precisión. | 
 | 3. Tasa de errores del usuario | (Errores cometidos durante las tareas / Total de tareas realizadas) x 100 | Detectar dificultades en formularios, selección de ubicaciones, introducción de cantidades o lectura de códigos de barras. Se debe definir qué se considera un error. | 
 | 4. Tasa de tareas completadas sin ayuda | (Tareas completadas sin asistencia / Total de tareas intentadas) x 100 | Comprobar si los operarios pueden utilizar el SGA sin recurrir continuamente a supervisores, compañeros o soporte técnico. | 
 | 5. Satisfacción del usuario (CSAT) | (Respuestas clasificadas como satisfactorias / Total de respuestas válidas) x 100 | Conocer la valoración de los operarios sobre la facilidad de uso, la claridad de las pantallas y la utilidad de las funciones del SGA mediante encuestas. | 
 | 6. Tasa de adopción de funcionalidades | (Usuarios objetivo que utilizan una funcionalidad / Total de usuarios objetivo) x 100 | Comprobar si se utilizan todas las funcionalidades. | 
 | 7. Número de errores por tarea | Total de errores registrados / Número de tareas observadas | Identificar qué procesos generan más dificultades y priorizar mejoras en los flujos de recepción, almacenamiento, preparación, etc. | 
 | 8. Tasa de abandono de tareas | (Tareas iniciadas y no completadas / Total de tareas iniciadas) x 100 | Detectar procesos que los usuarios dejan sin terminar, por ejemplo, por formularios confusos, instrucciones poco claras o demasiados pasos. | 
 | 9. Eficiencia temporal | (Tiempo de referencia para una tarea / Tiempo real empleado) x 100 | Comparar el tiempo real de una operación con un tiempo de referencia definido para valorar la eficiencia del proceso. El tiempo de referencia debe establecerse con datos realistas. | 
 | 10. Facilidad de aprendizaje | Medir el tiempo o el número de intentos que necesita un usuario nuevo para alcanzar un nivel de ejecución previamente definido. | Evaluar si los nuevos operarios aprenden rápidamente a utilizar terminales, registrar movimientos y pedidos sin cometer errores frecuentes. | 
 | 11. Tasa de uso correcto a la primera | (Tareas completadas correctamente en el primer intento / Total de tareas intentadas) x 100 | Comprobar si las pantallas, instrucciones y validaciones permiten registrar correctamente mercancías y movimientos sin tener que repetir operaciones. | 
 | 12. Valoración de la facilidad de uso | Encuesta estructurada, por ejemplo, mediante una escala de 1 a 5 o un cuestionario estandarizado como el System Usability Scale (SUS). | Obtener una valoración global de la facilidad de uso del SGA e identificar aspectos de la interfaz que requieren mejoras. | 

Estas métricas permiten identificar si la interfaz facilita el trabajo, qué operaciones provocan dificultades y qué elementos necesitan rediseño. Para obtener resultados comparables, se recomienda preparar un conjunto fijo de tareas, utilizar participantes representativos de los perfiles previstos y registrar tanto los resultados como las dificultades observadas.

La satisfacción puede medirse mediante una escala de valoración de 1 a 5, donde 1 representa una valoración muy negativa y 5 una valoración muy positiva, esta escala sería una decisión metodológica del proyecto, no un requisito específico de ISO 9241-11.


#### 1.3.1. Cómo interpretar los resultados [2], [5]
Los resultados deben analizarse en función de las tres dimensiones de usabilidad establecidas por la ISO 9241-11:2018.

- **Eficacia:** Una tasa de éxito elevada y pocos errores indican que los usuarios alcanzan sus objetivos correctamente. Si el 97% de las recepciones se registra correctamente, el proceso presenta una eficacia elevada.
- **Eficiencia:** Un menor tiempo de ejecución puede indicar una mayor eficiencia, siempre que se mantenga la precisión y se consideren los recursos empleados. Si un operario prepara pedidos más rápido sin aumentar los errores, el proceso ha mejorado.
- **Satisfacción:** Una valoración alta en las encuestas indica que los usuarios perciben favorablemente la experiencia de uso. Si los operarios consideran claras las pantallas y sencillos los procedimientos, la percepción de usabilidad es positiva.

Estos valores son objetivos orientativos iniciales propuestos para el SGA, no umbrales establecidos obligatorios.


### 1.4. Métricas de accesibilidad [6], [7]
La accesibilidad de una aplicación de escritorio implica que las personas puedan identificar, comprender y utilizar los controles de la interfaz mediante los mecanismos de interacción disponibles, incluidos el teclado y las tecnologías de asistencia. En aplicaciones de Windows, Microsoft recomienda comprobar tanto el acceso a los elementos de la interfaz como la navegación mediante teclado y el funcionamiento con tecnologías de asistencia.

 | KPI seleccionado | Método de cálculo o medición | Aplicación al SGA | 
 |---|---|---| 
 | 1. Tasa de cumplimiento de accesibilidad | (Criterios de accesibilidad superados / Total de criterios evaluados) x 100 | Medir el grado de cumplimiento de una lista de requisitos de accesibilidad en las pantallas de recepción, inventario, preparación y expedición. | 
 | 2. Tasa de navegación completa mediante teclado | (Elementos interactivos accesibles mediante teclado / Total de elementos interactivos evaluados) x 100 | Comprobar que se pueden recorrer los formularios, tablas, botones y menús del SGA con los atajos correspondientes. | 
 | 3. Tasa de controles con nombre accesible | (Controles con nombre accesible correcto / Total de controles evaluados) x 100 | Verificar que los campos, botones e iconos tienen nombres comprensibles para que un lector de pantalla pueda identificarlos. | 
 | 4. Tasa de tareas completadas con lector de pantalla | (Tareas completadas correctamente con lector de pantalla / Total de tareas evaluadas) x 100 | Comprobar si una persona puede consultar el stock, registrar una recepción o preparar un pedido utilizando un lector de pantalla como Narrador. | 
 | 5. Tasa de contraste visual adecuado | (Elementos de texto que cumplen el contraste requerido / Total de elementos de texto evaluados) x 100 | Verificar la legibilidad de cantidades, ubicaciones, alertas de stock y mensajes de error. Los umbrales deben definirse según el estándar de accesibilidad aplicable. | 
 | 6. Tasa de errores críticos de accesibilidad | (Controles con errores críticos / Controles evaluados) x 100 | Detectar obstáculos que impidan a los operarios completar procesos esenciales, como confirmar una entrada o consultar una ubicación. | 
 | 7. Tasa de compatibilidad con alto contraste y escalado | (Escenarios de visualización superados / Total de escenarios evaluados) x 100 | Comprobar que las pantallas del SGA siguen siendo legibles al utilizar temas de alto contraste o aumentar el tamaño de visualización del sistema. | 
 | 8. Tasa de elementos correctamente expuestos a tecnologías de asistencia | (Elementos expuestos correctamente mediante la interfaz de accesibilidad / Total de elementos evaluados) x 100 | Verificar que los controles personalizados, las tablas y los elementos interactivos transmiten correctamente su nombre, función, estado y estructura a las tecnologías de asistencia. | 
 | 9. Tasa de eventos de accesibilidad correctos | (Eventos de accesibilidad emitidos correctamente / Total de eventos evaluados) x 100 | Comprobar que el foco, la selección y los cambios de estado se notifican correctamente cuando se actualizan cantidades, se confirma un movimiento o se muestra una alerta. | 
 | 10. Tasa de regresiones de accesibilidad | (Pruebas de accesibilidad que antes pasaban y ahora fallan / Total de pruebas de accesibilidad ejecutas) x 100 | Detectar si una actualización del SGA introduce problemas nuevos en la navegación, los controles o la compatibilidad con lectores de pantalla. | 

Estas métricas permiten comprobar si los elementos de la interfaz exponen correctamente su información accesible y si las operaciones del SGA pueden realizarse mediante distintas formas de interacción. Las comprobaciones automáticas deben complementarse con pruebas manuales, ya que una herramienta de inspección no demuestra por sí sola que todas las tareas sean accesibles en condiciones reales de uso.

Para el proyecto, se propone como objetivo que todas las operaciones críticas puedan completarse mediante teclado y que no existan incidencias de accesibilidad críticas pendientes antes de la entrega. Ambos criterios son objetivos de aceptación propuestos, no porcentajes normativos universales.


#### 1.4.1. Cómo interpretar los resultados [6], [7]
Como punto de partida, se proponen los siguientes objetivos orientativos para el SGA. Estos valores son una referencia inicial para evaluar la accesibilidad y deberán ajustarse según las necesidades de los usuarios y los requisitos aplicables.

- **Tasa de cumplimiento de accesibilidad:** Como mínimo el 95% de los criterios evaluados superados.
- **Tasa de navegación completa mediante teclado:** 100% de los elementos interactivos accesibles mediante teclado.
- **Tasa de controles con nombre accesible:** 100% de los controles evaluados correctamente identificados.
- **Tasa de tareas completadas con lector de pantalla:** Como mínimo 95% de las tareas completadas correctamente.
- **Tasa de contraste visual adecuado:** 100% de los elementos de texto evaluados cumplen los requisitos de contraste aplicables.
- **Tasa de errores críticos de accesibilidad:** Sin errores críticos pendientes.
- **Tasa de compatibilidad con alto contraste y escalado:** 100% de los escenarios de visualización evaluados superados.
- **Tasa de elementos correctamente expuestos a tecnologías de asistencia:** 100% de los elementos esenciales evaluados correctamente expuestos.
- **Tasa de eventos de accesibilidad correctos:** 100% de los eventos críticos evaluados emitidos correctamente.
- **Tasa de regresiones de accesibilidad:** Sin regresiones críticas en cada nueva versión.

Estos objetivos son propuestas iniciales de gestión para el SGA, no valores numéricos exigidos por Microsoft Learn. Se recomienda dar prioridad a la ausencia de errores críticos y garantizar la accesibilidad de las operaciones esenciales.


## 2. Selección de herramientas
Para evitar duplicidades y facilitar la realización de la tarea, se propone utilizar las siguientes herramientas como conjunto principal de auditoría del SGA de escritorio [2], [6], [8], [9].

 | Dimensión | Herramienta elegida | Motivo de selección | 
 |---|---|---| 
 | Calidad | Apache NetBeans | Ejecutar pruebas funcionales y medir cobertura de código [8], [12], [13]. | 
 | Calidad complementaria | SonarQube | Examinar posibles defectos y problemas de mantenibilidad del código compatible [3]. | 
 | Rendimiento | Administrador de tareas de Windows | Medir el consumo de CPU y memoria del proceso [9], [10]. | 
 | Rendimiento complementario | PerfMon | Registrar la evolución de los recursos durante pruebas prolongadas [10], [11]. | 
 | Usabilidad | Hoja de cálculo | Registrar tiempos, errores, éxito de tareas y satisfacción [5].
 | Accesibilidad | Accessibility Insights for Windows | Inspeccionar los controles y detectar problemas de accesibilidad [6]. | 
 | Accesibilidad complementaria | NonVisual Desktop Access (NVDA) | Comprobar manualmente la información anunciada por un lector de pantalla. | 


## 3. Procedimiento propuesto para la auditoría
La auditoría se organizará en cinco fases para obtener resultados repetibles y permitir la comparación entre versiones de la aplicación [2], [5], [6].

- **Fase 1: Preparar los casos de prueba**
Definir operaciones representativas del SGA, estableciendo previamente qué resultado se considera correcto [2], [5].

- **Fase 2: Evaluar la calidad funcional**
Ejecutar las pruebas definidas, registrar las que pasan y fallan y analizar la cobertura del código y los defectos detectados [2], [8].

- **Fase 3: Medir el rendimiento**
Registrar el tiempo de respuesta de las operaciones y el consumo de CPU y memoria con una configuración controlada, repitiendo las pruebas para obtener resultados comparables [1], [3], [10], [11].

- **Fase 4: Evaluar la usabilidad y accesibilidad**
Realizar pruebas con usuarios representativos, medir el éxito y la duración de las tareas, inspeccionar los controles y comprobar la navegación por teclado y el uso del lector de pantalla [5], [6], [7].

- **Fase 5: Elaborar el informe**
Consolidar los resultados, comparar cada indicador con los objetivos de aceptación acordados, priorizar las incidencias por gravedad y repetir las pruebas después de aplicar las correcciones [2], [6].


## 4. Glosario:
1. **Percentil 95 (P95)** es una medida estadística que indica que el 95% de los datos o valores se encuentran por debajo de esa cifra, por lo que solo el 5% lo supera.
2. **CSAT**, por sus siglas Customer Satisfaction Score, es una métrica que mide qué tan satisfecho está u cliente con un producto, servicio o interacción.
3.  **Índice Apdex**, viene de Application Performance Index, y es un estándar abierto que mide y cuantifica la satisfacción del usuario final con el rendimiento de un servicio digital
4. **Usuarios tolerantes** se refiere a aquellos con alta paciencia frente a errores del sistema y comprenden que el software está en construcción, estando dispuestos a probar el producto aunque tenga fallos.


## 5. Referencias
[1] «7 importantes métricas de monitorización de la experiencia digital». Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://contentsquare.com/es-es/guias/monitorizacion-experiencia-digital/metricas/
[2] «Métricas clave para el monitoreo del rendimiento de aplicaciones», ManageEngine Blog. Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://www.manageengine.com/latam/blog/general/metricas-clave-monitoreo-rendimiento-de-aplicaciones.html
[3] «Métricas de calidad de software Abstracta | Abstracta». Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://abstracta.us/es/blog/metricas-de-calidad-de-software
[4] «10 métricas de rendimiento de aplicaciones y cómo medirlas | Computer Weekly», ComputerWeekly.es. Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://www.computerweekly.com/es/consejo/10-metricas-de-rendimiento-de-aplicaciones-y-como-medirlas
[5] GrantMeStrength, «Accessibility testing - Windows apps». Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://learn.microsoft.com/en-us/windows/apps/design/accessibility/accessibility-testing
[6] GrantMeStrength, «Testing for accessibility - Win32 apps». Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://learn.microsoft.com/en-us/windows/win32/winauto/accessibility-testingtools
[7] madskristensen, «Información general sobre las herramientas de prueba - Visual Studio (Windows)». Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://learn.microsoft.com/es-es/visualstudio/test/improve-code-quality?view=visualstudio
[8] kaushika-msft, «Troubleshoot processes by using Task Manager - Windows Server». Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://learn.microsoft.com/en-us/troubleshoot/windows-server/support-tools/support-tools-task-manager
[9] GrantMeStrength, «Memory Performance Information - Win32 apps». Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://learn.microsoft.com/en-us/windows/win32/memory/memory-performance-information
[10] kaushika-msft, «Troubleshoot issues using Performance Monitor - Windows Server». Accedido: 28 de octubre de 2026. [En línea]. Disponible en: https://learn.microsoft.com/en-us/troubleshoot/windows-server/support-tools/troubleshoot-issues-performance-monitor
[11] «Writing JUnit Tests in NetBeans IDE». Accedido: 29 de octubre de 2026. [En línea]. Disponible en: https://netbeans.apache.org/tutorial/main/kb/docs/java/junit-intro/
[12] «Java SE Learning Trail». Accedido: 29 de octubre de 2026. [En línea]. Disponible en: https://netbeans.apache.org/tutorial/main/kb/docs/java/


---

## 2. Diseño de la interfaz

Fase en la que se define cómo se verá y cómo se usará la aplicación: pautas visuales (colores, fuentes, iconos y distribución), estructura de navegación y elementos de interfaz. El resultado es el diseño que se seguirá al programar.

### 2.1. Crear y documentar wireframes y mockups

### Objetivo
Crear y documentar los wireframes y mockups de las cuatro pantallas principales de la aplicación de escritorio StockScan SGA (Inicio, Inventario, Escanear y Alertas) como referencia visual previa a la implementación en Swing.

### Wireframes
Esquemas en escala de grises con zonas numeradas. Todos mantienen la barra lateral fija de 9 secciones.

#### Wireframe 1 · Inicio

<img width="2400" height="1245" alt="Image" src="https://github.com/user-attachments/assets/a453236c-1323-49ed-b8cf-54e1aa61bb83" />

#### Wireframe 2 · Inventario
<img width="2400" height="1185" alt="Image" src="https://github.com/user-attachments/assets/ddb77741-6ae7-4a53-a425-ae114fd36d40" />

#### Wireframe 3 · Alertas
<img width="2400" height="1245" alt="Image" src="https://github.com/user-attachments/assets/cf546b66-90b4-4e7c-8fd1-1abc7b39aabd" />

| Pantalla | Función | Elementos clave |
|---|---|---|
| Inicio | Vista global del almacén | 4 indicadores, gráfico de actividad, mini-gráficos y actividad reciente |
| Inventario | Consultar y filtrar productos | Buscador, filtros por categoría y estado, tabla con barra de nivel, botón Editar |
| Alertas | Gestionar productos bajo el mínimo | Tarjetas resumen, una tarjeta por producto, Generar pedido y Notificar |

### Mockups
Aplican la paleta, la tipografía y los criterios de iconos de las pautas visuales (#45). [Diseño en Figma](figma.com/make/fVgbUMpu9QaXt6AXwhjVY5/StockScan-SGA-Interface-Design?t=gq0krPnJ916Ffdij-20&fullscreen=1&fuid=1686775443056008797)

### Decisiones de diseño
Barra lateral fija, adecuada para 5–10 categorías [2][3]; una acción principal por pantalla; estado del producto siempre con texto además del color [1]; contadores de aviso visibles [4]; una vista Swing por pantalla separada de la lógica [5].

### Resultado
Tres pantallas documentadas en versión escritorio, con sus zonas e incidencias resueltas o asignadas, como base para la implementación y las pruebas de usabilidad.

### Referencias
[1] W3C, «WCAG2ICT», W3C Group Note, 2025. https://www.w3.org/TR/2025/NOTE-wcag2ict-22-20251211
[2] Microsoft, «Navigation view», Microsoft Learn. https://learn.microsoft.com/windows/apps/design/controls/navigationview
[3] Apple Inc., «Sidebars», Human Interface Guidelines. https://developer.apple.com/design/human-interface-guidelines/sidebars
[4] J. Nielsen, «10 Usability Heuristics for User Interface Design», Nielsen Norman Group. https://www.nngroup.com/articles/ten-usability-heuristics/
[5] G. E. Krasner y S. T. Pope, *Journal of Object-Oriented Programming*, vol. 1, n.º 3, pp. 26–49, 1988.

### 2.2. Definir la estructura de navegación y los elementos de interfaz

### Objetivo
Definir la estructura de navegación de la aplicación de escritorio StockScan SGA (barra lateral con 9 secciones y diálogos modales) y catalogar los elementos de interfaz de cada pantalla, de modo que cualquier sección sea accesible en un solo clic y el equipo disponga de una referencia única para implementarla en Java Swing.

### Modelo de navegación
La aplicación usa una **barra lateral izquierda fija y siempre visible**, con 9 secciones:

| Nº | Sección | Aviso |
|---|---|---|
| 1 | Dashboard | — |
| 2 | Mapa de almacén | — |
| 3 | Stock | — |
| 4 | Etiquetas | — |
| 5 | Trazabilidad | — |
| 6 | Alertas | contador |
| 7 | Equipo | — |
| 8 | Agenda | — |
| 9 | Chat | contador |

**Por qué barra lateral:**
- Microsoft recomienda la navegación lateral cuando hay entre 5 y 10 categorías igual de importantes [2]. Aquí son 9.
- En escritorio hay ancho de sobra, así que no hace falta ocultar el menú [2][3].
- Se mantiene visible por defecto para que sea fácil de descubrir [3].

El pie de la barra muestra el usuario conectado (Ana Rodríguez · Admin) y no contiene acciones críticas [3].

### Jerarquía de navegación
- **Nivel 1:** las 9 secciones de la barra lateral (una pantalla cada una).
- **Nivel 2:** diálogos modales abiertos desde una pantalla:
  - Añadir producto / Editar (desde Stock)
  - Entrada de stock, con 3 pasos (desde Stock)
  - Generar pedido y Generar pedido múltiple (desde Alertas)
- **No hay nivel 3:** un diálogo no abre otro diálogo.

Se respeta el máximo de **2 niveles** que recomiendan Microsoft y Apple [2][3].

### Elementos de interfaz y componente Swing

| Elemento | Dónde | Componente Swing |
|---|---|---|
| Barra lateral | Todas | JPanel (BorderLayout.WEST) + botones de sección |
| Cambio de pantalla | Zona central | JPanel con CardLayout |
| Tarjetas de indicadores | Dashboard, Alertas | JPanel + JLabel |
| Gráfico de actividad | Dashboard | Componente propio (paintComponent) |
| Selector Día/Semana/Mes y chips de filtro | Dashboard, Stock | JToggleButton + ButtonGroup |
| Buscador | Stock | JTextField |
| Tabla de productos | Stock | JTable + JScrollPane |
| Barra de nivel | Stock, Alertas | JProgressBar (o componente propio) |
| Botones de acción (Añadir, Editar, Generar pedido, Notificar) | Stock, Alertas | JButton |
| Diálogo Entrada de stock | Stock | JDialog modal |
| Entrada manual de código + OK | Entrada de stock | JTextField + JButton |

Cada pantalla es una vista (JPanel) separada de la lógica, según MVC [6].

### Interacción con teclado y ratón
- **Tab / Mayús+Tab:** recorren los elementos en orden visual.
- **Enter:** confirma el diálogo o la acción principal.
- **Esc:** cancela y cierra el diálogo.
- **Foco inicial** en el campo de código de Entrada de stock, para que un lector USB escriba directamente.
- **Atajos de sección** (propuesta): Ctrl+1 … Ctrl+9, en el orden de la barra lateral

### Estados y avisos
- **Sección activa:** fondo resaltado + texto en negrita (no solo color).
- **Avisos:** contador en Alertas y Chat; el usuario ve el estado sin entrar [4].
- **Estado del producto:** etiqueta de texto (En stock, Stock bajo, Sin stock) además de la barra de nivel.
- **Elementos desactivados:** botón atenuado y sin respuesta al clic.
- **Errores:** mensaje junto al campo (por ejemplo, código de ubicación no válido) y foco en el campo.
El color nunca es el único indicador [1].

### Referencias
[1] W3C, «WCAG2ICT», W3C Group Note, 2025. https://www.w3.org/TR/2025/NOTE-wcag2ict-22-20251211
[2] Microsoft, «Navigation view», Microsoft Learn. https://learn.microsoft.com/windows/apps/design/controls/navigationview
[3] Apple Inc., «Sidebars», Human Interface Guidelines. https://developer.apple.com/design/human-interface-guidelines/sidebars
[4] J. Nielsen, «10 Usability Heuristics for User Interface Design», Nielsen Norman Group. https://www.nngroup.com/articles/ten-usability-heuristics/
[5] FormDev Software, «FlatLaf». https://www.formdev.com/flatlaf/
[6] G. E. Krasner y S. T. Pope, *Journal of Object-Oriented Programming*, vol. 1, n.º 3, pp. 26–49, 1988.
[7] Oracle, «Modifying the Look and Feel», The Java Tutorials. https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel

### 2.3. Establecer las pautas visuales: colores, fuentes, iconos y distribución

### Objetivo

Establecer colores, tipografía, iconos y distribución de la ventana de StockScan SGA para que la aplicación de escritorio sea coherente, legible y accesible.

### Colores

La paleta se basa en azul, blanco y ámbar. El verde y el rojo se reservan para indicar el estado de las operaciones.

| Uso | Color | Código |
|---|---|---|
| Primario | Azul | `#1B4F72` |
| Primario oscuro (cabeceras) | Azul oscuro | `#123A57` |
| Primario claro (fondos suaves) | Azul claro | `#D6EAF8` |
| Acento / alerta | Ámbar | `#F39C12` |
| Éxito | Verde | `#27AE60` |
| Peligro / error | Rojo | `#E74C3C` |
| Fondo / superficie | Gris muy claro / blanco | `#F5F7FA` / `#FFFFFF` |
| Texto principal / secundario | Gris casi negro / gris | `#1C1C1E` / `#6E6E73` |

**Contraste.** Se calcularon las relaciones de contraste de los pares de colores principales según las pautas WCAG 2.2 [1], que exigen un mínimo de 4,5:1 para el texto y de 3:1 para los componentes de interfaz:

- El texto principal sobre blanco alcanza 17:1 y el blanco sobre el azul primario, 8,7:1.
- El texto secundario sobre blanco alcanza 5,1:1.
- El blanco sobre ámbar (2,2:1) y sobre verde (2,9:1) no cumple el mínimo, por lo que en esos botones se utiliza texto oscuro (7,8:1 y 5,9:1 respectivamente).
- El blanco sobre rojo (3,8:1) solo se emplea en texto grande o en negrita.
- El gris terciario (`#AEAEB2`, 2,2:1) no se usa para información importante.

Como regla general, el color nunca es el único medio para transmitir un estado: siempre se acompaña de un icono o de texto [1].

### Tipografía

Se utiliza una fuente sans-serif (Inter) para la interfaz y una fuente monoespaciada para códigos y cifras, de modo que los datos se lean de un vistazo y no se confundan caracteres similares (0/O, 1/l).

| Nivel | Tamaño y peso | Uso |
|---|---|---|
| Display | 32 px · 800 | Título de la pantalla principal |
| H1 | 24 px · 700 | Título de sección |
| H2 | 20 px · 600 | Subsección |
| H3 | 16 px · 600 | Título de lista o tarjeta |
| Body | 14 px · 400 | Texto normal |
| Small | 12 px · 400 | Información secundaria |
| Caption | 11 px · 500 | Etiquetas y estados, en mayúsculas |

La tipografía monoespaciada se aplica a los códigos de producto (`PRD-0041-INOX`), a las ubicaciones de estantería (`PAS-02-EST-04`) y a las cifras de stock (`1,248`). La información importante (código, cantidad o estado) nunca se muestra en los niveles Small o Caption.

### Iconos

Se emplea un único conjunto de iconos de línea, con botones cuadrados de esquinas redondeadas. El color del fondo indica el tipo de acción:


| Icono | Acción | Fondo | Color del icono |
|---|---|---|---|
| <img width="50" height="50" alt="Icono" src="https://github.com/user-attachments/assets/3f533c5e-3435-4c24-bc96-ef392d48a22b" /> | Crear un elemento | Azul primario | Blanco |
| <img width="50" height="50" alt="Icono" src="https://github.com/user-attachments/assets/c7efd8fa-068a-4d2c-9446-743426cdfe71" /> | Buscar | Azul claro | Azul primario |
| <img width="50" height="50" alt="Icono" src="https://github.com/user-attachments/assets/4c2b02d9-ecde-401d-b5bc-6a67cddee5b2" /> | Filtrar | Gris claro | Gris |
| <img width="50" height="50" alt="Icono" src="https://github.com/user-attachments/assets/6e8a11e8-391a-4c4d-b1c3-8c86b1292df4" /> | Cancelar o eliminar | Rojo claro | Rojo |
| <img width="50" height="50" alt="Icono" src="https://github.com/user-attachments/assets/722feed4-ab8e-4434-af12-c4635c4cc223" /> | Confirmar | Verde claro | Verde |
| <img width="50" height="50" alt="Icono" src="https://github.com/user-attachments/assets/42186ffe-de4d-4fe8-99b8-a94ab81ff8fd" /> | Descargar o exportar | Ámbar claro | Ámbar |

Nota: Los iconos están seleccionados de **Font Awesome**, son intuitivos ya que habría que cambiar los colores y el fondo, cosa que la página web no permite.

Las reglas de uso son las siguientes:

- La acción principal de cada pantalla utiliza el único botón de fondo sólido.
- Los botones que solo contienen un icono llevan una etiqueta accesible (texto alternativo o ayuda emergente).
- Las acciones críticas (confirmar y eliminar) incluyen además texto visible junto al icono, para no depender solo del color [1].
- El tamaño táctil mínimo es de 48×48 dp [2].

**Limitación detectada.** Los iconos de color sobre su fondo claro no alcanzan el contraste de 3:1 recomendado para elementos de interfaz (rojo, 2,95:1; verde, 2,46:1; ámbar, 2,03:1) [1]. Se mitiga con la regla anterior de acompañar las acciones críticas con texto, y se deja como mejora oscurecer el tono de estos iconos.

### Distribución

Barra lateral fija (≈210 px), contenido con márgenes de ≈32 px y espaciado en múltiplos de 4/8 px, tarjetas con borde redondeado y tablas a ancho completo. La ventana es redimensionable, con tamaño mínimo propuesto de 1280×720. Las medidas con ≈ se confirmarán en Figma.


### Referencias
[1] W3C, «WCAG2ICT», W3C Group Note, 2025. https://www.w3.org/TR/2025/NOTE-wcag2ict-22-20251211
[2] Sun Microsystems, *Java Look and Feel Design Guidelines*, 2.ª ed. Addison-Wesley, 2001.
[3] Apple Inc., «Sidebars», Human Interface Guidelines. https://developer.apple.com/design/human-interface-guidelines/sidebars
[4] FormDev Software, «FlatLaf». https://www.formdev.com/flatlaf/
[5] Oracle, «Modifying the Look and Feel», The Java Tutorials. https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel

---

## 3. Implementación

La fase de implementación traslada las especificaciones de diseño y las directrices de accesibilidad a código Java ejecutable sobre el entorno Swing. Para ello, se ha desarrollado una arquitectura modular basada en el patrón Modelo-Vista-Controlador (MVC), donde la interfaz gráfica queda desacoplada de la lógica de negocio y de los mecanismos de almacenamiento.

El desarrollo se ha estructurado en torno a una ventana contenedora principal (`MainFrame`) con una resolución de $1000 \times 600\text{ px}$, sobre la que se intercalan dinámicamente los 9 paneles del sistema mediante un contenedor de tipo `CardLayout`, junto a una pantalla independiente de autenticación (`LoginFrame`).

---

### 3.1. Desarrollar componentes visuales e interactivos

Para garantizar la homogeneidad de la interfaz y acelerar el desarrollo con el editor visual NetBeans Matisse, se han categorizado y parametrizado los componentes gráficos clave de la aplicación:

#### Vista de Autenticación (`LoginFrame`)

> ![LoginFrame](https://github.com/user-attachments/assets/479aa5c7-2b1e-40e0-8c79-8c4872c28cef)

* **Estructura visual:** Formulario en *split layout* de $1000 \times 600\text{ px}$ dividido en un banner corporativo lateral (`panelBannerLogin`, $450\text{ px}$) y un área central de credenciales (`panelFormLogin`, $550\text{ px}$).
* **Componentes integrados:** Campos de entrada alineados para correo (`txtEmail`) y clave (`txtPassword`), junto a un botón principal estilizado (`btnIniciarSesion`).

---

#### Cuadro de Mando (`DashboardPanel`)

> ![Dashboard](https://github.com/user-attachments/assets/df6982c4-c4b8-4935-a8ed-6036b1447896)

* **Menu Lateral Fijo (`panelSidebar`):** Contenedor lateral de $220 \times 600\text{ px}$ en azul oscuro (`#121E2B`), con botones de acceso directo a los 9 paneles, tarjetas de usuario y etiquetas de aviso pendientes (`lblBadgeAlertas` y `lblBadgeChat`).
* **Tarjetas KPI y Gráficos:** Módulos visuales superiores para métricas en tiempo real e integración de gráficos de actividad y tablas de registro reciente.

---

#### Control de Inventario (`StockPanel`)

> ![StockPanel](https://github.com/user-attachments/assets/b313edcc-5205-47da-9a16-f0465524a41c)

* **Tabla Principal de Datos (`tblProductosStock`):** Implementada con `DefaultTableModel` no editable, renderizado de celdas personalizado para badges de estado (`[OK]`, `[BAJO]`, `[SIN STOCK]`) y barra visual de nivel.
* **Filtros e Inputs:** Buscador reactivo (`txtBuscarStock`), selector por categoría y botonera de acciones contextuales.

---

#### Impresión de Etiquetas y Trazabilidad (`EtiquetasPanel` y `TrazabilidadPanel`)

| Vista Previa de Etiquetas | Histórico de Trazabilidad |
| :---: | :---: |
| ![EtiquetasPanel](https://github.com/user-attachments/assets/e652abe3-ddf8-4728-bdb3-ca214639436b) | ![TrazabilidadPanel](https://github.com/user-attachments/assets/225f3d08-6733-4b70-80bc-b49da7e616f0) |

* **Generación de Etiquetas:** Visor de previsualización a escala $1:1$ (`panelPreviewEtiqueta`) que dibuja en tiempo real el código Barcode/QR parametrizado antes de enviar a imprenta.
* **Auditoría e Historial:** Tabla inmutable de registro de movimientos (`tblTrazabilidad`) con filtros combinados por rango de fecha, tipo de operación y operario.

---

### 3.2. Implementar eventos y acciones de los componentes

La capa interactiva de la aplicación gestiona la respuesta del sistema ante las acciones del usuario, aplicando controladores de eventos desacoplados según el tipo de interacción:

#### Navegación entre vistas
Los botones de la barra lateral escuchan eventos de tipo `ActionListener`. Al hacer clic en una sección, el controlador conmuta la vista activa en el `CardLayout` del contenedor central sin necesidad de instanciar de nuevo los paneles, optimizando el uso de memoria.

#### Búsqueda y filtrado reactivo
Para los campos de búsqueda (`txtBuscarStock`, `txtBuscarTraza`), se ha implementado un `DocumentListener` vinculado al `TableRowSorter` de cada tabla. Esto permite que los datos se filtren en tiempo real a medida que el usuario escribe, sin necesidad de pulsar un botón de confirmación o la tecla Enter.

#### Control de estados en la interfaz (UI/UX)
Para evitar errores de operación, los botones contextuales como *Editar*, *Eliminar* o *Imprimir Etiqueta* permanecen desactivados (`setEnabled(false)`) por defecto. Se ha vinculado un `ListSelectionListener` a las tablas que detecta cuándo hay una fila seleccionada, activando únicamente en ese momento las acciones correspondientes.

#### Mensajería y alertas
Las acciones críticas o los fallos de validación disparan alertas inmediatas mediante cuadros de diálogo `JOptionPane` o actualizaciones de texto en las barras de estado inferiores, asegurando que el usuario reciba confirmación visual de cada operación.

---

### 3.3. Definir la secuencia de control y la persistencia de datos

#### Secuencia de control y flujo de navegación
La aplicación gestiona las interacciones a través de una jerarquía clara de dos niveles:
1. **Nivel principal:** Navegación directa entre las 9 secciones desde el menú lateral.
2. **Nivel secundario:** Diálogos modales (`JDialog`) lanzados desde las pantallas principales para tareas específicas (alta de productos, registro de entradas o confirmación de traspasos).

El flujo operativo estándar de gestión de mercancía sigue el ciclo **Escanear > Confirmar > Actualizar**:
* **Escanear:** Entrada del código por pistola o teclado en la interfaz.
* **Confirmar:** Validación de datos (cantidad $>0$, stock suficiente en origen) en un diálogo modal.
* **Actualizar:** Ejecución de la operación y refresco automático de las tablas de la interfaz.

En caso de error (credenciales incorrectas, código no registrado o cantidad no válida), el sistema detiene el flujo, resalta el campo afectado y muestra un mensaje explicativo sin perder la información introducida.
---

## 4. Pruebas y auditoría

# Auditoría visual de StockScan

## 4.1. Objetivo y alcance

El objetivo de esta auditoría es revisar las vistas de la aplicación StockScan, desarrollada en Java Swing, antes de su validación.

En esta fase se evalúan únicamente los aspectos visuales del prototipo:

- Coherencia de textos y datos mostrados.
- Legibilidad y presentación de los componentes.
- Distribución de tablas, tarjetas, formularios y paneles.
- Consistencia visual entre las distintas pantallas.
- Posibles problemas de recorte, solapamiento o adaptación al tamaño de la ventana.

**Fuera de alcance:** el funcionamiento de botones, filtros, acciones y navegación. Estos elementos no necesitan funcionar en esta fase del prototipo.

Los hallazgos se clasifican en dos grupos:
- **Detectado en código:** se identifica directamente al revisar los archivos Java.
- **Pendiente de comprobación visual:** requiere ejecutar la aplicación y observar la interfaz.

## 4.2. Lista unificada de hallazgos

### Prioridades

- **Alta:** afecta significativamente a la claridad o coherencia de la interfaz.
- **Media:** conviene revisarlo antes de validar el diseño.
- **Baja:** mejora de acabado y consistencia.

| ID | Vista | Hallazgo | Prioridad | Estado |
|---|---|---|---|---|
| VIS-01 | Equipo | El encabezado indica 8 miembros, pero los datos visibles no parecen representar 8 registros completos y la tabla contiene filas vacías. Revisar la coherencia entre el contador y el contenido. | Media | Detectado en código |
| VIS-02 | Equipo | El registro de Miguel Ramírez muestra `Fichado (07:10` sin cerrar el paréntesis. | Baja | Detectado en código |
| VIS-03 | Etiquetas | El subtítulo indica «2 productos seleccionados» de forma fija. Revisar que el texto sea coherente con la selección que se desea representar en el prototipo. | Media | Detectado en código |
| VIS-04 | Etiquetas | Los códigos de barras de la vista previa parecen representados mediante caracteres de texto. Si se pretende simular una etiqueta lista para imprimir, valorar una representación gráfica. | Media | Detectado en código |
| VIS-05 | Etiquetas | El campo de búsqueda parece inicializarse con el texto «🔍 Buscar...». Comprobar si se muestra como contenido normal en lugar de como texto orientativo. | Media | Detectado en código |
| VIS-06 | Chat | Los campos de búsqueda y mensaje empiezan con textos orientativos. Comprobar que se distingan visualmente de los datos introducidos por el usuario. | Media | Detectado en código |
| VIS-07 | Stock | Aparece «Almacen Central» sin tilde. Unificar con «Almacén Central». | Baja | Detectado en código |
| VIS-08 | Trazabilidad | Aparece «Almacen Central» sin tilde. Unificar con el nombre utilizado en el resto de las vistas. | Baja | Detectado en código |
| VIS-09 | Varias vistas | El nombre «Ana Rodríguez» aparece también como «Ana Rodriguez». Unificar la escritura en todas las pantallas. | Baja | Detectado en código |
| VIS-10 | Dashboard | El panel destinado al gráfico parece no dibujar datos en el código revisado. Confirmar si se desea dejar como espacio reservado o incluir un gráfico de ejemplo. | Media | Pendiente de decisión |
| VIS-11 | Agenda | No se aprecian eventos en la cuadrícula semanal a partir del código revisado. Confirmar si el calendario vacío es intencional en esta fase. | Media | Pendiente de decisión |
| VIS-12 | Dashboard | La ventana tiene un tamaño mínimo de 1000 × 600. Comprobar que la composición conserve márgenes y proporciones al reducir el espacio disponible. | Media | Pendiente de comprobación visual |
| VIS-13 | Equipo | La ventana tiene un tamaño mínimo de 900 × 600 y la tabla contiene varias columnas. Comprobar que textos, estados y acciones no queden cortados. | Media | Pendiente de comprobación visual |
| VIS-14 | Etiquetas | La composición de dos columnas utiliza anchuras y separaciones definidas. Comprobar que la selección de productos y las etiquetas de vista previa no se corten al cambiar el tamaño de la ventana. | Media | Pendiente de comprobación visual |
| VIS-15 | Stock | La tabla contiene siete columnas. Comprobar su distribución horizontal y la legibilidad de los encabezados y valores. | Media | Pendiente de comprobación visual |
| VIS-16 | Trazabilidad | Comprobar que la tabla de movimientos, los filtros y los encabezados mantengan una distribución legible al tamaño mínimo. | Media | Pendiente de comprobación visual |
| VIS-17 | Mapa de almacén | Comprobar la alineación de las celdas, el contraste de los colores, la legibilidad de las etiquetas de pasillos y la claridad de la leyenda. | Media | Pendiente de comprobación visual |
| VIS-18 | Alertas | Comprobar la jerarquía visual entre los resúmenes numéricos, las tarjetas de alertas y las acciones disponibles. | Media | Pendiente de comprobación visual |
| VIS-19 | Chat | Comprobar la distribución de canales, conversación y zona de escritura para evitar que alguna sección pierda espacio o legibilidad. | Media | Pendiente de comprobación visual |
| VIS-20 | Login | Comprobar la alineación del formulario, la legibilidad de los campos y la jerarquía visual entre el acceso y la recuperación de contraseña. | Media | Pendiente de comprobación visual |

## 4.3. Revisión por pantalla

### 4.3.1. Login

**Aspectos que revisar:**
- Alineación y distribución del formulario.
- Legibilidad de los campos de correo y contraseña.
- Jerarquía visual entre el botón principal y la recuperación de contraseña.
- Coherencia de tipografías, colores y márgenes con el resto de la aplicación.

**Estado:** pendiente de comprobación visual.

### 4.3.2. Dashboard

**Aspectos que revisar:**
- Distribución de las tarjetas KPI.
- Presentación del panel del gráfico.
- Espaciado entre los elementos y la barra lateral.
- Adaptación de la composición al tamaño mínimo de la ventana.

**Observación:** decidir si el espacio del gráfico debe permanecer vacío o mostrar datos de ejemplo.

### 4.3.3. Mapa de almacén

**Aspectos que revisar:**
- Alineación y separación de las celdas.
- Contraste entre los colores utilizados.
- Legibilidad de las etiquetas de pasillos y zonas.
- Claridad de la leyenda.
- Ajuste del mapa al espacio disponible.

**Estado:** pendiente de comprobación visual.

### 4.3.4. Stock

**Aspectos que revisar:**
- Distribución y legibilidad de las siete columnas.
- Presentación de los niveles de existencias.
- Consistencia de los nombres y textos.
- Adaptación de la tabla al tamaño de la ventana.

**Observación:** corregir «Almacen Central» por «Almacén Central».

### 4.3.5. Trazabilidad

**Aspectos que revisar:**
- Legibilidad de la tabla de movimientos.
- Distribución de los filtros y encabezados.
- Consistencia de los nombres y textos.
- Adaptación al tamaño mínimo de la ventana.

**Observación:** corregir «Almacen Central» por «Almacén Central».

### 4.3.6. Agenda

**Aspectos que revisar:**
- Distribución de los días y la cuadrícula semanal.
- Legibilidad de los encabezados.
- Espaciado entre las secciones.
- Presentación de eventos, si se decide incluir datos de ejemplo.

**Observación:** confirmar si el calendario vacío es intencional.

### 4.3.7. Alertas

**Aspectos que revisar:**
- Jerarquía visual de los contadores.
- Diferenciación entre tipos de alertas.
- Legibilidad de los datos de los productos.
- Coherencia visual entre las tarjetas y las acciones disponibles.

**Estado:** pendiente de comprobación visual.

### 4.3.8. Chat

**Aspectos que revisar:**
- Distribución de canales y conversación.
- Legibilidad de los mensajes.
- Presentación del campo de escritura.
- Diferenciación entre textos orientativos y contenido real.
- Adaptación al tamaño mínimo de la ventana.

### 4.3.9. Equipo

**Aspectos que revisar:**
- Coherencia entre el contador de miembros y los registros mostrados.
- Presentación de las filas vacías.
- Legibilidad de las columnas y los estados de fichaje.
- Consistencia del formato de las horas.

**Observaciones:**
- Revisar el contador de miembros y los registros visibles.
- Corregir el texto `Fichado (07:10` para cerrar el paréntesis.

### 4.3.10. Etiquetas

**Aspectos que revisar:**
- Coherencia entre el número de productos seleccionados y el subtítulo.
- Presentación de la lista de productos.
- Aspecto de los códigos de barras de la vista previa.
- Diferenciación del texto orientativo del buscador.
- Adaptación de las dos columnas al tamaño de la ventana.

**Observaciones:**
- Revisar el texto fijo «2 productos seleccionados».
- Valorar si los códigos de barras deben representarse gráficamente.
- Comprobar la presentación del texto «🔍 Buscar...».

## 4.4. Orden recomendado de corrección

1. **Coherencia del contenido:** corregir las tildes, cerrar el paréntesis y revisar el contador y las filas de Equipo.
2. **Acabado visual:** revisar los textos orientativos y decidir cómo representar los códigos de barras.
3. **Consistencia entre pantallas:** unificar nombres, encabezados y textos compartidos.
4. **Distribución:** comprobar las ventanas a su tamaño mínimo para detectar posibles recortes, solapamientos y problemas de legibilidad.
5. **Decisiones sobre contenido de ejemplo:** determinar si el Dashboard debe mostrar un gráfico y si la Agenda debe incluir eventos.

## 4.5. Criterios de aceptación visual

La auditoría visual se considerará validada cuando:

- [ ] Los textos estén correctamente escritos y sean coherentes entre pantallas.
- [ ] Los contadores coincidan con los datos mostrados cuando corresponda.
- [ ] Los textos orientativos se distingan del contenido real.
- [ ] Las tablas y tarjetas sean legibles.
- [ ] No haya componentes cortados o solapados al tamaño mínimo admitido.
- [ ] Los colores, las tipografías y los márgenes mantengan una apariencia consistente.
- [ ] Se haya decidido cómo presentar los gráficos, el calendario y los códigos de barras en el prototipo.

## 4.6. Fuera de alcance

En esta fase no se consideran defectos:
- Botones que todavía no ejecutan acciones.
- Filtros que todavía no modifican los resultados.
- Navegación entre pantallas aún no implementada.
- Acciones que dependan de lógica funcional pendiente.

Estos aspectos podrán revisarse en una fase posterior de pruebas funcionales.

## 4.7. Conclusión

La revisión estática identifica ajustes de coherencia textual y presentación que conviene resolver antes de validar el prototipo. También quedan pendientes comprobaciones de distribución y legibilidad que requieren ejecutar la aplicación y observar las ventanas reales.

**Estado general:** auditoría estática realizada; validación visual en ejecución pendiente.

## 5. Validación y ajustes

Fase de contraste con los usuarios. Se enseña la aplicación a personas del público objetivo para comprobar que resuelve el problema inicial y que resulta fácil y rápida de usar. Con sus opiniones se hacen los ajustes finales.

- Revisar los resultados de las pruebas de usabilidad y de la auditoría (herramientas automáticas y pruebas manuales).
- Corregir en Wireframes, Mockups y prototipo Swing los problemas detectados, priorizando los de accesibilidad (contraste, teclado, tamaño de los elementos).
- Volver a comprobar los puntos corregidos y registrar el resultado antes y después.
- Documentar los resultados y los cambios realizados en el repositorio.

#### Validación con usuarios y revisión de resultados

- [x] Revisar los resultados de las pruebas de usabilidad y de la auditoría (herramientas automáticas y pruebas manuales) y listar los hallazgos en el registro de ajustes.
- [x] Preparar la sesión de prueba (protocolo de abajo).
- [x] Realizar la prueba con n personas del público objetivo.
- [x] Registrar resultados y opiniones en resultados.md.
- [x] Priorizar hallazgos: accesibilidad (contraste, teclado, tamaño de elementos).

#### Ajustes finales y recomprobación
- [x] Corregir en wireframes y mockups (Figma).
- [x] Corregir en el prototipo Swing + FlatLaf.
- [x] Volver a comprobar cada punto corregido con la misma herramienta o método y anotar el resultado antes y después.
- [x] Documentar cambios en el repositorio.

### 5.1. Documentar los resultados y cerrar el sprint

**Qué se ha revisado**
- Auditoría visual estática de las 10 vistas (sobre el código Java).
- Revisión cruzada de la documentación del sprint (diseño, implementación, accesibilidad y métricas).
- Usabilidad, accesibilidad y rendimiento: están definidos los requisitos, las métricas y las herramientas. 

---

### Problemas encontrados

**Auditoría visual: 20 hallazgos** (0 altos, 16 medios, 4 bajos)

| Grupo | Nº | Ejemplos |
|---|---|---|
| Detectados en código | 9 | Contador de Equipo sin 8 registros (VIS-01), «Fichado (07:10» sin cerrar (VIS-02), «2 productos seleccionados» fijo (VIS-03), códigos de barras hechos con texto (VIS-04), «Almacen» sin tilde (VIS-07/08), «Ana Rodriguez» (VIS-09) |
| Pendientes de decisión | 2 | Gráfico del Dashboard y calendario de la Agenda vacíos (VIS-10/11) |
| Pendientes de comprobación visual | 9 | Recortes y legibilidad al tamaño mínimo (VIS-12 a VIS-20) |

**Incoherencias entre documentos**

| Problema | Dónde |
|---|---|
| Ventana mínima: 1280×720 (pautas) frente a 1000×600 (implementación) y 900×600 (Equipo). Barra lateral ≈210 px frente a 220 px | Pautas, implementación y auditoría |
| Color de la barra lateral #121E2B fuera de la paleta | Implementación y pautas |
| Estados `[OK]/[BAJO]/[SIN STOCK]` frente a «En stock / Stock bajo / Sin stock» | Implementación y diseño |
| Gráficos y códigos de barras «en tiempo real» frente a la auditoría (panel sin datos, barras con texto) | Implementación y auditoría |
| Tamaño táctil 48×48 dp (unidad de Android) frente a 24×24 px de WCAG 2.2 | Pautas y estándares |
| Estándares de accesibilidad y métricas pensados para web o servidor (Lighthouse, axe, HTML, solicitudes, usuarios concurrentes) en una app Swing local con SQLite | Estándares y métricas |
| Errores en métricas: densidad de defectos con la fórmula de la tasa de errores, definición de «tolerantes» en Apdex y referencias que no coinciden | Métricas |

---

### Correcciones

| Corrección | Hallazgos |
|---|---|
| Cerrar el paréntesis de «Fichado (07:10)» | VIS-02 | 
| Unificar «Almacén Central» y «Ana Rodríguez» en una clase de constantes | VIS-07/08/09 | 
| Ajustar el contador de Equipo a los registros mostrados y quitar filas vacías | VIS-01 | 
| Generar el subtítulo de Etiquetas desde la selección | VIS-03 | 
| Usar placeholder en los buscadores (Etiquetas y Chat) | VIS-05/06 | 
| Decidir cómo mostrar los códigos de barras, el gráfico del Dashboard y la Agenda (propuesta: datos de ejemplo) | VIS-04/10/11 | 
| Unificar tamaño de ventana, ancho de la barra lateral, colores y textos de estado entre documentos | Incoherencias | 
| Reorientar estándares y métricas a escritorio (WCAG2ICT, API de accesibilidad de Java, NVDA) y corregir fórmulas, glosario y referencias | Incoherencias |

---

### Comparación antes y después

| Indicador | Antes | Después |
|---|---|---|
| Hallazgos de la auditoría | 20 | [completar] |
| Hallazgos de prioridad media / baja | 16 / 4 | [completar] |
| Incoherencias entre documentos | 7 grupos | [completar] |
| Vistas con textos incoherentes | 4 | [completar] |
| Vistas comprobadas con la aplicación en ejecución | 0 de 10 | [completar] |

**Estado:** auditoría estática y revisión cruzada hechas. Pasan al sprint 3: la validación visual con la aplicación en ejecución y las pruebas de usabilidad, accesibilidad y rendimiento.
