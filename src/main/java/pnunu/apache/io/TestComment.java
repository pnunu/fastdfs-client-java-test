package pnunu.apache.io;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;


/**
 * @Author: pnunu
 * @Date: Created in 17:59 2018/7/17
 * @Description:
 */
public class TestComment {

    public static void main(String[] args) throws MalformedURLException,
            IOException {
        InputStream in = new URL("http://www.apache.org").openStream();
        InputStream in2 = new URL("http://www.apache.org").openStream();
        /**
         * IOUtils.contentEquals(InputStream input1, InputStream input2)
         * 英文：
         * Compare the contents of two Streams to determine if they are equal or not.
         * 翻译：
         * 比较两个输入流的内容是否相等
         */
        try {
            //IOUtils.toString将缓冲区的内容以utf-8的编码方式以字符串的形式输出
            //System.out.println(IOUtils.toString(in,"UTF-8"));
        } finally {
            IOUtils.closeQuietly(in);
        }
        System.out.println(IOUtils.contentEquals(in, in2));
        System.out.println("-----------------------------------------------------------------------");
        /**
         * IOUtils.copy(InputStream input, OutputStream output)
         * 英文：
         * Copy bytes from an InputStream to an OutputStream.
         * 翻译：
         * 将字节从 InputStream复制到OutputStream中
         */
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        IOUtils.copy(in2, out);
        System.out.println(out.size());
        //System.out.println(out.toString("UTF-8"));
        //IOUtils.closeQuietly(in);
        //IOUtils.closeQuietly(out);
        System.out.println("-----------------------------------");
        /**IOUtils.copyLarge(InputStream input, OutputStream output);
         * 英文
         * Copy bytes from a large (over 2GB) InputStream to an OutputStream.
         * 翻译：
         * 将字节超过2G的字节输入流复制到输出流中
         */
        IOUtils.copyLarge(in2, out);
        //System.out.println(out.toString("UTF-8"));
        System.out.println("------------------------------------------------------------");

        /**
         * IOUtils.lineIterator(InputStream input, Charset encoding)
         * 英文
         * Return an Iterator for the lines in an InputStream, using the character encoding specified (or default encoding if null).
         * 翻译
         * 返回一个装有输入字节行数的Iterator对象，使用特定的字符编码（如果没用声明的话则用默认编码）
         */
        InputStream in3 = new URL("http://www.apache.org").openStream();
        try {
            LineIterator it = IOUtils.lineIterator(in3, "UTF-8");
            System.out.println(it.hasNext());
            if (it.hasNext()) {
                String line = it.nextLine();
                //System.out.println(line);
            }
        } finally {
            IOUtils.closeQuietly(in);
        }
        System.out.println("------------------------------------------------------------------");
        /**
         * IOUtils.read(InputStream input, byte[] buffer)
         * 英文：
         * Read bytes from an input stream.
         * 中文：从输入流中读取字节(通常返回输入流的字节数组的长度)
         */
        InputStream in4 = new URL("http://www.apache.org").openStream();
        byte[] buffer = new byte[100000];
        System.out.println(IOUtils.read(in4, buffer));
        System.out.println("------------------------------------------------");
        /**
         * IOUtils.readLines(InputStream input, Charset encoding)
         * 英文：
         * Get the contents of an InputStream as a list of Strings, one entry per line, using the specified character encoding.
         * 翻译：
         * 获得输入流的内容放回一个List<String>类型的容器，每一行为这个容器的一个入口，使用特定的字符集（如果为空就使用默认的字符集）
         */
        InputStream in5 = new URL("http://www.apache.org").openStream();
        List<String> list = IOUtils.readLines(in5, "UTF-8");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            //System.out.println(s);
        }
        System.out.println("--------------------------------------------------------------");
    }


}
