package xm.demo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class Test {
    private static final String a = "/tmp/评奖申报材料汇总/a.csv";
    private static final String b = "/tmp/评奖申报材料汇总/b.csv";

    public static void main(String[] args) throws IOException {
        String s = FileUtils.readFileToString(new File(b));
        String[] lines = s.split("\r");
//        int i=0;
//        for (String line : lines) {
//        	String[] ss = line.split(",",5);
//        	System.out.println("update project set description=" + ss[4] +" where id ="+i+" and manager=\""+ss[1]+"\";");
//        	i++;
//		}
        int i=21;
        for (String line : lines) {
        	String[] ss = line.split(",",6);
        	System.out.println("update project set description=" + ss[5] +" where id ="+i+" and manager=\""+ss[1]+"\";");
        	i++;
		}
//        lines.forEach(System.out::print);
//    	final Path path = new File( a ).toPath();
//		try( Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
//		    lines.forEach(e -> {
//		    	String[]s = e.split(",", 4);
//		    	System.out.println(s[3]);
//		    });
//		}
    }
}
