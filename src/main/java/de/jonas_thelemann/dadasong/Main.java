package de.jonas_thelemann.dadasong;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IoUtil.createFile(
                DadaLinguistic.getDadaSong(args.length > 0 ? Integer.parseInt(args[0]) : 4, args.length > 1 ? Integer.parseInt(args[1]) : 7),
                args.length > 2 ? args[2] : "target/dadasong.md");
    }
}
