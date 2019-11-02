import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {
    Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(String dataFile) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(dataFile));
        String line1 = reader.readLine();
        while(line1 != null) {
            String temp[] = line1.split(" ");
            for(String s:temp) {
                if (!wordCounter.containsKey(s)) {
                    wordCounter.put(s, 1);
                }
                else {
                    int count = wordCounter.get(s);
                    wordCounter.put(s, count + 1);
                }
            }
            line1 = reader.readLine();
        }
        reader.close();
    }

    public void write(String outputFile) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(outputFile);
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()){
            writer.println(entry.getKey() + entry.getValue());
        }
        writer.close();
    }
}
