package org.example.minevidencia.essentialEmEvidencia.Listener;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class PlayerReceiveExp implements Listener {

    public PlayerReceiveExp(){
    }

    public void onPlayerReceiveExpFromAnotherPlayer(Player player, CommandSender sender){
        PlayerExpChangeEvent eventExp = (PlayerExpChangeEvent) player;
        System.out.println("Você recebeu "+ eventExp.getAmount() + "niveis de exp do jogador " + sender.getServer().getPlayer(sender.getName()));
    }
}
