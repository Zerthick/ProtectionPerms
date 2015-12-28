package io.github.zerthick.protectionperms.events.listeners;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.DropItemEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

import java.util.List;

public class DropItemListener {

    @Listener
    public void onItemDrop(DropItemEvent.Pre event, @First Player player) {
        List<ItemStackSnapshot> itemStackList = event.getDroppedItems();
        for (ItemStackSnapshot snapshot : itemStackList) {
            String itemName = snapshot.getType().getName();
            if (!player.hasPermission("protectionPerms.item.drop." + itemName)) {
                event.setCancelled(true);
                player.sendMessage(Texts.of(TextColors.RED, "You don't have permission to drop " + itemName + '!'));
                break;
            }
        }
    }
}
