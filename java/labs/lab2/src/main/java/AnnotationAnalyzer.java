package labs.lab2.src.main.java;

import java.lang.reflect.*;
public class AnnotationAnalyzer {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Class<MyClass> cls = MyClass.class;
        try {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(MyAnnotation.class) &&
                        (Modifier.isPrivate(method.getModifiers()) || Modifier.isProtected(method.getModifiers()))) {
                    MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                    int count = annotation.count();
                    method.setAccessible(true);
                    for (int i = 0; i < count; i++) {
                        switch (method.getParameterCount()) {
                            case 0:
                                method.invoke(myClass);
                                break;
                            case 1:
                                method.invoke(myClass, "hello world");
                                break;
                            case 2:
                                method.invoke(myClass, "hello", 43);
                                break;
                            case 3:
                                method.invoke(myClass, 5, true, 32.64);
                                break;
                        }
                    }
                }
            }
        } catch (InvocationTargetException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
