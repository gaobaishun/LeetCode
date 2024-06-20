import java.util.*;

/**
 * 鸡蛋掉落
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions/xmup75/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class EggDrop {

    public Map<Integer, Integer> map = new HashMap<>();

    public Map<String, Integer> resultMap = new HashMap<>();

    public Map<Integer, TreeSet<Integer>> KNMap = new HashMap<>();

    public List<List<Integer>> list = new ArrayList<>();

    public int superEggDrop(int k, int n) {
        int tempK = k;
        //最坏情况下测试次数
        int maxTestNum = 0;
        for (int i = 1; i <= n; i++) {
            //从i层开始测

            int tempTestNum = 0;

            //能确定f的楼层数范围
            int unCheckNum = n + 1;
            for (int f = 0; f <= n; f++) {
                //当f为特定值时

                if (i > f) {
                    //表示当前层数高于f值，鸡蛋坏掉，数量减一
                    --tempK;

                    // unCheckNum 能确定f的楼层数范围为几层
                    // 比如在第一层鸡蛋就碎了，可以肯定f就在0层，此时unCheckNum为1
                    //在第二层鸡蛋就碎了，可以确定f在0层或者1层，此时unCheckNum为2，但此时没法确定具体数值
                    unCheckNum = unCheckNum - (n - 1);
                } else {

                    //比如在第二层鸡蛋未坏，此时可以排除0,1,2层了
                    unCheckNum = unCheckNum - (i + 1);
                }
                //已测试次数加一
                tempTestNum++;
                if (unCheckNum <= 1) {
                    //已经可以确定f的楼层数了
                    break;
                } else {

                }
            }

            if (tempK == 0) {
                //如果没有鸡蛋了，说明从i层开始检测不靠谱
                //重置tempK的值
                tempK = k;
                continue;
            }

            if (tempTestNum > maxTestNum) {
                //如果临时最大测试次数大于最大测试次数，则最大测试次数替换为临时最大测试次数
                maxTestNum = tempTestNum;
            }
        }

        return maxTestNum;
    }

    public int superEggDrop2(int k, int n) {
        int key = k * 10001 + n;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (k == 1 || n <= 2) {
            return n;
        }

        int minCounts = Integer.MAX_VALUE;
        for (int i = 2; i <= n / 2 + 1; i++) {
            //System.out.println(i);
            int left = superEggDrop2(k - 1, i - 1);
            int right = superEggDrop2(k, n - i);
            int temp = left > right ? left + 1 : right + 1;
            if (temp < minCounts) {
                //System.out.println("鸡蛋:"+k+"层数"+n+"划分："+i+"最优划分次数"+temp);
                minCounts = temp;
            }
        }
        //System.out.println(k+"  "+n+"  "+ minCounts);
        map.put(key, minCounts);
        return minCounts;
    }

//    public int superEggDrop3(int k, int n) {
//        list.
//    }

//    public int getSplitIndex(int k,int n){
//
//    }


    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int superEggDrop3(int k, int n) {
        return dp(k, n);
    }

    public int dp(int k, int n) {
        if (!memo.containsKey(n * 100 + k)) {
            int ans;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int lo = 1, hi = n;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(k - 1, x - 1);
                    int t2 = dp(k, n - x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(dp(k - 1, lo - 1), dp(k, n - lo)), Math.max(dp(k - 1, hi - 1), dp(k, n - hi)));
            }

            memo.put(n * 100 + k, ans);
        }

        return memo.get(n * 100 + k);

    }

    public int superEggDrop4(int k, int n) {
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            //dp为k 鸡蛋为特定值时，随着n 层数的增加最少次数
            dp[i] = i;
        }

        for (int j = 2; j <= k; ++j) {
            // Now, we will develop dp2[i] = dp(j, i)
            int[] dp2 = new int[n + 1];
            int x = 1;
            for (int m = 1; m <= n; ++m) {
                // Let's find dp2[m] = dp(j, m)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[m-x]) > max(dp[x], dp2[m-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                System.out.println("m: "+m);
                System.out.println("x-1: "+(x - 1)+"m-x: "+(m - x)+" x: "+x+" m-x-1: "+(m - x - 1));
                while (x < m && Math.max(dp[x - 1], dp2[m - x]) > Math.max(dp[x], dp2[m - x - 1])) {
                    x++;
                }

                // The final answer happens at this x.
                dp2[m] = 1 + Math.max(dp[x - 1], dp2[m - x]);
            }

            dp = dp2;
        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(new EggDrop().superEggDrop4(2, 9));
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(3);
        System.out.println(treeSet);
    }
}
