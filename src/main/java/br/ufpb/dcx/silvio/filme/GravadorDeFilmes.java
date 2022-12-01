package br.ufpb.dcx.silvio.filme;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeFilmes {

    private String fileName = "filmes.txt";

    public void gravarFilmes(Collection<Filme> filmes) throws IOException {
        ObjectOutputStream gravador = null;
        try {
            gravador = new ObjectOutputStream(new FileOutputStream(fileName));
            ArrayList<Filme> filmesASalvar = new ArrayList<>(filmes);
            gravador.writeObject(filmesASalvar);
        } finally {
            if(gravador != null) {
                gravador.close();
            }
        }
    }

    public Collection<Filme> recuperarFilmes() throws IOException, ClassNotFoundException {
        ObjectInputStream leitor = null;
        try {
            leitor = new ObjectInputStream(new FileInputStream(fileName));
            Collection<Filme> filmesLidos = (Collection<Filme>) leitor.readObject();
            return filmesLidos;
        } finally {
            if(leitor != null) {
                leitor.close();
            }
        }
    }
}
