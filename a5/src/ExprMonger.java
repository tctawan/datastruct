import java.lang.reflect.Array;
import java.util.*;

public class ExprMonger {

    //Subtask 1
    public static double evalFullyParenthesized(List<String> tokens){
        Stack<String> op = new Stack();
        Stack<Double> num = new Stack();
        for(String str : tokens){
            if(str.equals(")")){
                String operator = op.pop();
                Double b = num.pop();
                Double a = num.pop();
                num.push(eval(operator,a,b));

            }
            else if(str.equals("(")){ }
            else if(str.equals("+")){ op.push(str); }
            else if(str.equals("-")){ op.push(str);}
            else if(str.equals("*")){ op.push(str);}
            else if(str.equals("**")){ op.push(str);}
            else if(str.equals("/")){ op.push(str);}
            else{ num.push(Double.parseDouble(str)); }

        }
        return num.pop();
    }

    public static double eval(String op, Double a , Double b){
        if(op.equals("+")){return a + b;}
        else if(op.equals("-")){return a-b ;}
        else if(op.equals("*")){return a*b; }
        else if(op.equals("/")){return a/b ;}
        else{
            double temp = a;
            while( b > 1){
                temp *= a;
                b--;
            }
            return temp;
        }

    }


    //Subtask 2
    public static List<String> augmentExpr(List<String> tokens){

        int[] index = {0};
        String ans = augmentExprHelper(tokens,index);

        List<String> ls = Utils.tokenize(ans);
        return ls;
    }

    public static String augmentExprHelper(List<String> tokens, int[] index ){

        Stack<String> fpe = new Stack<>();
        Stack<String> ops = new Stack<>();
        String opChecker ;
        int i = index[0];

        while(i<tokens.size()){
            String t = tokens.get(i);

            if(t.equals(")")){
                break;
            }

            String top ;


            if(t.equals("+")){
                opChecker = "+-*/^";

                while(!ops.isEmpty()) {
                    top = ops.peek();
                    if(opChecker.contains(top)) {
                        concaternateExp(fpe, ops);
                    }else{
                        break;
                    }
                }
                ops.push("+");

            }else if(t.equals("-")){
                opChecker = "+-*/^";

                while(!ops.isEmpty()) {
                    top = ops.peek();
                    if(opChecker.contains(top)) {
                        concaternateExp(fpe, ops);
                    }else{
                        break;
                    }
                }
                ops.push("-");

            }else if (t.equals("*")){
                opChecker = "*/^";

                while(!ops.isEmpty()) {
                    top = ops.peek();
                    if(opChecker.contains(top)) {
                        concaternateExp(fpe, ops);
                    }else{
                        break;
                    }
                }
                ops.push("*");

            }else if(t.equals("/")){
                opChecker = "*/^";

                while(!ops.isEmpty()) {
                    top = ops.peek();
                    if(opChecker.contains(top)) {
                        concaternateExp(fpe, ops);
                    }else{
                        break;
                    }
                }
                ops.push("/");

            }else if(t.equals("**")){
                opChecker = "^";

                while(!ops.isEmpty()) {
                    top = ops.peek();
                    if(opChecker.contains(top)) {
                        concaternateExp(fpe, ops);
                    }else{
                        break;
                    }
                }

                ops.push("^");

            }else if(t.equals("(")){
                index[0] = i+1;
                fpe.push(augmentExprHelper(tokens,index));

            } else {
                fpe.push(t);
            }

            i = index[0];
            i++;
            index[0] = i;
        }


        while(!ops.isEmpty()){
            concaternateExp(fpe,ops);
        }

        return fpe.pop();

    }

    public static void concaternateExp(Stack<String> fpe, Stack<String> ops){
        String b = fpe.pop();
        String a = fpe.pop();
        String op = ops.pop();
        if(op.equals("^")){
            op = "**";
        }
        String concat = "("+a+op+b+")";
        fpe.push(concat);
    }


    //Subtask 3
    public static double evalExpr(List<String> tokens){
        List<String> fpe = augmentExpr(tokens);
        System.out.println(fpe);
        return evalFullyParenthesized(fpe);

    }

    public static void main(String[] args) {
        List a = Utils.tokenize("6/(2/1))");
        System.out.println(a);
        System.out.println(evalExpr(a));
    }
}















