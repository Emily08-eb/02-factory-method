# Bitácora de uso de IA — Patrón Factory Method


Aprendiz: Emily Echeverry Buitrago
Ficha: 3409871
Segundo aprendiz: __________________________

⸻

1. Predicción inicial de errores (sin utilizar IA)

Antes de consultar herramientas de inteligencia artificial, revisé el código y las reglas del proyecto.

Identifiqué los siguientes posibles errores:

1. El creador de SMS podría estar generando una notificación de correo electrónico en lugar de una notificación SMS.
2. La validación del correo electrónico podría permitir direcciones sin un punto en el dominio.
3. El límite de caracteres de los mensajes SMS podría no cumplir la regla de los 160 caracteres, incluyendo los tres puntos finales cuando el mensaje es demasiado largo.

⸻

2. Consulta a las herramientas de inteligencia artificial

Consulté las mismas instrucciones del proyecto con ChatGPT, Gemini y DeepSeek para comparar sus respuestas.

Herramienta	Resultado de la consulta
ChatGPT	Identificó los tres errores relacionados con el creador SMS, la validación del correo y el límite de caracteres.
Gemini	Identificó los errores principales, pero sugirió utilizar un carácter de puntos suspensivos diferente.
DeepSeek	Coincidió con los errores principales y también sugirió utilizar un carácter de puntos suspensivos diferente.

⸻

3. Comparación y análisis de las respuestas

Las tres herramientas coincidieron en los problemas principales del proyecto.

Sin embargo, encontré una diferencia en la forma de representar los puntos suspensivos del mensaje SMS.

El README exige utilizar tres puntos consecutivos (...), no el carácter especial de puntos suspensivos (…).

Por eso comparé las recomendaciones con las reglas del proyecto antes de realizar los cambios.

⸻

4. Correcciones realizadas y pruebas

Realicé las correcciones de acuerdo con las reglas del README y comprobé los resultados mediante pruebas unitarias.

Corrección 1: Creador SMS

Se corrigió el método para que CreadorSms genere una notificación SMS y no una notificación de correo electrónico.

Commit: a4cb9fc fix: corrige creador SMS

Corrección 2: Validación del correo electrónico

Se ajustó la expresión de validación para rechazar correos que no tengan un punto en el dominio.

Commit: 3795fee fix: corrige validacion de correo

Corrección 3: Límite de caracteres SMS

Se corrigió el límite para que los mensajes largos tengan exactamente 160 caracteres, conservando los primeros 157 y agregando ....

Commit: 6d688e2 fix: corrige limite de SMS

Corrección adicional: Mensajes SMS vacíos y espacios

Se agregó la validación para rechazar mensajes nulos o vacíos y eliminar los espacios al inicio y al final antes del envío.

Commit: 0967be8 fix: valida mensajes SMS vacios y elimina espacios

Pruebas adicionales

Se agregaron pruebas para comprobar que los mensajes SMS nulos o vacíos sean rechazados y que los espacios se eliminen correctamente.

Commit: ebe7552 test: agrega pruebas para mensajes SMS

Refactorización

Se mejoró la legibilidad de la validación del correo electrónico sin cambiar su comportamiento.

Commit: ef95720 refactor: mejora legibilidad validacion correo

Al ejecutar las pruebas unitarias, todas finalizaron correctamente.

⸻

5. Errores o diferencias encontradas en las recomendaciones de IA

Durante la comparación encontré que Gemini y DeepSeek sugirieron utilizar el carácter especial … para los mensajes SMS largos.

Esta recomendación no cumplía exactamente con la instrucción del README, que exige tres puntos consecutivos (...).

Por esta razón, no acepté todas las recomendaciones automáticamente y comprobé que los cambios respetaran las reglas del proyecto.

⸻

6. Reflexión final y revisión de seguridad

La inteligencia artificial me ayudó a identificar los errores y comprender cómo corregirlos.

Aprendí que el patrón Factory Method permite crear diferentes tipos de notificaciones.

También aprendí la importancia de realizar pruebas unitarias antes y después de corregir el código.

Las pruebas permitieron comprobar que las correcciones realizadas funcionaran correctamente.

Durante la comparación encontré que no todas las recomendaciones de las herramientas de IA eran correctas.

Por eso comparé sus respuestas con las reglas del README y los resultados de las pruebas.

En la revisión de seguridad tuve presente la importancia de validar los datos recibidos, rechazar mensajes nulos o vacíos y no compartir contraseñas ni tokens.

Finalmente, comprobé que los mensajes SMS eliminen los espacios al inicio y al final antes de enviarse.