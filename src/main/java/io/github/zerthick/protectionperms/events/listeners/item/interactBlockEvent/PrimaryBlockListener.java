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

package io.github.zerthick.protectionperms.events.listeners.item.interactBlockEvent;

import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

import java.util.Optional;

public class PrimaryBlockListener {

    @Listener
    public void onInteractBlockPrimaryMain(InteractBlockEvent.Primary.MainHand event, @First Player player) {
        Optional<ItemStack> itemStackOptional = player.getItemInHand(HandTypes.MAIN_HAND);
        if(itemStackOptional.isPresent()) {
            String blockName = event.getTargetBlock().getState().getType().getId();
            String itemName = itemStackOptional.get().getItem().getId();
            if (!player.hasPermission("protectionperms.item.use." + itemName + ".on." + blockName + ".primary")) {
                event.setCancelled(true);
                player.sendMessage(ChatTypes.ACTION_BAR,
                        Text.of(TextColors.RED, "You don't have permission to primary use " + itemName + " on " + blockName + '!'));
            }
        }
    }

    @Listener
    public void onInteractBlockPrimaryOff(InteractBlockEvent.Primary.OffHand event, @First Player player) {
        Optional<ItemStack> itemStackOptional = player.getItemInHand(HandTypes.OFF_HAND);
        if(itemStackOptional.isPresent()) {
            String blockName = event.getTargetBlock().getState().getType().getId();
            String itemName = itemStackOptional.get().getItem().getId();
            if (!player.hasPermission("protectionperms.item.use." + itemName + ".on." + blockName + ".primary")) {
                event.setCancelled(true);
                player.sendMessage(ChatTypes.ACTION_BAR,
                        Text.of(TextColors.RED, "You don't have permission to primary use " + itemName + " on " + blockName + '!'));
            }
        }
    }
}
