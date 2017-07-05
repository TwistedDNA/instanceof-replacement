package main;

import static checker.TypeChecker.whenTypeOf;

public class Main {

    public static void main(String[] args) {
        int result = whenTypeOf("aaa")
                .is(String.class).thenReturn(String::length)
                .is(Integer.class).thenReturn(d -> d).
        execute();
    }
}
