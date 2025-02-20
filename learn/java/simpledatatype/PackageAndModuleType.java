package simpledatatype;

public class PackageAndModuleType {
    public static void main(String[] args) {
        Module m = Integer.class.getModule();
        System.out.println(m);
        Package p = Integer.class.getPackage();
        System.out.println(p);
    }
}
