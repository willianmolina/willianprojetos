package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String nome;
    @Column(length = 30)
    private String unidade;
    @Column(length = 10)
    private String senha;
//    @OneToMany(mappedBy = "compra") //muitas compras para um usuario
//    private List<Compra> compra;
//    
    public Usuario(){
        id = 0;
        nome = "";
        unidade = "";
        senha = "";
    }
    
    public Usuario(String nome, String unidade, String senha){
        this.id = 0;
        this.nome = nome;
        this.unidade = unidade; 
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    public List<Compra> getCompra() {
//        return compra;
//    }
//
//    public void setCompra(List<Compra> compra) {
//        this.compra = compra;
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.unidade);
        hash = 47 * hash + Objects.hashCode(this.senha);
//        hash = 47 * hash + Objects.hashCode(this.compra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.unidade, other.unidade)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
//        if (!Objects.equals(this.compra, other.compra)) {
//            return false;
//        }
        return true;
    }


   
    
}