class Solution {

    static class FreeComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            //check weights first
            if(a[0] != b[0]){
                //if it returns -, we know a is smaller. (and the other way around)
                return a[0] - b[0];
            }
            // we get to this point only if weights are not equal. (So now we check indexes)
            // if it returns -, we know index of a is smaller (and the other way around)
            return a[1] - b[1];
        }
    }

    static class BusyComparator implements Comparator<long[]> {
        public int compare(long[] a, long[]b){
            // comparing free time
            if(a[0] != b[0]){
                return Long.compare(a[0], b[0]);
            }
            //comparing weight
            if(a[1] != b[1]){
                return Long.compare(a[1], b[1]);
            }
            //comparing index
            return Long.compare(a[2], b[2]);
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        
        PriorityQueue<int[]> free = new PriorityQueue<>(new FreeComparator());
        PriorityQueue<long[]> busy = new PriorityQueue<>(new BusyComparator());

        for(int i=0; i<n; i++){
            free.add(new int[]{servers[i], i});
        }
        int[] ans = new int[m];

        for(int j=0; j<m; j++){
            while (!busy.isEmpty() && busy.peek()[0] <= j){
                long[] s = busy.poll();
                free.add(new int[]{(int) s[1], (int) s[2]});
            }

            if(!free.isEmpty()){
                int[] s = free.poll();
                ans[j] = s[1];
                busy.add(new long[]{(long) j + tasks[j], s[0], s[1]});
            } else{
                long[] s = busy.poll();
                ans[j] = (int) s[2];
                busy.add(new long[]{s[0] + tasks[j], s[1], s[2]});

            }
        }
        return ans;
    }
}