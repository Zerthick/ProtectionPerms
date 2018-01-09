package io.github.zerthick.protectionperms.events.listeners.item;

import io.github.zerthick.protectionperms.PermHandler;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.ChangeInventoryEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

public class PickupItemListener {

    @Listener
    public void onItemPickup(ChangeInventoryEvent.Pickup.Pre event, @Root Player player) {

        ItemType itemType = event.getOriginalStack().getType();
        String itemId = itemType.getId();

        PermHandler ph = PermHandler.getInstance();

        if (!ph.checkPerm(player, "protectionperms.item.pickup." + itemId)) {
            event.setCancelled(true);
            player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to pick up " + itemType.getName() + '!'));
        }
    }
}
