import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        /* Arguments */
        int primeNumberAmount = 1000;

        for(int i = 0; i < args.length; i++) {
            final String argument = args[i];
            if(argument.equalsIgnoreCase("-amount")) {
                primeNumberAmount = Integer.parseInt(args[i + 1]);
            }
        }

        final ArrayList<Integer> primeNumbers = new ArrayList<>();
        final long initTime = System.currentTimeMillis();

        int current = 1;

        while(primeNumbers.size() != primeNumberAmount) {
            current++;
            boolean isPrimeNumber = true;
            int factors = 0;
            for(int i = 1; i <= current; i++) {
                if(current % i == 0) {
                    factors++;
                    if(factors > 2) {
                        isPrimeNumber = false;
                        break;
                    }
                }
            }
            if(isPrimeNumber) {
                System.out.println(current);
                primeNumbers.add(current);
            }
        }

        /* Calculate Time */
        final long time = System.currentTimeMillis() - initTime;
        System.out.println("Time: " + time);

        /* File saving */
        final File dir = new File("logs");
        if(!dir.exists())
            dir.mkdirs();
        final File file = new File(dir,primeNumberAmount + " (" + time + "ms) - " + System.currentTimeMillis()  + ".txt");
        file.createNewFile();
        final FileWriter writer = new FileWriter(file);
        for(int primeNumber : primeNumbers) {
            writer.write(primeNumber + "\n");
        }
        writer.close();
    }
}
