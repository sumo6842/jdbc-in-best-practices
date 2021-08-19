package config;


public class ConnectionThreadTest extends Thread {
//    private CountDownLatch latch;
//    private String taskName;
//
//    public ConnectionThreadTest(CountDownLatch latch, String taskName) {
//        this.latch = latch;
//        this.taskName = taskName;
//    }
//
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + " Starting. Task = " + taskName);
//        execute();
//        latch.countDown();
//        System.out.println(Thread.currentThread().getName() + "Finish");
//    }
//
//    private void execute() {
//        try {
//            String sqlSelect = "SELECT COUNT(*) AS total FROM Student";
//            try (Connection connection = ConcreteDatasource.getConnection();
//                 Statement stm = connection.createStatement();
//                 ResultSet rs = stm.executeQuery(sqlSelect)) {
//                Thread.sleep(2000);
//                rs.next();
//                System.out.println("Task = " + taskName + ": Run SQL successfully " + rs.getInt("total"));
//            }
//        } catch (SQLException | InterruptedException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
}

//class Main {
//    private static  final int NUMBER_OF_USERS = 8;
//
//    public static void main(String[] args) throws InterruptedException {
//        final CountDownLatch latch = new CountDownLatch(NUMBER_OF_USERS);
//        for (int i = 0; i < NUMBER_OF_USERS + 1; i++) {
//            Thread worker = new ConnectionThreadTest(latch, "" + i);
//            worker.start();
//        }
//        latch.await();
//        System.out.println("Done All task");
//    }
//}
