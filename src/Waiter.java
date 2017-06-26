/**
 * Created by Hillel on 26.06.2017.
 */
public class Waiter implements Runnable {
    private Message msg;

    public Waiter (Message m)
    {
        this.msg = m;
    }

    public void run()
    {
        String name = Thread.currentThread().getName(); //имя потока
        synchronized (msg)
        {
            try {
                System.out.println(name + "жду вызова notify: " + System.currentTimeMillis());
                msg.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(name + "был вызов метода notify: " + System.currentTimeMillis());
            System.out.println(name + " : " + msg.getMsg());

        }
    }
}
