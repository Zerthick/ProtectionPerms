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

package io.github.zerthick.protectionperms.events.listeners.item.interactBlockEvent;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

import java.util.Optional;

public class SecondaryBlockListener {

    @Listener
    public void onInteractBlockSecondary(InteractBlockEvent.Secondary event, @First Player player) {
        Optional<ItemStack> itemStackOptional = player.getItemInHand();
        if(itemStackOptional.isPresent()) {
            String blockName = event.getTargetBlock().getState().getType().getName();
            String itemName = itemStackOptional.get().getItem().getName();
            if (!player.hasPermission("protectionPerms.item.use." + itemName + ".on." + blockName + ".secondary")) {
                event.setCancelled(true);
                player.sendMessage(ChatTypes.ACTION_BAR,
                        Texts.of(TextColors.RED, "You don't have permission to secondary use " + itemName + " on " + blockName + '!'));
            }
        }
    }
}
