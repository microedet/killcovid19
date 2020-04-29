package com.vicente.pastor.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final Color BACKGROUND_COLOR = Color.SKY;
    public static final float WORLD_SIZE = 900;

    public static final String TEXTURE_ATLAS = "images/capitanByte.atlas";

    //parados
    public static final String PARADO_DERECHA = "disparoderecha03";
    public static final String PARADO_IZQUIERDA = "disparoizquierda03";

    //paseo a la derecha
    public static final String PASEO_DERECHA01 = "paseoderecha01";
    public static final String PASEO_DERECHA02 = "paseoderecha02";
    public static final String PASEO_DERECHA03 = "paseoderecha03";
    public static final String PASEO_DERECHA04 = "paseoderecha04";
    public static final String PASEO_DERECHA05 = "paseoderecha05";
    public static final String PASEO_DERECHA06 = "paseoderecha06";

    //paseo a la izquierda
    public static final String PASEO_IZQUIERDA01="paseoizquierda01";
    public static final String PASEO_IZQUIERDA02="paseoizquierda02";
    public static final String PASEO_IZQUIERDA03="paseoizquierda03";
    public static final String PASEO_IZQUIERDA04="paseoizquierda04";
    public static final String PASEO_IZQUIERDA05="paseoizquierda05";
    public static final String PASEO_IZQUIERDA06="paseoizquierda06";

    /*
    //disparo a la derecha
    public static final String DISPARO_DERECHA01 = "disparoderecha01";
    public static final String DISPARO_DERECHA02 = "disparoderecha02";
    public static final String DISPARO_DERECHA03 = "disparoderecha03";
    public static final String DISPARO_DERECHA04 = "disparoderecha04";

    //disparo a la derecha
    public static final String DISPARO_IZQUIERDA01 = "disparoizquierda01";
    public static final String DISPARO_IZQUIERDA02 = "disparoizquierda02";
    public static final String DISPARO_IZQUIERDA03 = "disparoizquierda03";
    public static final String DISPARO_IZQUIERDA04 = "disparoizquierda04";
    */

    //laser
    public static final String LASER_IMAGEN = "laser";
    public static final float LASER_VELOCIDAD = 150f;
    public static final Vector2 LASER_CENTRO = new Vector2(3, 2);
    public static final Vector2 PISTOLA_LASER_OFFSET= new Vector2(12,-7);
    public static final float TIEMPO_DISPARO= 0.25f;






    public static final Vector2 CAPITAN_EYE_POSITION = new Vector2(16, 24);

    public static final float CAPITAN_EYE_HEIGHT = 16.0f;

    //velocidad movimiento
    public static final float CAPITAN_MOVE_SPEED= WORLD_SIZE/2;

    //duracion del paseo a pie
    public static final float PASEO_DURACION= 0.25f;

}
