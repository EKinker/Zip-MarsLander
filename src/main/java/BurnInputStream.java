import java.util.Scanner;

public class BurnInputStream implements BurnStream {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int getNextBurn(DescentEvent status) {
        String[] tokens = scanner.nextLine().split(" ");  //does this let the user enter multiple burns in 1 line?
        if (tokens.length > 0) {
            while (true) {
                try {
                    int burn = Integer.parseInt(tokens[0]); //looks like it will only take the first one
                    return burn;
                } catch (NumberFormatException e) {
                    System.err.println("Must Enter a Number (0-200)");
                }
            }
        }
        return 0;
    }
}
