package com.gfq.mario;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * create by 高富强
 * on {2020/3/30} {18:37}
 * desctapion:
 */
public class ZYActor extends AbsActor {

    @Override
    protected String getActorName() {
        return "zy";
    }

    @Override
    protected int getActorBlood() {
        return 5000;
    }
}
