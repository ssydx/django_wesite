package simpledatatype;

import java.text.SimpleDateFormat;
import java.util.Date;

import tool.PrintMethods;

public class SimpleDateFormatType {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(s.toPattern());
        System.out.println(s.toLocalizedPattern());
        String str = s.format(d);
        System.out.println(str);
        PrintMethods.print(SimpleDateFormat.class);
    }
}
