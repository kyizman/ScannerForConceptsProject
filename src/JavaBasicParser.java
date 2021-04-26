import java.util.*;

public class JavaBasicParser {
    //variables to be used by whole parser
    boolean neg = false;
    boolean zero  = false;
    boolean proceed = true;
    int count = 0;
    Stack<String> closeParenthesis = new Stack<String>();

    public void token(ArrayList<String> tokenArray){

        if( !tokenArray.contains("Operator =")){
            System.out.println("\n Be sure to include equals with variable declaration");
            proceed = false;
        }

       else  if(count + 1 == tokenArray.size()){
            System.out.println("\n Improper variable declaration");
            proceed = false;
        }

        else {
            proceed = true;
            count++;
        }
    }
    //similar to the hashmap, adds commands to syntax map to check against later methods
    public void syntaxMap(ArrayList<String> syntaxArray){
        for(int i = 0; i < syntaxArray.size(); i++){
            if(syntaxArray.get(i).contains("VARIABLE")){
                token(syntaxArray);
                if(!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("=")){
                token(syntaxArray);
                operatorToken(syntaxArray,i);
                if(!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("Operator /")){
                token(syntaxArray);
                operatorToken(syntaxArray,i);
                if(!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("Operator *")) {
                token(syntaxArray);
                operatorToken(syntaxArray,i);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("Operator +")) {
                token(syntaxArray);
                operatorToken(syntaxArray,i);

                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("Operator /")) {
                token(syntaxArray);
                operatorToken(syntaxArray,i);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("Operator -")) {
                token(syntaxArray);
                operatorToken(syntaxArray,i);
                minusToken(syntaxArray,i);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("INTEGER")) {
                token(syntaxArray);

                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("Operator )")) {
                token(syntaxArray);
                rightParenthesisToken(syntaxArray);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("Operator (")) {
                token(syntaxArray);
                leftParenthesisToken(syntaxArray,i);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("0")) {
                token(syntaxArray);
                zeroToken(syntaxArray);
                operatorToken(syntaxArray,i);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("NEW LINE")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }
        }
    }
    //All methods below read through the file and makes sure to apply the proper tokens to each situation
    public void equalToken(ArrayList<String> equalTokenArray){
        if(count + 1 < equalTokenArray.size() &&! equalTokenArray.get(count + 1).contains("-")&&
        !equalTokenArray.get(count + 1).contains("INTEGER")&&
                !equalTokenArray.get(count + 1).contains("LEFT_PARENTHESIS")&&
                !equalTokenArray.get(count + 1).contains("ZERO")){
            System.out.println("Integer variables must have a minus, int, or left parenthesis when declared.");
            proceed = false;
        }
        else if(count + 1 == equalTokenArray.size()){
            System.out.println("Ending declarations with equals is improper.");
            proceed = false;
        }
        else {
            if(count + 1 < equalTokenArray.size() && equalTokenArray.get(count + 1).contains("0")){
                zero = true;
            }
            else if(count + 1 < equalTokenArray.size() && equalTokenArray.get(count + 1).contains("-")){
                neg = true;
                proceed = true;
                count++;
            }
        }
    }

    public void minusToken(ArrayList<String> minusTokenArray,int i){
        if(count + 1 < minusTokenArray.size() && !minusTokenArray.get(count + 1).contains("Integer")
            && !minusTokenArray.get(i+ 1).contains("-")&&
                !minusTokenArray.get(i + 1).contains("0")&&
                !minusTokenArray.get(i + 1).contains("(")){
            System.out.println("\n Be sure to have a minus, int, or left parenthesis following");
            proceed = false;
        }
        else if (count + 1 == minusTokenArray.size()){
            System.out.println("\n Improper declaration");
            proceed = false;
        }
        else
        {
            if(count + 1 < minusTokenArray.size()&& neg == true &&
                    minusTokenArray.get(count + 1).contains("ZERO"))
            {
                System.out.println("\n Neg zero is not a number");
                proceed = false;
            }

            else
            {
                proceed = true;
                count++;
            }
        }
    }
    public void operatorToken(ArrayList<String> operatorTokenArray ,int i)
    {
        if(i + 1 < operatorTokenArray.size()&&!operatorTokenArray.get(i + 1).contains("Integer") &&
                !operatorTokenArray.get(i + 1).contains("-") &&
                !operatorTokenArray.get(i + 1).contains("(")&&
                !operatorTokenArray.get(i + 1).contains("0"))
        {
            System.out.println("\nAn operator can only be followed by an "
                    + "integer, a minus sign, or a left parenthesis...");
            proceed = false;
        }

        else if(count + 1 == operatorTokenArray.size())
        {
            System.out.println("\n Cannot end declaration with operators");
            proceed = false;
        }

        else
        {
            if(i + 1 < operatorTokenArray.size()&&operatorTokenArray.get(i).contains("/") &&
                    operatorTokenArray.get(i + 1).contains("0"))
            {
                System.out.println("\n You can't divide by zero");
                proceed = false;
            }
            else
            {
                proceed = true;
                count++;
            }
        }
    }
    public void leftParenthesisToken(ArrayList<String> leftParenthesisTokenArray,int x)
    {
        if(x + 1 < leftParenthesisTokenArray.size()&&!leftParenthesisTokenArray.get(x + 1).contains("Integer") &&
                !leftParenthesisTokenArray.get(x + 1).contains("0")&&
                !leftParenthesisTokenArray.get(x + 1).contains("-")&&
                !leftParenthesisTokenArray.get(x + 1).contains("("))
        {
            System.out.println("\n You can only have a minus or int after left parenthesis");
            proceed = false;
        }

        else if(x + 1 == leftParenthesisTokenArray.size())
        {
            System.out.println("\n You can't end declarations with left parenthesis");
            proceed = false;
        }

        else
        {
            closeParenthesis.add("LEFT");
            proceed = true;
            count++;
        }
    }
    public void rightParenthesisToken(ArrayList<String> rightParenthesisTokenArray)
    {
        if(count + 1 < rightParenthesisTokenArray.size()&&!rightParenthesisTokenArray.get(count + 1).contains("+") &&
                !rightParenthesisTokenArray.get(count + 1).contains("-") &&
                !rightParenthesisTokenArray.get(count + 1).contains("/") &&
                !rightParenthesisTokenArray.get(count + 1).contains("*")&&
                !rightParenthesisTokenArray.get(count + 1).contains(")")&&
                !rightParenthesisTokenArray.get(count + 1).contains("NEW LINE"))
        {
            System.out.println("\n Right parenthesis are normally added past any operators");
            proceed = false;
        }

        else
        {
            if(closeParenthesis.isEmpty())
            {
                System.out.println("\n You can't have a close parenthesis without an open one.");
                proceed = false;
            }

            else
            {
                closeParenthesis.pop();
                proceed = true;
                count++;
            }
        }
    }

    public void integerToken(ArrayList<String> integerTokenArray)
    {
        if(count + 1 < integerTokenArray.size()&&!integerTokenArray.get(count + 1).contains("MINUS")&&
                !integerTokenArray.get(count + 1).contains("PLUS")&&
                !integerTokenArray.get(count + 1).contains("MULTIPLY")&&
                !integerTokenArray.get(count + 1).contains("DIVIDE")&&
                !integerTokenArray.get(count + 1).contains("LEFT_PARENTHESIS")&&
                !integerTokenArray.get(count + 1).contains("RIGHT_PARENTHESIS")&&
                !integerTokenArray.get(count + 1).contains("NEW LINE")&&
                !integerTokenArray.get(count + 1).contains("ZERO"))
        {
            System.out.println("\n Integers can have operators, other ints, parenthesises, or newlines");
            proceed = false;
        }

        else
        {
            proceed = true;
            count++;
        }
    }

    public void zeroToken(ArrayList<String> zeroTokenArray)
    {
        if(count + 1 < zeroTokenArray.size()&&!zeroTokenArray.get(count + 1).contains("INTEGER")&&
                !zeroTokenArray.get(count + 1).contains("RIGHT_PARENTHESIS")&&
                !zeroTokenArray.get(count + 1).contains("PLUS")&&
                !zeroTokenArray.get(count + 1).contains("MINUS")&&
                !zeroTokenArray.get(count + 1).contains("MULTIPLY")&&
                !zeroTokenArray.get(count + 1).contains("DIVIDE")&&
                !zeroTokenArray.get(count + 1).contains("NEW LINE"))
        {
            System.out.println("\n Zeroes can have ints, operators, right parenthesis, and tokens following");
            proceed = false;
        }

        else
        {
            if(zero == true && count + 1 < zeroTokenArray.size()&&
                    zeroTokenArray.get(count + 1).contains("INTEGER"))
            {
                System.out.println("\n Ints cannot have leading zeroes.");
                proceed = false;
            }

            else
            {
                proceed = true;
                count++;
            }
        }
    }

    public void newLineToken(ArrayList<String> newLineTokenArray)
    {
        if(count + 1 < newLineTokenArray.size()&&!newLineTokenArray.get(count + 1).contains("VARIABLE"))
        {
            System.out.println("\n Variables must have new lines after");
            proceed = false;
        }

        else if(count + 1 == newLineTokenArray.size())
        {
            System.out.println("\n Ending variable declarations with new lines is improper.");
            proceed = false;
        }

        else
        {
            zero = false;
            proceed = true;
            neg = false;
            count++;
        }
    }
}
