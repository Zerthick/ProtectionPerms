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

package io.github.zerthick.protectionperms.events.listeners.entity;


import io.github.zerthick.protectionperms.events.listeners.ListenerManager;
import io.github.zerthick.protectionperms.events.listeners.entity.interactEntityEvent.PrimaryListener;
import io.github.zerthick.protectionperms.events.listeners.entity.interactEntityEvent.SecondaryListener;

import java.util.LinkedList;
import java.util.List;

public class EntityListenerManager implements ListenerManager{

    private List<Object> listeners;

    public EntityListenerManager() {
        listeners = new LinkedList<>();
        listeners.add(new PrimaryListener());
        listeners.add(new SecondaryListener());
        listeners.add(new DamageEntityListener());
        listeners.add(new RideEntityMountListener());
        listeners.add(new TameEntityListener());
    }

    @Override
    public List<Object> getListeners() {
        return listeners;
    }
}
