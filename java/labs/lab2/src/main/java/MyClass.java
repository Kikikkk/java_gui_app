package labs.lab2.src.main.java;

public class MyClass {
    public void publicMethod(String arg1, int arg2) {
        System.out.println("This is a public method with parameters: " + arg1 + ", " + arg2);
    }

    @MyAnnotation()
    public void anotherPublicMethod(double arg1) {
        System.out.println("This is another public method with parameter: " + arg1);
    }

    @MyAnnotation(count=2)
    protected void protectedMethod(int arg1, boolean arg2, double arg3) {
        System.out.println("This is a protected method with parameters: " + arg1 + ", " + arg2 + ", " + arg3);
    }

    @MyAnnotation(count=3)
    protected void anotherProtectedMethod(String arg1, int arg2) {
        System.out.println("This is another protected method with parameters: " + arg1 + ", " + arg2);
    }

    @MyAnnotation(count=4)
    private void privateMethod(String arg1) {
        System.out.println("This is a private method with parameter: " + arg1);
    }

    @MyAnnotation()
    private void anotherPrivateMethod() {
        System.out.println("This is another private method without parameters");
    }
}