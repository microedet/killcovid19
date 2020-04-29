package com.vicente.pastor.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.vicente.pastor.util.Assets;
import com.vicente.pastor.util.Constants;
import com.vicente.pastor.util.Enums;
import com.vicente.pastor.util.Utils;

import java.awt.Event;

public class CapitanByte {

    public final static String TAG=CapitanByte.class.getName();
    //public Event position;

    //añadimos un vector de posicion,frame para paseo,velocidad
    public Vector2 position;
    Vector2 ultimoFrame;
    Vector2 velocidad;

    Enums.Dire direccion;
    Enums.Paseo paseo;

    //tiempo de inicio del paseo
    long tiempoinicioPaseo;


    //constructor
    public CapitanByte(){
        position = new Vector2(200, 20);
        //Se elige a la derecha
        direccion = Enums.Dire.RIGHT;
        ultimoFrame= new Vector2(position);
        velocidad = new Vector2();
        paseo= Enums.Paseo.PARADO;

    }

    public void update(float delta) {

        ultimoFrame.set(position);
        //velocidad.y -= Const
        position.mulAdd(velocidad,delta);

        //si se pulsa la tecla de la izquierda
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(delta);
        }else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            moveRight(delta);
        }else{
            paseo= Enums.Paseo.PARADO;
        }

        //disparo su pulsa x
        if(Gdx.input.isKeyPressed(Input.Keys.X)){

            //vector para la posicion del laser
            Vector2 laserposicion;
            if(direccion== Enums.Dire.RIGHT){
                laserposicion = new Vector2(
                        position.x + Constants.PISTOLA_LASER_OFFSET.x,
                        position.y + Constants.PISTOLA_LASER_OFFSET.y
                );
            }
            else {
                laserposicion =new Vector2(
                        position.x - Constants.PISTOLA_LASER_OFFSET.x,
                        position.y + Constants.PISTOLA_LASER_OFFSET.y
                );

            }
        }

    }

    private void moveLeft(float delta) {
        //direccion a la izquierda
        //direccion=Dire.LEFT;
        //position.x -= delta * Constants.CAPITAN_MOVE_SPEED;
        if(paseo != Enums.Paseo.PASEANDO){
            tiempoinicioPaseo = TimeUtils.nanoTime();
        }
        paseo= Enums.Paseo.PASEANDO;
        direccion= Enums.Dire.LEFT;
        position.x -=delta * Constants.CAPITAN_MOVE_SPEED;
    }

    private void moveRight(float delta) {
        //direccion a la derecha
        //direccion=Dire.RIGHT;
        //position.x += delta * Constants.CAPITAN_MOVE_SPEED;
        if(paseo != Enums.Paseo.PASEANDO){
            tiempoinicioPaseo = TimeUtils.nanoTime();
        }
        paseo= Enums.Paseo.PASEANDO;
        direccion= Enums.Dire.RIGHT;
        position.x +=delta * Constants.CAPITAN_MOVE_SPEED;

    }

    public void render(SpriteBatch batch) {

        TextureRegion region=(Assets.instance.capitanByteAssets.paradoDerecha);

        if (direccion == Enums.Dire.RIGHT && paseo== Enums.Paseo.PARADO) {
            region = Assets.instance.capitanByteAssets.paradoDerecha;
        } else if (direccion == Enums.Dire.RIGHT && paseo == Enums.Paseo.PASEANDO) {
            float tiempotranscurrido= MathUtils.nanoToSec * (TimeUtils.nanoTime() - tiempoinicioPaseo);
            //eleccion del frame right
            region = (TextureRegion) Assets.instance.capitanByteAssets.paseoDerechaAnimacion.getKeyFrame(tiempotranscurrido);
        } else if (direccion == Enums.Dire.LEFT && paseo== Enums.Paseo.PARADO){
            region = Assets.instance.capitanByteAssets.paradoIzquierda;
        } else if(direccion == Enums.Dire.LEFT && paseo== Enums.Paseo.PASEANDO){
            float tiempotranscurrido= MathUtils.nanoToSec * (TimeUtils.nanoTime() - tiempoinicioPaseo);
            //eleccion del frame right
            region = (TextureRegion) Assets.instance.capitanByteAssets.paseoIzquierdaAnimacion.getKeyFrame(tiempotranscurrido);


        }

        Utils.drawTextureRegion(batch,region,
                position.x - Constants.CAPITAN_EYE_POSITION.x,
                position.y - Constants.CAPITAN_EYE_POSITION.y
        );



    }




}
