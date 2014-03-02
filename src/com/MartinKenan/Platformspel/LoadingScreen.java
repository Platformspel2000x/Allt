package com.MartinKenan.Platformspel;

import com.MartinKenan.FrameWork.Game;
import com.MartinKenan.FrameWork.Graphics;
import com.MartinKenan.FrameWork.Screen;
import com.MartinKenan.FrameWork.Graphics.ImageFormat;


public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("ic_launcher.png", ImageFormat.RGB565);
        Assets.Character = g.newImage("RunSpriteSheet.png", ImageFormat.RGB565);
        Assets.Sky = g.newImage("Sky.png", ImageFormat.RGB565);
        Assets.Ground = g.newImage("Ground.png", ImageFormat.RGB565);


        
        game.setScreen(new MainMenuScreen(game));


    }


    @Override
    public void paint(float deltaTime) {


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


    }
}