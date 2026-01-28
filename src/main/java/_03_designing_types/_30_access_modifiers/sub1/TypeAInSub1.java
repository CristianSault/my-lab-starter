package _03_designing_types._30_access_modifiers.sub1;

// Having PUBLIC access modifier makes this class available to other packages
public class TypeAInSub1 {
    // Having no access modifier makes this class variable package-private
    static String s1a = "This is package-private to the _30_access_modifiers package";
    static private String s1b = "This is private to TypeA";

    // Having no access modifier makes this instance variable package-private
    String s2 = "Hello, from a TypeA object";

    // Having private access modifier makes this instance variable private
    private String s3 = "This is private to TypeA";

    // Having no access modifier makes this method package-private
    String getS3() {
        // CAN access private member here because we are inside TypeA
        return s3;
    }
}
