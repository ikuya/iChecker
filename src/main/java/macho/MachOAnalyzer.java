package macho;

import common.MachOFile;

import java.io.InputStream;

public class MachOAnalyzer {
    MachOFile machOFile;
    MachOData machOData;

    public MachOAnalyzer(MachOData _machOData) {
        machOData = _machOData;
    }

    public void setData(InputStream is) {
        // TODO Extract and bind data from mach-o binary to MachOData
    }

    public void parse() {

    }
}
