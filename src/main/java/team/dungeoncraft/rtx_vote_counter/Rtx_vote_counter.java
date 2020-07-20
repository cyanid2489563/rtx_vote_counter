package team.dungeoncraft.rtx_vote_counter;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public final class Rtx_vote_counter extends JavaPlugin {
    private DataParser dataParser = new DataParser();
    private List<Item> items;

    @Override
    public void onEnable() {
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new Expansion(this).register();
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                items = dataParser.getWebPage();
                System.out.println("已更新比賽統計資料");
            }
        }.runTaskTimer(this, 20, 6000);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

}
