package io.github.zerthick.protectionperms.events.listeners.interactEntityEvent;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

public class PrimaryListener {

    @Listener
    public void onInteractEntityPrimary(InteractEntityEvent.Primary event, @First Player player) {
        String entityName = event.getTargetEntity().getType().getName();
        if (!player.hasPermission("protectionPerms.entity.interact." + entityName + ".primary")) {
            event.setCancelled(true);
            player.sendMessage(Texts.of(TextColors.RED, "You don't have permission to primary interact with " + entityName + '!'));
        }
    }
}
