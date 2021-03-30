package Logic;

import java.io.*;

public class DataConverter {

    protected String readFromFile(String name) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(name))) {
            String s;
            while((s=br.readLine())!=null){
                result.append(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result.toString();
    }

    protected void writeToFile(String name, String data) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(name)))
        {
            bw.write(data);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
