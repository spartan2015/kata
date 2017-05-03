package amazon;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class Q2 {
	
	private static final Comparator<Movie> MIN_COMPARATOR = Comparator.comparing(Movie::getRating);
	private static final Comparator<Movie> MAX_COMPARATOR = MIN_COMPARATOR.reversed();

	/**
	 * return a list of N highest rated movies
	 * 
	 * @param movie
	 * @param N
	 * @return
	 */
	public Set<Movie> getMovieRecommendations(Movie movie, int N) {
		BitSet bitset = new BitSet(Integer.MAX_VALUE);
		PriorityQueue<Movie> maxPq = new PriorityQueue<>(MAX_COMPARATOR);
		PriorityQueue<Movie> minPq = new PriorityQueue<>(MIN_COMPARATOR);
		Queue<Movie> scanQueue = new LinkedList<>();
		scanQueue.addAll(movie.getSimilarMovies());
		
		while(!scanQueue.isEmpty()){
			Movie currentMovie = scanQueue.poll();
			if (!bitset.get(currentMovie.getId())){
				bitset.set(currentMovie.getId());
				// would improve by keeping the list small here - removing from maxPq if we find an element greater then min there
				maxPq.add(currentMovie);
				
			}
			scanQueue.addAll(currentMovie.getSimilarMovies());
		}
		
		HashSet set = convertToSet(N, maxPq);
		return set;
	}


	private HashSet convertToSet(int N, PriorityQueue<Movie> maxPq) {
		HashSet set = new HashSet<>();
		for(int i = 0 ; i < N & !maxPq.isEmpty(); i++){
			set.add(maxPq.remove());
		}
		return set;
	}

	private boolean less(Movie movie1, Movie movie2) {
		return MAX_COMPARATOR.compare(movie1, movie2) > 0;
	}
	
	/**
	 * tests below
	 * 
	 */
	
	@Test
	public void t(){
		Movie a = new Movie(1, 1.2f);
		Movie b = new Movie(2, 3.6f);
		Movie c = new Movie(3, 2.4f);
		
		a.addSimilarMovie(b);
		a.addSimilarMovie(c);
		
		assertTrue(1 == Arrays.asList(a,b,c).stream().limit(1).collect(Collectors.toSet()).size());
		
	}
	
	@Test
	public void lessTest(){
		
		assertTrue(less(new Movie(1,1f), new Movie(2,2)));
	}
	
	
	@Test
	public void test1(){
		Movie a = new Movie(1, 1.2f);
		Movie b = new Movie(2, 3.6f);
		Movie c = new Movie(3, 2.4f);
		
		a.addSimilarMovie(b);
		a.addSimilarMovie(c);
		
		Movie d = new Movie(4, 4.8f);
		
		b.addSimilarMovie(d);
		c.addSimilarMovie(d);
		
		assertTrue(new HashSet(Arrays.asList(d,b)).equals(getMovieRecommendations(a, 2)));
		
		assertTrue(new HashSet(Arrays.asList(c,b,d)).equals(getMovieRecommendations(a, 10)));
		
	}
	
	@Test
	public void streamOverPQDoesntWork(){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		 
		pq.add(3);
		pq.add(2);
		pq.add(1);
		 
		System.out.println(pq.stream().limit(2).collect(Collectors.toSet()));
		 
	}
}
