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
    
    public List<Ciudadano> verCiudadanos(){
        return control.verCiudadanos();
    }
    
    public List<Ciudadano> verCiduadanosId(Long id){
        return control.verCiudadanos().stream().filter(ciudadano -> ciudadano.getId()==id).toList();
    }
    
    //control Turno
    public void crearTurno(Turno turno){
        control.crearTurno(turno);
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
