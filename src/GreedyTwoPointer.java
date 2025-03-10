public class GreedyTwoPointer {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea =0;

        while(left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            //Move the Pointer that has the smaller height
            if(height[left] < height[right]) {
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area: " + maxArea(height1));

        int[] height2 = {1, 1};
        System.out.println("Max Area: " + maxArea(height2));
    }
}
