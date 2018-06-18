package FileReaderWriter;

import java.io.*;
import java.util.Scanner;


//Run the main of this class see part1 of E2E task
public class FileReaderWriter {

    /*
    * The below methods are part of task1
    * */

    String stripExtention(String filename){
        if(filename == null) return null;
        int position = filename.lastIndexOf(".");
        if (position == -1) return filename;
        return filename.substring(0, position);
    }

    String getExtention(String filename){
        if(filename == null) return null;
        int position = filename.lastIndexOf(".");
        if(position == -1) return "type file";
        return filename.substring(position);
    }

    public void listFiles(String directoryPath){
        File directory = new File(directoryPath);
        File[] fileList = directory.listFiles();
        String[] acceptedTypes = {".cvs", ".xlsx", ".xls", ".docx"};

        for (File file : fileList){
            if(file.isFile()){
                for(int i=0; i < acceptedTypes.length; i++){
                    if(getExtention(file.getName()).contains(acceptedTypes[i])){
                        stripExtention(file.getName());
                        System.out.println("File name: " + stripExtention(file.getName()) + "\n"
                                + "File type: " + getExtention(file.getName()) + "\n"
                                + "File size: " + file.length()+"KB" +
                                "\n" + "File extension: " + file.getName());
                    }
                }
            }
        }
    }

    public static void main(String[] args){

        while(true){
            FileReaderWriter fileReaderWriter = new FileReaderWriter();

            System.out.println("Enter Directory Path Of The Files You Would Like Read: ");

            Scanner sc = new Scanner(System.in);

            String directory = sc.nextLine();

            //This method reads files in a directory an returns each files name, type, size and extension
            fileReaderWriter.listFiles(directory);
        }
    }

}
