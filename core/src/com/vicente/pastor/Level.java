package com.vicente.pastor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vicente.pastor.entities.CapitanByte;

public class Level {

    CapitanByte capitanByte;
    //Laser laser;

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
