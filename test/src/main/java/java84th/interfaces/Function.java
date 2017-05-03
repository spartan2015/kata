package java84th.interfaces;

@FunctionalInterface
public interface Function<T,R> {
	R apply(T t);
}
