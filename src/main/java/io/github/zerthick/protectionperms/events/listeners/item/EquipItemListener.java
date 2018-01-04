package io.github.zerthick.protectionperms.events.listeners.item;

import io.github.zerthick.protectionperms.PermHandler;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;
import org.spongepowered.api.item.inventory.slot.EquipmentSlot;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

public class EquipItemListener {

    @Listener
    public void onItemEquip(ClickInventoryEvent event, @First Player player, @Getter("getTargetInventory") Inventory inventory) {

        if (inventory.getArchetype() == InventoryArchetypes.PLAYER) {

            Inventory equipmentSlots = inventory.query(QueryOperationTypes.INVENTORY_TYPE.of(EquipmentSlot.class));

            equipmentSlots.slots().forEach(slot -> slot.peek().ifPresent(itemStack -> {

                ItemType itemType = itemStack.getType();
                String itemId = itemType.getId();

                PermHandler ph = PermHandler.getInstance();

                if (!ph.checkPerm(player, "protectionperms.item.equip." + itemId + ".on.self")) {
                    event.setCancelled(true);
                    player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to equip " + itemType.getName() + '!'));
                }
            }));
        }
    }

}
