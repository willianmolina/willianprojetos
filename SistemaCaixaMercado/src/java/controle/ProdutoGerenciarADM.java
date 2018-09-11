package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Produto;


@ManagedBean (name="ProdutoGerenciarADM")
@ViewScoped
public class ProdutoGerenciarADM implements Serializable{   

    private List<Produto> produtos;
    private Dao<Produto> dao;
    private Produto novo;
    private Produto temp;
    private boolean mostraPopupNovo;
    
    public ProdutoGerenciarADM(){
        dao = new Dao(Produto.class);
        novo = new Produto();
        produtos = dao.listarTodos();
        mostraPopupNovo = false; 
    }
    
    public void excluirProduto(Produto u){
        dao.excluir(u.getId());
        produtos.remove(u); // remove da List
    }
    
    
    public void inserirProduto(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Produto cadastrado", null));
        produtos = dao.listarTodos();
        novo = new Produto();
    }
    
    public void preparaEditarProduto(Produto u){
        temp = u; 
    }
    
    public void alterarProduto(){
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
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setUsuarios(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Dao<Produto> getDao() {
        return dao;
    }

    public void setDao(Dao<Produto> dao) {
        this.dao = dao;
    }

    public Produto getNovo() {
        return novo;
    }

    public void setNovo(Produto novo) {
        this.novo = novo;
    }
    
    public Produto getTemp() {
        return temp;
    }

    public void setTemp(Produto temp) {
        this.temp = temp;
    }
    
    
    
}
