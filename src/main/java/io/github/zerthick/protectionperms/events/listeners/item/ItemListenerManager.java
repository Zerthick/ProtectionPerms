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

package io.github.zerthick.protectionperms.events.listeners.item;

import io.github.zerthick.protectionperms.events.listeners.ListenerManager;
import io.github.zerthick.protectionperms.events.listeners.item.interactBlockEvent.PrimaryBlockListener;
import io.github.zerthick.protectionperms.events.listeners.item.interactBlockEvent.SecondaryBlockListener;
import io.github.zerthick.protectionperms.events.listeners.item.interactEntityEvent.PrimaryEntityListener;
import io.github.zerthick.protectionperms.events.listeners.item.interactEntityEvent.SecondaryEntityListener;

import java.util.LinkedList;
import java.util.List;

public class ItemListenerManager implements ListenerManager{

    private List<Object> listeners;

    public ItemListenerManager() {
        listeners = new LinkedList<>();
        listeners.add(new PrimaryBlockListener());
        listeners.add(new SecondaryBlockListener());
        listeners.add(new PrimaryEntityListener());
        listeners.add(new SecondaryEntityListener());
        listeners.add(new UseItemListener());
        listeners.add(new DropItemListener());
        listeners.add(new CraftItemListener());
    }

    @Override
    public List<Object> getListeners() {
        return listeners;
    }
}
