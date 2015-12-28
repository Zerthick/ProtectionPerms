package io.github.zerthick.protectionperms.events.listeners.interactBlockEvent;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

public class SecondaryListener {

    @Listener
    public void onInteractBlockSecondary(InteractBlockEvent.Secondary event, @First Player player) {
        String blockName = event.getTargetBlock().getState().getType().getName();
        if (!player.hasPermission("protectionPerms.block.interact." + blockName + ".secondary")) {
            event.setCancelled(true);
            player.sendMessage(Texts.of(TextColors.RED, "You don't have permission to secondary interact with " + blockName + '!'));
        }
    }
}
