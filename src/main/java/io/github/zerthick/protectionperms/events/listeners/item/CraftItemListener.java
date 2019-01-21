package io.github.zerthick.protectionperms.events.listeners.item;

import io.github.zerthick.protectionperms.PermHandler;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.CraftItemEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.transaction.SlotTransaction;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;


public class CraftItemListener {

    @Listener
    public void onItemCraft(CraftItemEvent.Preview event, @First Player player, @Getter("getPreview") SlotTransaction preview) {

        ItemStackSnapshot itemStack = preview.getFinal();

        ItemType itemType = itemStack.getType();

        if (itemType != ItemTypes.AIR) {

            String itemId = itemType.getId();

            PermHandler ph = PermHandler.getInstance();

            if (!ph.checkPerm(player, "protectionperms.item.craft." + itemId)) {
                event.setCancelled(true);
                player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to craft " + itemType.getName() + '!'));
            }
        }
    }
}
