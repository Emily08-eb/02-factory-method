package co.sena.mercasena.factorymethod;

public class CreadorSms extends CreadorNotificacion {

    @Override
    protected Notificacion crearNotificacion() {
        return new NotificacionSms();
    }
}
