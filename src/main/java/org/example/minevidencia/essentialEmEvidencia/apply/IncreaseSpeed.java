package org.example.minevidencia.essentialEmEvidencia.apply;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.example.minevidencia.essentialEmEvidencia.Effects.ApplySpeedEffect;
import org.example.minevidencia.essentialEmEvidencia.Listerners.MessageOnApplyCommand;

public class IncreaseSpeed implements CommandExecutor {
    private final MessageOnApplyCommand message;
    private final VerifyIncreaseSpeed verifyIncreaseSpeed;
    private final ApplySpeedEffect applySpeedEffect;

    public IncreaseSpeed(MessageOnApplyCommand message, VerifyIncreaseSpeed verifyIncreaseSpeed, ApplySpeedEffect applySpeedEffect) {
        this.message = message;
        this.verifyIncreaseSpeed = verifyIncreaseSpeed;
        this.applySpeedEffect = applySpeedEffect;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        try {
            if (args[0].isEmpty()) {
                this.message.onCommandApplyError(sender);
                return false;
            }

            if (args.length == 1) {
                if (sender instanceof ConsoleCommandSender) {
                    sender.sendMessage("Apenas jogadores podem usar esse comando!");
                    return false;
                }
                Player player = sender.getServer().getPlayer(sender.getName());
                if (player != null){
                    if (Integer.parseInt(args[0]) == 0) {
                        player.removePotionEffect(PotionEffectType.SPEED);
                        this.message.onCommandApply(sender);
                        return true;
                    }
                    if (!this.verifyIncreaseSpeed.isValidSpeedIncrease(Integer.parseInt(args[0]))) {
                        this.message.onCommandApplyErrorIndexOutBound(sender);
                        return false;
                    }
                    return player.addPotionEffect(this.applySpeedEffect.execute(args[0], sender));
                }
            }

            if (args.length == 2 || sender instanceof ConsoleCommandSender) {
                for (Player onlinePlayer : sender.getServer().getOnlinePlayers()) {
                    if (onlinePlayer.isOnline() && onlinePlayer.getName().equals(args[0])) {
                        if (!this.verifyIncreaseSpeed.isValidSpeedIncrease(Integer.parseInt(args[1]))) {
                            this.message.onCommandApplyErrorIndexOutBound(sender);
                            return false;
                        }
                        if (args[1].equals("0")) {
                            onlinePlayer.removePotionEffect(PotionEffectType.SPEED);
                            return true;
                        }
                        return onlinePlayer.addPotionEffect(this.applySpeedEffect.execute(args[1], sender));
                    }
                    this.message.onCommandApplyOnPlayerOff(sender);
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            this.message.onCommandApplyError(sender);
        }
        return false;
    }
}
