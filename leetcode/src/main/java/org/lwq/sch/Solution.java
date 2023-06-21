package org.lwq.sch;

import java.util.Arrays;

/**
 * @author Liwq
 */
public class Solution {


    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] aa = {7,1,5,3,6,4};
        solution.maxProfit(aa);
//        System.out.println(solution.majorityElement(aa));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;

        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[--i] = nums1[--m];
                //替代swap，参考官方题解“逆向双指针解法”的公式
            } else {
                nums1[--i] = nums2[--n];
                //替代swap，参考官方题解“逆向双指针解法”的公式
            }

        }

    }

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    /**
     * 思路
     * <p>
     * 如果我们把众数记为
     * +
     * 1
     * +1，把其他数记为
     * −
     * 1
     * −1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     * <p>
     * 算法
     * <p>
     * Boyer-Moore 算法的本质和方法四中的分治十分类似。我们首先给出 Boyer-Moore 算法的详细步骤：
     * <p>
     * 我们维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
     * <p>
     * 我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
     * <p>
     * 如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
     * <p>
     * 如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
     * <p>
     * 在遍历完成后，candidate 即为整个数组的众数。
     * <p>
     * 我们举一个具体的例子，例如下面的这个数组：
     * <p>
     * <p>
     * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
     * 在遍历到数组中的第一个元素以及每个在 | 之后的元素时，candidate 都会因为 count 的值变为 0 而发生改变。最后一次 candidate 的值从 5 变为 7，也就是这个数组中的众数。
     * <p>
     * Boyer-Moore 算法的正确性较难证明，这里给出一种较为详细的用例子辅助证明的思路，供读者参考：
     * <p>
     * 首先我们根据算法步骤中对 count 的定义，可以发现：在对整个数组进行遍历的过程中，count 的值一定非负。这是因为如果 count 的值为 0，那么在这一轮遍历的开始时刻，我们会将 x 的值赋予 candidate 并在接下来的一步中将 count 的值增加 1。因此 count 的值在遍历的过程中一直保持非负。
     * <p>
     * 那么 count 本身除了计数器之外，还有什么更深层次的意义呢？我们还是以数组
     * <p>
     * <p>
     * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
     * 作为例子，首先写下它在每一步遍历时 candidate 和 count 的值：
     * <p>
     * <p>
     * nums:      [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
     * candidate:  7  7  7  7  7  7   5  5   5  5  5  5   7  7  7  7
     * count:      1  2  1  2  1  0   1  0   1  2  1  0   1  2  3  4
     * 我们再定义一个变量 value，它和真正的众数 maj 绑定。在每一步遍历时，如果当前的数 x 和 maj 相等，那么 value 的值加 1，否则减 1。value 的实际意义即为：到当前的这一步遍历为止，众数出现的次数比非众数多出了多少次。我们将 value 的值也写在下方：
     * <p>
     * <p>
     * nums:      [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
     * value:      1  2  1  2  1  0  -1  0  -1 -2 -1  0   1  2  3  4
     * 有没有发现什么？我们将 count 和 value 放在一起：
     * <p>
     * <p>
     * nums:      [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
     * count:      1  2  1  2  1  0   1  0   1  2  1  0   1  2  3  4
     * value:      1  2  1  2  1  0  -1  0  -1 -2 -1  0   1  2  3  4
     * 发现在每一步遍历中，count 和 value 要么相等，要么互为相反数！并且在候选众数 candidate 就是 maj 时，它们相等，candidate 是其它的数时，它们互为相反数！
     * <p>
     * 为什么会有这么奇妙的性质呢？这并不难证明：我们将候选众数 candidate 保持不变的连续的遍历称为「一段」。在同一段中，count 的值是根据 candidate == x 的判断进行加减的。那么如果 candidate 恰好为 maj，那么在这一段中，count 和 value 的变化是同步的；如果 candidate 不为 maj，那么在这一段中 count 和 value 的变化是相反的。因此就有了这样一个奇妙的性质。
     * <p>
     * 这样以来，由于：
     * <p>
     * 我们证明了 count 的值一直为非负，在最后一步遍历结束后也是如此；
     * <p>
     * 由于 value 的值与真正的众数 maj 绑定，并且它表示「众数出现的次数比非众数多出了多少次」，那么在最后一步遍历结束后，value 的值为正数；
     * <p>
     * 在最后一步遍历结束后，count 非负，value 为正数，所以它们不可能互为相反数，只可能相等，即 count == value。因此在最后「一段」中，count 的 value 的变化是同步的，也就是说，candidate 中存储的候选众数就是真正的众数 maj。
     */
    public int majorityElement(int[] nums) {

        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if (n < 2) {
            return;
        }
        while (k > 0) {

            int i = n-2,j=n-1;
            while (i >= 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i--;
                j--;
            }

            k--;
        }

        System.out.println(Arrays.toString(nums));

    }

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length < 2){
            return 0;
        }

        int i = 0;
        int j = 1;
        int pro = 0;
        while (j < prices.length){
            if(prices[i] < prices[j]){
                for (int m = j; m < prices.length; m++) {
                    pro = Math.max(prices[m] - prices[i],pro);
                }
            }

            i++;
            j++;
        }

        return Math.max(pro,0);
    }
}
