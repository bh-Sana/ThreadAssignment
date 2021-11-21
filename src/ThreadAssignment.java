
public class ThreadAssignment {

    static class Counter {
        void count() {
            for (int i=350 ;i>=1;i--){
                System.out.println(i);
            }
            System.out.println("FINISH !");
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            synchronized (counter) {
                counter.count();
            }        System.out.println("DONE !");

        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        new MyThread(counter).start();
        new MyThread(counter).start();
    }
}
