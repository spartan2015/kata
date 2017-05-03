package java8.stream.primitives;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;

import org.junit.Test;

public class PrimitivePredicateSupplierConsumerFunctionUnaryBiOperator {

	@Test
	public void primitivePredicate(){
		IntPredicate ip = i -> true;
		LongPredicate lp = l -> true;
		DoublePredicate dp = d -> true;
	}
	@Test
	public void primitiveSupplier(){
		IntSupplier is = () -> 1;
		LongSupplier ls;
		DoubleSupplier ds;
	}
	
	@Test
	public void primitiveConsumer(){
		IntConsumer ic;
		LongConsumer lc;
		DoubleConsumer dc;
		
		ObjIntConsumer oic;
		ObjLongConsumer olc;
		ObjDoubleConsumer odc;
	}
	
	@Test
	public void primitiveFunction(){
		IntFunction intFunction = (int i) -> true;
		ToIntFunction<Object> toIntFunction = o -> 1;
		toIntFunction.applyAsInt(new Object());
		IntToLongFunction itlf;
		IntToDoubleFunction itdf;
		ToIntBiFunction tibf;
		
		LongFunction lf;
		ToLongFunction tlf;
		ToLongBiFunction tlbf;
		LongToDoubleFunction ltdf;
		LongToIntFunction ltif;
		
		DoubleFunction df;
		ToDoubleFunction tdf;
		ToDoubleBiFunction tdbf;
		DoubleToIntFunction dtit;
		DoubleToLongFunction dtlf;
	}
	
	@Test
	public void primitiveUnaryOperator(){
		IntUnaryOperator intUnaryOpeartor = i -> i;
		LongUnaryOperator luo;
		DoubleUnaryOperator duo;
	}
	
	@Test
	public void primitiveBiOperator(){
		IntBinaryOperator intBiOperator = (i1,i2)->i1+i2;
		LongBinaryOperator lbo;
		DoubleBinaryOperator dbo;
	}
}
