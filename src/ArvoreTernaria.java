import java.util.LinkedList;

public class ArvoreTernaria {
    private No raiz;
    private LinkedList<String> todosArquivos;

    public ArvoreTernaria() {
        this.todosArquivos = new LinkedList<>();
    }

    public void inserir(String palavra, String nomeArquivo) {
        if (!this.todosArquivos.contains(nomeArquivo)) {
            this.todosArquivos.add(nomeArquivo);
        }
        this.raiz = inserir(this.raiz, palavra, nomeArquivo, 0);
    }

    private No inserir(No atual, String palavra, String nomeArquivo, int indice) {
        if (atual == null) {
            char p = palavra.charAt(indice);
            atual = new No(p);
        }

        char p = palavra.charAt(indice);
        if (p < atual.caractere) {
            atual.esq = inserir(atual.esq, palavra, nomeArquivo, indice);
        } else if (p > atual.caractere) {
            atual.dir = inserir(atual.dir, palavra, nomeArquivo, indice);
        } else if (indice < palavra.length() - 1) {
            atual.meio = inserir(atual.meio, palavra, nomeArquivo, indice + 1);
        } else {
            atual.fimPalavra = true;
            if (!atual.arquivos.contains(nomeArquivo)) {
                atual.arquivos.add(nomeArquivo);
            }
        }
        return atual;
    }

    public LinkedList<String> buscar(String palavra) {
        if (palavra == null || palavra.length() == 0) return null;
        return buscarRec(this.raiz, palavra, 0);
    }

    private LinkedList<String> buscarRec(No atual, String palavra, int indice) {
        if (atual == null) return null;

        char p = palavra.charAt(indice);
        if (p < atual.caractere) return buscarRec(atual.esq, palavra, indice);
        else if (p > atual.caractere) return buscarRec(atual.dir, palavra, indice);
        else if (indice < palavra.length() - 1) return buscarRec(atual.meio, palavra, indice + 1);
        else {
            if (atual.fimPalavra) return atual.arquivos;
            else return null;
        }
    }

    public LinkedList<String> obterTodosArquivos() {
        return this.todosArquivos;
    }
}