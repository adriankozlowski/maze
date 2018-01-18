package pl.sdacademy.maze;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        MazeGenerator generator = new MazeGenerator(10, 20);
        generator.display();

    }

    private static void solve(Maze maze) {
        PriorityQueue<MazeElement> mazeElementsQueue = new PriorityQueue<>((MazeElement e1, MazeElement e2) -> {
            return e1.getPathLength().compareTo(e2.getPathLength());
        });
        MazeElement startingElement = maze.getStartElement();
        startingElement.setVisited(true);
        mazeElementsQueue.add(maze.getStartElement());
        while (!mazeElementsQueue.isEmpty()) {
            MazeElement current = mazeElementsQueue.poll();
            Integer currentElementPathLength = current.getPathLength();
            MazeElement elementOnLeft = maze.getMazeElement(current.getX() - 1, current.getY());
            if (elementOnLeft != null && elementOnLeft.getElement() != '#' && !elementOnLeft.isVisited()) {
                elementOnLeft.setPathLength(currentElementPathLength + 1);
                elementOnLeft.setVisited(true);
                elementOnLeft.setPrevious(current);
                mazeElementsQueue.offer(elementOnLeft);
            }
            MazeElement elementOnTop = maze.getMazeElement(current.getX(), current.getY() - 1);
            if (elementOnTop != null && elementOnTop.getElement() != '#' && !elementOnTop.isVisited()) {
                elementOnTop.setPathLength(currentElementPathLength + 1);
                elementOnTop.setVisited(true);
                elementOnTop.setPrevious(current);
                mazeElementsQueue.offer(elementOnTop);
            }
            MazeElement elementOnRight = maze.getMazeElement(current.getX() + 1, current.getY());
            if (elementOnRight != null && elementOnRight.getElement() != '#' && !elementOnRight.isVisited()) {
                elementOnRight.setPathLength(currentElementPathLength + 1);
                elementOnRight.setVisited(true);
                elementOnRight.setPrevious(current);
                mazeElementsQueue.offer(elementOnRight);
            }
            MazeElement elementOnBottom = maze.getMazeElement(current.getX(), current.getY() + 1);
            if (elementOnBottom != null && elementOnBottom.getElement() != '#' && !elementOnBottom.isVisited()) {
                elementOnBottom.setPathLength(currentElementPathLength + 1);
                elementOnBottom.setVisited(true);
                elementOnBottom.setPrevious(current);
                mazeElementsQueue.offer(elementOnBottom);
            }
        }

        MazeElement pathElement = maze.getStopElement();
        while (pathElement != null) {
            maze.addPathElement(pathElement.getX(), pathElement.getY());
            pathElement = pathElement.getPrevious();
        }

    }

    public void go() {
//        maze.addPathElement(1, 1);
//        maze.addPathElement(1, 2);
//        maze.addPathElement(1, 3);
//        maze.addPathElement(1, 4);
//        maze.addPathElement(1, 5);
//        maze.addPathElement(1, 6);
//        maze.addPathElement(1, 7);
//        maze.addPathElement(1, 8);
//        maze.print();
    }
}
