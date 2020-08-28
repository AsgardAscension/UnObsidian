package com.github.thomhuds.unobsidian;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ObsidianListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        if (block == null) {
            return;
        }
        if (event.getMaterial().equals(Material.BUCKET)
                && block.getType().equals(Material.OBSIDIAN)) {
            ItemStack item = event.getItem();
            item.setAmount(item.getAmount() - 1);
            event.getClickedBlock().setType(Material.AIR, true);
            Location location = event.getClickedBlock().getLocation();
            location.getWorld().dropItemNaturally(location, new ItemStack(Material.LAVA_BUCKET));
        }
    }
}
