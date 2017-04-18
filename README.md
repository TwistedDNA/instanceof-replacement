# instanceOf replacement


#### The challange

Java has ```instanceof``` operator, which is often used for downcasting. We don't want to use that (care to explain why it's a bad idea?). Create a simple library, that will allow us to do the following:

```
int result = whenTypeOf(obj)
    .is(String.class).thenReturn(String::length)
    .is(Integer.class).thenReturn(d -> d)
    execute();
```

#### Requirements

* should be generic enough to use with any classes
* should examine every class top to bottom, returning the first matching class
* should match parent class, so that the following code should return "A"

```
class A {...}
class B extends A {...}

Object ab = new B();

whenTypeOf(ab)
    .is(A.class).thenReturn("A")
    .is(B.class).thenReturn("B")
```

* if none of the cases matched, should rise the exception on ```execute```
* should use static typing to catch incorrect usages on compilation time

## Environment setup

Basic template with attached test libraries and java execution task.

To compile code:
```
./mvnw compile
```
to run sample code from main class:
```
./mvnw compile exec:java
```
to run tests:
```
./mvnw test
```
to zip task sources with master pom.xml (from `maven_project_template` dir):
```
./mvnw assembly:single
```

## Libraries attached to project

Some potentially useful libraries are attached to project. You can (but you don't have to) use them:
* Javaslang
* RxJava
* Guava
* Lombok
* Apache Commons Lang
* JUnit
* Spock Framework
* TestNg

to switch between `JUnit` and `TestNG` uncomment proper section in `pom.xml` file (by default`JUnit`is enabled).
