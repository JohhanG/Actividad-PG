public class Contrarrelojista extends Ciclista {
    // Atributo privado
    private double velocidadMaxima;
 
    // Constructor invocando a la clase padre
    public Contrarrelojista(int identificador, String nombre, double velocidadMaxima) {
        super(identificador, nombre);
        this.velocidadMaxima = velocidadMaxima;
    }
 
    // Métodos protegidos (getters y setters)
    protected double getVelocidadMaxima() {
        return velocidadMaxima;
    }
 
    protected void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
 
    @Override
    public String imprimirTipo() {
        return "Es un Contrarrelojista";
    }
 
    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("Tipo: " + imprimirTipo());
        System.out.println("Velocidad máxima: " + velocidadMaxima + " Km/h");
    }
}