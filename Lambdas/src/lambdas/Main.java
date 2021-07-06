package lambdas;

public class Main {
    public static void main(String[] args) {
        OnOneListener oneListener = new OnOneListener() {
            @Override
            public void onOne(String message) {
                System.out.println("One: " + message);
            }
        };

        OnOneListener oneListener2 = (String message)-> {
            System.out.println("One Lambda :) " + message);
        };

        oneListener.onOne("Without Lambda :(");
        oneListener2.onOne("With Lambda :)");

        OnOneListener oneListener3 = message -> System.out.println("Your message: " + message);
    }
}
