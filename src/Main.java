import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    
public static void main(String[] argumentos) {
    
        ArvoreTernaria arvoreTernaria = new ArvoreTernaria();
        LeitorArquivos leitorDeArquivos = new LeitorArquivos();

        System.out.println("construindoIndice");
        leitorDeArquivos.carregaArquivos(arvoreTernaria);
        System.out.println("indiceConstruido");

        Scanner entradaDeDados = new Scanner(System.in);

        while (true) {
            System.out.println("digiteConsultaOuSair:");
            System.out.print("> ");
            String consulta = entradaDeDados.nextLine();

            if (consulta.equalsIgnoreCase("sair")) {
                System.out.println("programaEncerrado");
                break;
            }

            LinkedList<String> arquivosEncontrados = processarConsulta(consulta, arvoreTernaria);

            System.out.println("arquivosEncontrados");
            if (arquivosEncontrados != null && !arquivosEncontrados.isEmpty()) {
                for (String nomeDoArquivo : arquivosEncontrados) {
                    System.out.println(nomeDoArquivo);
                }
            } else {
                System.out.println("nenhumArquivo");
            }
        }

        entradaDeDados.close();
    }

    public static LinkedList<String> processarConsulta(String consulta, ArvoreTernaria arvore) {
        String[] partesOu = consulta.split("\\s+OU\\s+");
        LinkedList<String> resultadoFinal = new LinkedList<>();

        for (String parteOu : partesOu) {
            String[] tokens = parteOu.split("\\s+");
            LinkedList<String> resultadoBloco = null;
            boolean proximoNao = false;

            for (String token : tokens) {
                if (token.equals("E")) {
                    continue;
                }
                if (token.equals("NAO")) {
                    proximoNao = true;
                    continue;
                }

                String tokenNormalizado = token.toLowerCase().replaceAll("[^a-zá-úãõâêîôûç0-9]", "");
                LinkedList<String> arquivosPalavra = arvore.buscar(tokenNormalizado);

                if (resultadoBloco == null) {
                    if (proximoNao) {
                        resultadoBloco = diferenca(arvore.obterTodosArquivos(), arquivosPalavra);
                        proximoNao = false;
                    } else {
                        resultadoBloco = copiar(arquivosPalavra);
                    }
                } else {
                    if (proximoNao) {
                        resultadoBloco = diferenca(resultadoBloco, arquivosPalavra);
                        proximoNao = false;
                    } else {
                        resultadoBloco = intersecao(resultadoBloco, arquivosPalavra);
                    }
                }
            }
            resultadoFinal = uniao(resultadoFinal, resultadoBloco);
        }
        return resultadoFinal;
    }

    private static LinkedList<String> uniao(LinkedList<String> listaUm, LinkedList<String> listaDois) {
        LinkedList<String> resultado = new LinkedList<>();
        if (listaUm != null) {
            for (String item : listaUm) {
                if (!resultado.contains(item)) resultado.add(item);
            }
        }
        if (listaDois != null) {
            for (String item : listaDois) {
                if (!resultado.contains(item)) resultado.add(item);
            }
        }
        return resultado;
    }

    private static LinkedList<String> intersecao(LinkedList<String> listaUm, LinkedList<String> listaDois) {
        LinkedList<String> resultado = new LinkedList<>();
        if (listaUm == null || listaDois == null) return resultado;
        for (String item : listaUm) {
            if (listaDois.contains(item) && !resultado.contains(item)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    private static LinkedList<String> diferenca(LinkedList<String> listaUm, LinkedList<String> listaDois) {
        LinkedList<String> resultado = new LinkedList<>();
        if (listaUm == null) return resultado;
        for (String item : listaUm) {
            if (listaDois == null || !listaDois.contains(item)) {
                if (!resultado.contains(item)) resultado.add(item);
            }
        }
        return resultado;
    }

    private static LinkedList<String> copiar(LinkedList<String> lista) {
        LinkedList<String> resultado = new LinkedList<>();
        if (lista != null) {
            for (String item : lista) {
                resultado.add(item);
            }
        }
        return resultado;
    }
}