package io.github.zerthick.protectionperms.events.listeners.item;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.crafting.CraftingOutput;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

public class ItemCraftListener {

    @Listener
    public void onItemCraft(ClickInventoryEvent event, @Root Player player, @Getter("getTargetInventory") Inventory targetInventory) {
        if (targetInventory instanceof CraftingOutput) {
            CraftingOutput output = (CraftingOutput) targetInventory.que;
            output.peek().ifPresent(itemStack -> {
                String itemId = itemStack.getItem().getId();
                if (!player.hasPermission("protectionperms.item.craft." + itemId)) {
                    event.setCancelled(true);
                    player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to craft " + itemId + '!'));
                }
            });
        }
    }
}
