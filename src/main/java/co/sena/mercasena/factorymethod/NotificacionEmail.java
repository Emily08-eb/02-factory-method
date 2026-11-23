package co.sena.mercasena.factorymethod;

public class NotificacionEmail implements Notificacion {

    @Override
    public String canal() {
        return "EMAIL";
    }

    @Override
    public ResultadoEnvio enviar(String destino, String mensaje) {
        if (destino == null || !destino.contains("@")) {
            throw new IllegalArgumentException("Correo inválido: " + destino);
        }
        return new ResultadoEnvio(canal(), destino, mensaje);
    }
}
