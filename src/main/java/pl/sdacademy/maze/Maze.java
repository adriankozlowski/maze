package pl.sdacademy.maze;

public class Maze {
    private final MazeElement[][] elements;
    private final int xSize;
    private final int ySize;

    public Maze(MazeElement[][] elements) {
        this.elements = elements;
        ySize = elements.length;
        xSize = elements[0].length;
    }

    public void print() {
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                System.out.print(elements[y][x].getElement());
            }
            System.out.println();
        }
    }

    public boolean addPathElement(int x, int y) {
        if (elements[y][x].getElement() == ' ') {
            elements[y][x].setElement('.');
            return true;
        } else {
            return false;
        }
    }

    public MazeElement getMazeElement(int x, int y) {
        if (x < 0 || y < 0 || x >= xSize || y >= ySize) {
            return null;
        } else {
            return elements[y][x];
        }
    }

    public MazeElement getStartElement() {
        return elements[1][1];
    }

    public MazeElement getStopElement() {
        return elements[ySize - 2][xSize - 2];
    }

}
