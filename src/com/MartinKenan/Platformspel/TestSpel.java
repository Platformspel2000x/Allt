package com.MartinKenan.Platformspel;

import com.MartinKenan.FrameWork.Screen;
import com.MartinKenan.Implementation.PewPewTheGame;

public class TestSpel extends PewPewTheGame {
    @Override
    public Screen getInitScreen() {
       return new LoadingScreen(this); 
    }
}
