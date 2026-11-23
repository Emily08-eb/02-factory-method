package co.sena.mercasena.factorymethod;

/** Producto del patrón Factory Method. */
public interface Notificacion {

    String canal();

    ResultadoEnvio enviar(String destino, String mensaje);
}
