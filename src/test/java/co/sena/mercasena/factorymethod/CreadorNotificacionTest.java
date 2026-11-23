package co.sena.mercasena.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreadorNotificacionTest {

    @Test
    void creadorEmailEnviaPorCorreo() {
        ResultadoEnvio r = new CreadorEmail().notificar("ana.perez@sena.edu.co", "  Tu pedido fue enviado  ");
        assertEquals("EMAIL", r.canal());
        assertEquals("Tu pedido fue enviado", r.texto());
    }

    @Test
    void creadorSmsEnviaPorSms() {
        ResultadoEnvio r = new CreadorSms().notificar("3001234567", "Tu pedido fue enviado");
        assertEquals("SMS", r.canal());
        assertEquals("3001234567", r.destino());
    }

    @Test
    void mensajeVacioNoSePermite() {
        assertThrows(IllegalArgumentException.class, () -> new CreadorEmail().notificar("ana@sena.edu.co", "   "));
    }

    @Test
    void correoSinArrobaEsInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new CreadorEmail().notificar("ana.sena.edu.co", "Hola"));
    }

    @Test
    void celularInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new CreadorSms().notificar("12345", "Hola"));
    }

    @Test
    void correoSinPuntoEnDominioEsInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new CreadorEmail().notificar("ana@sena", "Hola"));
    }
}
