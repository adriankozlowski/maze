package pl.sdacademy.maze;

public class MazeElement {

    private char element;
    private int x;
    private int y;
    private Integer pathLength;
    private boolean visited;
    private MazeElement previous;

    public MazeElement(char element, int y, int x) {
        this.element = element;
        this.x = x;
        this.y = y;
        pathLength = 0;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public MazeElement getPrevious() {
        return previous;
    }

    public void setPrevious(MazeElement previous) {
        this.previous = previous;
    }

    public char getElement() {
        return element;
    }

    public void setElement(char element) {
        this.element = element;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Integer getPathLength() {
        return pathLength;
    }

    public void setPathLength(Integer pathLength) {
        this.pathLength = pathLength;
    }

}
