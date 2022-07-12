package com.grupoamper;


import java.io.File;
import java.io.IOException;
// import java.io.InputStream;
import java.nio.file.Paths;
import java.util.*;


public final class Jsh {


    public static void main(String[] args) throws IOException {
        promptTerminal();
    }


    private Jsh() {}


    public static void promptTerminal() throws IOException {
        boolean aux = true;
        while (aux) {
            exibirPrompt();
            Interface commandEntrant = lerCommando();
            aux = executorCommand(commandEntrant);
        }
    }


    public static void exibirPrompt() throws IOException {
        diretorioAtual = System.getProperty("user.dir");
        uidUsuario = gerarUUID();
        System.err.print(nomeUsuario + "#" + uidUsuario + ":" + diretorioAtual + "%" );
    }


    public static Interface lerCommando() {
        Scanner scanner =  new Scanner(System.in);
        String line = scanner.nextLine();
        return new Interface(line);
    }


    public static boolean executorCommand(Interface comando) throws IOException  {
        switch (comando.getNome()) {
            case "time":
                ComandosInternos.time();
                return true;
            case "exit":
                ComandosInternos.exit();
                return true;
            case "help":
                ComandosInternos.help();
                return true;
            case "clear":
                ComandosInternos.clear();
                return true;
            case "ls":
                ComandosInternos.ls();
                return true;
   //             Scanner pasta = new Scanner(System.in);
            case "cd":
                ComandosInternos.cd();

                return true;
            case "inicio":
                ComandosInternos.inicio();
                return true;
            case "open":
                ComandosInternos.open();
                return true;
            default:
                System.out.println(
                    "\n" + "Comando ou programa não identificado! Segue abaixo a lista de comandos existentes" + "\n" +
                        "'relogio' : Informa a data e a hora do sistema" + "\n" +
                        "'ls' : Mostra oque há dentro da pasta" + "\n" +
                        "'exit' : Encerra o programa" + "\n" +
                        "'help' : Apresenta os comandos disponíveis" + "\n" +
                        "'clear' : Limpa o terminal." + "\n");
                return true;
        }
    }

    public static void executarPrograma(Interface comando)  {
        File userdir = new File(Paths.get("user.dir").toAbsolutePath().toString());
        File[] arquivos = userdir.listFiles();

        List<String> finalList = new ArrayList<>();

        assert arquivos != null;
        for(File arquivo : arquivos) {
            String convertString = arquivo.toString();
            String trocandoBarras = convertString.replaceAll("\\\\", "/");
            String[] stringFinal = trocandoBarras.split("/");
            finalList.add(stringFinal[stringFinal.length-1]);
        }

    }

    /**
     * Método que obtém o UID do usuario a partir do processo.
     *
     * retorna um int com o valor obtido.
     */
    public static double gerarUUID() throws IOException {
        double uid = 0;

    //     String comando = "id -u " + nomeUsuario;
    //     Process comandoUID = Runtime.getRuntime().exec(comando);
    //     InputStream saidaProcesso = comandoUID.getInputStream();

    //    byte[] arrSaida = saidaProcesso.readAllBytes();
    //     uid = arrSaida[0];

        return uid;
    }

    public static double uidUsuario;
    public static String diretorioAtual;
    private static final String nomeUsuario = System.getProperty("user.name");
}
