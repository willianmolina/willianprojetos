package controle;


import dao.UsuarioDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Usuario;


@ManagedBean (name="indexControleUsuario")
@ViewScoped
public class IndexControleUsuario implements Serializable{
    private Usuario user;
    
    public IndexControleUsuario(){
        user = new Usuario();
    }
    
    public String autenticar(){
        UsuarioDao dao = new UsuarioDao();
        Usuario temp;
        temp = dao.autenticar(user);
        if (temp == null){  // se houver erro, método autenticar no dao retorna null
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos", null));
            return null;  //fica na página
        }  
        //seta usuario na Sessao
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        session.setAttribute("usuarioLogado", temp); 
        
        return "menu.xhtml";    // menu.xhtml
    }
    
      public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}