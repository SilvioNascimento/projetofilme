package br.ufpb.dcx.silvio.filme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SistemaFilmesSalvarController implements ActionListener {
    private SistemaFilmes filmes;
    private GravadorDeFilmes gravador;
    private JFrame janelaPrincipal;

    public SistemaFilmesSalvarController(SistemaFilmes filmes, JFrame janela, GravadorDeFilmes gravador) {
        this.filmes = filmes;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gravador.gravarFilmes(filmes.getFilmes());
            JOptionPane.showMessageDialog(janelaPrincipal, "Filmes salvos com sucesso!");
        } catch(IOException ioException) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Filmes não salvos. Erro: "
            + ioException.getMessage());
            ioException.printStackTrace();
        }
    }
}