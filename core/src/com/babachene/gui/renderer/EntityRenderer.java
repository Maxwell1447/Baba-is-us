package com.babachene.gui.renderer;

import java.security.InvalidParameterException;
import java.util.MissingResourceException;

import com.babachene.Baba;
import com.babachene.gui.BabaIsUs;
import com.babachene.gui.Rsrc;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * A renderer for ONE entity.
 * @author jeremy
 *
 */
class EntityRenderer extends Renderer { // Not a public class
	
	private RenderableEntity entity;
	
	private TextureRegion tex;
	
	private MapRenderingData mapData;
	
	public EntityRenderer(RenderableEntity e, MapRenderingData mapData) {
		if (e == null)
			throw new IllegalArgumentException("RenderableEntity arg cannot be null");
		if (mapData == null)
			throw new IllegalArgumentException("MapRenderingData arg cannot be null");
		
		this.mapData = mapData;
		entity = e;
		
		short entityId = e.getId();
		switch (entityId) { // TODO todo
		
		/*
		 * Text blocks
		 */
		case Baba.TXT_PUSH: tex = Rsrc.TXT_PUSH_TEXTURE;
			break;
		case Baba.TXT_ROCK: tex = Rsrc.TXT_ROCK_TEXTURE;
			break;
		case Baba.TXT_BABA: tex = Rsrc.TXT_BABA_TEXTURE;
			break;
		case Baba.TXT_WIN: tex = Rsrc.TXT_WIN_TEXTURE;
			break;
		case Baba.TXT_YOU: tex = Rsrc.TXT_YOU_TEXTURE;
			break;
		case Baba.TXT_SINK: tex = Rsrc.TXT_SINK_TEXTURE;
			break;
		case Baba.TXT_BLOCK: tex = Rsrc.TXT_STOP_TEXTURE;
			break;
		case Baba.TXT_WATER: tex = Rsrc.TXT_WATER_TEXTURE;
			break;
		case Baba.TXT_LAVA: tex = Rsrc.TXT_LAVA_TEXTURE;
			break;
		case Baba.TXT_WALL: tex = Rsrc.TXT_WALL_TEXTURE;
			
		
		
		case Baba.TXT_IS: tex = Rsrc.TXT_IS_TEXTURE;
			break;	
		case Baba.TXT_HAS: tex = Rsrc.TXT_HAS_TEXTURE;
			break;
		case Baba.TXT_AND: tex = Rsrc.TXT_AND_TEXTURE;
			break;
		case Baba.TXT_ON: tex = Rsrc.TXT_ON_TEXTURE;
			break;
		case Baba.TXT_BUT: tex = Rsrc.TXT_BUT_TEXTURE;
			break;
//		case Baba.TXT_SINK: tex = Rsrc.TXT_SINK_TEXTURE;
//			break;
//		case Baba.TXT_SINK: tex = Rsrc.TXT_SINK_TEXTURE;
//			break;
		
		/*
		 * Non-text blocks.
		 */
		case 1: tex = new TextureRegion(BabaIsUs.assetManager.get(BabaIsUs.textures.KERMIT, Texture.class));
			break;
		case Baba.ROCK: tex = Rsrc.ROCK_TEXTURE;
			break;
		case Baba.WATER: tex = Rsrc.WATER_TEXTURE;
			break;
		case Baba.LAVA: tex = Rsrc.LAVA_TEXTURE;
			break;
		case Baba.WALL: tex = Rsrc.WALL_TEXTURE;
			break;
		case Baba.TREE: tex = Rsrc.TREE_TEXTURE;
			break;
		case Baba.FLAG: tex = Rsrc.FLAG_TEXTURE;
			break;
		
			
		default:
			tex = Rsrc.MISSING_TEXTURE; // TODO It's better if an exception is thrown.
			//throw new InvalidParameterException("Unreconsized entity id: " + entityId);
		}
		if (tex == null)
			throw new MissingResourceException("Texture is not initialized. Entity id: "+entityId, "Rsrc", "Entity id :"+entityId);
		
	}
	
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(tex, mapData.xPosition(entity.getX()),
		                mapData.yPosition(entity.getY()),
		                mapData.tileWidth,
		                mapData.tileHeight);
		
	}
	@Override
	public void update() {
		
	}
	
	/////////////////////
	
	public RenderableEntity getRenderableEntity() {
		return entity;
	}
	
}