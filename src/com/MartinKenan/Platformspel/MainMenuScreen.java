package com.MartinKenan.Platformspel;

import java.util.List;

import android.graphics.Color;

import com.MartinKenan.FrameWork.Game;
import com.MartinKenan.FrameWork.Graphics;
import com.MartinKenan.FrameWork.Screen;
import com.MartinKenan.FrameWork.Input.TouchEvent;
import com.MartinKenan.FrameWork.Vector;


public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }
    
    Vector starButtonPosition = new Vector(10f,10f);

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {


                if (inBounds(event, (int)starButtonPosition.x, (int)starButtonPosition.y, Assets.menu.getWidth(), Assets.menu.getHeight())) 
                {
                	Graphics g2 = game.getGraphics();
                	g2.clearScreen(Color.BLACK);
                    game.setScreen(new GameScreen(game));               
                }


            }
        }
    }


    private boolean inBounds(TouchEvent event, int x, int y, int width,
            int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.menu, (int)starButtonPosition.x, (int)starButtonPosition.y);
    }


    @Override
    public void pause() {
    }


    @Override
    public void resume() {


    }


    @Override
    public void dispose() {


    }


    @Override
    public void backButton() {
        //Display "Exit Game?" Box


    }
}