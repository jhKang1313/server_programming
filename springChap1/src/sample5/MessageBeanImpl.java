package sample5;

public class MessageBeanImpl implements MessageBean {
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void sayHello() {
        try {
        //    Thread.sleep(5000);
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
        
        System.out.println("Hello, " + name + "!");
    }

    public void sayHi() {
        System.out.println("Hi, " + name + "!");
    }
}
