package com.github.thomhuds.unobsidian;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ObsidianListener(), this);
    }
}
