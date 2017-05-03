package java84th.interfaces;

@FunctionalInterface
public interface BiFunction<T,U,R> {
	R apply(T t, U u);
}
