package br.ufpb.dcx.silvio.filme;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SistemaFilmesObterQntFilmesComAtor implements ActionListener {
    private SistemaFilmes filmes;
    private JFrame janelaPrincipal;

    public SistemaFilmesObterQntFilmesComAtor(SistemaFilmes filmes, JFrame janela) {
        this.filmes = filmes;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        String nomeAtor = JOptionPane.showInputDialog("Informe o nome do autor");
        int qtDeFilmesComAtor = filmes.obterQuantidadeFilmesComAtor(nomeAtor);
        if(qtDeFilmesComAtor == 0) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não existe filmes que o ator " + nomeAtor + " participou");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "O ator " + nomeAtor + " participou de " + qtDeFilmesComAtor + " filme(s)");
        }
    }
}
