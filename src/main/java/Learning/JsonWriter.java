package Learning;

import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonWriter {
    public static void main(String[] args) throws IOException {
        JSONObjectToJson();
        JsonEncodeDemo();
        JavaDecodeDemo();
        ArrayToJson();
        ArrayListToJson();
        JsonToArrayList();
        MapToJson();
    }

    public static void JSONObjectToJson() throws IOException {
        JsonObject obj = new JsonObject();
//      obj.add("name","foo");
      obj.addProperty("name","foo");

        obj.addProperty("name", "foo");
        obj.addProperty("num", 100);
        obj.addProperty("balance", 1000.21);
        obj.addProperty("is_vip", Boolean.TRUE);

        StringWriter out = new StringWriter();
//        obj.writeJSONString(out);
//        obj.get(out);

        String jsonText = out.toString();
        System.out.print(jsonText);

    }

    public static void JsonEncodeDemo() {

        JsonObject obj = new JsonObject();

        obj.addProperty("name", "foo");
        obj.addProperty("num", 100);
        obj.addProperty("balance", 1000.21);
        obj.addProperty("is_vip", Boolean.TRUE);

        StringWriter out = new StringWriter();
        obj.get(String.valueOf(out));

        String jsonText = out.toString();
        System.out.print(jsonText);
    }

    public static void JavaDecodeDemo() {

        JsonParser parser = new JsonParser();
        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
        System.out.println();

        Object obj = parser.parse(s);
        JsonArray array = (JsonArray)obj;

        System.out.println("The 2nd element of array");
        System.out.println(array.get(1));
        System.out.println();

        JsonObject obj2 = (JsonObject)array.get(1);
        System.out.println("Field \"1\"");
        System.out.println(obj2.get("1"));

        s = "{}";
        obj = parser.parse(s);
        System.out.println(obj);

        s = "[5,]";
        obj = parser.parse(s);
        System.out.println(obj);

        s = "[5,,2]";
        obj = parser.parse(s);
        System.out.println(obj);
    }
    public static void ArrayToJson() {
            String [] myArray = {"JavaFX", "HBase", "JOGL", "WebGL"};
            JsonArray jsArray = new JsonArray();
        System.out.println("Array to Json");
            for (int i = 0; i < myArray.length; i++) {
                jsArray.add(myArray[i]);
            }
            System.out.println(jsArray);
    }
        public static void ArrayListToJson() throws IOException {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("JavaFX");
            arrayList.add("HBase");
            arrayList.add("JOGL");
            arrayList.add("WebGL");
            arrayList.add("OpenGL");
            String filepath =System.getProperty("user.dir")+File.separator+"ArrayListToJson.json";
           Gson gson =new Gson();
           Writer writer = new FileWriter(filepath);
           GsonBuilder gsonBuilder = new GsonBuilder();
           gsonBuilder.setPrettyPrinting().create();
           gson.toJson(arrayList,writer);
           writer.close();

        }
    public static void MapToJson() throws IOException {
        System.out.println("Map to Json");
        Map<String,String> arrayList = new HashMap<>();
        arrayList.put("1","JavaFX");
        arrayList.put("2","HBase");
        arrayList.put("3","JOGL");
        arrayList.put("4","WebGL");
        arrayList.put("5","OpenGL");
        String filepath =System.getProperty("user.dir")+File.separator+"MapToJson.json";
        Gson gson =new Gson();
        Writer writer = new FileWriter(filepath);
        gson.toJson(arrayList,writer);
        writer.close();

    }
    public static void JsonToArrayList() throws IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println("Convert Json to ArrayList");
        String filepath =System.getProperty("user.dir")+File.separator+"ArrayListToJson.json";
        String filepath1 =System.getProperty("user.dir")+File.separator+"MapToJson.json";
        Gson gson =new Gson();
        FileReader fileReader = new FileReader(filepath);
        Object obj =gson.fromJson(fileReader,Object.class);
        System.out.println(obj);
        FileReader fileReader1 = new FileReader(filepath1);
        Object obj1 =gson.fromJson(fileReader1,Object.class);
        Map<String,String>  map= new HashMap<>();
        map = (Map<String, String>) obj1;
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}

