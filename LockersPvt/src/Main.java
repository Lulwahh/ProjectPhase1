import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developer Lulwah M E AlDyouly");
        System.out.println("");

        System.out.println("------ Main Menu ------");
        System.out.println("Please choose one of the options");
        System.out.println("1. Show Files");
        System.out.println("2. Show File Options Menu");
        System.out.println("3. Quit");

        int option = input.nextInt();
        while (option!=3){
            switch(option) {
                case 1:

                case 2:

                case 3:


            }
        }

    }
}

class files {
    File directory = new File("/Users/lulwahaldyouly/Desktop/project/ProjectPhase1/LockersPvt");
    String[] flist = directory.list();

    public void addFile(String fileName){
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void deleteFile(String fileName){
        try {
            File f= new File(fileName);
            if(f.delete()){
                System.out.println(f.getName() + " File Deleted");
            }
            else {
                System.out.println("Sorry the operation failed");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void searchFile(String fileName){
        Set<String> sets = new TreeSet<String>();
        int flag = 0;

        if (flist == null) {
            System.out.println("Empty Directory.");
        } else {
            for (int i = 0; i < flist.length; i++) {
                String filename = flist[i];
                if (filename.equalsIgnoreCase(fileName)) {
                    System.out.println(filename + " File Found");
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            System.out.println("File Not Found");
        }

        Iterator<String> iterate = sets.iterator();
        System.out.println("Ascending Order ");
        while (iterate.hasNext()) {
            System.out.println(iterate.next());
        }
    }

    public void printAllFiles(){
        Set<String> sets = new TreeSet<String>();
        int flag = 0;
        if (flist == null) {
            System.out.println("Empty directory.");
        } else {

            for (int i = 0; i < flist.length; i++) {
                String filename = flist[i];
                sets.add(filename);
                flag = 1;
            }
        }
        Iterator<String> iterate = sets.iterator();
        while (iterate.hasNext()) {
            System.out.println(iterate.next());
        }
    }

    }


