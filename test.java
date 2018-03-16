package wordCount_dzx;

import java.io.*;

public class test {

        public int char_num;
        public int word_num;
        public int line_num;


        public void wordCount(int char_num,int word_num,int line_num){
            this.char_num=char_num;
            this.word_num=word_num;
            this.line_num=line_num;
        }

        public int getChar_num() {
            return char_num;
        }

        public void setChar_num(int char_num) {
            this.char_num = char_num;
        }

        public int getWord_num() {
            return word_num;
        }

        public void setWord_num(int word_num) {
            this.word_num = word_num;
        }

        public int getLine_num() {
            return line_num;
        }

        public void setLine_num(int line_num) {
            this.line_num = line_num;
        }

        public void readFile(String fileName) {
            File file = new File(fileName);
            Reader reader = null;
            try {
                System.out.println("以字符为单位读取文件内容，一次读一个字符：");
                // 一次读一个字符
                reader = new InputStreamReader(new FileInputStream(file));
                int tempchar;
                while ((tempchar = reader.read()) != -1) {
                    // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                    // 但如果这两个字符分开显示时，会换两次行。
                    // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                    char_num++;
                    if (((char) tempchar) != '\r') {
                        System.out.print((char) tempchar);
                    }
                    if((char)tempchar=='\n'){
                        line_num++;
                    }
                    if((char)tempchar==' '||(char)tempchar==','){
                        word_num++;

                    }
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                    }
                }
            }
        }
}
