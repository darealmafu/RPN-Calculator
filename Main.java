package zone.mafu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] tempargs) {

        ArrayList<String> args = new ArrayList<>(); //easier to work with em in an arraylist... at least I think so

        Scanner sc = new Scanner(System.in);
        String answer = "";
        while(!answer.equals("y") && !answer.equals("n")) {
            System.out.println("Show work? y/n");
            answer = sc.next();
        }

        for(int i = 0; i < tempargs.length; i++){
            args.add(tempargs[i]);
        }
        if(answer.equals("y"))
            System.out.println(args);

        int placeHolder = 0;
	    int sum = 0;

	    while(args.size() > 2) {

	        while (!isOperand(args.get(placeHolder))) {
                placeHolder++;
            }

            switch (args.get(placeHolder)) {
                case "+":
                    sum += Integer.parseInt(args.get(placeHolder - 2)) + Integer.parseInt(args.get(placeHolder - 1));
                    break;
                case "-":
                    sum += Integer.parseInt(args.get(placeHolder - 2)) - Integer.parseInt(args.get(placeHolder - 1));
                    break;
                case "*":
                    sum += Integer.parseInt(args.get(placeHolder - 2)) * Integer.parseInt(args.get(placeHolder - 1));
                    break;
                case "/":
                    sum += Integer.parseInt(args.get(placeHolder - 2)) / Integer.parseInt(args.get(placeHolder - 1));
                    break;
            }
            args.remove(placeHolder - 2);
            args.remove(placeHolder - 2);
            args.remove(placeHolder - 2);
            args.add(placeHolder - 2, Integer.toString(sum));

            if(answer.equals("y")){
                System.out.println(sum);
                System.out.println(args);
            }

            placeHolder = 0; //resetting placeholder
            sum = 0; //resetting sum
        }

        System.out.println("Answer: " + args.get(0));
    }

    public static boolean isOperand(String s){
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
}
