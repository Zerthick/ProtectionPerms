package io.github.zerthick.protectionperms.events;

import io.github.zerthick.protectionperms.events.listeners.DamageEntityListener;
import io.github.zerthick.protectionperms.events.listeners.DropItemListener;
import io.github.zerthick.protectionperms.events.listeners.changeBlockEvent.BreakListener;
import io.github.zerthick.protectionperms.events.listeners.changeBlockEvent.PlaceListener;
import io.github.zerthick.protectionperms.events.listeners.useItemStackEvent.StartListener;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.plugin.PluginContainer;

public class ListenerRegister {

    private PluginContainer container;

    public ListenerRegister(PluginContainer container) {
        this.container = container;
    }

    public void registerListeners() {
        EventManager eventManager = Sponge.getGame().getEventManager();
        Object instance = container.getInstance().get();

        eventManager.registerListeners(instance, new BreakListener());
        eventManager.registerListeners(instance, new PlaceListener());
        eventManager.registerListeners(instance, new DamageEntityListener());
        eventManager.registerListeners(instance,
                new io.github.zerthick.protectionperms.events.listeners.interactBlockEvent.PrimaryListener());
        eventManager.registerListeners(instance,
                new io.github.zerthick.protectionperms.events.listeners.interactBlockEvent.SecondaryListener());
        eventManager.registerListeners(instance,
                new io.github.zerthick.protectionperms.events.listeners.interactEntityEvent.PrimaryListener());
        eventManager.registerListeners(instance,
                new io.github.zerthick.protectionperms.events.listeners.interactEntityEvent.SecondaryListener());
        eventManager.registerListeners(instance,
                new StartListener());
        eventManager.registerListeners(instance, new DropItemListener());
    }
}
