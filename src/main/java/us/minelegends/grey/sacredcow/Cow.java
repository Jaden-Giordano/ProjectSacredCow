package us.minelegends.grey.sacredcow;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Jaden on 7/18/2015.
 */
public class Cow extends JavaPlugin {

    public static Cow instance;

    private SacredLog sacredLog;

    @Override
    public void onEnable() {
        instance = this;
        this.getLogger().info("Reading Sacred Logs...");
        this.sacredLog = new SacredLog(this.getDataFolder().getAbsolutePath());

        this.getServer().getPluginManager().registerEvents(new OnChat(), this);
        this.getCommand("addsword").setExecutor(new AddExecutor());

        this.getLogger().info(this.getName() + " has been loaded...");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Saving Sacred Logs...");
        this.sacredLog.saveToSacredLog();
        this.getLogger().info(this.getName() + " has been disabled...");
    }

    public SacredLog getSacredLog() {
        return this.sacredLog;
    }

}
