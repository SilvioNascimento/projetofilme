package br.ufpb.dcx.silvio.filme;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SistemaFilmesPesquisarFilmeController implements ActionListener {
    private SistemaFilmes filmes;
    private JFrame janelaPrincipal;

    public SistemaFilmesPesquisarFilmeController(SistemaFilmes filmes, JFrame janela) {
        this.filmes = filmes;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog("Informe o código do filme que deseja pesquisar");
        try {
            Filme f = filmes.pesquisaFilme(codigo);
            JOptionPane.showMessageDialog(janelaPrincipal, "Informações do filme: \n\n" + f.toString());
        } catch (FilmeNaoExisteException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }
    }

}
