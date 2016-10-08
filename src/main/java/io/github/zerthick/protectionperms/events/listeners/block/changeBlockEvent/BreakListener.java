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

package io.github.zerthick.protectionperms.events.listeners.block.changeBlockEvent;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;

import java.util.List;

public class BreakListener {

    @Listener
    public void onBlockBreak(ChangeBlockEvent.Break event, @First Player player) {
        List<Transaction<BlockSnapshot>> transactions = event.getTransactions();
        for (Transaction<BlockSnapshot> transaction : transactions) {
            BlockSnapshot snapshot = transaction.getOriginal();
            String blockName = snapshot.getState().getType().getId();
            if (!player.hasPermission("protectionperms.block.break." + blockName)) {
                event.setCancelled(true);
                player.sendMessage(ChatTypes.ACTION_BAR,
                        Text.of(TextColors.RED, "You don't have permission to break " + blockName + '!'));
                break;
            }
        }
    }
}
