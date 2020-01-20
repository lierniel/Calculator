public class RomanNum extends Number{

    private final static int MAX_AMOUNT = 3;

    private String romanString;
    private int num;

    public RomanNum(String romanString, RuntimeException e){
        this.romanString = romanString;
        this.num = 0;
        for (int i = romanString.length() - 1; i >= 0; i--){
            if (romanString.charAt(i) == 'I'){
                this.num++;
            } else if (romanString.charAt(i) == 'V'){
                if (i != 0 && romanString.charAt(i-1) == 'I') {
                    this.num += 3;
                } else this.num +=5;
            } else if (romanString.charAt(i) == 'X'){
                if (i != 0 && romanString.charAt(i-1) == 'I') {
                    this.num += 8;
                } else this.num +=10;
            } else throw e;
        }
        if (this.num > 10 || this.num < 0) throw new RuntimeException("Number " + romanString + " isn't in the range");
    }

    public RomanNum(int num){
        this.num = num;
        this.romanString = "";
        int currentNum = 0;

        if (num < 0){
            this.romanString += "-";
        }

        for (int i = MAX_AMOUNT - 1; i >= 0; i--){
            currentNum = num /(int)Math.pow(10,i) % 10;
            if (currentNum > 0){
                if (i == 2) {
                    this.romanString += "C";
                    continue;
                }
                if (i == 1) {
                    if (currentNum <=3){
                        for (int j = 0; j < currentNum; j++){
                            romanString += "X";
                        }
                    } else if(currentNum <= 8){
                        for (int j = 0; j < (5 - currentNum); j++){
                            romanString += "X";
                        }
                        romanString += "L";
                        for (int j = 0; j < (currentNum -5); j++){
                            romanString += "X";
                        }
                    } else {
                        romanString += "XC";
                    }
                    continue;
                }

                if (currentNum <=3){
                    for (int j = 0; j < currentNum; j++){
                        romanString += "I";
                    }
                } else if(currentNum <= 8){
                    for (int j = 0; j < (5 - currentNum); j++){
                        romanString += "I";
                    }
                    romanString += "V";
                    for (int j = 0; j < (currentNum -5); j++){
                        romanString += "I";
                    }
                } else {
                    romanString += "IX";
                }

            }
        }
    }

    @Override
    public int intValue() {
        return num;
    }

    @Override
    public long longValue() {
        return num;
    }

    @Override
    public float floatValue() {
        return num;
    }

    @Override
    public double doubleValue() {
        return num;
    }

    @Override
    public String toString(){
        return romanString;
    }
}
