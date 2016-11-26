/*
 * Copyright (C) 2016  Zerthick
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

package io.github.zerthick.protectionperms.events.listeners.item;

import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.entity.spawn.EntitySpawnCause;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.DropItemEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

import java.util.List;
import java.util.stream.Collectors;

public class DropItemListener {

    @Listener
    public void onItemDrop(DropItemEvent.Dispense event, @Root EntitySpawnCause spawnCause) {
        if (spawnCause.getEntity() instanceof Player) {
            Player player = (Player) spawnCause.getEntity();
            List<Item> itemEntities = event.getEntities()
                    .stream().filter(entity -> entity.getType().equals(EntityTypes.ITEM))
                    .map(Item.class::cast)
                    .collect(Collectors.toList());
            for (Item item : itemEntities) {
                String itemId = item.getItemType().getId();
                if (!player.hasPermission("protectionperms.item.drop." + itemId)) {
                    event.setCancelled(true);
                    player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to drop " + itemId + '!'));
                }
            }
        }
    }
}
