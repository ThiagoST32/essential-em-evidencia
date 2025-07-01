package org.example.minevidencia.essentialEmEvidencia;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.minevidencia.essentialEmEvidencia.Commnad.GiveExperience;
import org.example.minevidencia.essentialEmEvidencia.Listener.PlayerReceiveExp;

public final class EssentialEmEvidencia extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("exp").setExecutor(new GiveExperience(new PlayerReceiveExp()));
    }

    @Override
    public void onDisable() {
    }
}
