package br.ufpb.dcx.silvio.filme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Filme implements Serializable{
    private String codigo;
    private String nome;
    private List<CategoriaFilme> categorias;
    private List<String> nomesAtores;

    public Filme(String codigo) {
        this(codigo,"", new ArrayList<>(), new ArrayList<>());
    }

    public Filme(String codigo, String nome) {
        this(codigo, nome, new ArrayList<>(), new ArrayList<>());
    }

    public Filme(String codigo,String nome, List<CategoriaFilme> categorias,
        List<String> nomesAtores) {
        this.codigo = codigo;
        this.nome = nome;
        this.categorias = categorias;
        this.nomesAtores = nomesAtores;
    }

    public boolean ehDaCategoria(CategoriaFilme categoria) {
        for (CategoriaFilme cat: this.categorias) {
            if (cat == categoria) {
                return true;
            }
        }
        return false;
    }

    public void incluiAtorEmElenco(String nomeAtor) {
        this.nomesAtores.add(nomeAtor);
    }

    public boolean temNoElencoAtor(String nomeAtor) {
        for(String nomeDoAtor : this.nomesAtores) {
            if(nomeDoAtor.equals(nomeAtor)) {
                return true;
            }
        }
        return false;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 

    public String toString() {
        return "Código: " + this.codigo + "\nNome: " + this.nome + "\nCategoria(s): " + this.categorias + "\nAtor(es): " + this.nomesAtores + "\n\n";
    }
}
