package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Compra;
import modelo.Produto;
import modelo.Usuario;
import util.JpaUtil;

/**
* Classe genérica para persistir objetos. 
 */
public class Dao <T> implements Serializable {

    private final Class<T> classe;
    EntityManager manager;

    public Dao(Class<T> classe) {
        this.classe = classe;
    }

    public T alterar(T objeto) {
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        objeto = manager.merge(objeto);
        manager.getTransaction().commit();
        manager.close();
        return objeto;
    }

    public T buscarPorCodigo(Object id) {
        T objeto;
        manager = JpaUtil.getEntityManager();
        objeto = manager.find(classe, id);
        manager.close();
        return objeto;
    }

    public void excluir(Integer id) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        T temp = manager.find(classe, id);
        manager.remove(temp);
        tx.commit();
        manager.close();
    }

     public void inserir(T objeto) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(objeto);
        tx.commit();       
        return;
    }

    public List<T> listarTodos() {        
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        List<T> lista = manager.createQuery(query).getResultList();
        manager.close();      
        return lista;
    }
    
    
    public Usuario buscarPorNomeUsuario(String nome) {
        Usuario temp = new Usuario();
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT u FROM Usuario u WHERE u.nome = :nome";
        TypedQuery<Usuario> query = manager.createQuery(sql, Usuario.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
    
        public Produto buscarPorNomeProduto(String nome) {
        Produto temp = new Produto();
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT u FROM Produto u WHERE u.nome = :nome";
        TypedQuery<Produto> query = manager.createQuery(sql, Produto.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
        
        public Compra buscarPorCodCompra(String codigo) {
        Compra temp = new Compra();
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT u FROM Compra u WHERE u.codigo = :codigo";
        TypedQuery<Compra> query = manager.createQuery(sql, Compra.class);
        query.setParameter("codigo", codigo);
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