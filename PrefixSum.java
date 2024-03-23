public class PrefixSum {

    private int[] arr;
    private int[] prefix;

    public PrefixSum(int[] arr) {
        this.arr = arr;
        this.prefix = new int[arr.length];
        calculate();
    }

    private void calculate() {
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }
    }

    public int answerQuery(int start, int end) {
        if (start == 0) {
            return prefix[end];
        } else {
            return prefix[end] - prefix[start - 1];
        }
    }
}
