package PracticeQuestion;

import java.util.Scanner;

public class FinalFindStringSubsequence {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String mainString = in.next();
        String sub1 = "";

        int length = Integer.valueOf(in.next());
        for (int argNum = 0; argNum < length; argNum++) {

            sub1 = in.next();//args[argNum];
            int foundSubStringlegth = sub1.length();

            char[] array = mainString.toCharArray();
            char[] subArray = sub1.toCharArray();
            int jStart = 0;

            for (int i = 0; i < subArray.length; i++) {
                char c = subArray[i];

                if(foundSubStringlegth == 0) break;

                for (int j = jStart; j < array.length; j++) {

                    if (c == array[j]) {
                        jStart = ++j;
                        foundSubStringlegth--;
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
    }
}
