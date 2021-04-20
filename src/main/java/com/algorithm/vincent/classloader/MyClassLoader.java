package com.algorithm.vincent.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class MyClassLoader extends ClassLoader {
    private final static Path DEFAULT_CLASS_DIR = Paths.get("G:", "classloader1");
    private final Path classDir;

    public MyClassLoader(){
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(String classDir){
        super();
        this.classDir = Paths.get(classDir);
    }

    public MyClassLoader(String classDir, ClassLoader parent){
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = this.readClassBytes(name);
        // 如果数据为null, 或者没有读取到任何信息, 则抛出ClassNotFoundException异常
        if(null == classBytes || classBytes.length == 0){
            throw new ClassNotFoundException("Cannot load the class " + name);
        }

        // 读取偏移量和长度, 而不是直把所有byte交给defineClass因为, 我们获取流的方式不一样.
        // 有可能一个流里含有很多个类的定义
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    // 将class文件读入内存中
    private byte[] readClassBytes(String name) throws ClassNotFoundException{
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if(!classFullPath.toFile().exists()){
            throw new ClassNotFoundException("The class " + name + "not found.");
        }
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        }catch (IOException e){
            throw new ClassNotFoundException("load the class " + name + " occur error.", e);
        }
    }


    @Override
    public String toString(){
        return "My ClassLoader";
    }

}
