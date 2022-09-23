package test.productAndConsumer;

public class Apple {
    private int id; //编号
    public Apple(int id){
        this.id=id;
    }
    @Override
    public String toString() {
        return "苹果："+(id+1);
    }
}
