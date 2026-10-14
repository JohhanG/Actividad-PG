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
 
    // Métodos protegidos (getters y setters)
    protected double getPotenciaPromedio() {
        return potenciaPromedio;
    }
 
    protected void setPotenciaPromedio(double potenciaPromedio) {
        this.potenciaPromedio = potenciaPromedio;
    }
 
    protected double getVelocidadPromedioSprint() {
        return velocidadPromedioSprint;
    }
 
    protected void setVelocidadPromedioSprint(double velocidadPromedioSprint) {
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
