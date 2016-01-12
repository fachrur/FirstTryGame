package com.me.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Papan {
	public Texture teksPapan;
	public Rectangle posPapan;
	public int status = 0;
	
	public Papan(Rectangle posPapan, Texture teksPapan, int status){
		this.teksPapan = teksPapan;
		this.posPapan = posPapan;
		this.status = status;
	}
	
	public void Update(SpriteBatch b, OrthographicCamera c){
		if(Gdx.input.isTouched()){
			Vector3 p1 = new Vector3();
			p1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			c.unproject(p1);
			if(p1.x < 240){
				if(this.status == 1){
					this.posPapan.x -= 5;
				}else if(this.status == 2){
					this.posPapan.x += 5;
				}
			}else if(p1.x > 240){
				if(this.status == 1){
					this.posPapan.x += 5;
				}else if(this.status == 2){
					this.posPapan.x -= 5;
				}
			}
			if(this.posPapan.x < 0){
				this.posPapan.x = 0;
			}
			if(this.posPapan.x > 347){
				this.posPapan.x = 347;
			}
		}
		b.begin();
		b.draw(teksPapan, posPapan.x, posPapan.y);
		b.end();
	}
}
