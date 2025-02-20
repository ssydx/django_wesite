package tool;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/**
 * 打印属性的类
 * @category 打印
 * @author ssydx
*/
public class PrintFields {
    private static String delimiter = "|";
    private static int ModifiersWidth = 20;
    private static int FieldTypeWidth = 20;
    private static int FieldNameWidth = 20;
    private static void printHorizontalDelimiter() {
        System.out.println("-".repeat(ModifiersWidth + FieldTypeWidth + FieldNameWidth + delimiter.length() * 4));
    }
    /**
     * 设置打印参数
     * @return 该函数无返回值
     * @param _delimiter 竖向分隔线
    */
    public static final void set(String _delimiter) {
        delimiter = _delimiter;
    }
    /**
     * 设置打印参数
     * @return 该函数无返回值
     * @param _delimiter 竖向分隔线
     * @param _ModifiersWidth 修饰符列所占宽度
     * @param _FieldTypeWidth 属性类型列所占宽度
     * @param _FieldNameWidth 属性名称列所占宽度
    */
    public static final void set(String _delimiter, int _ModifiersWidth, int _FieldTypeWidth, int _FieldNameWidth) {
        delimiter = _delimiter;
        ModifiersWidth = _ModifiersWidth;
        FieldTypeWidth = _FieldTypeWidth;
        FieldNameWidth = _FieldNameWidth;
    }
    /**
     * 打印属性
     * @return 该函数无返回值
     * @param clazz 输入一个类型为类的参数
     * 例如：String.class,str.getClass()
    */
    public static final void print(Class<?> clazz) {
        // 格式串
        String formatter = delimiter + 
                            "%1$-" + ModifiersWidth + "s" + 
                            delimiter + 
                            "%2$-" + FieldTypeWidth + "s" + 
                            delimiter + 
                            "%3$-" + FieldNameWidth + "s" + 
                            delimiter + 
                            "\n";
        // 打印表头
        printHorizontalDelimiter();
        System.out.printf(
            formatter,
            "Modifiers",
            "FieldType",
            "FieldName"
        );
        printHorizontalDelimiter();
        // 打印内容
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.printf(
                formatter, 
                Modifier.toString(field.getModifiers()), 
                field.getType().getSimpleName(),
                field.getName()
            );
        }
        printHorizontalDelimiter();
    }
}
