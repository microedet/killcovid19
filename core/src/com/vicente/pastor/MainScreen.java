package com.vicente.pastor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.vicente.pastor.util.Assets;
import com.vicente.pastor.util.CamaraSeguimiento;
import com.vicente.pastor.util.Constants;

public class MainScreen extends ScreenAdapter {
	public static final String TAG = MainScreen.class.getName();


	Level level;
	SpriteBatch batch;
	ExtendViewport viewport;
	public CamaraSeguimiento camaraSeguimiento;


	@Override
	public void show() {
		AssetManager am = new AssetManager();
		Assets.instance.init(am);


		level = new Level();
		batch = new SpriteBatch();
		viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
		camaraSeguimiento= new CamaraSeguimiento(viewport.getCamera(),level.capitanByte);


	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void dispose() {
		Assets.instance.dispose();
	}

	@Override
	public void render(float delta) {
		level.update(delta);

		camaraSeguimiento.update();
		viewport.apply();
		Gdx.gl.glClearColor(
				Constants.BACKGROUND_COLOR.r,
				Constants.BACKGROUND_COLOR.g,
				Constants.BACKGROUND_COLOR.b,
				Constants.BACKGROUND_COLOR.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(viewport.getCamera().combined);
		//batch.begin();
		// TODO: Render the Level
		level.render(batch);
		//batch.end();
	}
}
