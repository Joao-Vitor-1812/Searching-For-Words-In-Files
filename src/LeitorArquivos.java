import java.io.File;
import java.util.Scanner;

public class LeitorArquivos {

    public void carregaArquivos(ArvoreTernaria arvore) {
        try {
            File pasta = new File("src/arquivos");
            File[] listaArquivos = pasta.listFiles();
            
            if (listaArquivos == null) return;

            int i = 0;
            while (i < listaArquivos.length) {
                Scanner conteudo = new Scanner(listaArquivos[i]);
                while (conteudo.hasNext()) {
                    String palavraTratada = conteudo.next();
                    String palavra = palavraTratada.toLowerCase().replaceAll("[^a-zá-úãõâêîôûç0-9]", "");
                    if (!palavra.isEmpty()) arvore.inserir(palavra, listaArquivos[i].getName());
                }
                conteudo.close();
                i++;
            }
        } catch (Exception e) {
            System.out.println("erroAoAbrirArquivo");
        }
    }

    public void exibirConteudoArquivo(String nomeArquivo) {
        File arquivoLido = new File("src/arquivos/" + nomeArquivo);
        if (arquivoLido.exists()) {
            try (Scanner leitor = new Scanner(arquivoLido)) {
                while (leitor.hasNextLine()) {
                    String dado = leitor.nextLine();
                    System.out.println(dado);
                }
            } catch (Exception e) {
                System.out.println("erroAoAbrirArquivo");
            }
        } else {
            System.err.println("arquivoNaoExiste");
        }
    }
}