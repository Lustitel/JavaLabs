package org.example;

import java.io.*;

public class BinStream {
    /* TODO
        1.Записать массив целых чисел в двоичный поток. Прочитать массив целых чисел из
        двоичного потока. Предполагается, что до чтения массив уже создан, нужно прочитать n
        чисел, где n — длина массива.
    */
    public static void writeIntArray(OutputStream output, int[] array) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(output)) {
            for (int num : array) {dos.writeInt(num);}
        }
    }

    public static void readIntArray(InputStream input, int[] array) throws IOException {
        try (DataInputStream dis = new DataInputStream(input)) {
            for (int i = 0; i < array.length; i++) {array[i] = dis.readInt();}
        }
    }


    /* TODO
        2.Аналогично, используя символьные потоки. В потоке числа должны разделяться
        пробелами.
    */
    public static void writeIntArray(Writer writer, int[] array) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(writer)) {
            for (int i = 0; i < array.length; i++) {
                bw.write(Integer.toString(array[i]));
                if (i < array.length - 1) bw.write(" ");
            }
        }
    }

    public static void readIntArray(Reader reader, int[] array) throws IOException {
        try (BufferedReader br = new BufferedReader(reader)) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            for (int i = 0; i < array.length && i < parts.length; i++) {array[i] = Integer.parseInt(parts[i]);}
        }
    }
}