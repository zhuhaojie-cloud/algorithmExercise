package test.productAndConsumer;

public class ProductAndConsumer {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Productor productor = new Productor(basket);
        Consumer consumer = new Consumer(basket);
        productor.start();
        consumer.start();
    }
}
