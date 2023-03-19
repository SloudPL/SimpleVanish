package pl.sloudpl.simplevanish;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class SimpleVanish extends JavaPlugin {

    public static SimpleVanish main;
    public ArrayList<Player> invisible = new ArrayList<>();

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults(true);
        saveConfig();

        main = this;

        new Command(this);
        new Events(this);

        getServer().getPluginManager().registerEvents(new Events(this), this);

    }

    public static SimpleVanish getMain(){

        return main;

    }
}
