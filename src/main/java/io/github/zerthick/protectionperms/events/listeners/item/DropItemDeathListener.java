package io.github.zerthick.protectionperms.events.listeners.item;

import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.entity.spawn.EntitySpawnCause;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.DropItemEvent;

public class DropItemDeathListener {

    @Listener
    public void onItemDropDeath(DropItemEvent.Destruct event, @Root EntitySpawnCause spawnCause) {

        if (spawnCause.getEntity() instanceof Player) {
            Player player = (Player) spawnCause.getEntity();
            event.filterEntities(entity -> {
                if (entity.getType().equals(EntityTypes.ITEM)) {
                    Item item = (Item) entity;
                    String itemId = item.getItemType().getId();
                    return player.hasPermission("protectionperms.item.drop." + itemId + ".death");
                }
                return true;
            });
        }
    }
}
