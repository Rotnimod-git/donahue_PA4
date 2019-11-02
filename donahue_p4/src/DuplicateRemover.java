import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DuplicateRemover {
    ArrayList<String> uniqueWords = new ArrayList<String>();

    public void remove(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line1 = reader.readLine();
        while(line1 != null){
            String temp[] = line1.split(" ");
            for(String i:temp){
                if(!uniqueWords.contains(i))   uniqueWords.add(i);
            }
            line1 = reader.readLine();
        }
        reader.close();
    }

    public void write(String fileName) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        for(String i:uniqueWords){
            writer.println(i);
        }
        writer.close();
    }
}
