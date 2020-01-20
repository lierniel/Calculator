public class OperationFactory {
    public static Operation getOperation(String operation){
        switch (operation){
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "/":
                return new Division();
            case "*":
                return new Multiply();
            default:
                throw new RuntimeException("Unidentified symbol: " + operation);
        }
    }
}
