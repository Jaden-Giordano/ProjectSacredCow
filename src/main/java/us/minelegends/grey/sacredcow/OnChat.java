package us.minelegends.grey.sacredcow;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Jaden on 7/18/2015.
 */
public class OnChat implements Listener {

    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent e) {
        if (Cow.instance.getMooMute().contains(e.getPlayer().getName())) {
           e.setMessage("moo");
        }
        else {
            String msg = e.getMessage();
            String newMsg = Cow.instance.getSacredLog().removeSacredWordsInMessage(msg);
            if (!msg.equals(newMsg)) {
                e.getPlayer().sendMessage("Please do not offend the Sacred Cow.....");
                e.setMessage(newMsg);
            }
        }
    }

}
