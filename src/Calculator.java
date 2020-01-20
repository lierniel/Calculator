import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String[] exp = scanner.nextLine().split(" ");

            Number num1;
            Number num2;

            try {
                num1 = Integer.valueOf(exp[0]);
                num2 = Integer.valueOf(exp[2]);
                if (Math.max(num1.intValue(),num2.intValue()) > 10 || Math.min(num1.intValue(),num2.intValue()) < 0){
                    throw new RuntimeException("Numbers isn't in the range");
                }
            }catch (NumberFormatException e){
                num1 = new RomanNum(exp[0], e);
                num2 = new RomanNum(exp[2], e);
            }

            Operation operation = OperationFactory.getOperation(exp[1]);

            System.out.println(operation.execute(num1, num2).toString());
        }

    }
}
