package org.example.minevidencia.essentialEmEvidencia.Commnad;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.example.minevidencia.essentialEmEvidencia.Domain.Experience;
import org.example.minevidencia.essentialEmEvidencia.Listener.PlayerReceiveExp;
import org.jetbrains.annotations.NotNull;

public class GiveExperience implements CommandExecutor {

    private final PlayerReceiveExp playerReceiveExp;

    public GiveExperience(PlayerReceiveExp playerReceiveExp) {
        this.playerReceiveExp = playerReceiveExp;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        Player player = sender.getServer().getPlayer(sender.getName());
        try {
            if (player == null) {
                return false;
            }

            int amountExperience = Integer.parseInt(args[1]);

            if (amountExperience <= 0) {
                sender.sendMessage("Digite um valor maior que 0!");
                return false;
            }

            if (args.length == 2) {
                if (player.getExpToLevel() < amountExperience) {
                    sender.sendMessage("Você não possui experiencia o suficiente!");
                    return false;
                }

                for (Player targetPlayer : sender.getServer().getOnlinePlayers()) {
                    if (!targetPlayer.isOnline()) {
                        return false;
                    }
                    if (args[0].equals(targetPlayer.getName())) {
                        float teste = Float.parseFloat(args[1]);
                        System.out.println("Função getLevelFromExp -> " + Experience.getLevelFromExp(amountExperience));
                        System.out.println("Função add exp -> " + Experience.changePlayerExp(player, amountExperience));
                        System.out.println("Função que calcula total levels -> " + Experience.getIntLevelFromExp(amountExperience));
                        System.out.println("Função getTotalExperience -> " + player.getTotalExperience());
                        System.out.println("Função getExperiencePointsNeededForNextLevel -> " + player.getExperiencePointsNeededForNextLevel());
                        System.out.println("Função player.calculateTotalExperiencePoints() -> " + player.calculateTotalExperiencePoints());
                        System.out.println("Função getExpToLevel -> " + player.getExpToLevel());
                        System.out.println("Função getExpCooldown -> " + player.getExpCooldown());
                        //player.sendExperienceChange(teste, amountExperience);
                        //targetPlayer.giveExp(amountExperience);
                        //sender.sendMessage("Transferencia realizada com sucesso! valor transferido: " + amountExperience);
                        //this.playerReceiveExp.onPlayerReceiveExpFromAnotherPlayer(targetPlayer, amountExperience);
                    }
                }
                return true;
            }

        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            throw new RuntimeException(e);
            //sender.sendMessage("Algo deu errado, verifique se o comando digitado está correto!");
        }
        return false;
    }
}
