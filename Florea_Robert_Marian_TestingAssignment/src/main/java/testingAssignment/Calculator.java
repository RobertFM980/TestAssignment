package testingAssignment;

public class Calculator {
    public String expression;
    public int result;
    public Scale scale;
    public String[] separator;

    public Calculator(String expression) {
        this.expression = expression;
        this.result = 0;
        this.scale = Scale.km;
        this.separator=expression.split(" ");

    }

    int calculateExpression(){
        int start = 0;
        if (separator[0].equals("-")) {
            result = - Integer.parseInt(separator[1]);
            start = 3;
            scale=Scale.valueOf(separator[2]);
        } else {
            result =  Integer.parseInt(separator[0]);
            start = 2;
            scale = Scale.valueOf(separator[1]);
        }
        int i=start;
        while(i <= separator.length-3)
        {
            if(Scale.valueOf(separator[i+2]).getNumber() < scale.getNumber()){
                if(separator[i].equals("+")){
                    result += Integer.parseInt(separator[i+1])*scale.getNumber()/Scale.valueOf(separator[i+2]).getNumber();
                }
                else if(separator[i].equals("-")){
                    result -= Integer.parseInt(separator[i+1])*scale.getNumber()/Scale.valueOf(separator[i+2]).getNumber();
                }
            } else if (Scale.valueOf(separator[i+2]).getNumber() > scale.getNumber()) {
                if(separator[i].equals("+")){
                    result = result*Scale.valueOf(separator[i+2]).getNumber()/scale.getNumber()+Integer.parseInt(separator[i+1]);
                }
                else if(separator[i].equals("-")){
                    result= result*Scale.valueOf(separator[i+2]).getNumber()/scale.getNumber()-Integer.parseInt(separator[i+1]);
                }
                scale=Scale.valueOf(separator[i+2]);

            } else if (Scale.valueOf(separator[i+2]).getNumber() == scale.getNumber()) {
                if(separator[i].equals("+")){
                    result += Integer.parseInt(separator[i+1]);
                }
                else if(separator[i].equals("-")){
                    result -= Integer.parseInt(separator[i+1]);
                }

            }
            i=i+3;
        }
        return result;
    }
}
