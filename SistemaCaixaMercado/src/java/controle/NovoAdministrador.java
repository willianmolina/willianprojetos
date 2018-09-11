package controle;

import dao.Dao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Administrador;

@ManagedBean (name="novoAdministrador")
@ViewScoped
public class NovoAdministrador implements Serializable {
    private Administrador administrador;
    private Dao<Administrador> dao;  
    
    public NovoAdministrador(){
        administrador = new Administrador();
        dao = new Dao(Administrador.class);
    }
    
    public void inserirAdministrador(){
        dao.inserir(administrador);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Administrador cadastrado", null));
        
        administrador = new Administrador();
    }
    
    
    public Administrador getAdministrador() { 
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Dao<Administrador> getDao() {
        return dao;
    }

    public void setDao(Dao<Administrador> dao) {
        this.dao = dao;
    }
       
}