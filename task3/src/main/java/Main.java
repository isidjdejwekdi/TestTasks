import org.json.simple.JSONObject;

import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2){
            System.out.println("tests.json and values.json required");
            System.exit(1);
        }

        MyJsonSimpleParser parser = new MyJsonSimpleParser();

        String tests = args[0];
        String values = args[1];

        try {

            JSONObject jObj = parser.buildJsonReport(tests, values);

            if (writeJsonReport(jObj))
                System.out.println("report.json successfully created");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean writeJsonReport(JSONObject jObj){
        try (FileWriter fw = new FileWriter("report.json")){
            fw.write(jObj.toJSONString());

            return true;

        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
