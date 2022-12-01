package br.ufpb.dcx.silvio.filme;

import java.util.Collection;
import java.util.List;

public interface SistemaFilmes {

    Collection<Filme> getFilmes();

    void cadastraFilme(Filme f) throws FilmeJaExisteException;

    void removerFilme(String codigoDoFilme) throws FilmeNaoExisteException;

    Filme pesquisaFilme(String codigo) throws FilmeNaoExisteException;

    List<Filme> pesquisaFilmesDaCategoria(CategoriaFilme categoria);

    int obterQuantidadeFilmesComAtor(String nomeAtor);
    
    void incluiAtorEmElencoDeFilme(String codigoFilme, String nomeAtor) throws FilmeNaoExisteException;
}
