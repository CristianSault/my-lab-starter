package _01_namespaces;

import java.util.*;

import static java.lang.Math.*;

interface MyType {
    class MyNestedType {
        enum MyReallyNestedType { TEST }
    }

    static void main() {
        IO.println("hi");

        final int ZERO = 0;

        var x = sqrt(234);


        List<String> L;

        Integer y = Integer.parseInt("123");
    }
}
