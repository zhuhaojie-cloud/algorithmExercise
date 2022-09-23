import test.node.ListNode;

import java.util.ArrayList;

public class Main {

    //声明初始化类型
    //整形数组int a[]={1,5,6,4,2,3,4,8};
    // 字符数组 char[] charArray ={ 'a', 'b', 'c', 'd', 'e' };
    //字符串数组 List<String> list=new ArrayList<String>();list.add("Hello");
    //ArrayList<String> sites = new ArrayList<String>();sites.add("Google");
    //ArrayList<Integer> li=new Arraylist<>();     // 存放整数元素
    //ArrayList<Character> li=new Arraylist<>();   // 存放字符元素
    //Map<String, String> map = new HashMap<String, String>();map.put("1", "value1");
    /*创建字符串链表 LinkedList<String> sites = new LinkedList<String>();
    sites.add("Google");
    使用 addFirst() 在头部添加元素
    使用 addLast() 在尾部添加元素
    使用 removeFirst() 移除头部元素
    使用 removeLast() 移除尾部元素
    使用 getFirst() 获取头部元素
    使用 getLast() 获取尾部元素
    */
   /*
       HashSet<String> sites = new HashSet<String>();
        sites.add("Google"); // 重复的元素不会被添加
        sites.contains("Taobao") 判断是否存在
        sites.remove("Taobao");  // 删除元素，删除成功返回 true，否则为 false
      sites.clear(); 清空
    */
   /* HashMap<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对
       Sites.put(1, "Google");
      HashMap<String, String> Sites = new HashMap<String, String>();
        // 添加键值对
        Sites.put("one", "Google");
        Sites.get(3)获取
         Sites.remove(4); 删除
         Sites.clear(); 清空
    */
    //转化操作
   /*字符数组转字符串 char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
    String helloString = new String(helloArray);*/
    //操作函数
    /*String site = "www.runoob.com";
        字符串长度int len = site.length();
       指定位置字符 char result = site.charAt(6);*/
    /* ArrayList<Integer> myNumbers = new ArrayList<Integer>();
       myNumbers.add(33);
        myNumbers.add(15);
    Collections.sort(myNumbers);  // 数字排序
     */
    /*Scanner s = new Scanner
        System.out.print("输入你的姓名：");
        String name = s.nextLine();
        System.out.print("输入你的年龄：");
        int age = s.nextInt();
        System.out.println("姓名：" + name + "  年龄：" + age );
        while (scanner.hasNext()) {
            a= scanner.nextInt();
        }
        s.close();         //若没有关闭Scanner对象将会出现警告  */
    public static void main(String[] args) {
       /* Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            System.out.print(s.nextInt());
        }*/
        //Test.sprinThread();
       // int[] a={1,2,2,3,8,7,9,4};
       /* Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.Next = node2;
        node2.Next = node3;
        node3.Next = node4;
        node4.Next = node5;
         * 2
       * / \
     * 3   4
   * / \  /
  * 5  6 7
        */
       /* TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left=b;
        a.right=e;
        b.left=c;
        b.right=d;
        e.left=f;*/
        /*TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        g.left=h;*/
       // test.tree.Tree.PrintFromTopToBottom1(a);
     //   ArrayList<Integer> path = new ArrayList<>()
       /*Test.verse();*/
        /*int []a={1,3,5,2,2};
        System.out.println(test.Finder.findKth(a,5,3));*/
        //List<Integer> aa=new LinkedList<>();
        //test.tree.Tree.flatten(a);
       // String a="pwwkew";
       // Test.m();
        /*ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);*/
       /* head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=new ListNode(7);
        head.next.next.next.next.next.next.next=new ListNode(8);*/
       // head=test.node.LinkTest.reverseList1(head);
        /*String[] ipArr={"192.168.1.1","192.168.1.2","192.168.1.3","192.168.1.4"};
        String[] blackIpArr={"192.168.1.1","192.168.1.4"};
        boolean[] re= isBlackIp(ipArr,blackIpArr);*/
        /*String content=null;
        ArrayList<String> re=filterSensitiveWords(content, new String[]{"here", "hope"});*/

        /*Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int a=s.charAt(0);
        String[] b=s.substring(4,s.length()-1).split(",");
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);
        int[] c = new int[s.length()];
        for(int i = 0;i < s.length();i++){
            c[i] = Integer.parseInt( String.valueOf(s.indexOf(i)));
        }*/
        //int[] c={2,3,5};
       /* Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();*/

        //Scanner sc = new Scanner(System.in);
        /*int n = 20;
        int[] nums ={0,1,0,3,4,5,0,2,0,1,2,4,6,3,2,1,0,0,3,1};*/
        /*for(int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }*/
        //dp[]选出总点赞数
        //Ndp选出总页数
        /*int[] dp = new int[n+1]; // 总点赞数
        dp[1] = nums[0];
        int[] dpN = new int[n+1]; // 挑选笔记数
        dpN[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(dp[i-1] < dp[i-2] + nums[i-1]) { // 选
                dp[i] = dp[i-2] + nums[i-1];
                dpN[i] = dpN[i-2] + 1;
            } else { // 不选
                dp[i] = dp[i-1];
                dpN[i] = dpN[i-1];
            }
        }
        System.out.println(dp[n] + " " + dpN[n]);*/
        //初始化
        ListNode head=new ListNode(1);
        init(head,2);
        //取到尾节点，首尾相连，循环链表
        ListNode temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;//连接head1
        print(head);

        ListNode t=head; //改变head
        t.next.next=t.next.next.next;//隔一颗取一颗
        t=t.next.next;
        while (true){
            if(t.next.val==1){//到达黑棋
                break;
            }
            t.next=t.next.next;//隔一颗取一颗
            t=t.next;
        }
        print(head.next);//不打印黑棋
    }

