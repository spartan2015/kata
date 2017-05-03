package mastering.jdbc.dao1;

import java.util.function.Supplier;

@FunctionalInterface
interface UnsafeSupplier<T> extends Supplier<T> {
	default T get() {
		try {
			return getWithException();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	T getWithException() throws Exception;
}
