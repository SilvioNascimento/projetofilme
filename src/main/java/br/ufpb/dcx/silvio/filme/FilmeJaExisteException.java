package br.ufpb.dcx.silvio.filme;

public class FilmeJaExisteException extends Exception{

    private static final long serialVersionUID = 1L;

    public FilmeJaExisteException(String msg) {
        super(msg);
    }
}
