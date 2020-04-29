package com.vicente.pastor.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.vicente.pastor.util.Assets;
import com.vicente.pastor.util.Constants;
import com.vicente.pastor.util.Enums;
import com.vicente.pastor.util.Utils;

public class Laser {

    //se elegimos el enum de la direcion
    private  Enums.Dire dire;
    public boolean active;
    private Vector2 position;

    //constructor con posicion y director
    public Laser(Vector2 position, Enums.Dire dire){
        this.position = position;
        this.dire = dire;
        active = true;
    }

    public void update(float delta) {
        switch (dire) {
            case LEFT:
                position.x -= delta * Constants.LASER_VELOCIDAD;
                break;
            case RIGHT:
                position.x += delta * Constants.LASER_VELOCIDAD;
                break;
        }

    }

    public void render(SpriteBatch batch) {
        TextureRegion region = Assets.instance.laserAssets.laser;
        Utils.drawTextureRegion(batch, region, position, Constants.LASER_CENTRO);
    }
}
