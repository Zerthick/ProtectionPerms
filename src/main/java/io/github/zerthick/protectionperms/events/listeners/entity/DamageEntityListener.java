/*
 * Copyright (C) 2015  Zerthick
 *
 * This file is part of ProtectionPerms.
 *
 * ProtectionPerms is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * ProtectionPerms is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ProtectionPerms.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.zerthick.protectionperms.events.listeners.entity;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.entity.damage.source.EntityDamageSource;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.text.title.TitleBuilder;

public class DamageEntityListener {

    @Listener
    public void onEntityDamage(DamageEntityEvent event, @First EntityDamageSource dmgSource) {
        if(dmgSource.getSource() instanceof Player) {
            Player player = (Player)dmgSource.getSource();
            String entityName = event.getTargetEntity().getType().getName();
            if (!player.hasPermission("protectionPerms.entity.damage." + entityName + ".deal")) {
                event.setCancelled(true);
                player.sendMessage(ChatTypes.ACTION_BAR,
                        Texts.of(TextColors.RED, "You don't have permission to damage " + entityName + "s!"));
            }
        }
    }
}
