package io.github.zerthick.protectionperms.events.listeners.item;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.slot.InputSlot;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

public class EnchantItemListener {

    @Listener
    public void onItemEnchant(ClickInventoryEvent event, @Root Player player, @Getter("getTargetInventory") Inventory inventory) {

        if (inventory.getArchetype() == InventoryArchetypes.ENCHANTING_TABLE) {

            Inventory enchantingInputs = inventory.query(InputSlot.class);

            enchantingInputs.slots().forEach(slot -> slot.peek().ifPresent(itemStack -> {
                String itemId = itemStack.getItem().getType().getId();

                itemStack.getValue(Keys.ITEM_ENCHANTMENTS).ifPresent(itemEnchantments -> itemEnchantments.forEach(enchantment -> {
                    String enchantmentId = enchantment.getEnchantment().getId();
                    if (!player.hasPermission("protectionperms.item.enchant." + itemId + ".with." + enchantmentId)) {
                        event.setCancelled(true);
                        player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to enchant " + itemId + " with " + enchantmentId + '!'));
                    }
                }));
            }));
        }
    }

}
