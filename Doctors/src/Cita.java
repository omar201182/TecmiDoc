import java.util.Date;

public class Cita {
    private static int contadorId = 1;
    private int id;
    private Date fechaHora;
    private String motivo;
    private Doctor doctor;
    private Paciente paciente;

    public Cita(Date fechaHora, String motivo, Doctor doctor, Paciente paciente) {
        this.id = contadorId++;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public String toString() {
        return "Cita{id=" + id + ", fechaHora=" + fechaHora + ", motivo='" + motivo + "', doctor=" + doctor + ", paciente=" + paciente + "}";
    }
}
