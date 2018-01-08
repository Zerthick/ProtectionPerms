package io.github.zerthick.protectionperms.events.listeners.entity;

public class BreedEntityListener {

    /*@Listener
    public void onEntityBreed(BreedEntityEvent.FindMate event, @Getter("getContext") EventContext context) {

        context.get(EventContextKeys.NOTIFIER).ifPresent(user -> user.getPlayer().ifPresent(player -> {
            EntityType entityType = event.getTargetEntity().getType();
            String entityId = entityType.getId();
            if (!player.hasPermission("protectionperms.entity.breed." + entityId)) {
                event.setCancelled(true);
                player.sendMessage(ChatTypes.ACTION_BAR,
                        Text.of(TextColors.RED, "You don't have permission to breed " + entityType.getName() + "s!"));
            }
        }));
    }*/
}
