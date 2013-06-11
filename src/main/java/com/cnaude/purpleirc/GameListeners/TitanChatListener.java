/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnaude.purpleirc.GameListeners;

import com.cnaude.purpleirc.PurpleIRC;
import com.titankingdoms.dev.titanchat.core.participant.Participant;
import com.titankingdoms.dev.titanchat.event.ChannelChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 *
 * @author cnaude
 */
public class TitanChatListener implements Listener {

    final PurpleIRC plugin;

    public TitanChatListener(PurpleIRC plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.NORMAL)
    public void onChannelChatEvent(ChannelChatEvent event) {
        Participant participant = event.getSender();
        Player player = plugin.getServer().getPlayer(participant.getName());
        String tChannel = event.getChannel().getName();
        String tColor = event.getChannel().getDisplayColour();
        if (player.hasPermission("irc.message.gamechat")) {
            for (String botName : plugin.ircBots.keySet()) {
                if (plugin.botConnected.get(botName)) {
                    plugin.ircBots.get(botName).titanChat(participant, tChannel, tColor, event.getMessage());
                }
            }
        }
    }
}