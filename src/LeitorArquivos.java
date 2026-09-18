import java.io.File;
import java.util.Scanner;

public class LeitorArquivos{

    public void carregaArquivos(ArvoreTernaria arvore){
        try{

        
            File pasta = new File("src/arquivos");
        
            File[] listaArquivos = pasta.listFiles();

            int i = 0;

            while(i < listaArquivos.length){
                Scanner conteudo = new Scanner(listaArquivos[i]);
                while (conteudo.hasNext()){
                    String palavraSTrat = conteudo.next();
                    String palavra = palavraSTrat.toLowerCase().replaceAll("[^a-zá-úãõâêîôûç0-9]", "");
                    if(!palavra.isEmpty()) arvore.Inserir(palavra, listaArquivos[i].getName());
                }
                conteudo.close();
                i++;
            }
        }catch (Exception e){
            System.out.println("Erro: Erro ao abrir o arquivo");
        }
    }

    public void exibirConteudoArquivo(String nomeArquivo){
        File arquivoLido = new File("src/arquivos/"+ nomeArquivo);
        if(arquivoLido.exists()){
            try (Scanner leitor = new Scanner(arquivoLido)) {
                while (leitor.hasNextLine()) {
                    String dado = leitor.nextLine();
                    System.out.println(dado);
                }
            }catch (Exception e){
                System.out.println("Erro: Erro ao abrir o arquivo");
            }
        }else{
            System.err.println("Arquivo não existe no diretório atual!");
        }
    }
}
