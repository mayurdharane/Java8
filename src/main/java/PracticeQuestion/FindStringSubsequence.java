package PracticeQuestion;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

public class FindStringSubsequence {

    /**
     * Sample input : coronavirus 4 abcde crnas onarous ooaius
     * @param args
     */

    public static void main (String [] args){

        Scanner in = new Scanner(System.in);
        String mainString = in.next();
        String sub1 = "";

//        Integer num = Integer.valueOf(noOfSubString);
        int length = Integer.valueOf(in.next());
        for (int argNum = 0; argNum < length; argNum++) {

            sub1 = in.next();//args[argNum];
            int foundSubStringlegth = sub1.length();

            char[] array = mainString.toCharArray();
            char[] subArray = sub1.toCharArray();

//            int iStart = 0;
            int jStart = 0;

            for (int i = 0; i < subArray.length; i++) {
                char c = subArray[i];

                if(foundSubStringlegth == 0) break;

                for (int j = jStart; j < array.length; j++) {

                    if (c == array[j]) {
//                        found[i] = c;
                        jStart = ++j;
                        foundSubStringlegth--;
//                        System.out.println(" found :" + Arrays.toString(found));
                        break;
                    }

                }
            }
            if(foundSubStringlegth == 0){
                System.out.println("POSITIVE");

            }else{
                System.out.println("NEGATIVE");
            }


        }

        // Commit 1

        // commit 2

        //commit 3

        //commit 4

        // commit 5 on test branch




    }
}
