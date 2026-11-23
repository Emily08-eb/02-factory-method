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

        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }

        String mensajeLimpio = mensaje.trim();

        String texto = mensajeLimpio.length() > LIMITE
                ? mensajeLimpio.substring(0, LIMITE - SUFIJO.length()) + SUFIJO
                : mensajeLimpio;

        return new ResultadoEnvio(canal(), destino, texto);
    }
}