package io.github.zerthick.protectionperms.events.listeners.item;

import io.github.zerthick.protectionperms.PermHandler;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.action.FishingEvent;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

public class FishingStartListener {

    @Listener
    public void onItemUse(FishingEvent.Start event, @Root Player player, @Getter("getContext") EventContext context) {

        context.get(EventContextKeys.USED_ITEM).ifPresent(itemStackSnapshot -> {
            ItemType itemType = itemStackSnapshot.getType();
            String itemId = itemType.getId();

            PermHandler ph = PermHandler.getInstance();

            if (!ph.checkPerm(player, "protectionperms.item.use." + itemId + ".on.self")) {
                event.setCancelled(true);
                player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to use " + itemType.getName() + '!'));
            }
        });
    }

}
