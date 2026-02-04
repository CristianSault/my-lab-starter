package _03_designing_types._30_access_modifiers.sub1;

import _03_designing_types._30_access_modifiers.sub2.TypeAInSub2;

class Main {
    // Having no access modifier makes this method package-private
    static void main() {

        IO.println(TypeAInSub1.s1a);
        // IO.println(TypeAInSub1.s1b); // ERROR: s1b has private access in TypeA

        var a = new TypeAInSub1();
        IO.println(a.s2);
        IO.println(a.getS3());
        //IO.println(a.s3); // ERROR: s3 has private access in TypeA

        //IO.println(TypeAInSub2.s1a);
    }
}