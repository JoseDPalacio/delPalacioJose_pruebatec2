/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jose.pruebatecnica2.logica;

import java.time.LocalDate;
import java.util.List;
import jose.pruebatecnica2.persistencia.ControladoraPersistencia;

/**
 *
 * @author Usuario
 */
public class Controladora {
    ControladoraPersistencia control = new ControladoraPersistencia();
    
    //control Ciudadano
    public void crearCiudadano(Ciudadano ciudadano){
        control.crearCiudadano(ciudadano);
    }
    
    //Metodo que recoge los datos del ciudadano de la vista y los procesa para insertar en la BBDD
    public void aniadirCiudadano(String nombre, String apellido, String dni){
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(nombre);
        ciudadano.setApellido(apellido);
        ciudadano.setDni(dni);
        Ciudadano ciudComaparador = verCiudadanoConcreto(nombre, apellido, dni);
        //Comprobar si la tabla tiene datos o si ya existe el ciudadano
        if(control.verCiudadanos().isEmpty() || !compararCiuadano(ciudadano, ciudComaparador)){
            control.crearCiudadano(ciudadano);
        }
    }
    
    public List<Ciudadano> verCiudadanos(){
        return control.verCiudadanos();
    }
    
    public List<Ciudadano> verCiduadanosId(Long id){
        return control.verCiudadanos().stream().filter(ciudadano -> ciudadano.getId()==id).toList();
    }
    
    public Ciudadano verCiudadanoConcreto(String nombre, String apellido, String dni){
        return control.verCiudadanos().stream()
                .filter(ciudadano->
                    ciudadano.getNombre().equalsIgnoreCase(nombre) &&
                    ciudadano.getApellido().equalsIgnoreCase(apellido) &&
                    ciudadano.getDni().equalsIgnoreCase(dni))
                .findFirst().get();
    }
    
    public boolean compararCiuadano(Ciudadano ciud, Ciudadano comp){
        return ciud.getNombre().equalsIgnoreCase(comp.getNombre())&&
                ciud.getApellido().equalsIgnoreCase(comp.getApellido())&&
                ciud.getDni().equalsIgnoreCase(comp.getDni());
    }
    
    //control Turno
    public void crearTurno(Turno turno){
        control.crearTurno(turno);
    }
    
    public void aniadirTurno(LocalDate fecha, String descripcion, String nombreC, String apellidoC, String dniC){
        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setDescripcion(descripcion);
        turno.setEstado("En espera");
        turno.setCiudadano(verCiudadanoConcreto(nombreC, apellidoC, dniC));
        
        crearTurno(turno);
    }
    
    public List<Turno> verTurnos(){
        return control.verTurnos();
    }
    
    public List<Turno> verTurnosFiltrado(LocalDate fecha, String estado){
        return control.verTurnos().stream()
                .filter(turno -> 
                        turno.getFecha().equals(fecha) && 
                        turno.getEstado().equalsIgnoreCase(estado))
                .toList();
    }
    
    public void editarTurno(Turno turno){
        control.editarTurno(turno);
    }
}
