package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Usuario;
import util.JpaUtil;

public class UsuarioDao implements Serializable { 
    
    public Usuario autenticar(Usuario user){
        Usuario temp = null; // administrador retornado na consulta ao banco
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Usuario> query = manager.createQuery("SELECT a FROM Usuario a WHERE a.unidade = :unidade AND a.senha = :senha",
                Usuario.class); 
        query.setParameter("unidade", user.getUnidade());
        query.setParameter("senha", user.getSenha());
        try{
            temp = query.getSingleResult(); 
        }
        catch(Exception e){ 
            
        }     //aqui poderia haver um tratamento de exceção mais decente
        finally{
            manager.close();
        }        
        return temp;
    }
        
    public Usuario buscarPorNome(String nome) {
        Usuario temp = null;
        EntityManager manager = JpaUtil.getEntityManager();
        String sql = "SELECT a FROM Usuario a WHERE a.nome = :n";
        TypedQuery<Usuario> query = manager.createQuery(sql, Usuario.class);
        query.setParameter("n", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
    
    public Usuario buscarPorNome(Usuario user) {
        Usuario temp = null;
        EntityManager manager = JpaUtil.getEntityManager();
        String sql = "SELECT a FROM Usuario a WHERE a.nome = :n";
        TypedQuery<Usuario> query = manager.createQuery(sql, Usuario.class);
        query.setParameter("n", user.getNome());
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
}