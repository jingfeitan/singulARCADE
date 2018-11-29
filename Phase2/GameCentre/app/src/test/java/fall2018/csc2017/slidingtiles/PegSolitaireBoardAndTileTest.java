package fall2018.csc2017.slidingtiles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class PegSolitaireBoardAndTileTest {

    /** The peg solitaire board for testing. */
    PegSolitaireBoard pegSolitaireBoard;

    /**
     * Make a set of tiles.
     * @return a set of tiles
     */
    private List<PegSolitaireTile> makeTiles() {
        List<PegSolitaireTile> tiles = new ArrayList<>();
        final int numTiles = PegSolitaireBoard.NUM_ROWS * PegSolitaireBoard.NUM_COLS;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            tiles.add(new PegSolitaireTile(2));
        }
        return tiles;
    }

    /**
     * Make a square peg solitaire board.
     */
    private void setUpSquare() {
        PegSolitaireBoard.setDimensions(6);
        pegSolitaireBoard = new PegSolitaireBoard(makeTiles());
    }

    /**
     * Make a cross peg solitaire board.
     */
    private void setUpCross() {
        PegSolitaireBoard.setDimensions(7);
        pegSolitaireBoard = new PegSolitaireBoard(makeTiles());
    }

    /**
     * Make a diamond peg solitaire board.
     */
    private void setUpDiamond() {
        PegSolitaireBoard.setDimensions(9);
        pegSolitaireBoard = new PegSolitaireBoard(makeTiles());
    }

    /**
     * Test numPieces works
     */
    @Test
    public void testNumPieces() {
        setUpCross();
        assertEquals(49, pegSolitaireBoard.numPieces());
    }

    /**
     * Test getTile works
     */
    @Test
    public void testGetTile() {
        setUpDiamond();
        assertEquals(0, pegSolitaireBoard.getPegTile(1, 0).getId());
    }

    /**
     * Test getDimensions works
     */
    @Test
    public void testGetDimensions() {
        setUpSquare();
        assertEquals(36, pegSolitaireBoard.getDimensions());
        PegSolitaireBoard.setDimensions(9);
        assertEquals(81, pegSolitaireBoard.getDimensions());
    }

    /**
     * Test moveGamepiece works
     */
    @Test
    public void testMoveGamepiece() {
        setUpCross();
        pegSolitaireBoard.moveGamepiece(1,3,3,3);
        assertEquals(2, pegSolitaireBoard.getPegTile(3,3).getId());
        assertEquals(1, pegSolitaireBoard.getPegTile(1,3).getId());
        assertEquals(1, pegSolitaireBoard.getPegTile(2,3).getId());
    }

    /**
     * Test addOrRemoveHighlight works
     */
    @Test
    public void testAddOrRemoveHighlight() {
        setUpSquare();
        pegSolitaireBoard.addOrRemoveHighlight(1, 3);
        assertEquals(R.drawable.tile_highlight, pegSolitaireBoard.getPegTile(1,3).getBackground());

    }

    /**
     * Test addOrRemoveHighlight works
     */
    @Test
    public void testNumRemainingPegs() {
        setUpDiamond();
        pegSolitaireBoard.moveGamepiece(2, 4, 4, 4);
        pegSolitaireBoard.moveGamepiece(3, 6, 4, 3);
        //pegSolitaireBoard.moveGamepiece(3, 3, 5, 3);
        assertEquals(38, pegSolitaireBoard.numRemainingPegs());

    }

    /**
     * Test whether compareTo works
     */
    @Test
    public void testCompareTo() {
        setUpDiamond();
        PegSolitaireTile comparingTile = pegSolitaireBoard.getOneTile(2,5);
        assertEquals(2, pegSolitaireBoard.getOneTile(0,0).compareTo(comparingTile));
    }


}
