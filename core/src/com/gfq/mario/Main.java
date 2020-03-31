package com.gfq.mario;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

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
    ScreenViewport screenViewport;
    BTManager btManager;

    ZYActor zyActor;
    ZFActor zfActor;

    @Override
    public void create() {
        screenViewport = new ScreenViewport();
        stage = new Stage();
//        ZYActor zyActor = new ZYActor(stage, 50, 50, 100, 70);
        Array<Actor> players = new Array<>();
        for (int i = 0; i < 6; i++) {
            players.add(new ZYActor());
        }

        Array<Actor> enemys = new Array<>();
        for (int i = 0; i < 6; i++) {
            enemys.add(new ZFActor());
        }

        btManager = new BTManager(stage,players,enemys);
    }

    @Override
    public void resize(int width, int height) {
        screenViewport.update(width, height);
    }


    @Override
    public void render() {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float deltaTime = Gdx.graphics.getDeltaTime();

        btManager.update(deltaTime);

        stage.act();
        stage.draw();

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
