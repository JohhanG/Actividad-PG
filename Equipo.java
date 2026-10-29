import java.util.ArrayList;
import java.util.List;
 
public class Equipo {
    // Atributos privados
    private String nombreEquipo;
    private String pais;
    private static int tiempoTotalEquipo = 0; // Atributo estático
    private List<Ciclista> ciclistas;
 
    // Constructor
    public Equipo(String nombreEquipo, String pais) {
        this.nombreEquipo = nombreEquipo;
        this.pais = pais;
        this.ciclistas = new ArrayList<>();
    }
 
    // Métodos getters y setters
    public String getNombreEquipo() {
        return nombreEquipo;
    }
 
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
 
    public String getPais() {
        return pais;
    }
 
    public void setPais(String pais) {
        this.pais = pais;
    }
 
    public static int getTiempoTotalEquipo() {
        return tiempoTotalEquipo;
    }
 
    public static void setTiempoTotalEquipo(int tiempoTotal) {
        tiempoTotalEquipo = tiempoTotal;
    }
   
    public List<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(List<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
        calcularTotalTiempos();
    }

    // Añadir ciclista y recalcular tiempo total acumulado
    public void añadirCiclista(Ciclista ciclista) {
        ciclistas.add(ciclista);
        calcularTotalTiempos();
    }

    // Métodos alias para compatibilidad
    public void anadirCiclista(Ciclista ciclista) {
        añadirCiclista(ciclista);
    }

    public void aadirCiclista(Ciclista ciclista) {
        añadirCiclista(ciclista);
    }

    // Calcula el total de tiempos de todos los ciclistas del equipo
    public void calcularTotalTiempos() {
        int total = 0;
        for (Ciclista c : ciclistas) {
            total += c.getTiempoAcumulado();
        }
        tiempoTotalEquipo = total;
    }
 
    // Listar los nombres e identificadores de los integrantes
    public void listarNombresCiclistas() {
        System.out.println("--- Integrantes del equipo " + nombreEquipo + " ---");
        for (Ciclista c : ciclistas) {
            System.out.println("- ID: " + c.getIdentificador() + " | Nombre: " + c.getNombre());
        }
    }
 
    // Imprimir datos generales del equipo
    public void imprimirDatosEquipo() {
        System.out.println("================================");
        System.out.println("Equipo: " + nombreEquipo);
        System.out.println("País: " + pais);
        System.out.println("Tiempo total acumulado: " + tiempoTotalEquipo + " minutos");
        System.out.println("================================");
    }

    // Busca un ciclista por su identificador. Si no existe, lanza CiclistaNoEncontradoException
    public Ciclista buscarCiclista(int id) throws CiclistaNoEncontradoException {
        for (Ciclista c : ciclistas) {
            if (c.getIdentificador() == id) {
                return c;
            }
        }
        throw new CiclistaNoEncontradoException(id);
    }
 
    // Imprime los datos del ciclista buscado por ID utilizando la excepción personalizada
    public void imprimirDatosCiclistaPorId(int id) {
        try {
            Ciclista c = buscarCiclista(id);
            System.out.println("\n--- Ciclista Encontrado ---");
            c.imprimirDatos();
        } catch (CiclistaNoEncontradoException e) {
            System.out.println("\n[Aviso] " + e.getMessage());
        }
    }
}
