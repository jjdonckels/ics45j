package labs.lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
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
		Map<Integer, List<NetflixTitle>>  groups = new TreeMap<>();
		groups = titles
				.filter(t -> t.getRuntime() > 0) // filter out non-zero runtimes
				.sorted((a, b) -> a.getTitle().compareTo(b.getTitle())) // sort alphabetically
				.collect(Collectors.groupingBy(
						t -> t.getRuntime())); // get keys based off runtime
		
		// now we have a map that maps runtime to a list of titles with that runtime
		// we want to get the list with the smallest runtime
		
		// we can traverse the key set and put all keys in an array list
		// the smallest key in the array list is the one we want
		Set<Integer> keys = groups.keySet();		
		ArrayList<Integer> keyList = new ArrayList<>();
		
		// add each key to the array list
		for (int key : keys)
			keyList.add(key);
		
		// case for empty keys meaning map was empty after processing stream
		if (keyList.isEmpty()) return new ArrayList<NetflixTitle>(); // return empty list of titles
		
		// sort array list so smallest key is at front
		Collections.sort(keyList);
		
		return groups.get(keyList.get(0)); // return the list mapped to the smallest non-zero key
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
		return null; // FIX ME
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
		return -1; // FIX ME
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
		return ""; // FIX ME
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
		return null; // FIX ME
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
		return -1; // FIX ME
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
		return null; // FIX ME
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
		return null; // FIX ME
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
		return -1; // FIX ME
	}
}