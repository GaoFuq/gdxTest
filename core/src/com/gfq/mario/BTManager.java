package com.gfq.mario;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

/**
 * create by 高富强
 * on {2020/3/31} {10:19}
 * desctapion:
 */
public class BTManager {
    Stage stage;
    Array<Actor> players;
    Array<Actor> enemys;
    public BTManager(Stage stage,Array<Actor> players,Array<Actor> enemys) {
        this.players = players;
        this.enemys = enemys;
        this.stage = stage;

        for (int i = 0; i < players.size; i++) {
            if(i<3){
                players.get(i).setBounds(50,50+i*100,100,70);
            }else {
                players.get(i).setBounds(200,50+(i-3)*100,100,70);
            }
            stage.addActor(players.get(i));
        }

        for (int i = 0; i < enemys.size; i++) {
            if(i<3){
                enemys.get(i).setBounds(600,50+i*100,100,70);
            }else {
                enemys.get(i).setBounds(750,50+(i-3)*100,100,70);
            }
            stage.addActor(enemys.get(i));

        }
    }


    public void update(float deltaTime) {

    }
}
