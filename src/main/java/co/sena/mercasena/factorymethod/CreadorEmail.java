package co.sena.mercasena.factorymethod;

public class CreadorEmail extends CreadorNotificacion {

    @Override
    protected Notificacion crearNotificacion() {
        return new NotificacionEmail();
    }
}
