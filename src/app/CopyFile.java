package app;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the source file: ");
        String sourceFile = scanner.nextLine();

        System.out.print("Enter the target file copy: ");
        String sourceTarget = scanner.nextLine();

        try {
            File file                  = new File(sourceFile);
            BufferedInputStream bindIn = new BufferedInputStream(new FileInputStream(file));
            System.out.println(file.length() + "byte");

            File fileTarget              = new File(sourceTarget);
            BufferedOutputStream bindOut = new BufferedOutputStream(new FileOutputStream(fileTarget));

            while (true) {
                int data = bindIn.read();
                if (data == -1) {
                    break;
                }
                bindOut.write(data);
            }
            bindOut.flush();
        }catch (IOException e){
            System.out.println("File source not found.");
        }
    }
}
