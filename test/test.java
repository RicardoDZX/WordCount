package test;

import java.io.*;

public class test {
    public static void test1(){
        String args="wc.exe  -w -c -l test.java";
        tests(args);
    }//(走无-o，无-e 无-a的路径，文件名用（默认）当前路径)
    public static void  test2(){
        String args="wc.exe -w -c D:\\test\\test.java";
        tests(args);
    }//(同上，走无-l的路径，文件名用绝对路径)

    public static void  test3(){
        String args="wc.exe -w -s *.java -o ouput.txt";
        tests(args);
    }//(同上，走“-s”路径，使用一般通配符，使用“-o”，声明输出文件)
    public static void  test4(){
        String args="wc.exe -w -s D:\\test\\*.java ";
        tests(args);
    }//(使用绝对路径和一般通配符)
    public static void  test5(){
        String args="wc.exe -c -l -w  -a test.java -e ignore.txt";
        tests(args);
    }//(测试功能-a，-e忽视词。此处我认为应该注意要有-w，单词数的显示。不然测试-e就没有意义了。不知道这个想法对不对。)
    public static void  test6(){
        String args="wc.exe  -c -l -s  test.java -e ignore.txt";
        tests(args);
    }//(走-s，-e路径，使用当前路径，不使用一般通配符。这个情况需求中没有明确给出。但我认为应该效果是遍历当前目录下所有具有给定名称的文件。（重名？）)
    public static void  test7(){
        String args="wc.exe -l -a -s D:\\test\\*.java -o output.txt";
        tests(args);
    }//(-a+ -s路径。使用输出)
    public static void  test8(){
        String args="wc.exe -c -a test.java -o";
        tests(args);
    }//(这个用例我想测试对于错误输入的反应。)
    public static void  test9(){
        String args=" wc.exe -c -s -a test.java -e";
        tests(args);
    }//(这个用例我想测试对于错误输入的反应。)
    public static void  test10(){
        String args="wc.exe -w -l -c -s -a D:\\test\\*.java -o output.txt -e ignore.txt";
        tests(args);
    }//(测试全部功能)

    public static void tests(String order){
        Runtime rt = Runtime.getRuntime();
        String path=System.getProperty("user.dir");
        try {
            rt.exec(path + " " + order);
        } catch (IOException e) {
            e.printStackTrace();
            }
        }



    public static void main(String[] args) {
        test1();
       // test2();
       // test3();
       // test4();
       // test5();
       // test6();
       // test7();
       // test8();
       // test9();
       // test10();

    }
}
