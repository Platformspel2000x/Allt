package com.MartinKenan.Platformspel;

import java.util.List;

import android.R.color;
import android.graphics.Color;
import android.graphics.Paint;

import com.MartinKenan.FrameWork.Game;
import com.MartinKenan.FrameWork.Graphics;
import com.MartinKenan.FrameWork.Image;
import com.MartinKenan.FrameWork.Screen;
import com.MartinKenan.FrameWork.Input.TouchEvent;

public class GameScreen extends Screen {
    enum GameState {
        Ready, Running, Paused, GameOver
    }

    GameState state = GameState.Running;

    int livesLeft = 1;
    Paint paint;

    Character player;
    
    int playerAnimationToggleTEST = 0;
    
    
    public GameScreen(Game game) {
        super(game);
        
        player = new Character(200, 472);

        paint = new Paint();
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
        if (state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateReady(List<TouchEvent> touchEvents) {
        
        if (touchEvents.size() > 0)
            state = GameState.Running;
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) 
    {
    	
    	player.Update(deltaTime);
    	
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_DOWN) {

                if (event.x < 640) {
                	
                if(playerAnimationToggleTEST < 15)
                playerAnimationToggleTEST++;
                else
                	playerAnimationToggleTEST = 0;
                
                }

                else if (event.x > 640) {
                	
                    if(playerAnimationToggleTEST < 15)
                        playerAnimationToggleTEST++;
                        else
                        	playerAnimationToggleTEST = 0;

                }
                
                player.setState((byte)playerAnimationToggleTEST);

            }

            if (event.type == TouchEvent.TOUCH_UP) {

                if (event.x < 640) {
                	
                }

                else if (event.x > 640) {
                	
                }
            }

            
        }
        
        
        if (livesLeft == 0) {
            state = GameState.GameOver;
        }
        
        
    }

    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {

            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (event.x > 300 && event.x < 980 && event.y > 100 && event.y < 500) {
                    nullify();
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.clearScreen(color.background_dark);
        g.drawImage(Assets.Sky, 0, 0);
        g.drawImage(Assets.Ground, 0, 700);
        
        //SpelElement som ska ritas
        g.drawAnimationSpriteSheet(Assets.Character, (int)player.playerPosition.x, (int)player.playerPosition.y, player.getSourceRectangle(), player.numberOfFramesX, player.numberOfFramesY);
        
        
        // UI
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

    private void nullify() 
    {
    	//GAMEOVER CALL, rör ej!
        paint = null;
        System.gc();
    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 0, 0, 0);
        g.drawString("Tap each side of the screen to move in that direction.", 640, 300, paint);

    }

    private void drawRunningUI() {
        Graphics g = game.getGraphics();

    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        g.drawARGB(155, 0, 0, 0);

    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1281, 801, Color.BLACK);
        g.drawString("GAME OVER.", 640, 300, paint);

    }

    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        pause();
    }
}