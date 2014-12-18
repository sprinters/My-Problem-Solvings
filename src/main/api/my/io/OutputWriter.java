package main.api.my.io;
import java.io.*;


/**

 * @author sandeepandey

 */

public class OutputWriter {

    private final PrintWriter writer;
    public OutputWriter(OutputStream outputStream) {

        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

    }



    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }



    public void print(Object...objects) {

        for (int i = 0; i < objects.length; i++) {

            if (i != 0)

                writer.print(' ');

            writer.print(objects[i]);

        }

    }



    public void printLine(Object...objects) {

        print(objects);

        writer.println();

    }



    public void printLine(char[] array) {

        writer.println(array);

    }



    public void printFormat(String format, Object...objects) {

        writer.printf(format, objects);

    }



    public void close() {

        writer.close();

    }



    public void flush() {

        writer.flush();

    }

    public void printArray(int...array) {
        for(int i : array) {
            print(i+" ");
        }
        printLine();
    }

    public void printArray(long...array) {
        for(long i : array) {
            print(i+" ");
        }
        printLine();
    }


}
