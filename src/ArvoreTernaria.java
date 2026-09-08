import java.util.LinkedList;


public class ArvoreTernaria{
    private No raiz;

    public ArvoreTernaria(No raiz){
        this.raiz = null;
    }
}

public void Inserir(String palavra, String NomeArquivo){
    this.raiz = Inserir(this.raiz, String palavra,String NomeArquivo, 0);
}

private No Inserir(No atual, String palavra, String NomeArquivo, int indice){
    if(atual == null) {
        char p = palavra.charAt(indice);
        atual = new No(p);
    }

    char p = palavra.charAt(indice);
    if(p < atual.caractere){
        atual.esq = Inserir(atual.esq, palavra, NomeArquivo, indice);
    }
}


public LinkedList<String> buscar(String palavra){

}