public class Velocista extends Ciclista {
    // Atributos privados
    private double potenciaPromedio;
    private double velocidadPromedioSprint;
 
    // Constructor invocando a la clase padre
    public Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadPromedioSprint) {
        super(identificador, nombre);
        this.potenciaPromedio = potenciaPromedio;
        this.velocidadPromedioSprint = velocidadPromedioSprint;
    }
 
    // Métodos getters y setters
    public double getPotenciaPromedio() {
        return potenciaPromedio;
    }
 
    public void setPotenciaPromedio(double potenciaPromedio) {
        this.potenciaPromedio = potenciaPromedio;
    }
 
    public double getVelocidadPromedioSprint() {
        return velocidadPromedioSprint;
    }
 
    public void setVelocidadPromedioSprint(double velocidadPromedioSprint) {
        this.velocidadPromedioSprint = velocidadPromedioSprint;
    }
 
    @Override
    public String imprimirTipo() {
        return "Es un Velocista";
    }
 
    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("Tipo: " + imprimirTipo());
        System.out.println("Potencia promedio: " + potenciaPromedio + " W");
        System.out.println("Velocidad promedio sprint: " + velocidadPromedioSprint + " Km/h");
    }
}
