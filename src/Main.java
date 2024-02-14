import java.util.Calendar;
import java.util.Random;

public class Main {

    private static int[] dataset() { return getThirdDataset(); }

    public static void main(String[] args) {

        for(int i = 1; i <= 8; i++) {
            System.out.printf("%d,", i);
        }
        System.out.print("];\nFIFO = [");
        for(int i = 1; i <= 8; i++) {
            System.out.printf("%d,",new FIFOReplacer(dataset(), i).simulate());
        }
        System.out.print("];\nLRU = [");
        for(int i = 1; i <= 8; i++) {
            System.out.printf("%d,",new LRUReplacer(dataset(), i).simulate());
        }
        System.out.print("];\nOPT = [");
        for(int i = 1; i <= 8; i++) {
            System.out.printf("%d,",new OptimalReplacer(dataset(), i).simulate());
        }
        System.out.println("];");
    }

    private static int[] getFirstDataset() {
        return new int[] {0,2,6,2,7,0,7,3,2,0,3,2,2,3,1,4,2,1,1,4,6,0,6,6,4,0,7,4,7,0};
    }

    private static int[] getSecondDataset() {
        return new int[] {1,2,0,1,1,3,0,7,0,1,1,7,0,6,5,0,1,5,4,7,1,1,6,1,4,0,4,3,2,1,6,3,2,2,2,1,0,4,2,0,7,2,2,6,2,1,6,0,3,7};
    }

    private static int[] getThirdDataset() {
        return new int[] {7,1,2,6,3,7,1,4,1,0,1,7,3,1,0,1,0,0,2,2,5,2,7,6,5,0,4,4,4,4,7,1,7,1,2,0,1,0,2,5,6,0,0,0,2,2,0,0,4,7,4,2,3,0,2,1,5,0,3,7,1,3,6,2,2,4,1,3,2,5,3,2,2,0,2,2,4,2,0,2,4,0,7,1,7,6,2,6,1,2,6,0,6,0,1,1,1,5,1,3};
    }

    private static int[] getForthDataset() {
        return new int[] {0, 2, 6, 2, 7, 0, 7, 3, 2, 0, 3, 2, 2, 3, 1, 4, 2, 1, 1, 4, 6, 0, 6, 6, 4, 0, 7, 4, 7, 0,
                5, 1, 6, 7, 3, 4, 0, 5, 7, 1, 2, 5, 6, 3, 4, 2, 1, 5, 4, 0, 2, 6, 3, 0, 1, 7, 2, 6, 5, 7,
                4, 3, 1, 0, 4, 6, 5, 3, 7, 6, 1, 0, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5,
                6, 7, 7, 6, 5, 4, 3, 2, 1, 0};
    }

    private static int[] getBasicDataset() {
        return new int[] {7,0,1,2,0,3,0,4,2,3,0,3,0,3,2,1,2,0,1,7,0,1};
    }

    private static int[] getRandArray(int size) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++)
            arr[i] = getNextPage();

        return arr;
    }

    private static final Random rand = new Random(Calendar.getInstance().getTimeInMillis());
    private static int getNextPage() {
        int x = rand.nextInt(14);
        return (x <= 5) ? x / 2 : x - 6;
    }
}
