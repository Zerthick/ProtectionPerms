package io.github.zerthick.protectionperms.events.listeners.changeBlockEvent;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

import java.util.List;

public class BreakListener {

    @Listener
    public void onBlockBreak(ChangeBlockEvent.Break event, @First Player player) {
        List<Transaction<BlockSnapshot>> transactions = event.getTransactions();
        for (Transaction<BlockSnapshot> transaction : transactions) {
            BlockSnapshot snapshot = transaction.getOriginal();
            String blockName = snapshot.getState().getType().getName();
            if (!player.hasPermission("protectionPerms.block.break." + blockName)) {
                event.setCancelled(true);
                player.sendMessage(Texts.of(TextColors.RED, "You don't have permission to break " + blockName + '!'));
                break;
            }
        }
    }
}
