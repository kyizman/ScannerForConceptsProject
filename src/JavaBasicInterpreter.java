import java.util.ArrayList;

public class JavaBasicInterpreter {


    public void OutputForProject(ArrayList<String> tokenArray) {
        int count = 0;
        String Convert = "";
        String temp;
        int length = 0;
        for (int x = 0; x < tokenArray.size(); x++) {
            if (tokenArray.get(x).contains("Letter")) {
                length = tokenArray.get(x).length();
                temp = tokenArray.get(x);

                Convert = Convert.concat(temp.substring(length - 2));
                Convert = Convert.replace("\n", "");
            } else if (tokenArray.get(x).contains("Operator")) {
                String op = tokenArray.get(x);

                if (op.contains("Operator +")) {
                    int first = ConvertInt(tokenArray.get(x - 1));;
                    int second = ConvertInt(tokenArray.get(x + 1));;

                    if (Convert.contains("PRINT")) {
                        System.out.println(first + second);
                    }
                } else if (op.contains( "Operator -")) {

                    int first =  ConvertInt(tokenArray.get(x - 1));
                    int second = ConvertInt(tokenArray.get(x + 1));;

                    if (Convert.contains("PRINT")) {
                        System.out.println(first - second);
                    }
                } else if (op.contains("Operator /")) {

                    int first =  ConvertInt(tokenArray.get(x - 1));
                    int second = ConvertInt(tokenArray.get(x + 1));;

                    if (Convert.contains("PRINT")) {
                        System.out.println(first / second);
                    }
                } else if (op.contains("Operator *")) {

                    int first =  ConvertInt(tokenArray.get(x - 1));
                    int second = ConvertInt(tokenArray.get(x + 1));;

                    if (Convert.contains("PRINT")) {
                        System.out.println(first * second);
                    }
                }

            }
        }

        System.out.println(Convert);
    }

    public int ConvertInt(String y) {
        String Convert2 = "";







                 Convert2 = y.replace("Integer","");

            Convert2 = Convert2.replace("\n", "");

            return Integer.parseInt(Convert2.trim());

    }
}


