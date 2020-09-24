package edu.ithaca.dragon.maze;

public enum KeyPress {
    SPACE, LEFT, RIGHT, UP, DOWN, W, A, S, D, Q, NONE;

    public GridMove convertToMove(){
        if (this == LEFT || this == A){
            return GridMove.LEFT;
        }
        else if (this == RIGHT || this == D){
            return GridMove.RIGHT;
        }
        else if (this == UP || this == W){
            return GridMove.UP;
        }
        else if (this == DOWN || this == S){
            return GridMove.DOWN;
        }
        else {
            return GridMove.NO_MOVE;
        }
    }
}
