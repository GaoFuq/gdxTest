package com.gfq.mario;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * create by 高富强
 * on {2020/3/30} {18:40}
 * desctapion:
 */
public class ZFActor extends AbsActor {
    public ZFActor(Stage stage, int x, int y, int w, int h) {
        super(stage, x, y, w, h);
    }

    @Override
    protected String getActorName() {
        return "ZF";
    }

    @Override
    protected int getActorBlood() {
        return 4000;
    }
}
