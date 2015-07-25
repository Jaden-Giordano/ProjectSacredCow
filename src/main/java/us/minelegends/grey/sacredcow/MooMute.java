package us.minelegends.grey.sacredcow;

import org.bukkit.entity.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 7/25/2015.
 */
public class MooMute {

    private ArrayList<String> mooplayers;
    private String path;

    public MooMute(String path) {
        this.mooplayers = new ArrayList<String>();
        this.path = path;

        try {
            File file = new File(path+File.separator+"MooMute.cow");
            File filePath = new File(path);
            filePath.mkdir();
            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if (!this.contains(line)) {
                    this.mooplayers.add(line);
                }
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToMooMute() {
        try {
            File filePath = new File(path);
            filePath.mkdir();
            File file = new File(path+File.separator+"MooMute.cow");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter w = new FileWriter(file, false);
            PrintWriter p = new PrintWriter(w);

            for (String i : this.mooplayers) {
                p.printf("%s"+"%n", i);
            }
            p.flush();
            p.close();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMooMutePlayer(String s) {
        if (!this.contains(s)) {
            this.mooplayers.add(s);
        }
    }

    public boolean removeMooMutePlayer(String s) {
        Player p = Cow.instance.getServer().getPlayer(s);
        if (p != null) {
            List<String> remove = new ArrayList<String>();
            for (String i : this.mooplayers) {
                if (i.equalsIgnoreCase(p.getName())) {
                    remove.add(i);
                }
            }
            for (String i : remove) {
                this.mooplayers.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean contains(String s) {
        for (String i : this.mooplayers) {
            if (i.equals(s)) {
                return true;
            }
        }
        return false;
    }

}
