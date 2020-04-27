package com.example.protetris;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class MainGameTest {

    MainBoard mainBoard;
    Boolean canChangePiece;

    /*The functionality works when the user touch the next piece view and he has deleted 2 files of the tetris(that means tha has earn 60 points)*/

    @Test
    public void useButtonWithThePointsRequired(){

        this.mainBoard = new MainBoard();
        this.canChangePiece = true;

        List<Piece> pieces = new ArrayList<>();

        pieces.add(mainBoard.getActualPiece());
        pieces.add(mainBoard.getNextPiece());

        mainBoard.changeNextPiece(this.canChangePiece);

        assertNotEquals(pieces.get(1),mainBoard.getNextPiece());
    }

    @Test
    public void useButtonWithoutThePointsRequired(){

        this.mainBoard = new MainBoard();
        this.canChangePiece = false;


        List<Piece> pieces = new ArrayList<>();

        pieces.add(mainBoard.getActualPiece());
        pieces.add(mainBoard.getNextPiece());

        mainBoard.changeNextPiece(this.canChangePiece);

        assertEquals(pieces.get(1),mainBoard.getNextPiece());
    }


    /*We don´t call these functions because is an event method*/
    /*@Test
    public void noUseButtonWithThePointsRequired(){

        this.mainBoard = new MainBoard();

        List<Piece> pieces = new ArrayList<>();

        pieces.add(mainBoard.getActualPiece());
        pieces.add(mainBoard.getNextPiece());

        assertEquals(pieces.get(1),mainBoard.getNextPiece());
    }


    @Test
    public void noUseButtonWithoutThePointsRequired(){

        this.mainBoard = new MainBoard();

        List<Piece> pieces = new ArrayList<>();

        pieces.add(mainBoard.getActualPiece());
        pieces.add(mainBoard.getNextPiece());

        assertEquals(pieces.get(1),mainBoard.getNextPiece());
    }*/

}