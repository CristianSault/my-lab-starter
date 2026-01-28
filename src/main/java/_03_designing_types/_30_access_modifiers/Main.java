package _03_designing_types._30_access_modifiers;

// Having no access modifier makes this class package-private
class Main {
    // Having no access modifier makes this method package-private
    static void main() {

        IO.println(TypeA.s1a);
        // IO.println(TypeA.s1b); // ERROR: s1b has private access in TypeA

        var a = new TypeA();
        IO.println(a.s2);
        IO.println(a.getS3());
        //IO.println(a.s3); // ERROR: s3 has private access in TypeA
    }
}
