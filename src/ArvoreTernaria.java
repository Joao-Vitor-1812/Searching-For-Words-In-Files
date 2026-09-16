public class ArvoreTernaria{
    private No raiz;
}

public void Inserir(String palavra, String NomeArquivo){
    this.raiz = Inserir(this.raiz,palavra,NomeArquivo, 0);
}

private No Inserir(No atual, String palavra, String NomeArquivo, int indice){
    if(atual == null) {
        char p = palavra.charAt(indice);
        atual = new No(p);
    }

    char p = palavra.charAt(indice);
    if(p < atual.caractere){
        atual.esq = Inserir(atual.esq, palavra, NomeArquivo, indice);
    }else if(p > atual.caractere){
        atual.dir = Inserir(atual.dir, palavra, NomeArquivo, indice);
    }else if(indice < palavra.length() - 1){
            atual.meio = Inserir(atual.meio, palavra, NomeArquivo, indice + 1);     
            }else{
                atual.fimPalavra = true;
                if(!atual.arquivos.contains(NomeArquivo)){
                    atual.arquivos.add(NomeArquivo);
                }
            }
            return atual;
}


public LinkedList<String> buscar(String palavra){
    if(palavra == null || palavra.length() == 0) return null;
    return buscarRec(this.raiz, palavra, 0);
}

private LinkedList<String> buscarRec(No atual, String palavra, int indice){
    if(atual == null) return null;

    char p = palavra.charAt(indice);
    if(p < atual.caractere){
        
    }
}