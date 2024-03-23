import java.util.ArrayList;
import java.util.List;

public class Arrays {
    // given an array find element k

    // O(N)
    public boolean linearSearch(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) return true;
        }

        return false;
    }

    // sorted [-3,-2,0,1,3,4] find element k
    // O(N)
    /*

    -3,-2,0,1,3,4
     */
    // 100 -> 50 -> 25 -> 12
    // O(LogN)
    // bug
    // (High - Low)/2 + Low
    // O(LogN)
    // 1024 - 1024 -> Log1024 -> 10
    // O(1): hashmap O(N) space
    public boolean binSearch(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) return true;
            if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    // given n return sqrt do not use inbuilt method
    // 64, 49, 169
    // brute force or naive
    // optimized
    // minimum rotated sorted
    public static int sqrt(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == n) return mid;
            if (mid * mid > n) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    public static int floor(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                if (mid == 0 || arr[mid - 1] != k) return mid;
                else high = mid - 1;
            } else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static int ceil(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                if (mid == n - 1 || arr[mid + 1] != k) return mid;
                else low = mid + 1;
            } else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static int frequency(int[] arr, int k) {
        int fl = floor(arr, k);
        if (fl == -1) return 0;
        int cl = ceil(arr, k);

        return cl - fl + 1;
    }

    public static void segregate(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            if (arr[low] == 0) low++;
            else if (arr[high] == 1) high--;
            else {
                arr[low] = 0;
                arr[high] = 1;
                low++;
                high--;
            }
        }
    }

    // pair
    // all pairs
    // duplicate
    // 3 pointer
    public static boolean twoSum(int[] arr, int k) {
        java.util.Arrays.sort(arr); // inplace O(NLogN)

        int low = 0, high = arr.length - 1;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum == k) return true;
            if (sum > k) high--;
            else low++;
        }

        return false;
    }

    public static List<List<Integer>> tripletSum(int[] arr, int target) {
        java.util.Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    res.add(list);
                    left++;
                    right--;
                } else if (sum > target) right--;
                else left++;
            }
        }
        return res;
    }

    public static void segregate012(int[] arr) {
        int left = 0, mid = 1, right = arr.length - 1;
        while (mid <= right) {
            if (arr[mid] == 1) mid++;
            else if (arr[mid] == 0) {
                // swap with left
                int temp = arr[left];
                arr[left] = arr[mid];
                arr[mid] = temp;
                left++;
            } else {
                // swap with right
                int temp = arr[right];
                arr[right] = arr[mid];
                arr[mid] = temp;
                right--;
            }
        }
    }

    public static int[] squaresSum(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        int low = 0, high = n - 1;
        int index = n - 1;

        while (low <= high) {
            int lowSquare = (int) Math.pow(arr[low], 2);
            int highSquare = (int) Math.pow(arr[high], 2);

            if (highSquare > lowSquare) {
                res[index--] = highSquare;
                high--;
            } else {
                res[index--] = lowSquare;
                low++;
            }
        }

        return res;
    }
}
