package org.example.minevidencia.essentialEmEvidencia;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.minevidencia.essentialEmEvidencia.Effects.ApplySpeedEffect;
import org.example.minevidencia.essentialEmEvidencia.Listerners.MessageOnApplyCommand;
import org.example.minevidencia.essentialEmEvidencia.apply.IncreaseSpeed;
import org.example.minevidencia.essentialEmEvidencia.apply.VerifyIncreaseSpeed;

public final class EssentialEmEvidencia extends JavaPlugin {

    @Override
    public void onEnable() {
        MessageOnApplyCommand message = new MessageOnApplyCommand();
        VerifyIncreaseSpeed verifyIncreaseSpeed = new VerifyIncreaseSpeed();
        ApplySpeedEffect applySpeedEffect = new ApplySpeedEffect(message);
        getLogger().info("Plugin de comando iniciado!");
        getCommand("speed").setExecutor(new IncreaseSpeed(message, verifyIncreaseSpeed, applySpeedEffect));

    }

    @Override
    public void onDisable() {
    }
}
