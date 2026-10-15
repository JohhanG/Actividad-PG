public class Escalador extends Ciclista {
    // Atributos privados
    private float aceleracionPromedio;
    private float gradoRampa;
 
    // Constructor invocando a la clase padre
    public Escalador(int identificador, String nombre, float aceleracionPromedio, float gradoRampa) {
        super(identificador, nombre);
        this.aceleracionPromedio = aceleracionPromedio;
        this.gradoRampa = gradoRampa;
    }
 
    // Métodos protegidos (getters y setters)
    protected float getAceleracionPromedio() {
        return aceleracionPromedio;
    }
 
    protected void setAceleracionPromedio(float aceleracionPromedio) {
        this.aceleracionPromedio = aceleracionPromedio;
    }
 
    protected float getGradoRampa() {
        return gradoRampa;
    }
 
    protected void setGradoRampa(float gradoRampa) {
        this.gradoRampa = gradoRampa;
    }
 
    @Override
    public String imprimirTipo() {
        return "Es un Escalador";
    }
 
    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("Tipo: " + imprimirTipo());
        System.out.println("Aceleración promedio en subida: " + aceleracionPromedio + " m/s2");
        System.out.println("Grado de rampa soportada: " + gradoRampa + " grados");
    }
}
