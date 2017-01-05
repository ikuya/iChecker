package analyzer;

import common.IpaFile;
import macho.MachOAnalyzer;
import macho.MachOData;
import pfile.PlistData;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

public class IpaAnalyzer {
    IpaFile ipaFile = null;
    MachOData machOData = new MachOData();
    PlistData plistData = new PlistData();

    public int analyze(String ipaFilePath) {
        // PlistAnalyzer plistAnalyzer = new PlistAnalyzer(plistData);
        MachOAnalyzer machoAnalyzer = new MachOAnalyzer(machOData);

        File file = null;
        file = new File(ipaFilePath);
        try {
            ipaFile = new IpaFile(file);
            String appName = ipaFilePath.substring(0, ipaFilePath.lastIndexOf("."));
            for(Enumeration<? extends ZipEntry> e = ipaFile.entries(); e.hasMoreElements();) {
                ZipEntry ze = e.nextElement();
                if (ze.isDirectory() || ze.getSize() == 0)
                    continue;

                InputStream is = new BufferedInputStream(ipaFile.getInputStream(ze));

                String entryName = ze.getName();

                if (entryName.equals("Info.plist")) {
                    // TODO info.plist
                } else if (entryName.equals(appName)) {
                    // TODO Mach-O binary
                    machoAnalyzer.setData(is);
                }
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 2;
        }

        machoAnalyzer.parse();

        analyzeSuspiciousAPI(machoAnalyzer);

        return 0;
    }

    private void analyzeSuspiciousAPI(MachOAnalyzer machOAnalyzer) {
        // TODO
    }
}
