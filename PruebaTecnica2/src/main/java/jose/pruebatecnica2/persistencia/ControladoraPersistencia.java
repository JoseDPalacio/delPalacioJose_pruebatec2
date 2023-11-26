/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jose.pruebatecnica2.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jose.pruebatecnica2.logica.Ciudadano;
import jose.pruebatecnica2.logica.Turno;

/**
 *
 * @author Usuario
 */
public class ControladoraPersistencia {
    CiudadanoJpaController ciudadanojc = new CiudadanoJpaController();
    TurnoJpaController turnojc = new TurnoJpaController();
    
    //Controladora Ciudadano
    public void crearCiudadano(Ciudadano ciudadano){
        ciudadanojc.create(ciudadano);
    }
    
    public List<Ciudadano> verCiudadanos(){
        return ciudadanojc.findCiudadanoEntities();
    }
    
    //Controladora Turno
    public void crearTurno(Turno turno){
        turnojc.create(turno);
    }
    
    public List<Turno> verTurnos(){
        return turnojc.findTurnoEntities();
    }
    
    public void editarTurno(Turno turno){
        try {
            turnojc.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
