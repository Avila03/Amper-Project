package com.grupoamper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.grupoamper.Jsh.diretorioAtual;
import static java.nio.file.Files.exists;
//import static jdk.jpackage.internal.OverridableResource.toPath;


public final class ComandosInternos {

    public static String dir1;
    public static String dir2;
    public static int count=1;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static String userdir;
    /** Essa classe não deve ser instanciada. */
    private ComandosInternos() {}

    /**
     * Método sem retorno que exibe o relógio com a data e horário atual.
     */
    public static void time() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }

    /**
     * Método para encerrar o programa.
     */
    public static void exit() {
        Runtime.getRuntime().exit(0);

    }
    /**
     * Método para solicitar os comandos disponiveis.
     */
    public static void help(){
        System.out.println(
            "\n" + "Comando ou programa não identificado! Segue abaixo a lista de comandos existentes" + "\n" +
                "'relogio' : Informa a data e a hora do sistema" + "\n" +
                "'ls' : Mostra oque há dentro da pasta" + "\n" +
                "'exit' : Encerra o programa" + "\n" +
                "'help' : Apresenta os comandos disponíveis" + "\n" +
                "'clear' : Limpa o terminal." );
    }

    /**
     * Método para limpar o terminal.
     * (Revisar)
     */
    public static void clear (){for(int i = 0; i < 300; i++)
    {
        System.out.println("\b");
    }
    }
    public static void ls  ()throws IOException {
        //Carpeta del usuario
        String sCarpAct = System.getProperty("user.dir");
        System.out.println("Pasta Atual = " + sCarpAct);
        File carpeta = new File(sCarpAct);
        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            System.out.println("Pasta vazia");
            return;
        }
        else {
            for (int i=0; i< listado.length; i++) {
                System.out.println(listado[i]);
            }
        }
        }

    public static void open()   {
    //Escolher o arquivo que vai ser aberto e executar e não só printar


        File file = new File("C:\\Users\\bruno.silva\\Desktop\\Amper\\iot-device-simulator\\src\\main\\java\\com\\grupoamper\\Teste.tld");
        try {
         try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
               System.out.println(line);
                       }
            }
     } catch (IOException e) {
         e.printStackTrace();
         }
    }
    public static void cd(){
        Scanner sc = new Scanner(System.in);
        String cdDir = sc.next();

        if(checkCount()==0){
          dir2= diretorioAtual;
          System.setProperty("user.dir", cdDir);
          dir1 = diretorioAtual;
          count++;
        }
        else if(checkCount()==1) {
            dir2 = dir1;
            System.setProperty("user.dir", cdDir);
            dir1 = diretorioAtual;
            count++;
        }else
            System.setProperty("user.dir", cdDir);
            dir2 = diretorioAtual;
            dir1 = diretorioAtual;
            count++;
    }
    public static void inicio(){

        System.setProperty("user.dir","C:\\Users\\bruno.silva\\Desktop\\Amper");

    }

    public static int checkCount(){

        if(count==1)
            return 0;
        else if((count%2)==1)
            return 1;
        else
            return 2;
    }
}

