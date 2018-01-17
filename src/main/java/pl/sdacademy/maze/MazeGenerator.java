package pl.sdacademy.maze;

import java.util.Arrays;
import java.util.Collections;

/*
 * Kod cichaczem pożyczony z
 * http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking
 */
public class MazeGenerator {
    private int x;
    private int y;
    private int[][] maze;

    public MazeGenerator() {
    }

    public Maze generateMiniMaze() {
        initialize(4, 4);
        generateMaze(0, 0);
        return convertMaze();
    }

    public Maze generateSmallMaze() {
        initialize(10, 10);
        generateMaze(0, 0);
        return convertMaze();
    }

    public Maze generateMediumMaze() {
        initialize(20, 20);
        generateMaze(0, 0);
        return convertMaze();
    }

    public Maze generateLargeMaze() {
        initialize(40, 40);
        generateMaze(0, 0);
        return convertMaze();
    }

    private void initialize(int x, int y) {
        this.x = x;
        this.y = y;
        maze = new int[this.x][this.y];
    }

    private void generateMaze(int cx, int cy) {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, x) && between(ny, y) && (maze[nx][ny] == 0)) {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generateMaze(nx, ny);
            }
        }
    }

    private boolean between(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    private Maze convertMaze() {
        MazeElement[][] elements = new MazeElement[y * 2 + 1][x * 2 + 1];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if ((maze[j][i] & 1) == 0) {
                    elements[i * 2][j * 2] = new MazeElement('#', i * 2, j * 2);
                    elements[i * 2][j * 2 + 1] = new MazeElement('#', i * 2, j * 2 + 1);
                } else {
                    elements[i * 2][j * 2] = new MazeElement('#', i * 2, j * 2);
                    elements[i * 2][j * 2 + 1] = new MazeElement(' ', i * 2, j * 2 + 1);
                }
            }
            elements[i * 2][x * 2] = new MazeElement('#', i * 2, x * 2);
            for (int j = 0; j < x; j++) {
                if ((maze[j][i] & 8) == 0) {
                    elements[i * 2 + 1][j * 2] = new MazeElement('#', i * 2 + 1, j * 2);
                    elements[i * 2 + 1][j * 2 + 1] = new MazeElement(' ', i * 2 + 1, j * 2 + 1);
                } else {
                    elements[i * 2 + 1][j * 2] = new MazeElement(' ', i * 2 + 1, j * 2);
                    elements[i * 2 + 1][j * 2 + 1] = new MazeElement(' ', i * 2 + 1, j * 2 + 1);
                }
            }
            elements[i * 2 + 1][x * 2] = new MazeElement('#', i * 2 + 1, x * 2);
        }
        for (int j = 0; j < x; j++) {
            elements[y * 2][j * 2] = new MazeElement('#', y * 2, j * 2);
            elements[y * 2][j * 2 + 1] = new MazeElement('#', y * 2, j * 2 + 1);
        }
        elements[y * 2][x * 2] = new MazeElement('#', y * 2, x * 2);
        return new Maze(elements);
    }

    private enum DIR {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);

        // use the static initializer to resolve forward references
        static {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;

        private DIR(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    }

    ;

}
