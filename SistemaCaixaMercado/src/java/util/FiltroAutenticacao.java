package util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import modelo.Administrador;
import modelo.Usuario;


public class FiltroAutenticacao implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        String pagina = facesContext.getViewRoot().getViewId();
        if (pagina.contains("/index") || pagina.contains("/menuloginadm") || pagina.contains("/menuloginusuario") || pagina.contains("administrador/ADMGerenciar") || pagina.contains("usuario/usuarioGerenciar") || pagina.contains("usuario/usuarioGerenciarADM") || pagina.contains("menuadm") || pagina.contains("menu") || pagina.contains("/ProdutoGerenciarADM") || pagina.contains("/ProdutoAlterarADM") || pagina.contains("produto/ProdutoGerenciar") || pagina.contains("produto/ProdutoAlterar") ) {
            return;
        }
        Administrador usuarioLogado = (Administrador) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/index?faces-redirect=true");
            facesContext.renderResponse();
        }
        Usuario usuarioLogado2 = (Usuario) session.getAttribute("usuarioLogado2");
        if (usuarioLogado2 == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/index?faces-redirect=true");
            facesContext.renderResponse();
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {        

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW; 
    }

}