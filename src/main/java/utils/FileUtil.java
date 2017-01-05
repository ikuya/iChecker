package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtil {

    public static byte[] readFile(File file, int offset, int length) throws IOException {
        if (!file.exists()) throw new RuntimeException(file + ": file not found");
        if (!file.isFile()) throw new RuntimeException(file + ": not a file");
        if (!file.canRead()) throw new RuntimeException(file + ": file not readable");

        long longLength = file.length();
        int fileLength = (int) longLength;
        if (fileLength != longLength) throw new RuntimeException(file + ": file too long");

        if (length == -1) {
            length = fileLength - offset;
        }

        if (offset + length > fileLength) throw new RuntimeException(file + ": file too short");

        FileInputStream in = new FileInputStream(file);
        int at = offset;
        while(at > 0) {
            long amt = in.skip(at);
            if (amt == -1) throw new RuntimeException(file + ": unexpected EOF");
            at -= amt;
        }
        byte[] result = readStream(in, length);
        in.close();
        return result;
    }

    public static byte[] readStream(FileInputStream in, int length) throws IOException {
        byte[] result = new byte[length];
        int at = 0;

        while(length > 0) {
            int amt = in.read(result, at, length);
            if (amt == -1) throw new RuntimeException("unexpected EOF");
            at += amt;
            length -= amt;
        }
        return result;
    }

}
