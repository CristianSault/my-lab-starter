package _01_namespaces;

import java.util.List;

interface MyType {
    class MyNestedType {
        enum MyReallyNestedType { TEST }
    }

    static void main() {
        IO.println("hi");

        final int ZERO = 0;

        Math.sqrt(234);


        List<String> L;

        Integer x = Integer.parseInt("123");
    }
}
