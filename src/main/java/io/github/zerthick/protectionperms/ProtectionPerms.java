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
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.spongepowered.api.asset.Asset;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import java.io.IOException;
import java.nio.file.Path;

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
    @Inject
    @DefaultConfig(sharedRoot = true)
    private Path defaultConfig;

    public Logger getLogger() {
        return logger;
    }

    public PluginContainer getInstance() {
        return instance;
    }


    @Listener
    public void onServerInit(GameInitializationEvent event) {

        ConfigurationLoader<CommentedConfigurationNode> configLoader = HoconConfigurationLoader.builder().setPath(defaultConfig).build();

        //Generate default config if it doesn't exist
        if (!defaultConfig.toFile().exists()) {
            Asset defaultConfigAsset = getInstance().getAsset("DefaultConfig.conf").get();
            try {
                defaultConfigAsset.copyToFile(defaultConfig);
                configLoader.save(configLoader.load());
            } catch (IOException e) {
                logger.error("Error loading default config! Error: " + e.getMessage());
            }
        }
        //Load invert
        try {
            CommentedConfigurationNode modeNode = configLoader.load().getNode("mode");
            if (modeNode.isVirtual()) {
                logger.warn("Config corrupt! Using defaults (whitelist mode)\nDelete " + instance.getId() + ".conf to fix");
            }
            String mode = modeNode.getString("whitelist");
            if (mode.equals("whitelist")) {
                PermHandler.getInstance().init(false);
            } else if (mode.equals("blacklist")){
                PermHandler.getInstance().init(true);
            }
        } catch (IOException e) {
            logger.error("Error loading config! Error: " + e.getMessage());
        }

        DebugLogger.getInstance().setLogger(logger);

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
