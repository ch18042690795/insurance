package com.middle.kafka;

import java.io.*;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Chen
 * @create: 2019-09-20 11:25
 **/
public class FileInput extends FileInputStream implements AutoCloseable {

    public FileInput(String name) throws FileNotFoundException {
        super(name);
    }

    public FileInput(File file) throws FileNotFoundException {
        super(file);
    }

    public FileInput(FileDescriptor fdObj) {
        super(fdObj);
    }

    @Override
    public void close() throws IOException {
        super.close();
        System.out.println("关闭了。。。。。。。");
    }
}
