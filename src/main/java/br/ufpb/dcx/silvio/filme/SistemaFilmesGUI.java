package br.ufpb.dcx.silvio.filme;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SistemaFilmesGUI extends JFrame{
    
    JLabel linha1, background;
    ImageIcon cineFilmeImg = new ImageIcon("src"+File.separator+"resources"+File.separator+"img"+File.separator+"cineFilmes.jpg");
    SistemaFilmes filmes = new SistemaFilmesMap();
    JMenuBar barraDeMenu = new JMenuBar();
    GravadorDeFilmes gravador = new GravadorDeFilmes();
    

    public SistemaFilmesGUI() {
        setTitle("Sistema de Filmes");
        setSize(650, 330);
        setLocation(200, 150);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        Collection<Filme> filmesParaLer = null;
        try {
            filmesParaLer = gravador.recuperarFilmes();
            for(Filme f : filmesParaLer) {
                this.filmes.cadastraFilme(f);
            }
            JOptionPane.showMessageDialog(null, "Filmes recuperados com sucesso");
        } catch(IOException | ClassNotFoundException | FilmeJaExisteException e) {
            JOptionPane.showMessageDialog(null, "Contatos não recuperados. Erro: " + e.getMessage());
            e.printStackTrace();
        }


        linha1 = new JLabel("Cine Filmes", JLabel.CENTER);
        linha1.setForeground(Color.WHITE);
        linha1.setFont(new Font("Serif", Font.BOLD, 30));

        background = new JLabel(cineFilmeImg);
        setContentPane(background);
        linha1.setBounds(130, 20, 400, 40);
        add(linha1);

        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarFilme = new JMenuItem("Cadastrar filme");
        menuCadastrar.add(menuCadastrarFilme);
        menuCadastrarFilme.addActionListener(new SistemaFilmesCadastrarFilmeController(filmes, this, gravador));

        JMenuItem menuCadastrarAtorNoFilme = new JMenuItem("Cadastrar ator no filme");
        menuCadastrar.add(menuCadastrarAtorNoFilme);
        menuCadastrarAtorNoFilme.addActionListener(new SistemaFilmesCadastrarAtorController(filmes, this, gravador));

        barraDeMenu.add(menuCadastrar);


        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverFilme = new JMenuItem("Remover Filme");
        menuRemover.add(menuRemoverFilme);
        menuRemoverFilme.addActionListener(new SistemaFilmesRemoverFilmeController(filmes, this, gravador));
        barraDeMenu.add(menuRemover);


        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarFilme = new JMenuItem("Pesquisar filme");
        menuPesquisar.add(menuPesquisarFilme);
        menuPesquisarFilme.addActionListener(new SistemaFilmesPesquisarFilmeController(filmes, this));

        JMenuItem menuPesquisarFilmePelaCat = new JMenuItem("Pesquisar filme pela categoria");
        menuPesquisar.add(menuPesquisarFilmePelaCat);
        menuPesquisarFilmePelaCat.addActionListener(new SistemaFilmesPesquisarFilmePelaCatController(filmes, this));

        barraDeMenu.add(menuPesquisar);


        JMenu menuQuantidade = new JMenu("Obter quantidade");
        JMenuItem menuQuantidadeFilmesComAtor = new JMenuItem("De filmes com ator");
        menuQuantidade.add(menuQuantidadeFilmesComAtor);
        menuQuantidadeFilmesComAtor.addActionListener(new SistemaFilmesObterQntFilmesComAtor(filmes, this));

        barraDeMenu.add(menuQuantidade);


        setJMenuBar(barraDeMenu);
    }

    public static void main(String[] args) {
        JFrame janela = new SistemaFilmesGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(janela, "Tem " +
                        "certeza de que quer sair?");
                if(resp == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
