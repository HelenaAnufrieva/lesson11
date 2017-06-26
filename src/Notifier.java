/**
 * Created by Hillel on 26.06.2017.
 */
public class Notifier implements Runnable{
    private Message msg;

    public Notifier (Message m)
    {
        this.msg = m;
    }

    public void run()
    {
        String name = Thread.currentThread().getName(); //имя потока
        System.out.println(name + " started");

        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name + "поток Notifier отработал");
                msg.notify();
                //msg.notifyAll();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
