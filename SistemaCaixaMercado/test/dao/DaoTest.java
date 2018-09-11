package dao;

import modelo.Administrador;
import modelo.Usuario;
import modelo.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author José
 */
public class DaoTest {

    public DaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  @Test
  public void testInserirAdministrador() {
        Dao dao = new Dao(Administrador.class);
       Administrador adm = new Administrador("WILL", "Willian Molina", "123456");
        dao.inserir(adm);
  }
//    @Test
//    public void testListarAdministrador() {
//        Dao<Administrador> dao = new Dao(Administrador.class);
//        List<Administrador> lista = dao.listarTodos();
//        for (Administrador adm : lista){
//            System.out.println(adm.getId() + " - "+adm.getLogin());
//        }
//        
//    }
  
   @Test
   public void testInserirProduto() {
        Dao<Produto> dao = new Dao(Produto.class);
       Produto u = new Produto( 1, 01, "Sabão", 10 , 10.50);
       dao.inserir(u);
    }

//    @Test
//    public void testAlterarUsuario() {
//        Dao<Usuario> dao = new Dao(Usuario.class);
//        Usuario u = new Usuario();
//        u.setId(3);
//        u = dao.buscarPorCodigo(u.getId());  // tem que buscar para recuperar a referência ao objeto
//        System.out.println("Antes: ");
//        System.out.println("Nome: " + u.getNome() + "\n\n");
//
//        // alterando o nome
//        u.setNome("José Reinaldo Merlin");
//        // gravando
//        dao.alterar(u);
//        u = dao.buscarPorCodigo(u.getId());  // tem que buscar para recuperar a referência ao objeto
//    }
    
   

}