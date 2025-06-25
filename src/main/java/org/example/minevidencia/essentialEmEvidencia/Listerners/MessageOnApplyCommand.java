package org.example.minevidencia.essentialEmEvidencia.Listerners;

import org.bukkit.command.CommandSender;

public class MessageOnApplyCommand {

    public void onCommandApply(CommandSender event) {
        event.sendMessage("O comando está sendo aplicado. Por favor, aguarde.");
    }

    public void onCommandApplyError(CommandSender event) {
        event.sendMessage("O comando não foi aplicado. Por favor, verifique se você digitou o comando corretamente.");
    }

    public void onCommandApplySuccess(CommandSender event) {
        event.sendMessage("O comando foi aplicado com sucesso!.");
    }

    public void onCommandApplyErrorIndexOutBound(CommandSender event) {
        event.sendMessage("O comando não foi aplicado. Verifique se você digitou o comando corretamente e se o índice está dentro do intervalo permitido.");
    }

    public void onCommandApplyOnPlayerOff(CommandSender event){
        event.sendMessage("O comando não foi apicado. O jogador especificado não está online!");
    }
}
