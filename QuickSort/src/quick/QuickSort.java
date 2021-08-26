package quick;

/**
 *
 * @author Lucas de Castro
 */
public class QuickSort {

    public static void main(String[] args) {
        Score[] scores = {
            new Score("andre", 4),
            new Score("carlos", 8.5),
            new Score("ana", 10),
            new Score("paulo", 3),
            new Score("juliana", 6.7),
            new Score("jonas", 9.3),
            new Score("paulo", 9),
            new Score("mariana", 5),
            new Score("guilherme", 7),};

        sort(scores, 0, scores.length);

        printArray(scores);
    }

    private static void sort(Score[] scores, int from, int until) {
        int elements = until - from;

        if (elements > 1) {
            int pivotPosition = breakInPivot(scores, from, until);
            sort(scores, from, pivotPosition);
            sort(scores, pivotPosition + 1, until);
        }
    }

    /**
     * Place the pivot element in the correct position
     *
     * @param scores
     * @param initial
     * @param end
     */
    private static int breakInPivot(Score[] scores, int initial, int end) {
        Score pivot = scores[end - 1];//get the last one as a pivot
        int minorsFound = 0;

        for (int analyzing = 0; analyzing < end - 1; analyzing++) {//-1 just to ignore the pivot
            Score actual = scores[analyzing];
            if (actual.getValue() <= pivot.getValue()) {
                swap(scores, analyzing, minorsFound);
                minorsFound++;
            }
        }

        swap(scores, end - 1, minorsFound);
        return minorsFound;
    }

    private static void swap(Score[] scores, int from, int to) {
        Score score1 = scores[from];
        Score score2 = scores[to];
        scores[to] = score1;
        scores[from] = score2;
    }
    

    private static void printArray(Score[] scores) {
        for (Score score : scores) {
            System.out.println(score);
        }
    }
}
