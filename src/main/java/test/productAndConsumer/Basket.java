package test.productAndConsumer;

import java.util.LinkedList;

public class Basket {
    //存放和取需要容器(使用LinkedList做增删操作效率高)
    private LinkedList<Apple> basket = new LinkedList<Apple>();
    //放四轮苹果(放的时候就不能吃，吃的时候就不能放，所以加同步锁)
    public synchronized void pushApple(){
        for(int i=0;i<20;i++){
            Apple apple = new Apple(i);
            push(apple);
        }
    }

    //吃苹果
    public synchronized void popApple(){
        for(int i=0;i<20;i++){
            pop();
        }
    }

    //向篮子放苹果
    private void push(Apple apple){
        //当篮子当中存放了五个苹果，就等待并通知消费者来消费
        if(basket.size()==5){
            try {
                //等待并释放当前对象的锁
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //假如篮子里不满五个苹果，继续放苹果，放的时候有动作，休眠一下，每隔五百毫秒
        try {
            //sleep方法时间过了会自动苏醒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basket.addFirst(apple);
        System.out.println("存放:"+apple.toString());
        notify();//通知消费者来消费
    }

    //向篮子当中取苹果
    private void pop(){
        //当篮子当中苹果数为0时，就等待并通知生产者来生产
        if(basket.size()==0){
            try {
                //等待并释放当前对象的锁
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //假如篮子里有五个苹果，继续取苹果，取的时候有动作，休眠一下，每隔五百毫秒
        try {
            //sleep方法时间过了会自动苏醒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Apple apple = basket.removeFirst();
        System.out.println("吃掉:"+apple.toString());
        notify();//通知生产者来生产
    }
}
