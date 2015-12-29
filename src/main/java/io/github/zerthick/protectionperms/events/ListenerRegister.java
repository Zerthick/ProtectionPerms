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

package io.github.zerthick.protectionperms.events;

import io.github.zerthick.protectionperms.events.listeners.ListenerManager;
import io.github.zerthick.protectionperms.events.listeners.block.BlockListenerManager;
import io.github.zerthick.protectionperms.events.listeners.entity.EntityListenerManager;
import io.github.zerthick.protectionperms.events.listeners.item.ItemListenerManager;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.HashSet;
import java.util.Set;

public class ListenerRegister {

    private PluginContainer container;

    public ListenerRegister(PluginContainer container) {
        this.container = container;
    }

    public void registerListeners() {

        Set<ListenerManager> listenerManagerSet = new HashSet<>();
        listenerManagerSet.add(new BlockListenerManager());
        listenerManagerSet.add(new EntityListenerManager());
        listenerManagerSet.add(new ItemListenerManager());

        EventManager eventManager = Sponge.getGame().getEventManager();
        Object instance = container.getInstance().get();

        for(ListenerManager listenerManager : listenerManagerSet){
            for(Object listener : listenerManager.getListeners()){
                eventManager.registerListeners(instance, listener);
            }
        }
    }
}
