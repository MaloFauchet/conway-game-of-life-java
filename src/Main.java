import java.security.KeyStore;

public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Conway conway = new Conway(10, 10);
        conway.printGrid();
        while (true) {
            Thread.sleep(100);
            System.out.print("\n\n\n\n\n\n");
            conway.run();
            conway.printGrid();
        }

    }
}