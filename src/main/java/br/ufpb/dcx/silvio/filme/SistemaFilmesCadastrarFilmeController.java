package br.ufpb.dcx.silvio.filme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaFilmesCadastrarFilmeController implements ActionListener {

    private SistemaFilmes filmes;
    private JFrame janelaPrincipal;
    private GravadorDeFilmes gravador;

    public SistemaFilmesCadastrarFilmeController(SistemaFilmes filmes, JFrame janela, GravadorDeFilmes gravador) {
        this.filmes = filmes;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog("Informe o código do filme");
        String nome = JOptionPane.showInputDialog("Informe o nome do filme");
        List<CategoriaFilme> categorias = new ArrayList<>();
        boolean sair = false;
        while(!sair) {
            String opc = JOptionPane.showInputDialog("Qual destas categorias pertence no filme?\n[1] Comédia\n[2] Romance\n[3] Terror\n[4] Ação\n[5] Drama\n");

            if(opc.equals("1")) {
                categorias.add(CategoriaFilme.COMEDIA);
            } else if(opc.equals("2")) {
                categorias.add(CategoriaFilme.ROMANCE);
            } else if(opc.equals("3")) {
                categorias.add(CategoriaFilme.TERROR);
            } else if(opc.equals("4")) {
                categorias.add(CategoriaFilme.ACAO);
            } else if(opc.equals("5")) {
                categorias.add(CategoriaFilme.DRAMA);
            } else {
                JOptionPane.showMessageDialog(janelaPrincipal,"Código inválido. Por favor, digite um código válido.");
            }
            String perg = JOptionPane.showInputDialog("Deseja continuar? \n[1] Sim\n[2] Não");
            if(perg.equals("2")) {
                sair = true;
            }
            
        }
        
        List<String> atores = new ArrayList<>();
        Filme f = new Filme(codigo, nome, categorias, atores);
        try {
            filmes.cadastraFilme(f);
            gravador.gravarFilmes(filmes.getFilmes());
            JOptionPane.showMessageDialog(janelaPrincipal, "Filme cadastrado com sucesso");
        } catch(FilmeJaExisteException | IOException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }
    }
}
