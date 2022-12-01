package br.ufpb.dcx.silvio.filme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SistemaFilmesRemoverFilmeController implements ActionListener{

    private SistemaFilmes filmes;
    private JFrame janelaPrincipal;
    private GravadorDeFilmes gravador;

    public SistemaFilmesRemoverFilmeController(SistemaFilmes filmes, JFrame janela, GravadorDeFilmes gravador) {
        this.filmes = filmes;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog("Digite o codigo do filme para apagar");
        try {
            filmes.removerFilme(codigo);
            gravador.gravarFilmes(filmes.getFilmes());
            JOptionPane.showMessageDialog(janelaPrincipal, "O filme foi apagado com sucesso");
            
        } catch(FilmeNaoExisteException | IOException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }
    }
}
