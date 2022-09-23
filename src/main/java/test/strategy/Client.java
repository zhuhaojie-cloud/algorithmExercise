package test.strategy;

public class Client {
    public static void main(String[] args) {
         Context context;
         context = new Context(new ConcreateStrategyA());
         context.contextInterface();
         context = new Context(new ConcreateStrategyB());
         context.contextInterface();
         context = new Context(new ConcreateStrategyC());
         context.contextInterface();
    }
}
