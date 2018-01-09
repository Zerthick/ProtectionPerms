package io.github.zerthick.protectionperms.events.listeners.item;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.inventory.Inventory;

public class ForgeItemListener {

    @Listener
    public void onItemForge(ClickInventoryEvent event, @Root Player player, @Getter("getTargetInventory") Inventory inventory) {

        /*if (inventory.getArchetype() == InventoryArchetypes.ANVIL) {

            Inventory forgingInputs = inventory.query(InputSlot.class);

            PermHandler ph = PermHandler.getInstance();
            
            forgingInputs.slots().forEach(slot -> slot.peek().ifPresent(itemStack -> {
                String itemId = itemStack.getItem().getType().getId();
                if (!ph.checkPerm(player, "protectionperms.item.forge." + itemId)) {
                    event.setCancelled(true);
                    player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to forge " + itemId + '!'));
                }
            }));
        }*/
    }

}
