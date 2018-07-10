import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * emoji data generate and test
 *
 * @author xuxueli 2018-07-10 21:17:36
 */
public class DemojiDataTest {

    public static void main(String[] args) {
        List<Map<String, String>> emojiData = readLines();
        System.out.println(emojiData);
    }


    public static List<Map<String, String>> readLines(){
        BufferedReader reader = null;
        try {
            List<Map<String, String>> lines = new ArrayList<>();
            reader = new BufferedReader(new InputStreamReader(DemojiDataTest.class.getResourceAsStream("emoji-ordering.txt"), "utf-8"));
            if (reader != null) {
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(";") && line.contains("#")) {

                        String version = null;
                        String emoji = null;
                        String unicode = null;
                        String aliases = null;

                        Map<String, String> emojiItem = new HashMap<>();
                        emojiItem.put("line", line);
                        emojiItem.put("version", version);
                        emojiItem.put("emoji", emoji);
                        emojiItem.put("unicode", unicode);
                        emojiItem.put("aliases", aliases);

                        lines.add(emojiItem);
                    }
                }
                return lines;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}