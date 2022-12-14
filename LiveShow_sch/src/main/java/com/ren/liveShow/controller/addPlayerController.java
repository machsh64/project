package com.ren.liveshow.controller;

import com.ren.liveshow.pojo.Player;
import com.ren.liveshow.service.GameService;
import com.ren.myssm.util.StringUtil;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-12-19 18:48
 * @description:
 **/
public class addPlayerController {

    GameService gameService;

    public String addPlayer(String playerName,Integer score){
        if (!StringUtil.isEmpty(playerName)) {
            Player player = new Player(playerName, score);
            gameService.addPlayer(player);
        }
        return "redirect:index.do?operate=index&page=rank1";
    }
}
