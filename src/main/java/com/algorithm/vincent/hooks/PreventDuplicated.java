package com.algorithm.vincent.hooks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class PreventDuplicated {

    private final static String LOCK_PATH = ".\\";
    private final static String LOCK_FILE = ".lock";
    private final static String PERMISSIONS ="rw-------";

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("The program received kill SIGNAL");
            getLockFile().toFile().delete();
        }));

        checkRunning();

        for(;;){
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("program is running.");
        }
    }

    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        System.out.println(path.toAbsolutePath());
        if(path.toFile().exists()){
            throw new RuntimeException("The program already running.");
        }

        Set<PosixFilePermission> permissionSet = PosixFilePermissions.fromString(PERMISSIONS);
        Files.createFile(path);
    }

    private static Path getLockFile(){
        return Paths.get(LOCK_PATH, LOCK_FILE);
    }
}
