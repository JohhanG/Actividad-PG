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
 
    // Métodos protegidos requeridos por el enunciado
    protected String getNombreEquipo() {
        return nombreEquipo;
    }
 
    protected void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
 
    protected String getPais() {
        return pais;
    }
 
    protected void setPais(String pais) {
        this.pais = pais;
    }
 
    protected static int getTiempoTotalEquipo() {
        return tiempoTotalEquipo;
    }
 
    protected static void setTiempoTotalEquipo(int tiempoTotal) {
        tiempoTotalEquipo = tiempoTotal;
    
    }
   
    protected List<Ciclista> getCiclistas() {
        return ciclistas;
    }

    protected void setCiclistas(List<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    protected void añadirCiclista(Ciclista ciclista) {
        ciclistas.add(ciclista);
        calcularTotalTiempos();
    }

    protected void calcularTotalTiempos() {
        int total = 0;
        for (Ciclista c : ciclistas) {
            total += c.getTiempoAcumulado();
        }
        tiempoTotalEquipo = total;
    }
 
    protected void listarNombresCiclistas() {
        System.out.println("--- Integrantes del equipo " + nombreEquipo + " ---");
        for (Ciclista c : ciclistas) {
            System.out.println("- ID: " + c.getIdentificador() + " | Nombre: " + c.getNombre());
        }
    }
 
    protected void imprimirDatosEquipo() {
        System.out.println("================================");
        System.out.println("Equipo: " + nombreEquipo);
        System.out.println("País: " + pais);
        System.out.println("Tiempo total acumulado: " + tiempoTotalEquipo + " minutos");
        System.out.println("================================");
    }
 
    protected void imprimirDatosCiclistaPorId(int id) {
        boolean encontrado = false;
        for (Ciclista c : ciclistas) {
            if (c.getIdentificador() == id) {
                System.out.println("\n--- Ciclista Encontrado ---");
                c.imprimirDatos();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("\n[Aviso] No existe un ciclista con el identificador: " + id);
        }
    }
}