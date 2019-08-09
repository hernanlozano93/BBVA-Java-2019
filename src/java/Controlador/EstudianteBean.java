/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.ejb.EJB;
import Modelo.Estudiante;
import Modelo.DAO.EstudianteFacadeREST;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Hernan Lozano
 */
@ManagedBean
@RequestScoped
public class EstudianteBean {
    @EJB
    private EstudianteFacadeREST estudiantesFacade;

    private int identificacion;
    private String nombre;
    private String apellido;
    Estudiante E = new Estudiante();
            
    public EstudianteBean() {
    }
    
    public List<Estudiante> getEstudiantes(){
        return estudiantesFacade.findAll();
    }
    
    public String crear(){
                
        E.setIdentificacion(identificacion);
        E.setNombre(nombre);
        E.setApellido(apellido);
        estudiantesFacade.create(E);
        
        return "estudiante";
        
    }
    
//    public String editar(){
//        
//        Estudiante E = new Estudiante();
//        E.setNombre(nombre);
//        E.setApellido(apellido);
//        estudiantesFacade.edit(E);
//        
//        return "estudiante";
//        
//    }
    
    public void editar(Estudiante es){
        estudiantesFacade.edit(es);
//        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se modificó"));
    }
  

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }    

}
