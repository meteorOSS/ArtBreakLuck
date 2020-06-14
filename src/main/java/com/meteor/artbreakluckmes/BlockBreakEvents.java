package com.meteor.artbreakluckmes;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

public class BlockBreakEvents implements Listener {
    private ArtBreakLuckMes plugin;
    public BlockBreakEvents(ArtBreakLuckMes plugin){
        this.plugin = plugin;
    }
    @EventHandler
    void breakBlock(BlockBreakEvent breakEvent){

        if(breakEvent.getBlock().getType().toString().equalsIgnoreCase("POKELUCKY_POKE_LUCKY")){
            List<Entity> olde = breakEvent.getPlayer().getNearbyEntities(5.0D,5.0D,5.0D);
            Bukkit.getScheduler().runTaskLater(plugin,()->{
                breakEvent.getPlayer().getNearbyEntities(5.0D,5.0D,5.0D).forEach((a)->{
                    if(!olde.contains(a)){
                        String name = a.getName();
                        if(name.equalsIgnoreCase("Musashi")||name.equalsIgnoreCase("Kojiro")){
                            name = name.equalsIgnoreCase("Musashi")?plugin.getConfig().getString("Musashi").replace("&","§"):
                                    plugin.getConfig().getString("Kojiro").replace("&","§");
                        }
                        Bukkit.broadcastMessage(plugin.getConfig().getString("break-luck").replace("@p@",breakEvent.getPlayer().getName()).replace(
                                "@pokemon@",name).replace("&","§")
                        );
                    }
                });
            },10);
        }
    }
}
