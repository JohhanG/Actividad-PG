import java.util.ArrayList;
import java.util.List;

/**
 * Suite de Pruebas Unitarias para el proyecto Actividad-PG.
 * Ejecutable de forma autónoma sin dependencias externas (Zero-dependency Test Runner).
 *
 * Para ejecutar:
 *   javac *.java
 *   java PruebasUnitarias
 */
public class PruebasUnitarias {

    private static int pruebasEjecutadas = 0;
    private static int pruebasExitosas = 0;
    private static int pruebasFallidas = 0;

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("       EJECUCIÓN DE PRUEBAS UNITARIAS - ACTIVIDAD-PG           ");
        System.out.println("===============================================================\n");

        // 1. Pruebas de la clase base Ciclista y herencia
        ejecutarPrueba("Ciclista - Atributos base y constructor", PruebasUnitarias::testCiclistaAtributosBase);
        ejecutarPrueba("Ciclista - Modificación de atributos con setters", PruebasUnitarias::testCiclistaSetters);

        // 2. Pruebas de la subclase Velocista
        ejecutarPrueba("Velocista - Constructor y atributos específicos", PruebasUnitarias::testVelocistaAtributos);
        ejecutarPrueba("Velocista - Método imprimirTipo()", PruebasUnitarias::testVelocistaImprimirTipo);

        // 3. Pruebas de la subclase Escalador
        ejecutarPrueba("Escalador - Constructor y atributos específicos", PruebasUnitarias::testEscaladorAtributos);
        ejecutarPrueba("Escalador - Método imprimirTipo()", PruebasUnitarias::testEscaladorImprimirTipo);

        // 4. Pruebas de la subclase Contrarrelojista
        ejecutarPrueba("Contrarrelojista - Constructor y velocidad máxima", PruebasUnitarias::testContrarrelojistaAtributos);
        ejecutarPrueba("Contrarrelojista - Método imprimirTipo()", PruebasUnitarias::testContrarrelojistaImprimirTipo);

        // 5. Pruebas de la clase Equipo
        ejecutarPrueba("Equipo - Inicialización y atributos base", PruebasUnitarias::testEquipoCreacion);
        ejecutarPrueba("Equipo - Añadir ciclistas y tamaño de lista", PruebasUnitarias::testEquipoAnadirCiclistas);
        ejecutarPrueba("Equipo - Polimorfismo con distintas especialidades", PruebasUnitarias::testEquipoPolimorfismo);
        ejecutarPrueba("Equipo - Cálculo automático de tiempo total acumulado", PruebasUnitarias::testEquipoCalculoTiempoTotal);
        ejecutarPrueba("Equipo - Recálculo de tiempo al modificar ciclistas", PruebasUnitarias::testEquipoRecalculoTiempo);
        ejecutarPrueba("Equipo - Búsqueda exitosa de ciclista por ID", PruebasUnitarias::testEquipoBuscarCiclistaExistente);
        ejecutarPrueba("Equipo - Búsqueda fallida lanza CiclistaNoEncontradoException", PruebasUnitarias::testEquipoBuscarCiclistaInexistenteLanzaExcepcion);
        ejecutarPrueba("Equipo - Actualización mediante setCiclistas() recalcula tiempo", PruebasUnitarias::testSetCiclistasRecalculaTiempo);
        ejecutarPrueba("Equipo - Modificación de nombre y país", PruebasUnitarias::testEquipoSetters);

        // 6. Pruebas de la excepción CiclistaNoEncontradoException
        ejecutarPrueba("Excepción - Mensaje descriptivo con ID correcto", PruebasUnitarias::testExcepcionMensaje);

        // Resumen final
        System.out.println("\n===============================================================");
        System.out.println("                 RESUMEN DE PRUEBAS UNITARIAS                  ");
        System.out.println("===============================================================");
        System.out.println("Total ejecutadas : " + pruebasEjecutadas);
        System.out.println("Exitosas [PASS]  : " + pruebasExitosas);
        System.out.println("Fallidas [FAIL]  : " + pruebasFallidas);

