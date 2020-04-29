package com.vicente.pastor.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG= Assets.class.getName();
    public static final Assets instance= new Assets();

    public CapitanByteAssets capitanByteAssets;
    private AssetManager assetManager;
    public LaserAssets laserAssets;

    private Assets(){}

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);
        capitanByteAssets = new CapitanByteAssets(atlas);
        laserAssets= new LaserAssets(atlas);
    }


    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);

    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class CapitanByteAssets {


        public final TextureAtlas.AtlasRegion paradoDerecha;
        public final TextureAtlas.AtlasRegion paradoIzquierda;
        public final TextureAtlas.AtlasRegion paseoDerecha;
        public final TextureAtlas.AtlasRegion paseoIzquierda;
        public final Animation paseoDerechaAnimacion;
        public final Animation paseoIzquierdaAnimacion;

        //public final Animation disparoDerechaAnimacion;



        public CapitanByteAssets(TextureAtlas atlas){
            paradoDerecha= atlas.findRegion(Constants.PARADO_DERECHA);
            paradoIzquierda= atlas.findRegion(Constants.PARADO_IZQUIERDA);
            paseoIzquierda= atlas.findRegion(Constants.PASEO_IZQUIERDA01);
            paseoDerecha= atlas.findRegion(Constants.PASEO_DERECHA01);

            //animacion derecha
            Array<TextureAtlas.AtlasRegion> paseoDerechaFrame = new Array<TextureAtlas.AtlasRegion>();
            //paseoDerechaFrame.add(atlas.findRegion(Constants.PASEO_DERECHA01));
            paseoDerechaFrame.add(atlas.findRegion(Constants.PASEO_DERECHA02));
            paseoDerechaFrame.add(atlas.findRegion(Constants.PASEO_DERECHA03));
            paseoDerechaFrame.add(atlas.findRegion(Constants.PASEO_DERECHA04));
            paseoDerechaFrame.add(atlas.findRegion(Constants.PASEO_DERECHA05));
            paseoDerechaFrame.add(atlas.findRegion(Constants.PASEO_DERECHA06));

            //paseoderechaanimacion = new Array<>(Constants.PASEO_DURACION, paseoderechaanimacion, Animation.PlayMode.LOOP);
            paseoDerechaAnimacion= new Animation(Constants.PASEO_DURACION, paseoDerechaFrame, Animation.PlayMode.LOOP);

            //animacion izquierda
            Array<TextureAtlas.AtlasRegion> paseoIzquierdaFrame = new Array<TextureAtlas.AtlasRegion>();
            //paseoIzquierdaFrame.add(atlas.findRegion(Constants.PASEO_IZQUIERDA01));
            paseoIzquierdaFrame.add(atlas.findRegion(Constants.PASEO_IZQUIERDA02));
            paseoIzquierdaFrame.add(atlas.findRegion(Constants.PASEO_IZQUIERDA03));
            paseoIzquierdaFrame.add(atlas.findRegion(Constants.PASEO_IZQUIERDA04));
            paseoIzquierdaFrame.add(atlas.findRegion(Constants.PASEO_IZQUIERDA05));
            paseoIzquierdaFrame.add(atlas.findRegion(Constants.PASEO_IZQUIERDA06));

            paseoIzquierdaAnimacion = new Animation(Constants.PASEO_DURACION,paseoIzquierdaFrame, Animation.PlayMode.LOOP);

            //animacion disparo derecha
            /*Array<AtlasRegion> disparoDerechaFrame = new Array<AtlasRegion>();
            disparoDerechaFrame.add(atlas.findRegion(Constants.DISPARO_DERECHA01));
            disparoDerechaFrame.add(atlas.findRegion(Constants.DISPARO_DERECHA02));
            disparoDerechaFrame.add(atlas.findRegion(Constants.DISPARO_DERECHA03));
            disparoDerechaFrame.add(atlas.findRegion(Constants.DISPARO_DERECHA04));

            disparoDerechaAnimacion = new Animation(Constants.TIEMPO_DISPARO,disparoDerechaFrame,Animation.PlayMode.LOOP);

             */

        }
    }

    public class LaserAssets {
        public final TextureAtlas.AtlasRegion laser;

        public LaserAssets(TextureAtlas atlas){
            laser = atlas.findRegion(Constants.LASER_IMAGEN);
        }
    }
}
