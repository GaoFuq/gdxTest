package com.gfq.mario;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * create by 高富强
 * on {2020/3/30} {18:37}
 * desctapion:
 */
public class ZYActor extends AbsActor {
    public ZYActor(Stage stage, int x, int y, int w, int h) {
        super(stage, x, y, w, h);
    }

    @Override
    protected String getActorName() {
        return "zy";
    }

    @Override
    protected int getActorBlood() {
        return 5000;
    }
}
