import java.io.IOException;

/**
 * Created by gabriel on 18/04/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        MineradorDioLinux mineradorDioLinux = new MineradorDioLinux();
        mineradorDioLinux.conectaDioLinux();
        System.out.println(mineradorDioLinux.processaDados());

    }
}
