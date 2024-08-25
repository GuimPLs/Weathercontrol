package pl.guimpl.weathercontrol;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.guimpl.weathercontrol.commands.WeatherCommand;

public class Weathercontrol extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("WeatherControl został włączony!");
        this.getCommand("pogoda").setExecutor(new WeatherCommand(this));
        // Rejestracja innych komend i nasłuchiwaczy
    }

    @Override
    public void onDisable() {
        getLogger().info("WeatherControl został wyłączony.");
    }
}
