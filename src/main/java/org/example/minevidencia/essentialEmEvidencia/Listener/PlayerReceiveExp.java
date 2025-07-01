package org.example.minevidencia.essentialEmEvidencia.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class PlayerReceiveExp implements Listener {

    public PlayerReceiveExp(){
    }

    public void onPlayerReceiveExpFromAnotherPlayer(Player player, Integer amount){
        PlayerExpChangeEvent eventExp = new PlayerExpChangeEvent(player, amount);
        System.out.println("Você recebeu "+ eventExp.getAmount() + "niveis de exp do jogador tal");
    }
}
