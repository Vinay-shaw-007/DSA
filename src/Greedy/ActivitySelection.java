import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class ActivitySelection {
    public static void main(String[] args) {
        int n = 4;
        int[] start = {2, 6, 4, 1, 4, 2, 3};
        int[] end = {4, 10, 9, 9, 4, 5, 4};
        
        System.out.println("Count = "+activitySelection(start, end, n));
    }

    private static ArrayList<Pair> sortArray(int[] start, int[] end, int n) {
        ArrayList<Pair> pairs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(start[i], end[i]));
        }
        System.out.println("Before sorting");
        for (Pair pair : pairs) {
            System.out.print(pair.first+" ");
        }
        System.out.println();
        for (Pair pair : pairs) {
            System.out.print(pair.second+" ");
        }
        Collections.sort(pairs, new SortPair());
        System.out.println();
        System.out.println("After sorting");
        for (Pair pair : pairs) {
            System.out.print(pair.first+" ");
        }
        System.out.println();
        for (Pair pair : pairs) {
            System.out.print(pair.second+" ");
        }
        return pairs;
    }

    public static int activitySelection(int start[], int end[], int n)
    {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Pair> pair = sortArray(start, end, n);
        System.out.println();
        int previousActivity = -1;
        for(int i = 0; i < n; i++) {
            int currStart = pair.get(i).first;
            int currEnd = pair.get(i).second;

            if (i == 0) {
                set.add(currStart);
                set.add(currEnd);
                previousActivity = currEnd;
                System.out.println("CurrStart = "+currStart+", previousActivity ="+previousActivity);
                count++;
            }
            
            if (i != 0 && currStart > previousActivity) {
                System.out.println("CurrStart = "+currStart+", previousActivity ="+previousActivity);
                if (set.contains(currStart) && set.contains(currEnd)) continue;
                set.add(currStart);
                set.add(currEnd);
                previousActivity = currEnd;
                count++;
            }
        }
        return count;
    }
}
class Pair {
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class SortPair implements Comparator<Pair>{

    @Override
    public int compare(Pair a, Pair b) {
        if (a.second<b.second) {
            return -1;
        } else if (a.second > b.second) {
            return 1;
        } else {
            if (a.first<b.first) {
                return -1;
            } else if (a.first > b.first) {
                return 1;
            }
        }
        return 0;
    }

}
