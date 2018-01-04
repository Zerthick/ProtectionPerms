package io.github.zerthick.protectionperms.events.listeners.entity;

import io.github.zerthick.protectionperms.PermHandler;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.action.FishingEvent;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

public class HookEntityListener {

    @Listener
    public void onEntityHook(FishingEvent.HookEntity event) {

        event.getContext().get(EventContextKeys.OWNER).ifPresent(user ->

                user.getPlayer().ifPresent(player -> {

                    EntityType entityType = event.getTargetEntity().getType();
                    String entityId = entityType.getId();

                    PermHandler ph = PermHandler.getInstance();

                    if (!ph.checkPerm(player, "protectionperms.entity.hook." + entityId)) {
                        event.setCancelled(true);
                        player.sendMessage(ChatTypes.ACTION_BAR,
                                Text.of(TextColors.RED, "You don't have permission to hook " + entityType.getName() + "s!"));
                    }

                })

        );

    }
}
