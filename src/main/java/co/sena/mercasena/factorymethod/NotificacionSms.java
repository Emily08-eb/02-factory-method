package co.sena.mercasena.factorymethod;

public class NotificacionSms implements Notificacion {

    static final int LIMITE = 160;
    private static final String SUFIJO = "...";

    @Override
    public String canal() {
        return "SMS";
    }

    @Override
    public ResultadoEnvio enviar(String destino, String mensaje) {
        if (destino == null || !destino.matches("^3\\d{9}$")) {
            throw new IllegalArgumentException("Celular inválido: " + destino);
        }

        String texto = mensaje.length() > LIMITE
                ? mensaje.substring(0, LIMITE - SUFIJO.length()) + SUFIJO
                : mensaje;

        return new ResultadoEnvio(canal(), destino, texto);
    }
}