import java.util.LinkedList;

public class No{
    public char caractere;
    public No esq;
    public No meio;
    public No dir;
    public boolean fimPalavra;
    public LinkedList<String> arquivos;

    public No(char caractere, No esq, No meio, No dir){
        this.caractere = caractere;
        this.fimPalavra = false;
        this.arquivos = new LinkedList<>();
    }
}

