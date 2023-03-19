package pl.sloudpl.simplevanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events  implements Listener {

    SimpleVanish plugin;

    public Events(SimpleVanish m){

        plugin = m;

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        for (int i = 0; i < plugin.invisible.size(); i++){

            p.hidePlayer(plugin.invisible.get(i));

        }

    }

}
