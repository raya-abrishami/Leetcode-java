import java.util.Arrays;
import java.util.HashSet;

class Solution {

    // Approach 3: HashSet
    // Time: O(n), Space: O(n)
    // This is the one LeetCode runs.
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    // Approach 2: Sort, then check neighbors
    // Time: O(n log n), Space: O(1) extra
    public boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // Approach 1: Brute force, compare every pair
    // Time: O(n²), Space: O(1)
    // Too slow for large inputs (Time Limit Exceeded).
    public boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}