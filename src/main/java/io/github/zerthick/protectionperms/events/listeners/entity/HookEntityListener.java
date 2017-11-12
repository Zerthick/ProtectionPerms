package io.github.zerthick.protectionperms.events.listeners.entity;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.action.FishingEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

public class HookEntityListener {

    @Listener
    public void onEntityHook(FishingEvent.HookEntity event, @First Player player) {

        player.sendMessage(Text.of("Test"));

        String entityId = event.getTargetEntity().getType().getId();
        if (!player.hasPermission("protectionperms.entity.hook." + entityId)) {
            event.setCancelled(true);
            player.sendMessage(ChatTypes.ACTION_BAR,
                    Text.of(TextColors.RED, "You don't have permission to hook " + entityId + "s!"));
        }
    }
}
