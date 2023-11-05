package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String output = askInput();
        boolean fileExists = fileCheck(output);
        if (fileExists) {
            File file = makeFileObject(output);
            //printFile(file);
            ArrayList<String> fileArray = storeFile(file);
            int maxLength = findLongestStringInt(fileArray);

            //printArray(fileArray);
            //printArrayWithSpacing(fileArray, maxLength);
            printReverseArray(fileArray, maxLength);
            //System.out.println(findLongestString(fileArray));



        }

    }

    public static void loopTest() {
        for(int i = 0; i<5;i++) {
            System.out.print("|");
            for(int j = 4; j-i>0;j--) {
                System.out.print(" ");
            }

            for(int k = 0; k<=i;k++) {
                System.out.print("+");
            }

            for(int l = 0; l<=i;l++) {
                System.out.print("*");
            }
            for(int m = 4; m-i>0;m--) {
                System.out.print(" ");
            }

            System.out.println("|");
        }
    }

    public static void printCow() {

        System.out.println("            ^__^");
        System.out.println("    _______/(oo)");
        System.out.println("/\\/(       /(__)");
        System.out.println("   | w----||    ");
        System.out.println("   ||     ||    ");
    }

    public static String askInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path: ");
        String output = scanner.nextLine();
        return output;
    }

    public static boolean fileCheck(String pathInput) {
        boolean fileCheck = false;
        File file = new File((pathInput));

        if (file.exists()) {
            //System.out.println(file.toString());
            fileCheck = true;
            return fileCheck;
        }
        else {
            System.out.println("File not found!");
            return fileCheck;
        }


    }

    public static File makeFileObject(String pathInput) {
        File file = new File(pathInput);
        return file;
    }

    public static void printFile(File file) {
        try {
            Scanner fileReader = new Scanner(new FileReader(file));
            while (fileReader.hasNext()) {
                System.out.println(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.print("File not found!");
        }
    }

    public static ArrayList<String> storeFile(File file) {
        ArrayList<String> stringArray = new ArrayList<>();

        try {
            Scanner fileReader = new Scanner(new FileReader(file));
            while (fileReader.hasNext() ) {
                stringArray.add(fileReader.nextLine());
            }
        } catch (FileNotFoundException e ) {
            System.out.println("File not found!");
        }

        return stringArray;
    }

    public static void printArray(ArrayList<String> arrayList) {
        for (String x : arrayList) {
            System.out.print(x);
            System.out.print("|");
            System.out.println(x);

        }
    }

    public static void printReverseArray(ArrayList<String> arrayList, int maxLength ) {
        for (String x : arrayList) {
            StringBuilder stringBuilder = new StringBuilder(x);
            //int difference = maxLength - x.length();
            while (stringBuilder.length()<maxLength) {
                stringBuilder.append(" ");
            }
            System.out.print(stringBuilder);
            System.out.print(" | ");
            for(int i = stringBuilder.length()-1;i>=0;i--) {
                if(stringBuilder.substring(i,i+1).equals("/")) {
                    System.out.print("\\");
                }
                else if(stringBuilder.substring(i,i+1).equals("\\")) {
                    System.out.print("/");
                }
                else if(stringBuilder.substring(i,i+1).equals("(")) {
                    System.out.print(")");
                }
                else if(stringBuilder.substring(i,i+1).equals(")")) {
                    System.out.print("(");
                }
                else if(stringBuilder.substring(i,i+1).equals("[")) {
                    System.out.print("]");
                }
                else if(stringBuilder.substring(i,i+1).equals("]")) {
                    System.out.print("[");
                }
                else if(stringBuilder.substring(i,i+1).equals(">")) {
                    System.out.print("<");
                }
                else if(stringBuilder.substring(i,i+1).equals("<")) {
                    System.out.print(">");
                }
                else {
                    System.out.print(stringBuilder.charAt(i));
                }
            }
            System.out.println();
        }
    }

    public static void printArrayWithSpacing(ArrayList<String> arrayList, int maxLength) {
        //System.out.print("Max length " + maxLength);
        int spaceCount =0;
        for (String x : arrayList) {
            System.out.print(x);
            int difference = maxLength - x.length();
            //System.out.print("Difference " + difference);
            if (difference > 0 ) {
                for(int i = 0; i <difference; i++ ) {
                    System.out.print(" ");
                    spaceCount++;
                }
            }
            System.out.print(" | ");
            System.out.print(x);
            for(int i = 0; i<spaceCount; i++ ) {
                System.out.print(" ");
            }
            System.out.println("");
            spaceCount =0;

        }
    }

    public static String findLongestString(ArrayList<String> arrayList) {
        int max = -1;
        String longestString = "";

        for (String x : arrayList) {
            if (x.length() > max ) {
                max = x.length();
                longestString = x;
            }
        }
        System.out.println(longestString.length());
        return longestString;
    }
    public static int findLongestStringInt(ArrayList<String> arrayList) {
        int max = -1;
        //String longestString = "";

        for (String x : arrayList) {
            if (x.length() > max ) {
                max = x.length();
         //       longestString = x;
            }
        }
        return max;
    }

}