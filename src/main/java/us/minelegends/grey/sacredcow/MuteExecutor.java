package us.minelegends.grey.sacredcow;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Jaden on 7/25/2015.
 */
public class MuteExecutor implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("moo")) {
            if (strings.length < 1) {
                return false;
            }
            Player p = Cow.instance.getServer().getPlayer(strings[0]);
            if (p != null) {
                Cow.instance.getMooMute().addMooMutePlayer(p.getName());
                commandSender.sendMessage("Added "+strings[0]+" to the moo mute list...");
            }
            else {
                commandSender.sendMessage("Could not find "+strings[0]+"...");
            }
            return true;
        }
        if (command.getName().equalsIgnoreCase("unmoo")) {
            if (strings.length < 1) {
                return false;
            }
            if (Cow.instance.getMooMute().removeMooMutePlayer(strings[0])) {
                commandSender.sendMessage("Unmooed "+strings[0]+"...");
            }
            else {
                commandSender.sendMessage(strings[0]+" is not mooed...");
            }
            return true;
        }
        return false;
    }
}
