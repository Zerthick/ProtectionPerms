package io.github.zerthick.protectionperms;


import com.google.inject.Inject;
import io.github.zerthick.protectionperms.events.ListenerRegister;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

@Plugin(id = "ProtectionPerms", name = "ProtectionPerms", version = "0.0.1")
public class ProtectionPermsMain {

    @Inject
    private Logger logger;
    @Inject
    private PluginContainer instance;
    private ListenerRegister listenerRegister;

    public Logger getLogger() {
        return logger;
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {

        //Register Event Listeners
        listenerRegister = new ListenerRegister(instance);
        listenerRegister.registerListeners();

        // Log Start Up to Console
        getLogger().info(
                instance.getName() + " version " + instance.getVersion()
                        + " enabled!");
    }


}
