package com.arkdex.springinaction.disruptorqueue;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StaticTest {




    public static void main(String[] args) {
        Path path = null;
        try {
            path = Helpers.fileOutBeanPath();
        } catch (Exception ex) {
            Helpers.err(ex);
        }
        try {
            writeCsvFromBean(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String writeCsvFromBean(Path path) throws Exception {
        Writer writer  = new FileWriter(path.toString());

        StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();

        List<CsvBean> list = new ArrayList<>();
        list.add(new WriteExampleBean("Test1", "sfdsf", "fdfd"));
        list.add(new WriteExampleBean("Test2", "ipso", "facto"));

        sbc.write(list);
        writer.close();
        return Helpers.readFile(path);
    }
}
