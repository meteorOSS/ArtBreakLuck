package com.meteor.artbreakluckmes;

import org.bukkit.plugin.java.JavaPlugin;

public final class ArtBreakLuckMes extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getLogger().info("插件已加载完成,meteor.联系qq2260483272,接插件定制");
        getServer().getPluginManager().registerEvents(new BlockBreakEvents(this),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
