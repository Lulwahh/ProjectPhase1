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

        files allFiles = new files();
        Scanner input = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developer Lulwah M E AlDyouly");
        System.out.println("");

        System.out.println("------ Main Menu ------");
        System.out.println("Please choose one of the options");
        System.out.println("1. Show Files");
        System.out.println("2. Show File Options Menu");
        System.out.println("3. Quit");

        int option = input.nextInt();
        while (option !=3 ){
            switch(option) {
                case 1:
                    System.out.println("---- All LockedMe.com files ----");
                    allFiles.printAllFiles();
                    break;

                case 2:
                    System.out.println("------ File Menu ------");
                    System.out.println("Please choose one of the options");
                    System.out.println(" 1. Add file ");
                    System.out.println(" 2. Delete file ");
                    System.out.println(" 3. Search file");
                    System.out.println(" 4. Back to Main Menu");
                    int option1 = input.nextInt();
                    switch (option1){
                        case 1:
                            System.out.println("---- Add a File ----");
                            System.out.println("Please Enter File Name to Create:");
                            String fileAdd = input.next();
                            allFiles.addFile(fileAdd);
                            break;
                        case 2:
                            System.out.println("---- Delete a File ----");
                            System.out.println("Please Enter File Name to Delete:");
                            String fileDelete = input.next();
                            allFiles.addFile(fileDelete);
                            break;
                        case 3:
                            System.out.println("---- Search a File ----");
                            System.out.println("Please Enter File Name to Search:");
                            String fileSearch = input.next();
                            allFiles.searchFile(fileSearch);
                            break;
                        case 4:
                            Main.main(null);
                            break;
                        default:
                            System.out.println("Invalid Menu Choice! Please Try Again.");
                            break;

                    }
                    break;

                case 3:
                    System.out.println("Program Ended");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Menu Choice! Please Try Again.");
                    break;
            }
            System.out.println("------ Main Menu ------");
            System.out.println("Please choose one of the options");
            System.out.println("1. Show Files");
            System.out.println("2. Show File Options Menu");
            System.out.println("3. Quit");

            option = input.nextInt();
        }

    }
}

class files {
    File directory = new File("/Users/lulwahaldyouly/Desktop/project/ProjectPhase1/LockersPvt/allFiles");
    String[] flist = directory.list();

    public void addFile(String fileName){
        try {
            //Change file path
            File myObj = new File("/Users/lulwahaldyouly/Desktop/project/ProjectPhase1/LockersPvt/allFiles/ProjectPhase1/LockersPvt/allFiles/"+fileName);
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


