package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class DealersTest {
	static class Dealer {
		List<Car> cars;
		Address address;

		public List<Car> getCars() {
			return cars;
		}

		public void setCars(List<Car> cars) {
			this.cars = cars;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

	}

	static class Address {
		String country;
		String city;

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

	}

	static class Car {
		int horsePower;
		short manufacturingYear;
		String brand;
		long price;

		public int getHorsePower() {
			return horsePower;
		}

		public void setHorsePower(int horsePower) {
			this.horsePower = horsePower;
		}

		public short getManufacturingYear() {
			return manufacturingYear;
		}

		public void setManufacturingYear(
				short manufacturingYear) {
			this.manufacturingYear = manufacturingYear;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}

	}

	private List<Dealer> dealers = new ArrayList<>();

	@Test
	public void manufacturedIn2009SortedByPrice() {

		List<Car> carsManufacturedIn2009 = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.filter(car -> car
						.getManufacturingYear() == 2009)
				.collect(Collectors.toList());

	}

	@Test
	public void availableBrands() {
		List<String> availableBrands = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.map(Car::getBrand).distinct()
				.collect(Collectors.toList());
	}

	@Test
	public void carsInLondonSortedByPrice() {

		List<Car> carsInLondon = dealers.stream()
				.filter(dealer -> "London".equals(
						dealer.getAddress().getCity()))
				.flatMap(d -> d.getCars().stream())
				.sorted((car1,
						car2) -> car1.getPrice() < car2
								.getPrice() ? -1 : 1)
				.sorted(Comparator.comparing(Car::getPrice))
				.collect(Collectors.toList());
	}

	@Test
	public void allBrandsSorted() {
		List<String> allBrands = dealers.stream()
				.flatMap(
						dealer -> dealer.getCars().stream())
				.map(Car::getBrand)
				.sorted(String::compareTo)
				.collect(Collectors.toList());
	}

	@Test
	public void anyCarInVienna() {
		boolean anyCarInVienna = dealers.stream()
				.anyMatch(dealer -> "Vienna"
						.equals(dealer.getAddress()
								.getCity())
						&& dealer.getCars().size() > 0);
	}

	@Test
	public void printCarPricesFromDealersInBucharest() {
		dealers.stream()
				.filter(dealer -> "Bucuresti".equals(
						dealer.getAddress().getCity()))
				.flatMap(
						dealer -> dealer.getCars().stream())
				.forEach(car -> System.out
						.println(car.getPrice()));
	}

	@Test
	public void theMostExpensiveCar() {
		Car car = dealers.stream()
				.flatMap(
						dealer -> dealer.getCars().stream())
				.reduce((car1,
						car2) -> car1.getPrice() > car2
								.getPrice() ? car1 : car2)
				.orElse(null);
		;

	}

	@Test
	public void iteratingFibonacci() {
		List<Integer> fibonacci =

				Stream.iterate(new int[] { 0, 1 },
						ints -> new int[] { ints[1],
								ints[0] + ints[1] })

						.flatMap(ints -> Arrays
								.asList(ints[0], ints[1])
								.stream())
						.limit(20).

						collect(Collectors.toList());

	}

	@Test
	public void collectToList() {
		List<Dealer> toList = dealers.stream()
				.collect(Collectors.toList());
		List<Car> toListOfCar = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(Collectors.toList());
		Set<Car> toSet = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(Collectors.toSet());

		Set<Car> toSet1 = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(Collectors
						.toCollection(HashSet::new));

		long countCars = dealers.stream()
				.flatMap(d -> d.getCars().stream()).count();

		countCars = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(Collectors.counting());

		Car maxPricedCar = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(Collectors.maxBy((car1,
						car2) -> (int) (car1.getPrice()
								- car2.getPrice())))
				.orElse(null);

		maxPricedCar = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(Collectors.collectingAndThen(
						Collectors.maxBy((car1,
								car2) -> (int) (car1
										.getPrice()
										- car2.getPrice())),
						Optional::get));

		long totalCarsValue = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(Collectors
						.summingLong(Car::getPrice));

		LongSummaryStatistics statistics = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(Collectors
						.summarizingLong(Car::getPrice));

		String allBrands = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.map(Car::getBrand)
				.collect(Collectors.joining(","));

		totalCarsValue = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.map(Car::getPrice)
				.collect(Collectors.reducing(0l,
						Function.identity(), Long::sum))
				.longValue();

		Map<String, List<Car>> carsGroupedByBrand = dealers
				.stream().flatMap(d -> d.getCars().stream())
				.collect(Collectors
						.groupingBy(Car::getBrand));

		carsGroupedByBrand = dealers.stream()
				.flatMap(d -> d.getCars().stream()).collect(
						Collectors.groupingBy(Car::getBrand,
								Collectors.toList()));

		Map<String, Set<Car>> carsGroupedByBrandAsSet = dealers
				.stream().flatMap(d -> d.getCars().stream())
				.collect(Collectors.groupingBy(
						Car::getBrand, Collectors.toSet()));

		Map<String, Map<Long, List<Car>>> carsGroupedByBrandAndThenByPrice = dealers
				.stream().flatMap(d -> d.getCars().stream())
				.collect(
						Collectors.groupingBy(Car::getBrand,
								Collectors.groupingBy(
										Car::getPrice)));

		Map<String, Car> maxPricedCarPerBrand = dealers
				.stream().flatMap(d -> d.getCars().stream())
				.collect(Collectors.groupingBy(
						Car::getBrand, Collectors
								.collectingAndThen(
										Collectors
												.maxBy(Comparator
														.comparing(
																Car::getPrice)),
										Optional::get)));

		Map<String, Long> totalNoCarsPerBrand = dealers
				.stream().flatMap(d -> d.getCars().stream())
				.collect(
						Collectors.groupingBy(Car::getBrand,
								Collectors.counting()));

		Map<Boolean, List<Car>> carsWeCanAfford = dealers
				.stream().flatMap(d -> d.getCars().stream())
				.collect(Collectors.partitioningBy(
						car -> car.getPrice() < 1000));

		toListOfCar = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(new ToListCollector());
		
		toListOfCar = dealers.stream()
				.flatMap(d -> d.getCars().stream())
				.collect(ArrayList::new, List::add, List::addAll);
		
		
		
		dealers.stream();
		dealers.stream().parallel().sequential();
		
	}

	static class ToListCollector implements Collector<Car, List<Car>, List<Car>>{

		@Override
		public Supplier<List<Car>> supplier() {
			return ArrayList::new;
		}

		@Override
		public synchronized BiConsumer<List<Car>, Car> accumulator() {
			return List::add;
		}

		@Override
		public synchronized BinaryOperator<List<Car>> combiner() {
			return (list1,list2)->{list1.addAll(list2); return list1;};
		}

		@Override
		public Function<List<Car>, List<Car>> finisher() {
			return Function.identity();
		}

		@Override
		public Set<Characteristics> characteristics() {			
			return EnumSet.of(Characteristics.CONCURRENT);
		}
		
	}
	
	
	

}
