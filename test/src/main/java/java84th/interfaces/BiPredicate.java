package java84th.interfaces;

@FunctionalInterface
public interface BiPredicate<T,U> {
	boolean test(T t, U u);
}
