package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Administrador;


@ManagedBean (name="ADMGerenciar")
@ViewScoped
public class ADMGerenciar implements Serializable{   

    private List<Administrador> adms;
    private Dao<Administrador> dao;
    private Administrador novo;
    private Administrador temp;
    private boolean mostraPopupNovo;
    
    public ADMGerenciar(){
        dao = new Dao(Administrador.class);
        novo = new Administrador();
        adms = dao.listarTodos();
        mostraPopupNovo = false; 
    }
    
    public void excluirADM(Administrador a){
        dao.excluir(a.getId());
        adms.remove(a); 
    }
    
    public void inserirADM(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "ADM cadastrado", null));
        adms = dao.listarTodos();
        novo = new Administrador();
    }
    
    public void preparaEditarADM(Administrador u){
        temp = u; 
    }
    
    public void alterarADM(){
        dao.alterar(temp);
    }
    
    public void abrirPopupNovo() {
        this.mostraPopupNovo = true;
    }
    
    public void fecharPopupNovo(){
        mostraPopupNovo = false;
    }
    
    public boolean isMostraPopupNovo() {
        return mostraPopupNovo;
    }

    public void setMostraPopupNovo(boolean mostraPopupNovo) {
        this.mostraPopupNovo = mostraPopupNovo;
    }

    public List<Administrador> getAdms() {
        return adms;
    }

    public void setAdms(List<Administrador> adms) {
        this.adms = adms;
    }

    public Dao<Administrador> getDao() {
        return dao;
    }

    public void setDao(Dao<Administrador> dao) {
        this.dao = dao;
    }

    public Administrador getNovo() {
        return novo;
    }

    public void setNovo(Administrador novo) {
        this.novo = novo;
    }

    public Administrador getTemp() {
        return temp;
    }

    public void setTemp(Administrador temp) {
        this.temp = temp;
    }
    
   
}
