package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private Integer cod;
    @Column(length = 30)
    private String nome;
    @Column(length = 30)
    private Integer quantidade;
     @Column(length = 30)
    private double preco;
//    @ManyToOne(optional=false )    // muitos produtos para uma compra
//    @JoinColumn(name="Compra")
//    private Compra compra;

    
    public Produto(){
        id = 0;
        cod = 0;
        nome = "";
        quantidade = 0;
        preco = 0;
    }
    
    public Produto(Integer id, Integer cod, String nome, Integer quantidade, double preco){
        this.id = 0;
        this.cod = 0;
        this.nome = nome;
        this.quantidade = quantidade; 
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.cod);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.quantidade);
        hash = 41 * hash + Objects.hashCode(this.preco);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
         if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto[" + "id=" + id + "cod =" + cod + ", nome=" + nome + ", quantidade=" + quantidade + ", preco=" + preco +']';
    }
    
}