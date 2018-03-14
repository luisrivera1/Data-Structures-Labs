package AnatoliyAssignment;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {

    public static void main(String[] args) {

        int command;
        int command1;
        int command2;
     

        ArrayList<Integer> s1 = new ArrayList<>();

        Scanner in = new Scanner(System.in);




        System.out.println("Select number of commands:");
        command = in.nextInt();
        while(command > 0 ){

        System.out.println("1 X put X at the end of ArrayList\n2 Y to remove all Y elements\n3 Print ArrayList Size");
        command1 = in.nextInt();
        command2 = in.nextInt();

    

            if (command1 == 1) {
                s1.add(command2);
                System.out.println(s1.toString());
                command--;

                if(command1 == 2){
                    ArrayList1.removeNumber(command2, s1);
                    System.out.println(s1.toString());
                    command--;
                }

                if(command1 == 3){
                    System.out.println(s1.size());
                    System.out.println(s1.toString());
                    command--;
                }

            }

        }
    }
}