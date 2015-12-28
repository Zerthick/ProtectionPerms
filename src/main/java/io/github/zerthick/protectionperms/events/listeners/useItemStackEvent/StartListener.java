package io.github.zerthick.protectionperms.events.listeners.useItemStackEvent;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.UseItemStackEvent;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

public class StartListener {

    @Listener
    public void onItemUse(UseItemStackEvent.Start event, @First Player player) {
        String itemName = event.getItemStackInUse().getOriginal().getType().getName();
        if (!player.hasPermission("protectionPerms.item.use." + itemName)) {
            event.setCancelled(true);
            player.sendMessage(Texts.of(TextColors.RED, "You don't have permission to use " + itemName + '!'));
        }
    }
}
