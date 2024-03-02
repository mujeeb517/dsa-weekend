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
}
