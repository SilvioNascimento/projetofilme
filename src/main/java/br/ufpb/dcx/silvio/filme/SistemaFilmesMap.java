package br.ufpb.dcx.silvio.filme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SistemaFilmesMap implements SistemaFilmes {
    private Map<String, Filme> filmes;

    public SistemaFilmesMap() {
        this.filmes = new HashMap<String, Filme>();
    }

    @Override
    public Collection<Filme> getFilmes() {
        return this.filmes.values();
    }

    @Override
    public void cadastraFilme(Filme f) throws FilmeJaExisteException {
        if(this.filmes.containsKey(f.getCodigo())) {
            throw new FilmeJaExisteException("Já existe filme com o código" + f.getCodigo());
        } else {
            this.filmes.put(f.getCodigo(), f);
        }
    }

    @Override
    public void removerFilme(String codigoFilme) throws FilmeNaoExisteException {
        if(this.filmes.containsKey(codigoFilme)) {
            filmes.remove(codigoFilme);
        } else {
            throw new FilmeNaoExisteException("Não foi possível apagar o filme com código " + codigoFilme + ". Verifique se este filme já foi cadastrado.");
        }
    }

    @Override
    public Filme pesquisaFilme(String codigo) throws FilmeNaoExisteException {
        Filme f = this.filmes.get(codigo);
        if(f == null) {
            throw new FilmeNaoExisteException("Não existe filme com o código " + codigo);
        } else {
            return f;
        }
    }

    @Override
    public List<Filme> pesquisaFilmesDaCategoria(CategoriaFilme categoria) {
        List<Filme> filmesDaCat = new ArrayList<>();
        for(Filme f : this.filmes.values()) {
            boolean temCategoria = f.ehDaCategoria(categoria);
            if(temCategoria) {
                filmesDaCat.add(f);
            }
        }
        return filmesDaCat;
    }

    @Override
    public int obterQuantidadeFilmesComAtor(String nomeAtor) {
        int qtDeFilmesComAtor = 0;
        for(Filme f : this.filmes.values()) {
            boolean temAtorNesteFilme = f.temNoElencoAtor(nomeAtor);
            if(temAtorNesteFilme) {
                qtDeFilmesComAtor++;
            }
        }
        return qtDeFilmesComAtor;
    }

    @Override
    public void incluiAtorEmElencoDeFilme(String codigoFilme, String nomeAtor) throws FilmeNaoExisteException {
        if(!this.filmes.containsKey(codigoFilme)) {
            throw new FilmeNaoExisteException("Não existe filme com o código " + nomeAtor);
        } else {
            Filme f = this.filmes.get(codigoFilme);
            f.incluiAtorEmElenco(nomeAtor);
        }
    }
    
}
