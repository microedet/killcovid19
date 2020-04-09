package com.vicente.pastor.util;

import com.badlogic.gdx.graphics.Camera;
import com.vicente.pastor.entities.CapitanByte;

public class CamaraSeguimiento {

    private Camera camera;
    private CapitanByte objeto;

    public CamaraSeguimiento( Camera camera,CapitanByte objeto) {
        this.camera = camera;
        this.objeto = objeto;
    }

    public void update(){
        camera.position.x = objeto.position.x;
        camera.position.y = objeto.position.y;

    }

}
