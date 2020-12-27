/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theproject;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ferid
 */
public class FileUtility implements Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

       
    }

    public static void fileLvl(String fileName, int text) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(text);

        }

    }

    public static void writeIntoFile(String fileName, String text) throws IOException {
        try (FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(text);

        }

    }

    public static String readOnFile(String fileName) throws Exception {
        try (InputStream in = new FileInputStream(fileName);
                InputStreamReader r = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(r);) {
            String line = null;
            String result = "";
            while ((line = reader.readLine()) != null) {

                result += line + "\n";
            }
            return result;
        }

    }

    public static byte[] readLvl(String fileName) throws Exception {
        File file = new File(fileName);
        try (FileInputStream fis = new FileInputStream(file);) {
            byte[] array = new byte[(int) file.length()];

            fis.read(array);
            return array;
        }
    }

    public static void writeIntoFile(String fileName, byte[] data) throws Exception {
        File f = new File(fileName);
        FileOutputStream fop = new FileOutputStream(f);

        fop.write(data);
        fop.flush();
        fop.close();

        System.out.println("Done!");

    }

    public static void writeBytesNIO(byte[] data, String fileName) throws Exception {
        Path filePath = Paths.get(fileName);

        Files.write(filePath, data);

    }

    public static byte[] readBytesNIO(String fileName) throws Exception {
        Path filePath = Paths.get(fileName);

        byte[] byteArray = Files.readAllBytes(filePath);
        return byteArray;
    }

    public static void writeObject(Serializable obj, String name) throws Exception {
        try (FileOutputStream fop = new FileOutputStream(name);
                ObjectOutputStream oos = new ObjectOutputStream(fop)) {

            oos.writeObject(obj);
        }
    }

    public static Object readObjectFile(String name) throws Exception {
        Object obj = null;

        FileInputStream fis = new FileInputStream(name);
        try (ObjectInputStream oos = new ObjectInputStream(fis)) {
            obj = oos.readObject();

        } finally {
            return obj;
        }
    }
}
