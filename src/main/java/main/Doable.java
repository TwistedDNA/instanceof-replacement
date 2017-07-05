package main;

import checker.TypeChecker;

import java.util.function.Function;

/**
 * Crafted by TwistedDNA on 7/5/2017.
 */

public class Doable<T> {
    private T type;

    public Doable(T type) {
        this.type = type;
    }

    public <T> TypeChecker thenReturn(TypeChecker caller, Function<T, Integer> func) {
        return new TypeChecker(caller, type.getClass(), func);
    }
}