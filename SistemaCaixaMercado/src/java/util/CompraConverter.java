package util;

import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Compra;

@FacesConverter(value = "compraConverter", forClass=Compra.class)
public class CompraConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String codigo;
        Compra temp = null;
        Dao<Compra> dao = new Dao(Compra.class);
        try {
            codigo = value;
            temp = dao.buscarPorCodCompra(codigo);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione uma Compra"));
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Compra){
            Compra u = (Compra)obj;
            return u.getCodigo();
        }
        return "";
    }
    
}