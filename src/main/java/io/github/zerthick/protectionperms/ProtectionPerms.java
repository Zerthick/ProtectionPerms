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

package io.github.zerthick.protectionperms;


import com.google.inject.Inject;
import io.github.zerthick.protectionperms.events.ListenerRegister;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

@Plugin(id = "protectionperms",
        name = "ProtectionPerms",
        description = "A simple player protection and control plugin.",
        authors = {
                "Zerthick"
        }
)
public class ProtectionPerms {

    @Inject
    private Logger logger;
    @Inject
    private PluginContainer instance;

    public Logger getLogger() {
        return logger;
    }

    public PluginContainer getInstance() {
        return instance;
    }
    

    @Listener
    public void onServerInit(GameInitializationEvent event) {

        DebugLogger.getInstance().setLogger(logger);

        PermHandler.getInstance().init(false);

        //Register Event Listeners
        ListenerRegister.registerListeners(this);
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {

        // Log Start Up to Console
        getLogger().info(
                instance.getName() + " version " + instance.getVersion().orElse("")
                        + " enabled!");
    }
}
