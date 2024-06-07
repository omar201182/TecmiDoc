import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SistemaCitas {
    private List<Doctor> doctores = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Cita> citas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaCitas sistema = new SistemaCitas();
        sistema.ejecutar();
    }

    private void ejecutar() {
        if (!autenticarAdministrador()) {
            System.out.println("Acceso denegado.");
            return;
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (opcion) {
                case 1 -> darAltaDoctor();
                case 2 -> darAltaPaciente();
                case 3 -> crearCita();
                case 4 -> mostrarCitas();
                case 0 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private boolean autenticarAdministrador() {
        System.out.print("Ingrese ID de administrador: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        return Administrador.autenticar(id, password);
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Dar de alta doctor");
        System.out.println("2. Dar de alta paciente");
        System.out.println("3. Crear cita");
        System.out.println("4. Mostrar citas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void darAltaDoctor() {
        System.out.print("Nombre completo del doctor: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        Doctor doctor = new Doctor(nombreCompleto, especialidad);
        doctores.add(doctor);
        System.out.println("Doctor registrado: " + doctor);
    }

    private void darAltaPaciente() {
        System.out.print("Nombre completo del paciente: ");
        String nombreCompleto = scanner.nextLine();
        Paciente paciente = new Paciente(nombreCompleto);
        pacientes.add(paciente);
        System.out.println("Paciente registrado: " + paciente);
    }

    private void crearCita() {
        if (doctores.isEmpty() || pacientes.isEmpty()) {
            System.out.println("Debe haber al menos un doctor y un paciente registrados para crear una cita.");
            return;
        }

        System.out.print("Fecha y hora de la cita (dd-MM-yyyy HH:mm): ");
        String fechaHoraStr = scanner.nextLine();
        Date fechaHora = convertirFecha(fechaHoraStr);
        if (fechaHora == null) {
            System.out.println("Fecha y hora no válidas.");
            return;
        }

        System.out.print("Motivo de la cita: ");
        String motivo = scanner.nextLine();

        System.out.println("Seleccione un doctor:");
        for (int i = 0; i < doctores.size(); i++) {
            System.out.println((i + 1) + ". " + doctores.get(i).getNombreCompleto());
        }
        int doctorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        System.out.println("Seleccione un paciente:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNombreCompleto());
        }
        int pacienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        Doctor doctor = doctores.get(doctorIndex);
        Paciente paciente = pacientes.get(pacienteIndex);
        Cita cita = new Cita(fechaHora, motivo, doctor, paciente);
        citas.add(cita);
        System.out.println("Cita creada: " + cita);
    }

    private Date convertirFecha(String fechaHoraStr) {
        try {
            java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm");
            return formato.parse(fechaHoraStr);
        } catch (java.text.ParseException e) {
            return null;
        }
    }

    private void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        System.out.println("\n--- Citas Registradas ---");
        for (Cita cita : citas) {
            System.out.println(cita);
        }
    }
}
