package jose.pruebatecnica2.logica;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import jose.pruebatecnica2.persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia control = new ControladoraPersistencia();

    //control de Ciudadano
    public void crearCiudadano(Ciudadano ciudadano) {
        control.crearCiudadano(ciudadano);
    }

    //Metodo que recoge los datos del ciudadano de la vista y cargarlos a la BBDD
    public void aniadirCiudadano(String nombre, String apellido, String dni) {
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(nombre);
        ciudadano.setApellido(apellido);
        ciudadano.setDni(dni);
        //Comprobar si la tabla tiene datos
        if (control.verCiudadanos().isEmpty()) {
            control.crearCiudadano(ciudadano);
        }
        // Verificar si el ciudadano ya existe antes de crearlo
        Ciudadano ciudadanoExistente = verCiudadanoConcreto(nombre, apellido, dni);
        if (ciudadanoExistente == null) {
            control.crearCiudadano(ciudadano);
        }
    }

    public List<Ciudadano> verCiudadanos() {
        return control.verCiudadanos();
    }

    //Metodo para encontrar a un ciudadano concreto
    public Ciudadano verCiudadanoConcreto(String nombre, String apellido, String dni) {
        Optional<Ciudadano> ciudadanoOptional = control.verCiudadanos().stream()
                .filter(ciudadano -> ciudadano.getNombre().equalsIgnoreCase(nombre)
                && ciudadano.getApellido().equalsIgnoreCase(apellido)
                && ciudadano.getDni().equalsIgnoreCase(dni))
                .findFirst();
        return ciudadanoOptional.orElse(null);
    }

    //control de Turno
    public void crearTurno(Turno turno) {
        control.crearTurno(turno);
    }

    //Metodo para recoger los datos del turno de la vista y cargarlos a la BBDD
    public void aniadirTurno(LocalDate fechaTurno, String descripcionTurno, String nombreCiudadano, String apellidoCiudadano, String dniCiudadano) {
        Turno turno = new Turno();
        turno.setFecha(fechaTurno);
        turno.setDescripcion(descripcionTurno);
        turno.setEstado("En espera");
        turno.setCiudadano(verCiudadanoConcreto(nombreCiudadano, apellidoCiudadano, dniCiudadano));

        crearTurno(turno);
    }

    public List<Turno> verTurnos() {
        return control.verTurnos();
    }

    public List<Turno> verTurnosFecha(LocalDate fecha) {
        return control.verTurnos().stream()
                .filter(turno -> turno.getFecha().equals(fecha))
                .toList();
    }

    public List<Turno> verTurnosFiltrado(LocalDate fecha, String estado) {
        return control.verTurnos().stream()
                .filter(turno
                        -> turno.getFecha().equals(fecha)
                && turno.getEstado().equalsIgnoreCase(estado))
                .toList();
    }

    public void editarTurno(Turno turno) {
        control.editarTurno(turno);
    }

    public void editarTurnoRecogido(String idTurno, LocalDate fechaTurno, String descripcionTurno, String estadoTurno,
            String nombreCiudadano, String apellidoCiudadano, String dniCiudadano) {

        Turno turno = new Turno();
        turno.setId(Long.parseLong(idTurno));
        turno.setFecha(fechaTurno);
        turno.setDescripcion(descripcionTurno);
        turno.setEstado(estadoTurno);
        turno.setCiudadano(verCiudadanoConcreto(nombreCiudadano, apellidoCiudadano, dniCiudadano));

        editarTurno(turno);
    }
}
