class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int[][] q = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] count = new int[n + 1];
        int busyCount = 0;
        int left = 0;
        int right = 0;
        int[] result = new int[queries.length];

        for (int k = 0; k < q.length; k++) {
            int end = q[k][0];
            int start = end - x;
            int position = q[k][1];

            while (right < logs.length && logs[right][1] <= end) {
                int s = logs[right][0];
                if (count[s] == 0) {
                    busyCount++;
                }
                count[s]++;
                right++;
            }

            while (left < right && logs[left][1] < start) {
                int s = logs[left][0];
                count[s]--;
                if (count[s] == 0) {
                    busyCount--;
                }
                left++;
            }

            result[position] = n - busyCount;
        }

        return result;
    }
}