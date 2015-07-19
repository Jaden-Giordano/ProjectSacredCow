package us.minelegends.grey.sacredcow;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Jaden on 7/18/2015.
 */
public class AddExecutor implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("addsword")) {
            if (commandSender.hasPermission("cow.admin")) {
                if (strings.length == 0) {
                    return false;
                }
                String msg = "";
                for (int i = 0; i < strings.length; i++) {
                    if (i == strings.length-1) {
                        msg += strings[i];
                    } else {
                        msg += strings[i] + " ";
                    }
                }
                Cow.instance.getSacredLog().addSacredWord(msg);
                commandSender.sendMessage("Added "+msg+" to the Sacred Cow Log...");
                return true;
            }
            else {
                commandSender.sendMessage("You don't have permission to do this...");
                return true;
            }
        }
        return false;
    }
}
