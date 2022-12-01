package br.ufpb.dcx.silvio.filme;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SistemaFilmesPesquisarFilmePelaCatController implements ActionListener {
    private SistemaFilmes filmes;
    private JFrame janelaPrincipal;

    public SistemaFilmesPesquisarFilmePelaCatController(SistemaFilmes filmes, JFrame janela) {
        this.filmes = filmes;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        CategoriaFilme cat = null;
        String opcao = JOptionPane.showInputDialog("O filme que está pesquisando é da categoria:\n[1] COMEDIA\n[2] ROMANCE\n[3] TERROR\n[4] ACAO\n[5] DRAMA");
        if(opcao.equals("1")) {
            cat = CategoriaFilme.COMEDIA;
        } else if(opcao.equals("2")) {
            cat = CategoriaFilme.ROMANCE;
        } else if(opcao.equals("3")) {
            cat = CategoriaFilme.TERROR;
        } else if(opcao.equals("4")) {
            cat = CategoriaFilme.ACAO;
        } else if(opcao.equals("5")) {
            cat = CategoriaFilme.DRAMA;
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,"Opção inválida. Tente novamente mais tarde");
        }

        String lista = "";
        List<Filme> filmesDaCat = filmes.pesquisaFilmesDaCategoria(cat);
        for(Filme f : filmesDaCat) {
            lista += f.toString();
        }
        if(lista.length() == 0) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Não existe filmes cadastrados com a categoria " + cat);
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, lista);
        }
    }
}
