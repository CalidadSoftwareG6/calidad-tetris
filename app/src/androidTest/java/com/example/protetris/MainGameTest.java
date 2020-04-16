package com.example.protetris;

import android.view.View;
import android.widget.RelativeLayout;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainGameTest {


    @Test
    public void useButton(){

        MainBoard mainBoard = new MainBoard();

        List<Piece> pieces = new ArrayList<>();

        pieces.add(mainBoard.getActualPiece());
        pieces.add(mainBoard.getNextPiece());

        mainBoard.changeNextPiece(null);

        assertNotEquals(pieces.get(1),mainBoard.getNextPiece());
    }


    /*We don´t call the function because is an event method*/
    @Test
    public void noUseButton(){

        MainBoard mainBoard = new MainBoard();

        List<Piece> pieces = new ArrayList<>();

        pieces.add(mainBoard.getActualPiece());
        pieces.add(mainBoard.getNextPiece());

        assertEquals(pieces.get(1),mainBoard.getNextPiece());
    }

}