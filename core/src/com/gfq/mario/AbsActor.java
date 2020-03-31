package com.gfq.mario;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;

/**
 * create by 高富强
 * on {2020/3/27} {10:40}
 * desctapion:
 */
public abstract class AbsActor extends Table {

    private StateManager.AbsActorState state = StateManager.AbsActorState.alive;
    private StateManager.BTType btType = StateManager.BTType.clear;
    private ActionsOver actionsOver;
    private AbsActor otherActor;
    //    private int index;
    Texture texture;
    int x, y;
    int id;

    public AbsActor() {

        int actorBlood = getActorBlood();
        String actorName = getActorName();

        BitmapFont bitmapFont = new BitmapFont();
        Label blood = new Label(actorBlood + "", new Label.LabelStyle(bitmapFont, Color.PINK));
        blood.setFontScale(2);
        Label name = new Label(actorName, new Label.LabelStyle(bitmapFont, Color.WHITE));
        name.setFontScale(2);

        top();
        add(blood).expand();

        row().expand();
        add(name);
        setDebug(true);


    }

//    protected abstract int getIndex();


    protected abstract String getActorName();

    protected abstract int getActorBlood();

    public void setState(StateManager.AbsActorState state) {
        this.state = state;
    }

    private void setBtType(StateManager.BTType btType) {
        this.btType = btType;
    }

//    @Override
//    public void draw(Batch batch, float parentAlpha) {
//        batch.draw(texture, getX(), getY());
//    }

    //    boolean addOnceActions = true;
//
//    public void setFlag(boolean flag) {
//        this.addOnceActions = flag;
//    }

    public void attack(AbsActor otherActor) {
        this.otherActor = otherActor;

        this.setBtType(StateManager.BTType.attack);
        otherActor.setBtType(StateManager.BTType.defence);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (btType == StateManager.BTType.attack) {
            addActions();
//            btType = StateManager.BTType.clear;
        }
        if (btType == StateManager.BTType.defence) {
            btType = StateManager.BTType.clear;
        }


        if (state == StateManager.AbsActorState.alive) {
            Array<Action> actions = getActions();
            if ((actions == null || actions.size == 0)) {
                btType = StateManager.BTType.clear;
            }
        }

        if (state == StateManager.AbsActorState.die) {
            setVisible(false);
        }
    }

    public interface ActionsOver {
        void actionOver(float delta);
    }


    public AbsActor addActions() {
        MoveToAction moveToAction = Actions.moveTo(otherActor.getX() - getWidth(), otherActor.getY(), 1f, Interpolation.elastic);
        MoveToAction moveToAction2 = Actions.moveTo(getX(), getY(), 0.8f);
        SequenceAction sequence = Actions.sequence(moveToAction, moveToAction2);
        addAction(sequence);
        return this;
    }
}
