package cn.xyz.thread;

public class SequenceNumber {
    //ThreadLocal为每个线程提供了单独的副本
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNexNum(){
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber number = new SequenceNumber();

        TestClient client1 = new TestClient(number);
        TestClient client2 = new TestClient(number);
        TestClient client3 = new TestClient(number);
        client1.start();
        client2.start();
        client3.start();
    }

    private static class TestClient extends Thread{
        private SequenceNumber number;
        public TestClient(SequenceNumber number){
            this.number = number;
        }

        @Override
        public void run() {
            for (int i=0;i<3;i++){
                System.out.println("thread[" + Thread.currentThread().getName() + "] sn[" + number.getNexNum() + "]");
            }
        }
    }
}
