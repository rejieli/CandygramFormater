import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Sort {

    private static String fileName = "File.txt";
    private static PrintWriter writer;

    public static void main(String[] args){
        try {
            writer = new PrintWriter(new File(fileName));
            Scanner scanner = new Scanner(new File("EARL Candygram 2022 form (Responses) - Form Responses 1.tsv"));
            int counter = 0;

            scanner.nextLine();//get rid of title

            while(scanner.hasNext()){
                counter++;
                String s= scanner.nextLine(); //next entry
                String[] info = s.split("\\t");//Split by ,
                System.out.println(Arrays.toString(info));
                System.out.println(counter);
                String sender = (info[3].equals("Yes") ? "Anonymous " : info[1]);
                String printingInfo = "Order ID: " + (counter*100) +
                        "\nHomeroom: " + info[8] +
                        "\nGrade: " + info[7] +
                        "\nHey " + info[4] + ", \n You've received  a candygram from a fellow lion!\n " + info[9] + "\n -" + sender;
                writeToFile(printingInfo);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.close();//close file
    }

    public static void writeToFile(String info) throws FileNotFoundException {
        writer.println(info + "\n-----------------------------------------------"); // write file
    }



}
