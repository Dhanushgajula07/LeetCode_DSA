class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;

        if (n == 0) return;

        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                shift(i, m - 1, nums1); // shift valid elements to right
                nums1[i] = nums2[j];
                j++;
                m++;   // valid size of nums1 increases
            }
            i++;
        }

        while (j < n) {   // copy remaining nums2 elements
            nums1[i] = nums2[j];
            i++;
            j++;
        }
    }

    private void shift(int start, int end, int[] nums1) {
        while (end >= start) {
            nums1[end + 1] = nums1[end];
            end--;
        }
    }
}
