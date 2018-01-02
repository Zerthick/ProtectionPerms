package io.github.zerthick.protectionperms.events.listeners.item;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;
import org.spongepowered.api.item.inventory.slot.FuelSlot;
import org.spongepowered.api.item.inventory.slot.InputSlot;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

public class SmeltItemListener {

    @Listener
    public void onItemSmelt(ClickInventoryEvent event, @First Player player, @Getter("getTargetInventory") Inventory inventory) {

        if (inventory.getArchetype() == InventoryArchetypes.FURNACE) {

            Inventory smeltingInputs = inventory.query(QueryOperationTypes.INVENTORY_TYPE.of(InputSlot.class));

            smeltingInputs.slots().forEach(slot -> slot.peek().ifPresent(itemStack -> {

                ItemType itemType = itemStack.getType();
                String itemId = itemType.getId();

                if (slot instanceof FuelSlot) {
                    if (!player.hasPermission("protectionperms.item.fuel." + itemId)) {
                        event.setCancelled(true);
                        player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to use " + itemType.getName() + " as fuel!"));
                    }
                } else {
                    if (!player.hasPermission("protectionperms.item.smelt." + itemId)) {
                        event.setCancelled(true);
                        player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to smelt " + itemType.getName() + '!'));
                    }
                }
            }));
        }
    }

}
