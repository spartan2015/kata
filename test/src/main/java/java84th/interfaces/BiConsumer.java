package java84th.interfaces;

@FunctionalInterface
public interface BiConsumer<T,U> {
	void accept(T t, U u);
}
