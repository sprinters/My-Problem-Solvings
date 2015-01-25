package main.crackingcodinginterviews.pmc;

/**
 * * @author sandeepandey
 */
public class TaskA {
    public static void main(String...s) {

        TaskA taskA =   new TaskA();
        taskA.solve();
    }

    private void solve() {
        shuffleArray(null);
    }

    private void shuffleArray(int[] cards) {
        int tmp,index;

        for(int i   =   0;i < cards.length ; i++) {

            index = (int) (Math.random() * (cards.length-i) + i);

            tmp = cards[i];
            cards[i] = cards[index];
            cards[index]=tmp;
        }
    }
}
