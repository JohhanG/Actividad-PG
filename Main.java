import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Crear equipo
        Equipo equipo = new Equipo("Team Colombia", "Colombia");

        // 2. Instanciar ciclistas de cada especialidad
        Velocista v1 = new Velocista(101, "Fernando Gaviria", 1250.5, 68.4);
        v1.setTiempoAcumulado(185);
        Escalador e1 = new Escalador(102, "Nairo Quintana", 4.8f, 15.5f);
        e1.setTiempoAcumulado(170);
        Contrarrelojista c1 = new Contrarrelojista(103, "Rigoberto Urán", 62.3);
        c1.setTiempoAcumulado(178);

        // 3. Añadir al equipo
        equipo.añadirCiclista(v1);
        equipo.añadirCiclista(e1);
        equipo.añadirCiclista(c1);

        // 4. Menú interactivo
        int opcion = -1;
        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Ver datos del equipo");
            System.out.println("2. Listar nombres de ciclistas");
            System.out.println("3. Buscar ciclista por identificador");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                continue;
            }

            switch (opcion) {
                case 1:
                    equipo.imprimirDatosEquipo();
                    break;
                case 2:
                    equipo.listarNombresCiclistas();
                    break;
                case 3:
                    System.out.print("Ingrese el identificador del ciclista: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        equipo.imprimirDatosCiclistaPorId(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: el identificador debe ser un número entero.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
