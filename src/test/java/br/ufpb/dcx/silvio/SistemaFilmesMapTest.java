package br.ufpb.dcx.silvio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.ufpb.dcx.silvio.filme.CategoriaFilme;
import br.ufpb.dcx.silvio.filme.Filme;
import br.ufpb.dcx.silvio.filme.FilmeJaExisteException;
import br.ufpb.dcx.silvio.filme.FilmeNaoExisteException;
import br.ufpb.dcx.silvio.filme.SistemaFilmesMap;

public class SistemaFilmesMapTest {
    
    @Test
    public void testaCadastroEPesquisa() {
        SistemaFilmesMap sistema = new SistemaFilmesMap();
        List<CategoriaFilme> categorias = new ArrayList<>();
        categorias.add(CategoriaFilme.ACAO);
        try {
            sistema.cadastraFilme(new Filme("001", "Matrix", categorias, new ArrayList<>()));
            Filme f = sistema.pesquisaFilme("001");
            assertEquals("Matrix", f.getNome());
            f.incluiAtorEmElenco("Keanu Reeves");
            assertEquals(1, sistema.obterQuantidadeFilmesComAtor("Keanu Reeves"));

        } catch (FilmeJaExisteException | FilmeNaoExisteException e) {
            fail("Não deveria lançar exceção ao cadastrar e pesquisar depois");
        }
    }

    @Test
    public void testaPesquisarFilmesDaCategoria() {
        SistemaFilmesMap sistema = new SistemaFilmesMap();
        List<CategoriaFilme> categorias1 = new ArrayList<>();
        categorias1.add(CategoriaFilme.ACAO);
        List<CategoriaFilme> categorias2 = new ArrayList<>();
        categorias2.add(CategoriaFilme.TERROR);
        try {
            sistema.cadastraFilme(new Filme("001", "Matrix", categorias1, new ArrayList<>()));
            sistema.cadastraFilme(new Filme("021", "Sexta-Feira 13", categorias2, new ArrayList<>()));
            assertEquals(1, sistema.pesquisaFilmesDaCategoria(CategoriaFilme.ACAO).size());

        } catch(FilmeJaExisteException e) {
            fail("Não deveria lançar exceção ao cadastrar e pesquisar quantos filmes existem de uma categoria");
        }
    }

    @Test
    public void testaObterQtFilmesComAtor() {
        SistemaFilmesMap sistema = new SistemaFilmesMap();
        List<String> atores1 = new ArrayList<>();
        List<String> atores2 = new ArrayList<>();
        atores1.add("Michael Jackson");
        atores2.add("Justin Bieber");
        try {
            sistema.cadastraFilme(new Filme("001", "Sucessos de Michael Jackson", new ArrayList<>(), atores1));
            sistema.cadastraFilme(new Filme("005", "Sucessos de Justin Bieber", new ArrayList<>(), atores2));
            assertEquals(1, sistema.obterQuantidadeFilmesComAtor("Michael Jackson"));
        } catch(FilmeJaExisteException e) {
            fail("Não deveria lançar exceção para verificar se existe 1 filme com determinado ator");
        }
    }

    @Test
    public void testaInclusaoDeAtorEmUmFilme() {
        SistemaFilmesMap sistema = new SistemaFilmesMap();
        try {
            sistema.cadastraFilme(new Filme("001", "Matrix 2"));
            Filme f = sistema.pesquisaFilme("001");
            f.incluiAtorEmElenco("Jackie Pierre");
            assertEquals(true, f.temNoElencoAtor("Jackie Pierre"));
        } catch(FilmeJaExisteException | FilmeNaoExisteException e) {
            fail("Não deveria lançar exceção ao verificar se existia o determinado ator em um filme");
        }
    }
}
