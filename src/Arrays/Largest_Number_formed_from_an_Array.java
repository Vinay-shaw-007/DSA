package Arrays;

public class Largest_Number_formed_from_an_Array {
    public static void main(String[] args) {
        String[] arr = {"54", "546", "548", "60"};
        System.out.println(new Solution().printLargest(arr));
    }

}

class Solution {
    String printLargest(String[] arr) {
        // code here
//        another shortest approach
//        String ans = "";
//        Arrays.sort(arr, (X, Y) -> (Y+X).compareTo(X+Y));
//        for (String i :
//                arr) {
//            ans += i;
//        }
//        return ans;
        merge(0, arr.length - 1, arr);
        return  printArray(arr);
    }

    private String printArray(String[] arr) {
        StringBuilder ans = new StringBuilder();
        for (String i :
                arr) {
            ans.append(i);
        }
        return ans.toString();
    }

    public static void merge(int l, int r, String[] arr) {

        if (l < r) {

            int mid = (l + r) / 2;

            merge(l, mid, arr);
            merge(mid + 1, r, arr);
            mergeSort(l, mid, r, arr);
        }

    }

    public static void mergeSort(int l, int mid, int r, String[] arr) {
        String [] temp = new String[r - l + 1];
        int i = l, j = mid+1, k = 0;
        while (i <= mid && j <= r) {
            long b1 = Long.parseUnsignedLong(arr[i]+arr[j]);
            long b2 = Long.parseUnsignedLong(arr[j]+arr[i]);
            if (b1 > b2) {
                temp[k++] = arr[i++];
            } else temp[k++] = arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for(k=0,i=l;k< temp.length;k++,i++)
            arr[i]=temp[k];
    }
}