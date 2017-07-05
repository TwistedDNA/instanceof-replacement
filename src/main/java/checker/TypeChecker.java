package checker;


import main.Doable;

import java.util.HashMap;
import java.util.function.Function;

public class TypeChecker {
    private HashMap<Class, Function> map;
    private Object obj;

    public static TypeChecker whenTypeOf(Object object) {
        return new TypeChecker(object);
    }

    public <T> Doable<T> is(T clazz) {
        return new Doable(clazz);
    }

    public TypeChecker(Object object) {
        map = new HashMap<>();
        this.obj = object;
    }

    public TypeChecker(TypeChecker predecessor, Class key, Function value) {
        this.map = new HashMap<>(predecessor.map);
        this.obj = predecessor.obj;
        map.put(key, value);
    }

    public void execute() {
        Function f = map.get(obj.getClass());
        if (f != null) {
            f.apply(obj);
        }
    }


}
