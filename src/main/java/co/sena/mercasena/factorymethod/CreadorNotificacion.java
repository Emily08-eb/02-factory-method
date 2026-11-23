package co.sena.mercasena.factorymethod;

/** Creador del patrón Factory Method. */
public abstract class CreadorNotificacion {

    /** Método fábrica: cada subclase decide qué notificación crear. */
    protected abstract Notificacion crearNotificacion();

    public ResultadoEnvio notificar(String destino, String mensaje) {
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }
        Notificacion notificacion = crearNotificacion();
        return notificacion.enviar(destino, mensaje.strip());
    }
}
