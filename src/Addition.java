public class Addition implements Operation {
    @Override
    public Number execute(Number num1, Number num2) {
        if (num1 instanceof RomanNum) {
            return new RomanNum(num1.intValue() + num2.intValue());
        } else return num1.intValue() + num2.intValue();
    }
}
