import java.util.*;

public class JavaBasicParser {
    boolean neg = false;
    boolean zero  = false;
    boolean proceed = true;
    int count = 0;
    Stack<String> closeParenthesis = new Stack<String>();

    public void token(ArrayList<String> tokenArray){
        if(count + 1 < tokenArray.size() && !tokenArray.get(count + 1).contains("EQUALS")){
            System.out.println("\n Be sure to include equals with variable declaration");
            proceed = false;
        }

        else if(count + 1 == tokenArray.size()){
            System.out.println("\n Improper variable declaration");
            proceed = false;
        }

        else {
            proceed = true;
            count++;
        }
    }

    public void syntaxMap(ArrayList<String> syntaxArray){
        for(int i = 0; i < syntaxArray.size(); i++){
            if(syntaxArray.get(i).contains("VARIABLE")){
                token(syntaxArray);
                if(!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("EQUALS")){
                token(syntaxArray);
                if(!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("DIVIDE")){
                token(syntaxArray);
                if(!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("MULTIPLY")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("PLUS")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("DIVIDE")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("MINUS")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("INTEGER")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("RIGHT_PARENTHESIS")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("LEFT_PARENTHESIS")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("ZERO")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }
            else if(syntaxArray.get(i).contains("NEW LINE")) {
                token(syntaxArray);
                if (!proceed)
                    break;
            }

            else
            {
                System.out.println("token not recognized!");
                break;
            }
            if(i + 1 == syntaxArray.size() && proceed == true && closeParenthesis.isEmpty())
                System.out.println("Correct syntax");

            else
                System.out.println("Closed parenthesis is missing.");
        }
    }
}
