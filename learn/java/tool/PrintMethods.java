package tool;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;
/**
 * 打印方法的类
 * @category 打印
 * @author ssydx
*/
public class PrintMethods {
    private static String delimiter = "|";
    private static int ModifiersWidth = 20;
    private static int ReturnTypeWidth = 20;
    private static int MethodNameWidth = 20;
    private static int ParameterTypesWidth = 20;
    private static void printHorizontalDelimiter() {
        System.out.println("-".repeat(ModifiersWidth + ReturnTypeWidth + MethodNameWidth + ParameterTypesWidth + delimiter.length() * 5));
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
     * @param _ReturnTypeWidth 返回值类型列所占宽度
     * @param _MethodNameWidth 方法名称列所占宽度
     * @param _ParameterTypesWidth 参数类型列所占宽度
    */
    public static final void set(String _delimiter, int _ModifiersWidth, int _ReturnTypeWidth, int _MethodNameWidth, int _ParameterTypesWidth) {
        delimiter = _delimiter;
        ModifiersWidth = _ModifiersWidth;
        ReturnTypeWidth = _ReturnTypeWidth;
        MethodNameWidth = _MethodNameWidth;
        ParameterTypesWidth = _ParameterTypesWidth;
    }
    /**
     * 打印方法
     * @return 该函数无返回值
     * @param clazz 输入一个类型为类的参数
     * 例如：String.class,str.getClass()
    */
    public static final void print(Class<?> clazz) {
        // 格式串
        String formatter = delimiter + 
                            "%1$-" + ModifiersWidth + "s" + 
                            delimiter + 
                            "%2$-"+ ReturnTypeWidth + "s" + 
                            delimiter + 
                            "%3$-" + MethodNameWidth + "s" + 
                            delimiter + 
                            "%4$-" + ParameterTypesWidth + "s" + 
                            delimiter + 
                            "\n";
        // 打印表头
        printHorizontalDelimiter();
        System.out.printf(
            formatter,
            "Modifiers",
            "ReturnType",
            "MethodName",
            "ParameterTypes"
        );
        printHorizontalDelimiter();
        // 打印内容
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.printf(
                formatter, 
                Modifier.toString(method.getModifiers()), 
                method.getReturnType().getSimpleName(), 
                method.getName(),
                Arrays.stream(method.getParameterTypes()).map(Class::getSimpleName).collect(Collectors.joining(", "))
            );
        }
        printHorizontalDelimiter();
    }
}
