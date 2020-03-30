package com.gfq.mario;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * create by 高富强
 * on {2020/3/27} {10:37}
 * desctapion:
 */
public class Main implements ApplicationListener {

    Stage stage;
//    AbsActor a1;
//    AbsActor a2;
//    AbsActor a3;
//    AbsActor a4;
    @Override
    public void create() {
        stage = new Stage();
        new ZYActor(stage,50,50,100,70);
        new ZFActor(stage,50,130,100,70);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
//        a1.act(Gdx.graphics.getDeltaTime());

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
