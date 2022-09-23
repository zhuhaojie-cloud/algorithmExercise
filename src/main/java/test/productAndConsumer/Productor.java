package test.productAndConsumer;

public class Productor extends Thread{
    private Basket basket = null;

    public Productor(Basket basket) {
        super();
        this.basket = basket;
    }
    //重写run，生产者生产苹果
    @Override
    public void run() {
        basket.pushApple();
    }
}
