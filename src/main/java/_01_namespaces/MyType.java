package _01_namespaces;

import java.awt.*;
import java.util.*;
import java.util.List;

import static java.lang.Math.*;

interface MyType {
    class MyNestedType {
        enum MyReallyNestedType { TEST }
    }

    static void main() {

        final int EVENT_TITLE_INDEX = 0;


        IO.println("hi");

        final int ZERO = 0;

        var x = sqrt(234);

        var r = new Rectangle(10, 10);

        r.width = 10;


        List<String> L;

        Integer y = Integer.parseInt("123");
    }
}
