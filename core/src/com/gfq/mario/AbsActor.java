package com.gfq.mario;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
public abstract class AbsActor extends Actor {

    private StateManager.AbsActorState state = StateManager.AbsActorState.alive;
    private ActionsOver actionsOver;
    Texture texture;
    int x,y;
    int id;
    public AbsActor(Stage stage, int x, int y, int w, int h) {
//        stage.addActor(this);

        int actorBlood = getActorBlood();
        String actorName = getActorName();
        this.x=x;
        this.y=y;

        setBounds(x, y, w, h);

//        Pixmap pixmap = new Pixmap(w, h, Pixmap.Format.RGBA8888);
//        pixmap.setColor(1, 0.5f, 1, 1);
//        pixmap.fillRectangle(0, 0, w, h);

        BitmapFont bitmapFont = new BitmapFont();
        Label blood = new Label(actorBlood+"",new Label.LabelStyle(bitmapFont, Color.PINK));
//        blood.setDebug(true);
//        blood.setWidth(w);
//        blood.setHeight(h/3);

        Label name = new Label(actorName,new Label.LabelStyle(bitmapFont, Color.WHITE));
//        Label label = new Label("xx",new Label.LabelStyle(new BitmapFont(), Color.PINK));
//        name.setDebug(true);
        Table table = new Table();
        table.setBounds(x,y,w,h);

        table.top();
        table.add(blood).expand();

        table.row().expand();
        table.add(name);
        table.setDebug(true);


        stage.addActor(table);




//        texture = new Texture(pixmap, Pixmap.Format.RGBA8888, false);
        this.actionsOver = actionsOver;
//        if(id==5){
//            doActions();
//        }

//        doActions();
    }


    protected abstract String getActorName();

    protected abstract int getActorBlood();

    public void setState(StateManager.AbsActorState state) {
        this.state = state;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY());
    }

    boolean addOnceActions = true;

    public void setFlag(boolean flag) {
        this.addOnceActions = flag;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(addOnceActions) {
            if (state == StateManager.AbsActorState.alive) {
                Array<Action> actions = getActions();
                if ((actions == null || actions.size == 0)) {
                    System.out.println("xx  act");
//                    if (actionsOver != null) actionsOver.actionOver(delta);
                    addOnceActions = false;
                }
            }
        }
    }

    public interface ActionsOver {
        void actionOver(float delta);
    }


    public AbsActor doActions(){
        MoveToAction moveToAction = Actions.moveTo(400, 400, 1f);
        MoveToAction moveToAction2 = Actions.moveTo(x, y, 1f);
        SequenceAction sequence = Actions.sequence(moveToAction, moveToAction2);
        addAction(sequence);
//        sequence.setActor(this);
        return this;
    }
}
