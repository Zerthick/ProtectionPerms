package io.github.zerthick.protectionperms.events.listeners.item;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.inventory.Inventory;

public class BrewItemListener {

    @Listener
    public void onItemSmelt(ClickInventoryEvent event, @Root Player player, @Getter("getTargetInventory") Inventory inventory) {

        /*if (inventory.getArchetype() == InventoryArchetypes.BREWING_STAND) {

            Inventory brewingInputs = inventory.query(InputSlot.class);

            brewingInputs.slots().forEach(slot -> slot.peek().ifPresent(itemStack -> {
                String itemId = itemStack.getItem().getType().getId();

                PermHandler ph = PermHandler.getInstance();
                
                if (slot instanceof FuelSlot) {
                    if (!ph.checkPerm(player, "protectionperms.item.fuel." + itemId)) {
                        event.setCancelled(true);
                        player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to use " + itemId + " as fuel!"));
                    }
                } else {
                    if (!ph.checkPerm(player, "protectionperms.item.brew." + itemId)) {
                        event.setCancelled(true);
                        player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to brew " + itemId + '!'));
                    }
                }
            }));
        }*/
    }
}
