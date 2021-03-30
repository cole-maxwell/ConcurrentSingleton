package cs681;
import java.util.concurrent.locks.*;

public class ConcurrentSingleton {

    private ConcurrentSingleton() {};
    private static ConcurrentSingleton instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    // Factory method to create or return the singleton instance
    public static ConcurrentSingleton getInstance() {
        lock.lock();
        try{
            if(instance==null) {
                instance = new ConcurrentSingleton();
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
    }
}