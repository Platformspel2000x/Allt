package com.MartinKenan.Platformspel;

import java.util.List;

import com.MartinKenan.FrameWork.Graphics;
import com.MartinKenan.FrameWork.Vector;
import com.MartinKenan.FrameWork.Input.TouchEvent;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;

public class Character {
	

	private float frameTicker = 2;
	public Vector playerPosition;
	private SpriteAnimation spriteAnim;
	public int numberOfFramesX;
	public int numberOfFramesY;
	
	public enum playerState { running, jumping, attacking, idle };
	
	public playerState currentState;
	
	
	public Character (float posx, float posy)
	{
		currentState = playerState.idle;
		playerPosition = new Vector (posx, posy);
		numberOfFramesX = 16;
		numberOfFramesY = 16;
		spriteAnim = new SpriteAnimation(Assets.Character.getWidth()/numberOfFramesX, Assets.Character.getHeight()/numberOfFramesY);
		spriteAnim.horisontalLockValue = numberOfFramesX -1;
		setState((byte)0);
		
	}
	
	public void Update(float deltaT)
	{
		spriteAnim.UpdateAnimation(deltaT, Assets.Character.getWidth()/numberOfFramesX);
	}
	public Rect getSourceRectangle()
	{
		return spriteAnim.sourceRectangle;
	}
	
	public boolean onTouchEvent(MotionEvent event) {
	    int eventaction = event.getAction();
	    
	    switch (eventaction) {
	        case MotionEvent.ACTION_DOWN: 
	           // if((int)event.getX() < 300) {
	        	
	            //}
	            break;

	        case MotionEvent.ACTION_MOVE:

	            break;

	        case MotionEvent.ACTION_UP:   
	            
	            break;
	    }
	    return true; 
	}
	
	public void setState(byte state)
	{
		// DETTA ÄR DEN RIKTIGA KODEN, ALLT NEDANFÖR DETTA ÄR BARA FÖR ATT TESTA ANIMATIONSMOTORN
		/*
		switch(state)
		{
		case 0:
			spriteAnim.SetVerticalPosition(0, Assets.Character.getHeight()/16);
			break;
		case 1:
			spriteAnim.SetVerticalPosition(1, Assets.Character.getHeight()/16);
			break;
		case 2: 
			spriteAnim.SetVerticalPosition(2, Assets.Character.getHeight()/16);
			break;
		case 3:
			spriteAnim.SetVerticalPosition(3, Assets.Character.getHeight()/16);
			break;
		default:
			spriteAnim.SetVerticalPosition(4, Assets.Character.getHeight()/16);
			break;
		}
		*/
		
		spriteAnim.SetVerticalPosition(state, Assets.Character.getHeight()/16);
		
		
	}
	
	

}