        if (pruebasFallidas == 0) {
            System.out.println("\n>>> RESULTADO: TODAS LAS PRUEBAS PASARON SATISFACTORIAMENTE <<<\n");
            System.exit(0);
        } else {
            System.err.println("\n>>> RESULTADO: ALGUNAS PRUEBAS FALLARON <<<\n");
            System.exit(1);
        }
    }

    // --- CASOS DE PRUEBA ---

    public static void testCiclistaAtributosBase() {
        // Usamos una subclase concreta para probar la clase abstracta
        Velocista c = new Velocista(1, "Egan Bernal", 1100.0, 60.0);
        afirmarIgualdad(1, c.getIdentificador(), "El ID debe ser 1");
        afirmarIgualdad("Egan Bernal", c.getNombre(), "El nombre debe ser Egan Bernal");
        afirmarIgualdad(0, c.getTiempoAcumulado(), "El tiempo inicial debe ser 0");
    }

    public static void testCiclistaSetters() {
        Velocista c = new Velocista(1, "Ciclista Temp", 1000.0, 50.0);
        c.setIdentificador(99);
        c.setNombre("Nuevo Nombre");
        c.setTiempoAcumulado(120);

        afirmarIgualdad(99, c.getIdentificador(), "El ID modificado debe ser 99");
        afirmarIgualdad("Nuevo Nombre", c.getNombre(), "El nombre modificado debe ser 'Nuevo Nombre'");
        afirmarIgualdad(120, c.getTiempoAcumulado(), "El tiempo acumulado modificado debe ser 120");
    }

    public static void testVelocistaAtributos() {
        Velocista v = new Velocista(101, "Fernando Gaviria", 1250.5, 68.4);
        afirmarVerdadero(Math.abs(v.getPotenciaPromedio() - 1250.5) < 0.001, "Potencia promedio debe ser 1250.5");
        afirmarVerdadero(Math.abs(v.getVelocidadPromedioSprint() - 68.4) < 0.001, "Velocidad promedio sprint debe ser 68.4");

        v.setPotenciaPromedio(1300.0);
        v.setVelocidadPromedioSprint(70.0);
        afirmarVerdadero(Math.abs(v.getPotenciaPromedio() - 1300.0) < 0.001, "Potencia modificada debe ser 1300.0");
        afirmarVerdadero(Math.abs(v.getVelocidadPromedioSprint() - 70.0) < 0.001, "Velocidad sprint modificada debe ser 70.0");
    }

    public static void testVelocistaImprimirTipo() {
        Velocista v = new Velocista(101, "Fernando Gaviria", 1250.5, 68.4);
        afirmarIgualdad("Es un Velocista", v.imprimirTipo(), "imprimirTipo() debe retornar 'Es un Velocista'");
    }

    public static void testEscaladorAtributos() {
        Escalador e = new Escalador(102, "Nairo Quintana", 4.8f, 15.5f);
        afirmarVerdadero(Math.abs(e.getAceleracionPromedio() - 4.8f) < 0.001f, "Aceleración promedio debe ser 4.8");
        afirmarVerdadero(Math.abs(e.getGradoRampa() - 15.5f) < 0.001f, "Grado de rampa debe ser 15.5");

        e.setAceleracionPromedio(5.2f);
        e.setGradoRampa(18.0f);
        afirmarVerdadero(Math.abs(e.getAceleracionPromedio() - 5.2f) < 0.001f, "Aceleración modificada debe ser 5.2");
        afirmarVerdadero(Math.abs(e.getGradoRampa() - 18.0f) < 0.001f, "Grado rampa modificado debe ser 18.0");
    }

    public static void testEscaladorImprimirTipo() {
        Escalador e = new Escalador(102, "Nairo Quintana", 4.8f, 15.5f);
        afirmarIgualdad("Es un Escalador", e.imprimirTipo(), "imprimirTipo() debe retornar 'Es un Escalador'");
    }

    public static void testContrarrelojistaAtributos() {
        Contrarrelojista c = new Contrarrelojista(103, "Rigoberto Urán", 62.3);
        afirmarVerdadero(Math.abs(c.getVelocidadMaxima() - 62.3) < 0.001, "Velocidad máxima debe ser 62.3");

        c.setVelocidadMaxima(65.0);
        afirmarVerdadero(Math.abs(c.getVelocidadMaxima() - 65.0) < 0.001, "Velocidad máxima modificada debe ser 65.0");
    }

    public static void testContrarrelojistaImprimirTipo() {
        Contrarrelojista c = new Contrarrelojista(103, "Rigoberto Urán", 62.3);
        afirmarIgualdad("Es un Contrarrelojista", c.imprimirTipo(), "imprimirTipo() debe retornar 'Es un Contrarrelojista'");
    }

    public static void testEquipoCreacion() {
        Equipo equipo = new Equipo("Team Colombia", "Colombia");
        afirmarIgualdad("Team Colombia", equipo.getNombreEquipo(), "El nombre debe ser Team Colombia");
        afirmarIgualdad("Colombia", equipo.getPais(), "El país debe ser Colombia");
        afirmarIgualdad(0, equipo.getCiclistas().size(), "La lista de ciclistas debe iniciar vacía");
    }

    public static void testEquipoAnadirCiclistas() {
        Equipo equipo = new Equipo("Movistar Team", "España");
        Velocista v = new Velocista(201, "Ciclista 1", 1000.0, 55.0);
        Escalador e = new Escalador(202, "Ciclista 2", 4.0f, 12.0f);

        equipo.añadirCiclista(v);
        afirmarIgualdad(1, equipo.getCiclistas().size(), "Debe haber 1 ciclista en el equipo");

        equipo.añadirCiclista(e);
        afirmarIgualdad(2, equipo.getCiclistas().size(), "Debe haber 2 ciclistas en el equipo");
    }

    public static void testEquipoPolimorfismo() {
        Equipo equipo = new Equipo("Ineos", "Gran Bretaña");
        Ciclista c1 = new Velocista(301, "Velo", 1100, 60);
        Ciclista c2 = new Escalador(302, "Esca", 4.5f, 14.0f);
        Ciclista c3 = new Contrarrelojista(303, "Crono", 61.5);

        equipo.añadirCiclista(c1);
        equipo.añadirCiclista(c2);
        equipo.añadirCiclista(c3);

        afirmarIgualdad("Es un Velocista", equipo.getCiclistas().get(0).imprimirTipo(), "El primer elemento debe responder como Velocista");
        afirmarIgualdad("Es un Escalador", equipo.getCiclistas().get(1).imprimirTipo(), "El segundo elemento debe responder como Escalador");
        afirmarIgualdad("Es un Contrarrelojista", equipo.getCiclistas().get(2).imprimirTipo(), "El tercer elemento debe responder como Contrarrelojista");
    }

    public static void testEquipoCalculoTiempoTotal() {
        Equipo equipo = new Equipo("Team Colombia", "Colombia");
        Velocista v = new Velocista(101, "Fernando Gaviria", 1250.5, 68.4);
        v.setTiempoAcumulado(185);
        Escalador e = new Escalador(102, "Nairo Quintana", 4.8f, 15.5f);
        e.setTiempoAcumulado(170);
        Contrarrelojista c = new Contrarrelojista(103, "Rigoberto Urán", 62.3);
        c.setTiempoAcumulado(178);

        equipo.añadirCiclista(v);
        equipo.añadirCiclista(e);
        equipo.añadirCiclista(c);

        int esperado = 185 + 170 + 178; // 533 minutos
        afirmarIgualdad(esperado, Equipo.getTiempoTotalEquipo(), "El tiempo total acumulado debe ser 533");
    }

    public static void testEquipoRecalculoTiempo() {
        Equipo equipo = new Equipo("Quick-Step", "Bélgica");
        Velocista v = new Velocista(401, "Remco", 1200, 65);
        v.setTiempoAcumulado(100);
        equipo.añadirCiclista(v);

        afirmarIgualdad(100, Equipo.getTiempoTotalEquipo(), "Tiempo inicial debe ser 100");

        // Modificamos el tiempo del ciclista y recalculamos
        v.setTiempoAcumulado(150);
        equipo.calcularTotalTiempos();

        afirmarIgualdad(150, Equipo.getTiempoTotalEquipo(), "Tiempo recalculado debe ser 150");
    }

    public static void testEquipoBuscarCiclistaExistente() {
        Equipo equipo = new Equipo("Team Colombia", "Colombia");
        Escalador e = new Escalador(102, "Nairo Quintana", 4.8f, 15.5f);
        equipo.añadirCiclista(e);

        try {
            Ciclista encontrado = equipo.buscarCiclista(102);
            afirmarIgualdad("Nairo Quintana", encontrado.getNombre(), "El ciclista encontrado debe ser Nairo Quintana");
            afirmarIgualdad(102, encontrado.getIdentificador(), "El ID debe coincidir");
        } catch (CiclistaNoEncontradoException ex) {
            lanzarFallo("No debió lanzar excepción al buscar ciclista existente con ID 102");
        }
    }

    public static void testEquipoBuscarCiclistaInexistenteLanzaExcepcion() {
        Equipo equipo = new Equipo("Team Colombia", "Colombia");
        Velocista v = new Velocista(101, "Fernando Gaviria", 1250.5, 68.4);
        equipo.añadirCiclista(v);

        boolean excepcionLanzada = false;
        try {
            equipo.buscarCiclista(999); // ID no existente
        } catch (CiclistaNoEncontradoException ex) {
            excepcionLanzada = true;
        }

        afirmarVerdadero(excepcionLanzada, "Debe lanzar CiclistaNoEncontradoException al buscar ID no registrado (999)");
    }

    public static void testSetCiclistasRecalculaTiempo() {
        Equipo equipo = new Equipo("Bora", "Alemania");
        List<Ciclista> lista = new ArrayList<>();

        Velocista v = new Velocista(501, "Ciclista A", 1000, 60);
        v.setTiempoAcumulado(80);
        Contrarrelojista c = new Contrarrelojista(502, "Ciclista B", 60);
        c.setTiempoAcumulado(95);

        lista.add(v);
        lista.add(c);

        equipo.setCiclistas(lista);
        afirmarIgualdad(175, Equipo.getTiempoTotalEquipo(), "setCiclistas debe recalcular tiempo total a 175 (80 + 95)");
    }

    public static void testEquipoSetters() {
        Equipo equipo = new Equipo("Equipo Original", "País Original");
        equipo.setNombreEquipo("Astana Qazaqstan");
        equipo.setPais("Kazajistán");

        afirmarIgualdad("Astana Qazaqstan", equipo.getNombreEquipo(), "Nombre debe ser actualizado");
        afirmarIgualdad("Kazajistán", equipo.getPais(), "País debe ser actualizado");
    }

    public static void testExcepcionMensaje() {
        int idInexistente = 777;
        CiclistaNoEncontradoException ex = new CiclistaNoEncontradoException(idInexistente);
        String mensaje = ex.getMessage();
        afirmarVerdadero(mensaje != null && mensaje.contains("777"), "El mensaje de la excepción debe incluir el ID 777");
    }

    // --- MÉTODOS DE ASERCIÓN Y UTILIDADES ---

    private static void ejecutarPrueba(String nombre, Runnable caso) {
        pruebasEjecutadas++;
        try {
            caso.run();
            pruebasExitosas++;
            System.out.println("  [PASS] " + nombre);
        } catch (Throwable t) {
            pruebasFallidas++;
            System.err.println("  [FAIL] " + nombre + " -> " + t.getMessage());
        }
    }

    private static void afirmarIgualdad(Object esperado, Object actual, String mensaje) {
        if (esperado == null && actual == null) return;
        if (esperado != null && esperado.equals(actual)) return;
        lanzarFallo(mensaje + " | Esperado: [" + esperado + "] pero se obtuvo: [" + actual + "]");
    }

    private static void afirmarVerdadero(boolean condicion, String mensaje) {
        if (!condicion) {
            lanzarFallo(mensaje + " | Se esperaba 'true' pero fue 'false'");
        }
    }

    private static void lanzarFallo(String detalle) {
        throw new AssertionError(detalle);
    }
}
