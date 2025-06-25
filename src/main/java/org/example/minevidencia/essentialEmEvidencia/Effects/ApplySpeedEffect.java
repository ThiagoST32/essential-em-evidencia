package org.example.minevidencia.essentialEmEvidencia.Effects;

import org.bukkit.command.CommandSender;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.example.minevidencia.essentialEmEvidencia.Listerners.MessageOnApplyCommand;

public class ApplySpeedEffect {
    private final MessageOnApplyCommand message;
    int speedIncrease;
    private PotionEffect potionEffect;

    public ApplySpeedEffect(MessageOnApplyCommand message) {
        this.message = message;
    }

    public PotionEffect execute(String args, CommandSender sender) {
        try {
            speedIncrease = Integer.parseInt(args);
            potionEffect = new PotionEffect(
                    PotionEffectType.SPEED,
                    PotionEffect.INFINITE_DURATION,
                    speedIncrease,
                    true,
                    true
            );
            this.message.onCommandApplySuccess(sender);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            this.message.onCommandApplyError(sender);
        }
        return potionEffect;
    }
}