    //初始化
    public static ListNode init(ListNode head,int i){
        ListNode temp=new ListNode(i);
        head.next=temp;
        i++;
        if(i<9){
            init(temp,i);
        }
        return head;
    }

    //打印
    public static void print(ListNode head){
        while(head.val<head.next.val){//到达循环点
            System.out.println(head.val);
            head=head.next;
        }
        System.out.println(head.val);
    }

    public static ArrayList<String> filterSensitiveWords(String content, String[] sensitiveWords) {
        // write code here
        int[] a=new int[4];
        if(content==null){
            return null;
        }
        ArrayList<String> re=new ArrayList<>();
        String[] contents=content.split(" ");
        for(int i=0;i<contents.length;i++){
            for(int j=0;j<sensitiveWords.length;j++){
                //boolean status = str.contains("a");
                //if(b(contents[i],sensitiveWords[j])) {
                if(contents[i].contains(sensitiveWords[j])) {
                    re.add(sensitiveWords[j]);
                }
            }
        }
        return re;
    }

    /*private boolean b(String content, String sensitiveWord) {
         for(int m=0;m<content.length();m++){

         }
    }*/

    public static boolean[] isBlackIp(String[] ipArr, String[] blackIpArr) {
        // write code here
        boolean[] re = new boolean[ipArr.length];
        for(int i=0;i<ipArr.length;i++){
            for(int j=0;j<blackIpArr.length;j++){
              /*  if(a(blackIpArr[i],ipArr[j])){
                    re[i]=true;
                }*/
                if(ipArr[i].equals(blackIpArr[j])){
                    re[i]=true;
                    break;
                }
            }
        }
        return re;
    }

    private static boolean a(String ip1,String ip2) {
        String[] arr1 = ip1.split("\\.");
        String[] arr2= ip2.split("\\.");
        if(Integer.parseInt(arr1[0])==Integer.parseInt(arr2[0])&&Integer.parseInt(arr1[1])==Integer.parseInt(arr2[1])&&Integer.parseInt(arr1[2])==Integer.parseInt(arr2[2])&&Integer.parseInt(arr1[3])==Integer.parseInt(arr2[3])){
            return true;
        }
        return false;
    }

    /**
     * 将IP地址字符串转换为int
     * @param ip
     * @return
     */
    private static int chgIpStrToInt(String ip) {
        /*if (ip == null || StringUtils.isEmpty(ip)) {
            throw new RuntimeException("Null string");
        }*/
        String[] arr = ip.split("\\.");
        /*if (arr == null || arr.length != 4) {
            throw new RuntimeException("Invalid ip");
        }*/
        /*if ("128.0.0.0".equals(ip)) {
            return Integer.MIN_VALUE;
        }*/
        StringBuilder sb = new StringBuilder();
        sb.append(getByteBinaryStr(new Integer(arr[0])));
        sb.append(getByteBinaryStr(new Integer(arr[1])));
        sb.append(getByteBinaryStr(new Integer(arr[2])));
        sb.append(getByteBinaryStr(new Integer(arr[3])));
        String intStr = sb.toString();
        // Integer.valueOf处理负数会有问题
        if (intStr.charAt(0) == '1') {
            char[] chars = intStr.toCharArray();
            chars[0] = '0';
            intStr = new String(chars);
            return 0 - Integer.valueOf(intStr, 2).intValue();
        }
        return Integer.valueOf(intStr, 2).intValue();
    }

    /**
     * 固定8位，前面不足的补零
     * @param num
     * @return
     */
    private static String getByteBinaryStr(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if ((num & 1) == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            num = num >> 1;
        }
        return sb.reverse().toString();
    }

    /*public static ListNode flattn(TreeNode root){
        if(root==null) return null;
        ListNode listNode=new ListNode(root.val);
        listNode1.next=listNode;
        if(root.left!=null) flattn(root.left);
        if(root.right!=null) flattn(root.right);
        return listNode;
    }*/
}
