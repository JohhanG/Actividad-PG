import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas Unitarias para Equipo y Búsqueda")
public class EquipoTest {

    private Equipo equipo;
    private Velocista v1;
    private Escalador e1;
    private Contrarrelojista c1;

    @BeforeEach
    public void setUp() {
        equipo = new Equipo("Team Colombia", "Colombia");

        v1 = new Velocista(101, "Fernando Gaviria", 1250.5, 68.4);
        v1.setTiempoAcumulado(185);

        e1 = new Escalador(102, "Nairo Quintana", 4.8f, 15.5f);
        e1.setTiempoAcumulado(170);

        c1 = new Contrarrelojista(103, "Rigoberto Urán", 62.3);
        c1.setTiempoAcumulado(178);
    }

    @Test
    @DisplayName("CP05 - Creación e inicialización del equipo")
    public void testCreacionEquipo() {
        assertEquals("Team Colombia", equipo.getNombreEquipo());
        assertEquals("Colombia", equipo.getPais());
        assertNotNull(equipo.getCiclistas());
        assertEquals(0, equipo.getCiclistas().size());
    }

    @Test
    @DisplayName("CP06 - Añadir ciclistas y comprobar tamaño de la lista")
    public void testAnadirCiclistas() {
        equipo.añadirCiclista(v1);
        equipo.añadirCiclista(e1);
        equipo.añadirCiclista(c1);

        assertEquals(3, equipo.getCiclistas().size());
        assertTrue(equipo.getCiclistas().contains(v1));
        assertTrue(equipo.getCiclistas().contains(e1));
        assertTrue(equipo.getCiclistas().contains(c1));
    }

    @Test
    @DisplayName("CP07 - Cálculo acumulativo del tiempo total del equipo")
    public void testCalculoTiempoTotalEquipo() {
        equipo.añadirCiclista(v1);
        equipo.añadirCiclista(e1);
        equipo.añadirCiclista(c1);

        int esperado = 185 + 170 + 178; // 533
        assertEquals(esperado, Equipo.getTiempoTotalEquipo());
    }

    @Test
    @DisplayName("CP08 - Recálculo del tiempo total tras modificar tiempo individual")
    public void testRecalculoTiempoTotal() {
        equipo.añadirCiclista(v1);
        assertEquals(185, Equipo.getTiempoTotalEquipo());

        v1.setTiempoAcumulado(200);
        equipo.calcularTotalTiempos();
        assertEquals(200, Equipo.getTiempoTotalEquipo());
    }

    @Test
    @DisplayName("CP09 - Búsqueda exitosa de ciclista por identificador existente")
    public void testBuscarCiclistaExistente() throws CiclistaNoEncontradoException {
        equipo.añadirCiclista(v1);
        equipo.añadirCiclista(e1);

        Ciclista encontrado = equipo.buscarCiclista(102);
        assertNotNull(encontrado);
        assertEquals("Nairo Quintana", encontrado.getNombre());
        assertEquals(102, encontrado.getIdentificador());
    }

    @Test
    @DisplayName("CP10 - Búsqueda de ciclista inexistente debe lanzar CiclistaNoEncontradoException")
    public void testBuscarCiclistaInexistenteLanzaExcepcion() {
        equipo.añadirCiclista(v1);

        CiclistaNoEncontradoException exception = assertThrows(
                CiclistaNoEncontradoException.class,
                () -> equipo.buscarCiclista(999)
        );

        assertTrue(exception.getMessage().contains("999"));
    }

    @Test
    @DisplayName("CP11 - Reemplazo de lista con setCiclistas actualiza el tiempo total")
    public void testSetCiclistasRecalculaTiempo() {
        List<Ciclista> nuevaLista = new ArrayList<>();
        nuevaLista.add(v1); // 185
        nuevaLista.add(c1); // 178

        equipo.setCiclistas(nuevaLista);
        assertEquals(2, equipo.getCiclistas().size());
        assertEquals(185 + 178, Equipo.getTiempoTotalEquipo());
    }
}
