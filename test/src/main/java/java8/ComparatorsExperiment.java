package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class ComparatorsExperiment {

	class Address {
		String city;
		String county;
		String country;

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCounty() {
			return county;
		}

		public void setCounty(String county) {
			this.county = county;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
	}

	@Test
	public void test() {
		List<Address> list = new ArrayList<>();
		list.sort(Comparator.comparing(Address::getCountry)
				.thenComparing(Address::getCounty)
				.thenComparing(Address::getCity));
	}

}
