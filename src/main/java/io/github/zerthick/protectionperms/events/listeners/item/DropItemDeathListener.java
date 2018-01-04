package io.github.zerthick.protectionperms.events.listeners.item;

import io.github.zerthick.protectionperms.PermHandler;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.DropItemEvent;

public class DropItemDeathListener {

    @Listener
    public void onItemDropDeath(DropItemEvent.Destruct event, @Root Player player) {

        PermHandler ph = PermHandler.getInstance();
            
            event.filterEntities(entity -> {
                if (entity.getType().equals(EntityTypes.ITEM)) {
                    Item item = (Item) entity;
                    String itemId = item.getItemType().getId();
                    return ph.checkPerm(player, "protectionperms.item.drop." + itemId + ".death");
                }
                return true;
            });
    }
}
