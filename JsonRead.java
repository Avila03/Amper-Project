import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class JSONsimple {
    public static void(String[] args) throws Exception {
        // parsing file "JSONExample.json"
        Object ob = new JSONParser().parse(new FileReader("Recieve.json"));

        // typecasting ob to JSONObject
        JSONObject js = (JSONObject) ob;

        // Gera uma variável "x" com o mesmo conteudo q a variavel com nome "x" no JSON
        String mType = (String) js.get("mType");  //cases      
        String hwv = (String) js.get("hwv");
        String seq = (String) js.get("seq"); //Rever
        String pv = (String) js.get("pv");
        String sn = (String) js.get("sn");
        String opStat = (String) js.get("oStat");
        String dateTime = (String) js.get("dateTime");
        String cellId = (String) js.get("cellId");
        String tac = (String) js.get("tac");
        String sigPw = (String) js.get("sigPaw");
        String totPw = (String) js.get("totPw");
        String ecl = (String) js.get("ecl");//REVER
        String ctTx = (String) js.get("ctTx"); // REVER
        String snr = (String) js.get("snr");
        String txTime = (String) js.get("txTime");
        String txTime = (String) js.get("txTime");
        String measTime = (String) js.get("measTime");
        String al = (String) js.get("al"); //cases
        String bat = (String) js.get("bat");
        String tem = (String) js.get("tem");
        String mf = (String) js.get("mf");
        String pre = (String) js.get("pre");
        String crc = (String) js.get("crc");
        String hash = (String) js.get("hash");




        String mTypeResult;
        switch(mType){
            case 1: mTypeResult = "Funcionamento normal";
            case 2: mTypeResult = "Disparou alarme";
            case 3: mTypeResult = "Precisa de manutençao";
            case 4: mTypeResult = "Esta em manutençao";
            default:System.out.println("Not mType");   

        }

        String alResult;
        switch(al){
            case 1: alResult = "Ajustar";
            case 2: alResult = "Pressao baixa";
            case 3: alResult = "Pressao alta";
            case 4: alResult = "Shock";
            case 5: alResult = "Vibration";
            default:System.out.println("Not al");   

        }

        
        // System.out.println("First name is: " + firstName);
        // System.out.println("Last name is: " +lastName);
    }
}
