package io.github.zerthick.protectionperms.events.listeners.interactBlockEvent;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

public class PrimaryListener {

    @Listener
    public void onInteractBlockPrimary(InteractBlockEvent.Primary event, @First Player player) {
        String blockName = event.getTargetBlock().getState().getType().getName();
        if (!player.hasPermission("protectionPerms.block.interact." + blockName + ".primary")) {
            event.setCancelled(true);
            player.sendMessage(Texts.of(TextColors.RED, "You don't have permission to primary interact with " + blockName + '!'));
        }
    }
}
