package io.github.zerthick.protectionperms.events.listeners;


import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

public class DamageEntityListener {

    @Listener
    public void onEntityDamage(DamageEntityEvent event, @First Player player) {
        String entityName = event.getTargetEntity().getType().getName();
        if (!player.hasPermission("protectionPerms.entity.damage." + entityName)) {
            event.setCancelled(true);
            player.sendMessage(Texts.of(TextColors.RED, "You don't have permission to damage " + entityName + '!'));
        }
    }
}
