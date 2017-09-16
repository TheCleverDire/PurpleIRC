/*
 * Copyright (C) 2014 cnaude
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.cnaude.purpleirc.Hooks;

import com.cnaude.purpleirc.PurpleIRC;
import de.myzelyam.api.vanish.VanishAPI;
import java.util.List;
import java.util.UUID;
import org.bukkit.entity.Player;

/**
 *
 * @author Chris Naude
 */
public class SuperVanishHook {

    final PurpleIRC plugin;

    /**
     *
     * @param plugin the PurpleIRC plugin
     */
    public SuperVanishHook(PurpleIRC plugin) {
        this.plugin = plugin;
    }

    /**
     *
     * @param player
     * @return
     */
    public boolean isVanished(Player player) {
        List<UUID> allinvisiblePlayers = VanishAPI.getAllInvisiblePlayers();
        for (UUID uuid : allinvisiblePlayers) {
            if (uuid.equals(player.getUniqueId())) {
                plugin.logDebug("Player " + player.getName() + " is vanished.");
                return true;
            }
        }
        plugin.logDebug("Player " + player.getName() + " is not vanished.");
        return false;
    }
}
