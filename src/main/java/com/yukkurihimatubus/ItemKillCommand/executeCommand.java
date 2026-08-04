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

import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

//BasicCommandに準じて実装
public class executeCommand{

    //「/itemkill」コマンド実行時の実際の動作
    public void execute(CommandContext<CommandSourceStack> context) {

        var sender = context.getSource().getSender(); //senderを取得



        //アイテムの数を保持する変数
        long count = 0;


        for (World world : Bukkit.getWorlds()) { //ワールドを取り出す
            for (Entity entity : world.getEntities()) { //ワールド内のエンティティを取り出す

                if (entity instanceof Item item) { //エンティティがアイテムなら
                    item.remove(); //削除する
                    count++; //カウントを1増やす
                }

            }
        }

        if (count > 0) { //カウントが1以上ならば
            sender.sendMessage(
                    "§7落ちているアイテムを" + count + "個削除しました" //削除したよ
            );
        } else { //ではないなら
            sender.sendMessage(
                    "§7落ちているアイテムが無かったためアイテムを削除できませんでした。" //無理だった
            );
        }
    }
}