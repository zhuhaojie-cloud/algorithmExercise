package test.productAndConsumer;

public class Consumer extends Thread{
    private Basket basket = null;
    public Consumer(Basket basket) {
        super();
        this.basket = basket;
    }
    //重写run，消费者消费苹果
    @Override
    public void run() {
        basket.popApple();
    }
}
