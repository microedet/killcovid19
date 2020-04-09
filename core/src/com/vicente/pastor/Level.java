package com.vicente.pastor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vicente.pastor.entities.CapitanByte;
import com.vicente.pastor.entities.Platform;

import java.lang.reflect.Array;

public class Level {

    CapitanByte capitanByte;
    //array de virus
    //Array<Platform>

    public Level() {

        capitanByte=new CapitanByte();


    }

    public void update(float delta) {

        capitanByte.update(delta);
        //laser.update(delta);

    }

    public void render(SpriteBatch batch) {

        batch.begin();
        capitanByte.render(batch);
        batch.end();


    }

    //Crear clase para añadir laser

}
