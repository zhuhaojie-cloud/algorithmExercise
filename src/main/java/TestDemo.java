import java.util.*;

public class TestDemo {

    /**
     * 去除重复的字母
     * 输入: "abccda"
     * 输出: "abcd"
     * 找到第一个字符，删除与它相同的字符，加上，再找下一个字符，。。。，递归重复，直到s==""
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;//统计a,b,c...有几个
        for (int i = 0; i < s.length(); i++) {  //找到第一个字符，删除与他相同的字符
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;  //先--再比较，
        }
        // String n=s.substring(pos + 1).replaceAll("" + "a", "");
        // String m=s.substring(pos + 1).replaceAll("" + s.charAt(pos), "");
        //截取目标字符的字符串再，用""去覆盖剩下的目标字符
        //如abccda，第一次统计cnt[2,1,2,1,0,0...],第一个字符减去1，只剩下1个，那就截掉a,
        // 剩下的bccda，再用a去匹配剩下的a,最后结果递归调用
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    /**
     * 括号匹配。给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 输入: "()[]{}"
     * 输出: true
     * 输入: "([)]"
     * 输出: false
    **/
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {//stack.peek()返回栈顶的值，与pop的区别是，不删除
                    return false;
                }
                stack.pop();  //出栈
            } else {
                stack.push(ch); //进栈
            }
        }
        return stack.isEmpty();
    }

    /**
     * 无重复字符的最长子串
     * 输入: "pwwkew"    wke
     * 输出:
     */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /***
     * 给定'1'(陆地) 和'0'(水) 的二维网格图，计算岛屿的数量。
     * 利用一个同样大小的二维数组，作为已经遍历过的标志
     * 双循环遍历每个点，如果为1，计数为++，则进入四个方向深度优先遍历，将所有原数组为1的地方，把标志数组也赋值为1
     * 遇到外边界，或者0，或者标志数组为1的地方都不去
     */
    public static void m() {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '0', '1', '1'}};
        //isvisit表示是否遍历过
        char[][] isgrid = new char[grid.length][grid[0].length]; //初始化一个相同大小，但值全为空
        System.out.println(def(grid, isgrid));
    }

    public static int def(char[][] grid, char[][] isgrid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isgrid[i][j] != '1') {
                    if (grid[i][j] == '1') {
                        count++;
                    }
                    defVisit(grid, isgrid, i, j);//深度优先搜索,并绘制isgrid
                }
            }
        }
        return count;
    }

    public static void defVisit(char[][] grid, char[][] isgrid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
            //越界
            return;
        }
        if (grid[i][j] == '0') {
            //不是
            return;
        }
        if (isgrid[i][j] == '1') {
            //已经遍历过
            return;
        } else {
            isgrid[i][j] = '1';
            defVisit(grid, isgrid, i - 1, j);//上
            defVisit(grid, isgrid, i + 1, j);//下
            defVisit(grid, isgrid, i, j - 1);//左
            defVisit(grid, isgrid, i, j + 1);//右
        }
    }


    /**
     * 注意! 本题不要遍历二维数组. 要求时间复杂度严格低于n^2, 否则视为不得分
     * 现有一个n*n的二维正整数数组nums，每行元素保证递增，每列元素保证递增，求某正整数x是否存在于该二维数组中，需要尽量优化时间和空间复杂度；
     *  1  2  3
     *  2  5  6
     *  4  7  8
     * 先与左下角4比较，如果目标大于4往右走，如果小于往上走
     */
    public static boolean searchMatrix(int[][] nums, int x) {
        int n = nums.length;
        int row = 0;
        int col = n - 1;
        while ((row <= n - 1) && (col >= 0)) {
            if (nums[row][col] > x) {
                col--;
            } else if (nums[row][col] < x) {
                row++;
            } else if (nums[row][col] == x) {
                n = row + 1;
                n = col + 1;
                return true;
            }
        }
        if ((row > n - 1) || (col < 0)) {
            n = -1;
            n = -1;
        }
        return false;
    }

    /***
     * 输入一个字符串，允许删除字符串中的某些字符，变成连续字符都是不一样的字符串，如AAABBCC形成ABC删除4个
     */
    public static void deletechar() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int  n=1;
        while (n-- != 0) {
            String s = in.next();
            //String s="AABB";
            int kill = 0; //删除的个数
            for (int i = 0; i < s.length() - 1; i++) {
                char temp = s.charAt(i); //当前字符
                while (i < s.length() - 1 && s.charAt(i + 1) == temp) {  //如果不是最后一个字符，且后面一个字符和它相同
                    kill++;  //删除+1
                    i++;  //直接跳过一个
                }
            }
            System.out.println(kill);
        }
    }

    /***
     * 求数组中出现次数超过一半的值
     * @param v
     * @return
     */
    public static int findMoreThanHalf(int[] v) {
        int len = v.length;
        if (len == 0)
            return 0;//无效输入
        //因为同样的数肯定比所有不同的数加起来还多
        //同样的数字个树与所有不同的数字相抵消，得到key。
        int key = v[0];  //取第一个
        int value = 1;   //表示key出现一次
        for (int i = 1; i < len; ++i) {
            if (value == 0) {   //如果被抵消了，重新取key
                key = v[i];
                value = 1;
            }
            if (key == v[i]) {  //看这个数与key是不是相同，如果相同则次数+1,不相同则次数-1
                value++;
            } else
                value--;
        }
        //得出key即为所求，在存在的情况下
        //判断出现超过一半的数是否存在
        value = 0;
        for (int i = 0; i < len; ++i) {
            if (key == v[i])
                value++;
        }
        if (value <= len / 2)
            return 0;//无效输入
        else
            return key;
    }
    //给定一个n*m矩阵，求从左上角格子到右下角格子总共存在多少条路径，每次只能向右走或者向下走。
    //注意走格子和走定点是不一样的

    //动态规划思想,储存单步运算的结果，避免重复计算
    public static int totalMethod(int n, int m) {
        if (n == 1 && m == 1) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return 1;
        }
        return totalMethod(n - 1, m) + totalMethod(n, m - 1);
    }



    /***
     * 一个线程打印abcdef，一个线程打印123456，两个线程交替打印，最终打印结果为a1b2c3d4e5f6
     * 用wait,notify实现
     */
    public static void sprinThread() {
        final Object lock = new Object();
        char[] nums = "123456".toCharArray();
        char[] nums1 = "ABCDEF".toCharArray();
        new Thread(() -> {
            synchronized (lock) {
                for (char n : nums) {
                    System.out.print(n);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "N").start();

        new Thread(() -> {
            synchronized (lock) {
                for (char c : nums1) {
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "C").start();
    }

     //使用LockSupport实现：
     /*public static void sprinThread1(){
        char[] nums = "123456".toCharArray();
        char[] chars= "ABCDEF".toCharArray();
        Thread N;
        Thread C = null;
         N = new Thread(()->{
                for (char n:nums) {
                    System.out.print(n);
                    LockSupport.unpark(C);
                    LockSupport.park();
                }
            },"N");
         C = new Thread(()->{
                for (char c:chars) {
                    LockSupport.park();
                    System.out.print(c);
                    LockSupport.unpark(N);
                }
            },"C");
            N.start();
            C.start();
      }*/


    /***
     * 快速幂
     * b是拆成二进制,根据二进制的权值来求解
     * 那么在关于位运算的部分，我们可以逐位获取b的位，碰到0，就累乘，
     * 碰到1，就将累乘的值并且将乘到答案
     * @param a
     * @param b
     * @return
     */
    static int poww(int a, int b) {
        int ans = 1, base = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans *= base;
            }
            base *= base;
            b >>= 1;
        }
        return ans;
    }

    /***
     * 快速幂取模
     * @param a
     * @param b
     * @param c
     * @return
     */
    static int pow_mod(int a, int b, int c) {
        int ans = 1;
        int base = a % c;
        while (b > 0) {
            if ((b & 1) != 0)
                ans = (ans * base) % c;
            base = (base * base) % c;
            b >>= 1;
        }
        return ans;
    }

    /***
     * 给定一个句子（只包含字母和空格），
     * 将句子中的单词位置反转，单词用空格分割,
     * 单词之间只有一个空格，前后没有空格。
     * 比如： （1） “hello xiao mi”-> “mi xiao hello”
     */
    public static void verse() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String help[] = str.split(" ");
            String res = "";
            for (int i = help.length - 1; i >= 0; i--) {
                res = res + help[i] + " ";
            }
            res = res.trim(); //删除两端的空格
            System.out.println(res);
        }
    }

    /***
     * 最长公共子序列
     * @param a
     * @param b
     * @return
     */
    private static int LCS(String a, String b) {
        if (a == null || b == null || "".equals(a) || "".equals(b)) return -1;
        int dp[][] = new int[a.length()][b.length()];
        for (int i = 1, lena = a.length(); i <= lena; i++) {
            for (int j = 1, lenb = b.length(); j <= lenb; j++) {
                char cha = a.charAt(i - 1);
                char chb = b.charAt(j - 1);
                if (cha == chb) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    /***
     * 假设你有一个用1001个整数组成的数组，这些整数是任意排列的，
     * 但是你知道所有的整数都在1到1000(包括1000)之间。此外，除一个数字出现两次外，
     * 其他所有数字只出现一次。假设你只能对这个数组做一次处理，
     * 用一种算法找出重复的那个数字。如果你在运算中使用了辅助的存储方式，
     * 那么你能找到不用这种方式的算法吗?
     * @param a
     * @return
     */
    //把数组之和减去1-1000相加
    static int fun2(int a[]) {
        int s1 = 0;
        int s2 = (1 + 1000) * 1000 / 2;
        for (int i = 0; i < 1001; i++) {
            s1 += a[i];
        }
        return s1 - s2;
    }


    /**给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法
     * 动态规划，每次小循环只用一种硬币。
     *若在一次for循环中处理四种情况(一个for里带四个硬币的处理情况)，每次计算新一项时，
     *由于每次取的硬币是任意的，会出现对于不同的硬币取法，情况重复的现象。
     *例如：n=15时，res[15] = 1(全1) + res[15 - 5] + res[15 - 10] = 7，但10 + 5和5 + 10是重复的。
     *每次小循环只用一种硬币可以避免重复，因为每次小循环中选用的硬币是固定的，在没有到对应硬币的循环前，
     *表内记录对应的解必然不包含该硬币。
     * 例如：n=15时， 四次：res[15]=0 -> res[15] = 0 -> res[15] = 2 -> res[15] = 6
     *实际上coins数组升序也不会影响结果。
     * */
    public static int mod = 1000000007;
    public static int[] coins = {25, 10, 5, 1};

    public static int waysToChange(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                res[i] = (res[i] + res[i - coin]) % mod;
            }
        }
        return res[n];
    }

    /**
     * 薯队长写了一篇笔记草稿，请你帮忙输出最后内容。
     *  1.输入字符包括，"("    ,    ")"    和    "<"和其他字符。
     *  2.其他字符表示笔记内容。
     *  3.()之间表示注释内容，任何字符都无效。    括号保证成对出现。
     *  4."<"表示退格,    删去前面一个笔记内容字符。括号不受"<"影响
     **/
    public static void te() {
        Scanner scanner = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer = new StringBuffer(scanner.nextLine());
        List<Integer> k = new ArrayList<>();
        //用一个列表来装括号的匹配
        //遇见‘（’添加首次匹配位置进去
        //遇见‘）’从最后一次‘（’匹配位置开始删除字符串
        for (int i = 0; i < stringBuffer.length(); ) {
            if (stringBuffer.charAt(i) == '(') {
                k.add(i);
                i++;
            } else if (stringBuffer.charAt(i) == '<' && k.size() == 0) {
                stringBuffer.delete(i - 1, i + 1);
                i = i - 1;
            } else if (stringBuffer.charAt(i) == ')') {
                stringBuffer.delete(k.get(k.size() - 1), i + 1);
                i = k.get(k.size() - 1);
                k.remove(k.size() - 1);
            } else
                i++;
        }
        System.out.println(stringBuffer);
    }

    /**
     * 数组循环又移k位
     */
    public static void reverseK(int[] list, int k) {
        //三次反转
        //先反转0 , n-k-1
        //再反转n-k,n-1
        //再反转0，n-1
        if (k == 0) {
            PrintDemo.PrintArr(list);
        }
        int temp = 0;
        int size = list.length;
        reverse(list,0,size-k-1);
        reverse(list,size-k,size-1);
        reverse(list,0,size-1);
        PrintDemo.PrintArr(list);
    }

    public static void reverse(int[] list,int i,int j) {
        for (; i < j; i++, j--) {
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7,8};
        reverseK(list,2);
    }
}
