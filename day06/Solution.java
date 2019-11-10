class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int size = height.length;

        // Calculate left maxes
        int[] leftMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Calculate right maxes
        int[] rightMax = new int[size];
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate amount of water that can be stored above each spot on histogram
        int water = 0;
        for (int i = 1; i < size - 1; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}
