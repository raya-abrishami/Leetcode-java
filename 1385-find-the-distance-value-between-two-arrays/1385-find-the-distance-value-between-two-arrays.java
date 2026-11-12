class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        //Count keeps tra ck how many elements are considered far. Boolean "tooClose" is the actual checking step. 

        int count=0;
        boolean tooClose = false;

        //a nested for loop is needed to check each element in arr1 individually against each element in arr2. 
        for(int i=0; i<arr1.length; i++){

            // we need the boolean check in this step, so it resets for each inex in arr1. 
            tooClose = false;
            for(int j=0; j<arr2.length; j++){
                if(Math.abs(arr1[i]- arr2[j]) <= d){
                    tooClose = true;
                    
                    // break exits out of the inner loop, and checks the next element in arr1 (outer loop)
                    break;
                }
            }
                // this condition is outside the loop so that it updates the count accordingly, once for each "far" element in arr1
                if(!tooClose){
                    count++;
                }
            }
        
        return count;
    }
}