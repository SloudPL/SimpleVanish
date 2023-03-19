package pl.sloudpl.simplevanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    SimpleVanish plugin;

    public Command(SimpleVanish m){

        plugin = m;
        m.getCommand("vanish").setExecutor(this);
        m.getCommand("v").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (p.hasPermission("sloudpl.vanish") || p.isOp()) {

                if (plugin.invisible.contains(p)) {

                    for (Player players : Bukkit.getOnlinePlayers()) {

                        players.showPlayer(p);

                    }
                    plugin.invisible.remove(p);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("vanish.show")));

                } else if (!plugin.invisible.contains(p)) {

                    for (Player players : Bukkit.getOnlinePlayers()) {

                        players.hidePlayer(p);

                    }
                    plugin.invisible.add(p);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("vanish.hide")));

                }

            } else {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("vanish.nopermission")));

            }

        } else {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("vanish.console")));

        }

        return false;
    }
}
