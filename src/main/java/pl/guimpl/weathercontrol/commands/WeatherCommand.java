package pl.guimpl.weathercontrol.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WeatherCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public WeatherCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                switch (args[0].toLowerCase()) {
                    case "slonecznie":
                        player.getWorld().setWeatherDuration(0);
                        player.getWorld().setStorm(false);
                        player.sendMessage("Pogoda została ustawiona na słoneczną.");
                        break;
                    case "deszcz":
                        player.getWorld().setWeatherDuration(10000); 
                        player.getWorld().setStorm(true);
                        player.sendMessage("Pogoda została ustawiona na deszczową.");
                        break;
                    case "burza":
                        player.getWorld().setWeatherDuration(10000);
                        player.getWorld().setStorm(true);
                        player.getWorld().setThundering(true);
                        player.sendMessage("Pogoda została ustawiona na burzową.");
                        break;
                    default:
                        player.sendMessage("Niepoprawny typ pogody. Użyj: slonecznie, deszcz, burza.");
                        break;
                }
                return true;
            } else {
                player.sendMessage("Użyj: /pogoda <typ>");
                return false;
            }
        } else {
            sender.sendMessage("Ta komenda może być używana tylko przez graczy.");
            return false;
        }
    }
}

