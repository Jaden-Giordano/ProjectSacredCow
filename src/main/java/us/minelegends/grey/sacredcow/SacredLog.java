package us.minelegends.grey.sacredcow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 7/18/2015.
 */
public class SacredLog {

    List<String> sacredwords;
    private String path;

    public SacredLog(String path) {
        this.sacredwords = new ArrayList<String>();
        this.path = path;

        try {
            File file = new File(path+File.separator+"SacredLog.cow");
            File filePath = new File(path);
            filePath.mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if (!this.contains(line)) {
                    this.sacredwords.add(line);
                }
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String blah = "";
        for (String i : this.sacredwords) {
            blah += i+",";
        }
        Cow.instance.getLogger().info("Current Sacred Words: "+blah);
    }

    public void saveToSacredLog() {
        try {
            File filePath = new File(path);
            filePath.mkdir();
            File file = new File(path+File.separator+"SacredLog.cow");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter w = new FileWriter(file, false);
            PrintWriter p = new PrintWriter(w);

            for (String i : this.sacredwords) {
                p.printf("%s"+"%n", i);
            }
            p.flush();
            p.close();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addSacredWord(String word) {
        this.sacredwords.add(word);
    }

    public List<String> getSacredWords() {
        return this.sacredwords;
    }

    public String removeSacredWordsInMessage(String msg) {
        String newMsg = msg;
        for (String i : sacredwords) {
            newMsg = newMsg.replaceAll("(?i)"+i, "moo");
        }
        return newMsg;
    }

    public void removeSacredWord(String s) {
        List<String> remove = new ArrayList<String>();
        for (String i : this.sacredwords) {
            if (i.equalsIgnoreCase(s)) {
                remove.add(i);
            }
        }
        for (String i : remove) {
            this.sacredwords.remove(i);
        }
    }

    public boolean contains(String s) {
        for (String i : this.sacredwords) {
            if (i.equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }

}
