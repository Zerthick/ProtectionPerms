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

import io.github.zerthick.protectionperms.DebugLogger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.DropItemEvent;

public class DropItemListener {

    @Listener
    public void onItemDrop(DropItemEvent.Pre event) {
        DebugLogger.getInstance().getLogger().info(event.getDroppedItems().toString());
        /*if(spawnCause.getEntity() instanceof Player) {
            Player player = (Player) spawnCause.getEntity();
            List<Entity> itemEntities = event.getEntities()
                    .stream().filter(entity -> entity.getType().equals(EntityTypes.ITEM))
                    .collect(Collectors.toList());
            for (Entity item : itemEntities) {
                String itemId = item.get;
                DebugLogger.getInstance().getLogger().info(itemId);
                if (!player.hasPermission("protectionperms.item.drop." + itemId)) {
                    event.setCancelled(true);
                    player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, "You don't have permission to drop " + itemId + '!'));
                }
            }
        }*/
    }
}
