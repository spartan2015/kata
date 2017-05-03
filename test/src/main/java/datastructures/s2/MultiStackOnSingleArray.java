package datastructures.s2;

public class MultiStackOnSingleArray<E> {

	E[] data;
	int[] indexes;
	int individualArraySize;
	
	@SuppressWarnings("unchecked")
	public MultiStackOnSingleArray(int individualArraySize, int noOfArrays){
		this.individualArraySize = individualArraySize;
		this.data = (E[])new Object[individualArraySize * noOfArrays];
		indexes = new int[noOfArrays];
	}
	
	public void push(int stackNo, E e){
		int stackIndex = getStackCurrentIndex(stackNo);
		if (stackIndex > (stackNo+1)  * individualArraySize -1){
			throw new RuntimeException("stack full");
		}
		data[stackIndex] = e;
		indexes[stackNo]++;
	}

	private int getStackCurrentIndex(int stackNo) {
		return stackNo*individualArraySize + indexes[stackNo];
	}
	
	public E pop(int stackNo){
		if (stackNo*individualArraySize == getStackCurrentIndex(stackNo)){
			return null;
		}else{
			indexes[stackNo]--;
			return data[getStackCurrentIndex(stackNo)];
		}
	}
}
