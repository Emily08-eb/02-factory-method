# Bitácora de uso de IA — Patrón Factory Method


Aprendices: Emily Echeverry Buitrago / ______________________
Ficha: 3409871  Fecha de inicio: 23/11/2026

La bitácora es evidencia del ítem 18 de la lista de chequeo. Regístralo todo, también las respuestas de la IA que estaban mal.
Nunca pegues en una IA contraseñas, tokens, datos personales reales ni código que no tengas permiso de compartir.

1. Predicción sin IA (máx. 20 minutos)

Antes de abrir cualquier IA, lee el README y el código. Escribe aquí qué errores crees que hay y por qué.

#	Archivo y línea	¿Qué creo que está mal?	¿Qué regla de negocio rompe?
1	CreadorSms.java	El método crearNotificacion() devuelve una notificación de correo en lugar de una de SMS.	El creador de SMS debe crear notificaciones SMS.
2	NotificacionEmail.java	La validación del correo solamente comprueba que no sea null y que contenga un arroba (@).	Los correos deben tener exactamente un @, una parte local válida y un dominio con al menos un punto.
3	NotificacionSms.java	El mensaje se recorta a 160 caracteres y después se agregan tres puntos, superando el límite permitido.	Los SMS no pueden superar 160 caracteres y deben conservar 157 caracteres antes de agregar “…”.

2. Registro de interacciones con IA

Copia una fila por cada consulta importante.

#	Herramienta (ChatGPT / Gemini / DeepSeek / Copilot / otra)	Prompt (resumen o enlace)	¿Qué respondió?	¿Era correcto? ¿Cómo lo verifiqué?	¿Lo usé? (sí / no / modificado)
1	ChatGPT	Análisis de los tres posibles errores del patrón Factory Method.	Identificó los tres errores y explicó las pruebas y correcciones necesarias.	Sí. Se verificó mediante pruebas unitarias.	Modificado
2	Gemini	Se envió el mismo prompt utilizado en ChatGPT.	Identificó los tres errores, pero propuso utilizar el carácter de elipsis (…), que no corresponde a los tres puntos literales exigidos.	Parcialmente correcto. Se comparó con la regla de 157 caracteres más “…”.	No
3	DeepSeek	Se envió el mismo prompt utilizado en las otras herramientas.	Identificó los tres errores, pero también utilizó el carácter de elipsis (…) en lugar de tres puntos.	Parcialmente correcto. Se verificó que el resultado debía tener 160 caracteres.	No

3. Jurado de IAs

Envía el mismo prompt a tres herramientas distintas y compara.

Pregunta enviada	ChatGPT	Gemini	DeepSeek	¿Quién acertó? ¿En qué discreparon?
Análisis de los tres errores del proyecto Factory Method, indicando cuáles son reales, cómo demostrarlos con pruebas y cómo corregirlos.	Identificó correctamente los tres errores y explicó que el SMS debe conservar 157 caracteres y agregar tres puntos.	Identificó los tres errores, pero confundió los tres puntos con un carácter de elipsis.	Identificó los tres errores, pero también confundió los tres puntos con un carácter de elipsis.	Las tres herramientas identificaron los problemas principales. ChatGPT explicó correctamente el límite de 160 caracteres. Gemini y DeepSeek se equivocaron en el sufijo del SMS.

4. Errores encontrados y corregidos

#	Error	Prueba que lo demuestra (nombre del método de prueba)	Commit de la corrección	¿Lo encontré yo, la IA o ambos?
1	CreadorSms devuelve NotificacionEmail en lugar de NotificacionSms.	creadorSmsEnviaPorSms	a4cb9fc	Ambos
2	NotificacionEmail acepta correos sin punto en el dominio.	correoSinPuntoEnDominioEsInvalido	3795fee	Ambos
3	NotificacionSms supera los 160 caracteres al agregar el sufijo.	smsLargoNoSupera160Caracteres	6d688e2	Ambos

5. Lo que la IA hizo mal o no vio

Durante la comparación de las herramientas se encontró un error en las respuestas de Gemini y DeepSeek. Ambas recomendaron utilizar el carácter de elipsis (…) en lugar de tres puntos consecutivos (…).

La diferencia es importante porque el requisito establece conservar 157 caracteres y agregar tres puntos, para obtener exactamente 160 caracteres.

Este error se identificó al comparar las respuestas con las reglas del proyecto y con la prueba unitaria. Esto demuestra que las respuestas de la inteligencia artificial deben verificarse antes de utilizarlas.

6. Reflexión final (5 a 10 líneas)

La inteligencia artificial me ayudó a identificar los errores y comprender cómo corregirlos.
Aprendí que el patrón Factory Method permite crear diferentes tipos de notificaciones.
También aprendí la importancia de realizar pruebas unitarias antes y después de corregir el código.
Las pruebas permitieron comprobar que las tres correcciones realizadas funcionaran correctamente.
Durante la comparación encontré que no todas las recomendaciones de las IA eran correctas.
Por eso comparé sus respuestas con las reglas del README y los resultados de las pruebas.
En la revisión también tuve presente la importancia de validar los datos recibidos y no compartir contraseñas ni tokens.
Queda por comprobar el cumplimiento de la regla de mensajes nulos o vacíos y el recorte de espacios antes del envío.