package br.ufpb.dcx.silvio.filme;

public class FilmeNaoExisteException extends Exception {

    private static final long serialVersionUID = 1L;

    public FilmeNaoExisteException(String msg) {
        super(msg);
    }

}
