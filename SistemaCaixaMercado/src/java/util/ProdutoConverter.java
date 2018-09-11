package util;

import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Produto;

@FacesConverter(value = "produtoConverter", forClass=Produto.class)
public class ProdutoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Produto temp = null;
        Dao<Produto> dao = new Dao(Produto.class);
        try {
            nome = value;
            temp = dao.buscarPorNomeProduto(nome);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione um Produto"));
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Produto){
            Produto u = (Produto)obj;
            return u.getNome();
        }
        return "";
    }
    
}