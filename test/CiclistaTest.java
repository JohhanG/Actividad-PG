import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas Unitarias para Ciclista y sus Especialidades")
public class CiclistaTest {

    private Velocista velocista;
    private Escalador escalador;
    private Contrarrelojista contrarrelojista;

    @BeforeEach
    public void setUp() {
        velocista = new Velocista(101, "Fernando Gaviria", 1250.5, 68.4);
        velocista.setTiempoAcumulado(185);

        escalador = new Escalador(102, "Nairo Quintana", 4.8f, 15.5f);
        escalador.setTiempoAcumulado(170);

        contrarrelojista = new Contrarrelojista(103, "Rigoberto Urán", 62.3);
        contrarrelojista.setTiempoAcumulado(178);
    }

    @Test
    @DisplayName("CP01 - Validación de datos base en clase abstracta Ciclista")
    public void testDatosBaseCiclista() {
        assertEquals(101, velocista.getIdentificador());
        assertEquals("Fernando Gaviria", velocista.getNombre());
        assertEquals(185, velocista.getTiempoAcumulado());

        velocista.setNombre("Nuevo Fernando");
        velocista.setIdentificador(999);
        velocista.setTiempoAcumulado(200);

        assertEquals(999, velocista.getIdentificador());
        assertEquals("Nuevo Fernando", velocista.getNombre());
        assertEquals(200, velocista.getTiempoAcumulado());
    }

    @Test
    @DisplayName("CP02 - Validación de especialidad Velocista y su tipo")
    public void testVelocista() {
        assertEquals("Es un Velocista", velocista.imprimirTipo());
        assertEquals(1250.5, velocista.getPotenciaPromedio(), 0.001);
        assertEquals(68.4, velocista.getVelocidadPromedioSprint(), 0.001);

        velocista.setPotenciaPromedio(1300.0);
        velocista.setVelocidadPromedioSprint(70.0);

        assertEquals(1300.0, velocista.getPotenciaPromedio(), 0.001);
        assertEquals(70.0, velocista.getVelocidadPromedioSprint(), 0.001);
    }

    @Test
    @DisplayName("CP03 - Validación de especialidad Escalador y su tipo")
    public void testEscalador() {
        assertEquals("Es un Escalador", escalador.imprimirTipo());
        assertEquals(4.8f, escalador.getAceleracionPromedio(), 0.001f);
        assertEquals(15.5f, escalador.getGradoRampa(), 0.001f);

        escalador.setAceleracionPromedio(5.0f);
        escalador.setGradoRampa(18.0f);

        assertEquals(5.0f, escalador.getAceleracionPromedio(), 0.001f);
        assertEquals(18.0f, escalador.getGradoRampa(), 0.001f);
    }

    @Test
    @DisplayName("CP04 - Validación de especialidad Contrarrelojista y su tipo")
    public void testContrarrelojista() {
        assertEquals("Es un Contrarrelojista", contrarrelojista.imprimirTipo());
        assertEquals(62.3, contrarrelojista.getVelocidadMaxima(), 0.001);

        contrarrelojista.setVelocidadMaxima(66.5);
        assertEquals(66.5, contrarrelojista.getVelocidadMaxima(), 0.001);
    }
}
