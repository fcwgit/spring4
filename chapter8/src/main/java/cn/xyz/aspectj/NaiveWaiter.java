package cn.xyz.aspectj;

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("NaiveWaiter:greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("NaiveWaiter:serve to " + name + "...");
    }
}
