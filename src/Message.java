
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;


public class Message {
    String label;
    String contenu;

    public Message(String label, String contenu) {
        this.label = label;
        this.contenu = contenu;
    }

    public String getContenu() {
        return this.contenu;
    }

    public String label() {
        return this.label;
    }

}


public class Scheduler implements Runnable {
    BlockingQueue<Message> queue;
    ArrayList<Job> jobs;

    public Scheduler(BlockingQueue q) {
        this.queue = q;
    }

    public void run() {
        Message mess;
        try {
            while(true) {
                mess = queue.poll();
                if (mess == null) {
                    break;

                switch (mess.label()) {
                    case "P0":
                        Job job = new P1(queue);
                        jobs.add(job);
                        job.addMessage(mess);

                    case "P1":

                }

                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public class Job implements Runnable{
        BlockingQueue<Message> outqueue, inqueue;
        public Job(BlockingQueue q){
            this.outqueue = q;
        }
        public void addMessage(Message m){
            inqueue.add(m);
        }
        public void run(){
            Message mess;
            while(true){
                mess= inqueue.poll();
                if (mess==null){
                    break;
                } else {
                    mess = process(mess.contenu);
                    if (mess != null)
                        outqueue.add(mess);
                }
            }
        }
        // virtuel  method
        public Message process(String contenu){
            System.out.println("generic method");
            return null;
        }
    }

    public class P1 extends Job{
        Message process(String contenu){

        }
    }
    public static void main(String[] args) {
    }
}
