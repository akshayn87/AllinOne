package Learning;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileHandling {

    public static void main(String[] args) throws IOException {
        CheckFileExists();
        WriteFile();
        ReadFile();
        ReadFile2();
        DeleteFile();
        ReadFile3();
        ReadingFileUsingInputStream();
        ReadingFileUsingBufferedReader();
        ReadFileUsingNio();
        File file1 = new File("abc.txt");
        File file2 = new File("copyofabc.txt");
        CopyFile(file1, file2);
        PrintFilesandFolders();
        FileWritingUsingScanner();
        ReadWriteExecutables();
    }

    private static void CheckFileExists() throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("Current Method:-" + name);
        File file = new File("abc.txt");
        if (file.exists()) {
            System.out.println("Name of the File :-" + file.getName());
        } else {
            file.createNewFile();
            System.out.println("New File created  :-" + file.getName());
        }
    }

    public static void WriteFile() throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("Current Method:-" + name);
        FileWriter fileWriter = new FileWriter("abc.txt");
        fileWriter.write("This is the first Line\nThis is the second Line");
        fileWriter.close();
    }

    public static String ReadFile() throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("Current Method:-" + name);
        File file = new File("abc.txt");
        Scanner sc = new Scanner(file);
        String line = null;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            System.out.println(line);
        }
        sc.close();
        return line;
    }

    public static String ReadFile2() throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("Current Method:-" + name);
        FileReader fileReader = new FileReader("abc.txt");
        int c = 0;
        while ((c = fileReader.read()) != -1) {
            System.out.print((char) c);
        }
        String line = String.valueOf((char) c);
        return line;
    }

    public static void DeleteFile() throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\nCurrent Method:-" + name);
        File file = new File("abc.txt");
        if (file.delete()) {
            file.delete();
            System.out.println("I have deleted the File :-" + file.getName());
        }
    }

    public static void ReadFile3() throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("Current Method:-" + name);
        String path = System.getProperty("user.dir") + "//abc.txt";
        File file = new File(path);
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }

    }

    public static void ReadingFileUsingInputStream() throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("Current Method:-" + name);
        String path = System.getProperty("user.dir") + "//abc.txt";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        int c = 0;
        while ((c = fis.read()) != -1) {
            System.out.print((char) c);
        }
        fis.close();
    }

    public static void ReadingFileUsingBufferedReader() throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.print("\n");
        System.out.println("Current Method:-" + name);
        String path = System.getProperty("user.dir") + "//abc.txt";
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        int c = 0;
        while ((c = bufferedReader.read()) != -1) {

            System.out.print((char) c);
        }
        bufferedReader.close();

    }

    public static void ReadFileUsingNio() throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.print("\n");
        System.out.println("Current Method:-" + name);
        String path = System.getProperty("user.dir") + "//abc.txt";
        List<String> li = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

        Iterator<String> itr = li.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

    public static void CopyFile(File InputFile, File OutputFile) throws IOException {
        /**
         * get current method name
         */
        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.print("\n");
        System.out.println("Current Method:-" + name);
        String InputPath = System.getProperty("user.dir") + "//abc.txt";
        InputFile = new File(InputPath);
        String OutputPath = System.getProperty("user.dir") + "//CopyOfabc.txt";
        OutputFile = new File(OutputPath);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        fileInputStream = new FileInputStream(InputFile);
        fileOutputStream = new FileOutputStream(OutputFile);

        int c = 0;
        while ((c = fileInputStream.read()) != -1) {
            fileOutputStream.write(c);
        }
        System.out.println(fileOutputStream.getFD());
        System.out.println(fileInputStream.available());
        fileOutputStream.flush();
        fileInputStream.close();
        fileOutputStream.close();

    }

    public static void PrintFilesandFolders() {
        String path = "C:\\Users\\Akshay\\Downloads";
        System.out.println("Folder under Scan :-" + path);
        File file = new File(path);

        File[] dir = file.listFiles();
        Arrays.sort(dir);
        for (File f : dir) {
            if (f.isFile()) {
                System.out.println("File :- " + f.getName());
            } else if (f.isDirectory()) {
                System.out.println("Directory :- " + f.getName());
            } else {
                System.out.println("Something elsse also present");
            }
        }
    }

    public static void FileWritingUsingScanner() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the File name with Location Path");

        String fileName = sc.nextLine();
        FileOutputStream fos = new FileOutputStream(fileName, true);

        System.out.println("Enter the File Contents");
        String content = sc.nextLine();
        byte[] b = content.getBytes();
        fos.write(b);
        fos.close();
        sc.close();
        System.out.println("File is saved on Location Path");
    }

    public static void ReadWriteExecutables() {
        File file = new File("abc.txt");
        file.setExecutable(true);
        file.setReadable(true);
        file.setWritable(true);
        //Use gitbash to set all the permissions true
        //open git bash
        // Write chmod 777 abc.txt


    }
}
