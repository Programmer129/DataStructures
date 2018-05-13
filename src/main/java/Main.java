import backtracking.KnightTourProblem;

public class Main {

    public static void main(String[] args)  {
        KnightTourProblem knightTourProblem = new KnightTourProblem(0, 7);
        knightTourProblem.sovler();
        System.out.println(knightTourProblem.step);
        knightTourProblem.printBoard();
    }
}
