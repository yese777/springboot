package com.yese.util;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;

public class ReadWord {

    /**
     * 传入word文件路径,读取内容
     *
     * @param path
     * @return
     */
    public static String readWord(String path) {
        File file = new File(path);
        String text = "";
        String fileName = file.getName().toLowerCase();// 得到名字小写
        try {
            FileInputStream in = new FileInputStream(file);
            if (fileName.endsWith(".doc")) { // doc为后缀的
                //WordExtractor extractor = new WordExtractor(in);
                //text = extractor.getText();
                //extractor.close();
            }
            if (fileName.endsWith(".docx")) { // docx为后缀的
                XWPFWordExtractor docx = new XWPFWordExtractor(new XWPFDocument(in));
                text = docx.getText();
                docx.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(readWord("C:\\Users\\zqf\\Desktop\\1.docx"));
    }

}