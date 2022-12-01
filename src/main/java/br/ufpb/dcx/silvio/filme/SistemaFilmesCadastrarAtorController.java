package br.ufpb.dcx.silvio.filme;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SistemaFilmesCadastrarAtorController implements ActionListener {
    private SistemaFilmes filmes;
    private JFrame janelaPrincipal;
    private GravadorDeFilmes gravador;

    public SistemaFilmesCadastrarAtorController(SistemaFilmes filmes, JFrame janela, GravadorDeFilmes gravador) {
        this.filmes = filmes;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog("Informe o código do filme que queira cadastrar o(s) ator(es)");
        String ator = JOptionPane.showInputDialog("Informe o nome do ator para adicionar no filme");
        try {
            filmes.incluiAtorEmElencoDeFilme(codigo, ator);
            gravador.gravarFilmes(filmes.getFilmes());
            JOptionPane.showMessageDialog(janelaPrincipal, "Operação realizada com sucesso");
        } catch(FilmeNaoExisteException | IOException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }

    }
}
