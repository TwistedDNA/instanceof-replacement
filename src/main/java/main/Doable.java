package main;

import checker.TypeChecker;

import java.util.function.Function;

/**
 * Crafted by TwistedDNA on 7/5/2017.
 */
public class Doable<T>{
    private final TypeChecker caller;
    private T type;

    public Doable(T type, TypeChecker caller) {
        this.type = type;
        this.caller = caller;
    }

    public <T> TypeChecker thenReturn(Function<T, Integer> func) {
        return new TypeChecker(caller, type.getClass(), func);
    }
}