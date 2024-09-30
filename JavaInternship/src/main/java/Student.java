import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter Student name");
        String name=sc.nextLine();

        System.out.println("Enter Student age");
        int age=sc.nextInt();

        System.out.println("Your Name is "+name+ " Your Age is "+age);
    }
}
