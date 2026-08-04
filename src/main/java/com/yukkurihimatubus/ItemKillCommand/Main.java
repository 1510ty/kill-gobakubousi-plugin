//        kill Gobakubousi plugin
//        Copyright (C) 2026  yukkurihimatubus
//
//        This program is free software: you can redistribute it and/or modify
//        it under the terms of the GNU General Public License as published by
//        the Free Software Foundation, either version 3 of the License, or
//        (at your option) any later version.
//
//        This program is distributed in the hope that it will be useful,
//        but WITHOUT ANY WARRANTY; without even the implied warranty of
//        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//        GNU General Public License for more details.
//
//        You should have received a copy of the GNU General Public License
//        along with this program.  If not, see https://www.gnu.org/licenses/.

package com.yukkurihimatubus.ItemKillCommand;

import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("kill Gobakubousi plugin が正常に読み込まれました");
        getLogger().info("開発: yukkurihimatubus");
        getLogger().info("ほんのちょっとだけ手助け: 1510ty");

        executeCommand executecmd = new executeCommand(); //実体化

        //コマンドを登録
        getLifecycleManager().registerEventHandler(
                LifecycleEvents.COMMANDS,
                event -> {
                    event.registrar().register(
                            Commands.literal("itemkill")
                                    .requires(source -> source.getSender().hasPermission("itemkill.use")) // ここで権限を設定すると非表示になります！
                                    .executes(context -> {
                                        executecmd.execute(context);
                                        return 1;
                                    })
                                    .build(),
                            "落ちているアイテムを削除"
                    );
                }
        );
    }

}