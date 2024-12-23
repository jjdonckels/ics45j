package labs.lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NetflixTitlesStats {
	
	/**
	 * Returns a list that contains the title with the shortest non-zero runtime 
	 * in the Stream.
	 * 
	 * If there are multiple titles with the shortest runtime, returns them
	 * all in the list.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	a list that contains the title with the shortest non-zero runtime 
	 * in the Stream (or multiple if there are > 1)
	 */
	public static List<NetflixTitle> problem1_shortestRuntime(Stream<NetflixTitle> titles) {
		
		Map<Integer, List<NetflixTitle>> result = titles.filter(t -> t.getRuntime() > 0) // filter out non-zero runtimes
				.sorted((a, b) -> a.getTitle().compareTo(b.getTitle())) // sort by title
				.collect(Collectors.groupingBy(t -> t.getRuntime()));
		
		// we now have a map that maps runtime to lists of NetflixTitle objects
		
		// case for empty stream and empty map
		if (result.isEmpty()) return new ArrayList<NetflixTitle>();
		
		// we can find the smallest key for our map and return the list that it maps to
		int minKey = Collections.min(result.keySet());
		return result.get(minKey);
	}
	
	
	/**
	 * Given a Stream of NetflixTitles, returns the most number of genres in one title
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the most number of genres in one title
	 */
	public static int problem2_mostGenresInOneTitle(Stream<NetflixTitle> titles) {
		
		NetflixTitle[] result = titles
				.sorted((a, b) -> b.getGenres().size() - a.getGenres().size()) // sort by most genres
				.limit(1)
				.toArray(NetflixTitle[]::new);
		
		// result should hold the title with the most genres, so now we can return the
		// number of genres from that title
		if (result.length == 0) return 0; // case for empty stream and no results
		return result[0].getGenres().size();
	}
	
	
	/**
	 * Counts how many titles are produced in each country.
	 * Grabs all titles from the stream and groups them by production country. 
	 * Returns a Map<String, Long> that maps production countries to the number
	 * of titles produced in that country.
	 * 
	 * This map should be sorted in ascending order of production country.
	 * 
	 * If the stream is empty, returns an empty map.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	a Map<String, Long> that maps production countries to the number
	 * of titles produced in that country
	 */
	public static Map<String, Long> problem3_countTitlesByProductionCountry(Stream<NetflixTitle> titles) {
		
		// we want to take all the production countries that each title has in it, count them, and put them in a 
		// map where the country's name is mapped to its count
		
		return titles
				.flatMap(t -> t.getProductionCountries().stream()) // create a stream where each element is a production country
				.sorted() // sort by country name
				.collect(Collectors.groupingBy( 
						t -> t, 
						Collectors.counting()));
	}
	
	
	/**
	 * Calculates what percentage of the titles in the stream are of the given genre
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param genre		genre to use for calculation
	 * 
	 * @return	percentage of the titles in the stream are of the given genre
	 */
	public static double problem4_getPercentageOfGenre(Stream<NetflixTitle> titles, String genre) {
		// we can map the titles to a boolean of whether the title contains the genre and put that in an array
		Boolean[] results = titles
				.map(t -> t.getGenres().contains(genre))
				.toArray(Boolean[]::new);
		
		// check for empty stream
		if (results.length == 0) return 0;
		
		// we can make a stream out of the boolean array and count how many true entries are in it
		// then get a percentage of the total from that
		
		long numTrue = Stream.of(results)
				.filter(b -> b == true)
				.count();
		
		return (numTrue / (double) results.length) * 100.0 ;
	}
	
	/**
	 * Given a Stream of NetflixTitles, returns a comma-separated string of all 
	 * the different genres in the stream, sorted in ascending lexicographic order
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	a comma-separated string of all the different genres in 
	 * the stream, sorted in ascending lexicographic order
	 */
	public static String problem5_getGenres(Stream<NetflixTitle> titles) {
		
		// we can put all the genres in a list in a map, and then return that list
		Map<Boolean, List<String>> result = titles
				.flatMap(t -> t.getGenres().stream()) // create a stream of all the genres
				.sorted() // sort the genres by name
				.distinct() // remove duplicates
				.collect(Collectors.groupingBy(
						g -> g.isEmpty(),
						Collectors.toList()));
		
		// case for blank map
		if (result.isEmpty()) return "";
		
		// case for blank genres
		if (result.get(Boolean.FALSE) == null) return "";
		
		// now all the genres should be grouped into a single list in the map under the Boolean.FALSE key
		// we can now return the string representation of that list without the brackets
		String resultStr = result.get(Boolean.FALSE).toString(); // get the string representation of the list
		// remove the brackets from the string representation of the list and return it
		return resultStr.substring(1, resultStr.length() - 1);
	}
	
	
	/**
	 * Returns the most popular title (based on IMDB score) in the stream. 
	 * (Note that title with a blank IMDB score are considered to have a
	 * score of 0)
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the most popular title (based on IMDB score) in the stream
	 */
	public static Optional<NetflixTitle> problem6_getMostPopularTitle(Stream<NetflixTitle> titles) {
		
		return titles.sorted((a, b) -> compareDoubles(a.getImdbScore(), b.getImdbScore())) // sort by highest imdb score
				.findFirst();
	}
	
	// meant to sort doubles greatest to least, a > b returns -1, a < b returns 1, else return 0
	private static int compareDoubles(double a, double b)
	{
		if (a < b) return 1;
		else if (a > b) return -1;
		else return 0;
	}
	
	
	/**
	 * Returns the average number of seasons of NetflixTitles in the stream. 
	 * Only take into account titles with non-zero, non-blank num seasons.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the average number of (non-zero, non-blank) seasons of NetflixTitles in the stream
	 */
	public static double problem7_getAverageNumSeasons(Stream<NetflixTitle> titles) {
		
		Map<Boolean, Double> averages = titles.filter(t -> t.getNumSeasons() > 0) // filter out blank and zero season titles
				.collect(Collectors.groupingBy( t -> 
				t.getNumSeasons() > 0, // group everything into true in the map
						Collectors.averagingInt(NetflixTitle::getNumSeasons))); // average the number of seasons
		
		// case for empty stream and 0 average
		if (averages.isEmpty()) return 0; 
		
		return averages.get(Boolean.TRUE);		
	}
	
	
	/**
	 * Gets a list of titles made in a time frame, given an (inclusive) range of 
	 * years. Titles are sorted in ascending lexicographic order.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param minYear	lower bound of the range of years (inclusive)
	 * @param maxYear	upper bound of the range of years (inclusive)
	 * 
	 * @return	list of titles released in the time frame, sorted in ascending lexicographic order
	 */
	public static List<String> problem8_getTitlesReleasedInYears(Stream<NetflixTitle> titles,
			int minYear, int maxYear) {
		
		return titles.filter(t -> t.getReleaseYear() >= minYear && t.getReleaseYear() <= maxYear) // filter by time frame
				.sorted((a, b) -> a.getTitle().compareTo(b.getTitle())) // sort in title order
				.map(t -> t.getTitle()) // map title objects to title names
				.collect(Collectors.toList());
	}
	
	
	/**
	 * Returns the first NetflixTitle whose description contains the given string (ignoring case),
	 * or else null if none found. "First" here means the first title encountered, when 
	 * considering titles sorted in ascending lexicographic order. So if titles "A", "B", and "C"
	 * all contain the string, title "A" will be found first.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param str		string to search for in titles
	 * 
	 * @return	first NetflixTitle whose description contains the given string (ignoring case),
	 * or else null if none found
	 */
	public static NetflixTitle problem9_getFirstTitleContainingStringInDescription(Stream<NetflixTitle> titles,
			String str) {
		
		NetflixTitle[] result = titles.sorted((a, b) -> a.getTitle().compareTo(b.getTitle())) // sort in title order
				.filter(t -> t.getDescription().toLowerCase().contains(str.toLowerCase())) // filter by titles containing target string
				.limit(1)
				.toArray(NetflixTitle[]::new);
		
		// case for no result
		if (result.length == 0) return null;
		
		return result[0];
	}
	
	
	/**
	 * Given a Stream of NetflixTitles, return the number of NetflixTitles whose title is
	 * a duplicate of another NetflixTitle (case-sensitive)
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the number of duplicate NetflixTitles
	 */
	public static long problem10_countDuplicateTitles(Stream<NetflixTitle> titles) {
		
		Map<String, Long> titleCounts = titles.sorted((a, b) -> a.getTitle().compareTo(b.getTitle())) // sort by title
				.collect(Collectors.groupingBy(
						t -> t.getTitle().toLowerCase(), 
						Collectors.counting()));
		
		// case for empty stream and thus no duplicates
		if (titleCounts.isEmpty()) return 0;
		
		
		// we now have a map that maps titles to the number of elements with that title
		// if we go through the map and add up the numbers, we should have our answer
		Set<String> keySet = titleCounts.keySet();
		
		Stream<String> keyStream = keySet.stream();
		Map<Boolean, Long> result = keyStream.map(s -> titleCounts.get(s) - 1) // map the keys to the number of duplicates
				.collect(Collectors.groupingBy( e -> e > 0, Collectors.counting())); // put count of duplicates into map
		
		
		// case where no duplicates were found but stream wasn't empty
		if (result.get(Boolean.TRUE) == null)
			return 0;
		
		return result.get(Boolean.TRUE);
				
	}
}