package com.javainputoutput;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class CreatingFileAndDirectory {
    public static void createDirectory(){
        File dir = new File("/home/noyon_admin/Personal/Java/Java-advance-programming");
        dir.mkdir();

        String dirPath = dir.getPath();
        System.out.println("Directory path: " + dirPath);

        // lets create a new file
        String fileName = "newFile.txt";
        createFile(dirPath + File.separator + fileName);
    }

    public static void createFile(String directoryName){
        File file = new File(directoryName);
        if(file.exists()){
            System.out.println("File exists");
        }else{
            System.out.println("File does not exist, lets create one");
            try{
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        String filePath = file.getPath();
        System.out.println("File path: " + filePath);
    }

    public static void renameing(String file1, String file2){
        File oldFile = new File(file1);
        File newFile = new File(file2);

        boolean fileRenamed = oldFile.renameTo(newFile);
        if(fileRenamed) {
            System.out.println(oldFile + " rename to " + newFile + ".");
        }else {
            System.out.println("Ranaming " + oldFile + " to " + newFile + " failed.");
        }
    }

    public static void listOfAllFile(){
        File home = new File("/home/noyon_admin/Personal/Java/Java-advance-programming");
        File[] listRoots = home.listFiles();
        for(File file : listRoots){
            System.out.println(file.getPath());
        }
    }

    public static void filteringFile(){
        File home = new File("/home/noyon_admin/Personal/Images/ExabytingTour");

        FileFilter pngFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String fileName = pathname.getName();
                if (fileName.endsWith(".png")) {
                    return true;
                }
                return false;
            }
        };

        File[] pngFiles = home.listFiles(pngFilter);
        for(File file : pngFiles){
            System.out.println(file.getPath());
        }
    }

    public static void main(String[] args){
        createDirectory();
        renameing("hello1.txt", "newHello1.txt");
        listOfAllFile();
        filteringFile();
    }
}
