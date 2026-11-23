# MercaSENA · Patrón Factory Method (Creacional)

**Dominio:** Notificaciones a clientes por correo y SMS

## Contexto

MercaSENA avisa a sus clientes cuando cambia el estado de su pedido. Hoy existen dos canales, **correo** y **SMS**, y pronto llegarán otros como WhatsApp o notificaciones push. Para no llenar el código de `if (canal.equals(...))`, se usa **Factory Method**: cada creador concreto decide qué notificación fabricar.

Clases principales:

- `CreadorNotificacion` (abstracta): contiene el método fábrica `crearNotificacion()` y la operación `notificar(destino, mensaje)`.
- `CreadorEmail` y `CreadorSms`: creadores concretos.
- `NotificacionEmail` y `NotificacionSms`: productos concretos.
- `ResultadoEnvio`: registro inmutable con el canal, el destino y el texto realmente enviado.

## Reglas de negocio

1. Cada creador fabrica **solo** su tipo de notificación: `CreadorSms` produce notificaciones de canal `"SMS"` y `CreadorEmail` de canal `"EMAIL"`.
2. El mensaje no puede ser nulo ni estar en blanco (`IllegalArgumentException`). Los espacios al inicio y al final se eliminan antes de enviarlo.
3. **Correo válido:** tiene una parte local con letras, dígitos, `.`, `_`, `+` o `-`, luego **una** `@` y luego un dominio con **al menos un punto**, por ejemplo `ana.perez@sena.edu.co`. Si el correo es inválido se lanza `IllegalArgumentException`. Ejemplos inválidos: `ana@`, `@sena.edu.co`, `ana@sena`, `ana perez@sena.co`.
4. **Celular válido:** 10 dígitos que empiezan por `3`, por ejemplo `3001234567`. Si no, se lanza `IllegalArgumentException`.
5. **Límite del SMS:** un SMS tiene como máximo **160 caracteres**. Si el mensaje es más largo, se recorta a 157 caracteres y se le agrega `...`, para un total de **exactamente 160**.

## Tu misión

Este proyecto implementa el patrón **Factory Method** dentro de la tienda en línea **MercaSENA**. El código *compila*, pero tiene **errores sembrados**: algunos los detectan las pruebas que ya existen y otros **no**. Tu trabajo es encontrarlos todos, demostrarlos con pruebas y corregirlos con ayuda de la IA, sin perder el control técnico.

> La fuente de verdad son las **reglas de negocio** de este README. La IA no las conoce si no se las das.

## Protocolo de trabajo (obligatorio)

1. **Prepara el repositorio.** Crea un repositorio en GitHub con este proyecto y haz el primer commit sin cambios: `git commit -m "chore: estado inicial"`.
2. **Predice sin IA (20 min).** Lee este README y el código. Escribe tus hipótesis en `BITACORA_IA.md`, sección 1.
3. **Ejecuta las pruebas.** Corre `mvn test` o las pruebas desde IntelliJ / Eclipse. Anota cuáles fallan.
4. **Demuestra cada error con una prueba.** Por cada error que encuentres, incluidos los que las pruebas actuales no detectan, escribe primero una prueba que **falle**. Haz commit: `test: demuestra <error>`.
5. **Consulta al jurado de IAs.** Envía el mismo prompt a ChatGPT, Gemini y DeepSeek. Usa el prompt de 5 piezas: contexto, tarea, restricciones, formato y criterio de verificación. Registra en la bitácora en qué coincidieron y en qué no.
6. **Corrige.** Aplica la corrección que **tú** entiendes y puedes explicar. La prueba debe pasar. Haz commit: `fix: corrige <error>`.
7. **Refactoriza con IA.** Pide a la IA una mejora de legibilidad que no cambie el comportamiento. Todas las pruebas deben seguir en verde. Haz commit: `refactor: ...`.
8. **Revisa la seguridad.** Pregúntate qué podría hacer un usuario malicioso con este código y anota tu respuesta en la bitácora.
9. **Prepara la defensa.** El instructor te pedirá explicar, **sin IA**, cualquier línea que hayas cambiado.

## Cómo ejecutar

```bash
mvn test
```

Requisitos: JDK 17 o superior y Maven 3.9 o superior, o el Maven que trae IntelliJ IDEA o Eclipse.

## Qué NO hacer

- No borres ni debilites pruebas para que pasen.
- No pegues el proyecto completo en una IA sin explicarle las reglas de negocio.
- No aceptes una corrección que no sabes explicar.

## Referencia del patrón

- https://refactoring.guru/es/design-patterns/factory-method
