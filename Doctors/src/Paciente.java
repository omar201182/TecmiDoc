public class Paciente {
    private static int contadorId = 1;
    private int id;
    private String nombreCompleto;

    public Paciente(String nombreCompleto) {
        this.id = contadorId++;
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    @Override
    public String toString() {
        return "Paciente{id=" + id + ", nombreCompleto='" + nombreCompleto + "'}";
    }
}

