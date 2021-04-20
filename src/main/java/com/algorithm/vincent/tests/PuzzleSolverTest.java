package com.algorithm.vincent.tests;

import java.awt.event.ItemEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class PuzzleSolverTest<P, M> implements Puzzle {

    private static final int PUZZLE_WIDTH = 8;
    private static final int PUZZLE_LENGTH = 8;

    public enum DIRECTION {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }
    int[][] puzzle = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, -1},
    };

    @Override
    public P initialPosition() {
        return (P)new Position(0, 0);
    }

    @Override
    public boolean isGoal(Object position) {
        if(position instanceof Position){
            return puzzle[((Position) position).getX()][((Position) position).getY()] == -1;
        }
        return false;
    }

    @Override
    public Set<M> legalMoves(Object position) {
        Set moves = new HashSet(4);
        if(position instanceof Position){
            Position leftPosition = new Position(((Position) position).getX() -1, ((Position) position).getY());
            Position rightPosition = new Position(((Position) position).getX() + 1, ((Position) position).getY());
            Position upPosition = new Position(((Position) position).getX(), ((Position) position).getY() - 1);
            Position downPosition = new Position(((Position) position).getX(), ((Position) position).getY() + 1);

            if(judgeLeaglePosition(leftPosition)){
                moves.add(DIRECTION.LEFT);
            }

            if(judgeLeaglePosition(rightPosition)){
                moves.add(DIRECTION.RIGHT);
            }

            if(judgeLeaglePosition(upPosition)){
                moves.add(DIRECTION.UP);
            }

            if(judgeLeaglePosition(downPosition)){
                moves.add(DIRECTION.DOWN);
            }

            return moves;
        }
        return null;
    }

    private boolean judgeLeaglePosition(Position leftPosition) {
        return leftPosition.getX() >=0 &&
                leftPosition.getX() < PUZZLE_WIDTH &&
                leftPosition.getY() >=0 &&
                leftPosition.getY() < PUZZLE_LENGTH;
    }

    @Override
    public P move(Object position, Object move) {
        if(position instanceof Position && move instanceof DIRECTION){
            Position result = new Position(((Position) position).getX(), ((Position) position).getY());
            DIRECTION direction = (DIRECTION) move;
            switch(direction){
                case LEFT:
                    result.setX(result.getX() - 1);
                    break;
                case RIGHT:
                    result.setX(result.getX() + 1);
                    break;
                case UP:
                    result.setY(result.getY() - 1);
                    break;
                case DOWN:
                    result.setY(result.getY() + 1);
                    break;
                default:
                    result = null;
                    break;
            }
            System.out.println("move to " + result.getX() + "," + result.getY());
            return (P)result;
        }

        return null;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Puzzle puzzle = new PuzzleSolverTest();
        ConcurrentPuzzleSolver<Position, DIRECTION> puzzleSolver = new ConcurrentPuzzleSolver<>(puzzle);
        CountDownLatch latch = new CountDownLatch(1);
        FutureTask<List<DIRECTION>> task = new FutureTask<List<DIRECTION>>(()-> {
            return puzzleSolver.solve();
        });
        task.run();
        task.get().forEach(item -> {
            System.out.println(item);
        });
    }
}
