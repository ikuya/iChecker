package common;

import utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

public class IpaFile extends ZipFile {
//    public final byte[] magic;
    public IpaFile(File file) throws IOException {
        super(file);
//        this.magic = FileUtil.readFile(file, 0, 8);
//        if (!(this.magic[0] == 0x50 && this.magic[1] == 0x4b)) {
//            throw new RuntimeException(file + ": not a ipa file");
//        }
    }

}
