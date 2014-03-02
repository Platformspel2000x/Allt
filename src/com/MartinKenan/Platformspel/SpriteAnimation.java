package com.MartinKenan.Platformspel;

import android.graphics.Rect;


public class SpriteAnimation {
	
	public int currentFrameX;
	public int horisontalLockValue;
	public int currentFrameY;
	public float frameTicker = 2;
	Rect sourceRectangle;
	
	public SpriteAnimation(int imageWidth, int imageHeight)
	{
		currentFrameX = 0;
		horisontalLockValue = 0;
		currentFrameY = 0;
		sourceRectangle = new Rect(0, 0, imageWidth, imageHeight);
		
	}

	public void SetVerticalPosition(int y, int imageWidth)
	{
		sourceRectangle.top = y*imageWidth;
		sourceRectangle.bottom = sourceRectangle.top + imageWidth;
		currentFrameX = 0;
		frameTicker = 2;
		
	}
	public void UpdateAnimation(float deltaT, int imageWidth)
	{
		
		
		frameTicker = frameTicker - deltaT;
		
		if(frameTicker <= 0)
		{
		if(currentFrameX < horisontalLockValue)
		{
		currentFrameX++;
		frameTicker = 2;
		}
		else
		{
		currentFrameX = 0;
		frameTicker = 2;
		}
		}
		
		sourceRectangle.left = currentFrameX * imageWidth;
		sourceRectangle.right = sourceRectangle.left + imageWidth;
		
	}
	
	
	

}
