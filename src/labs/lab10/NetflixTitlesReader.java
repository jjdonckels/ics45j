package labs.lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Utility class for reading in a file of Netflix title data
 */
public class NetflixTitlesReader {
	
	/**
	 * Reads in a file of Netflix title data and returns a list of NetflixTitle objects
	 * 
	 * @param filename	name of file containing Netflix title data
	 * 
	 * @return	list of NetflixTitle objects from the file
	 */
	public static List<NetflixTitle> readFile(String filename) {
		List<NetflixTitle> titles = new ArrayList<>();
		try (Scanner in = new Scanner(new File(filename))) {
			if (in.hasNextLine()) {
				in.nextLine(); // consume column heading line
			}
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (line.length() > 0) {
					List<String> fields = getFields(line);
					/*
					 * The format of each line is id,title,type,description,release_year,age_certification,runtime,genres,production_countries,seasons,imdb_id,imdb_score,imdb_votes,tmdb_popularity,tmdb_score
					 */
					
					// skip id (fields[0])
					String title = fields.get(1);
//					System.out.println("title: " + title);
					NetflixTitleType type = NetflixTitleType.getType(fields.get(2));
//					System.out.println("type: " + type);
					String description = fields.get(3);
//					System.out.println("description: " + description);
					int releaseYear = Integer.parseInt(fields.get(4));
//					System.out.println("release year: " + releaseYear);
					String ageCert = fields.get(5);
//					System.out.println("ageCert: " + ageCert);
					int runtime = Integer.parseInt(fields.get(6));
//					System.out.println("runtime: " + runtime);
					List<String> genres = getList(fields.get(7));
//					System.out.println("genres: " + genres);
					List<String> prodCountries = getList(fields.get(8));
//					for (String c : prodCountries) {
//						System.out.println(c);
//					}
//					System.out.println("prodCountries: " + prodCountries);
					String seasonsStr = fields.get(9);
					int seasons = seasonsStr.length() > 0 ? Integer.parseInt(seasonsStr) : 0;
//					System.out.println("seasons: " + seasons);
					// skip imdb_id (fields[10])
					String imdbScoreStr = fields.get(11);
					double imdbScore = imdbScoreStr.length() > 0 ? Double.parseDouble(imdbScoreStr) : 0;
//					System.out.println("imdb score: " + imdbScore);
					String imdbVotesStr = fields.get(12);
					int imdbVotes = imdbVotesStr.length() > 0 ? Integer.parseInt(imdbVotesStr) : 0;
//					System.out.println("imdb votes: " + imdbVotes);
					String tmdbPopularityStr = fields.get(13);
					double tmdbPopularity = 
							tmdbPopularityStr.length() > 0 ? Double.parseDouble(tmdbPopularityStr) : 0;
//					System.out.println("tmdb popularity: " + tmdbPopularity);
					String tmdbScoreStr = fields.size() > 14 ? fields.get(14) : "";
					double tmdbScore = tmdbScoreStr.length() > 0 ? Double.parseDouble(tmdbScoreStr) : 0;
//					System.out.println("tmdbScore: " + tmdbScore);
	
					titles.add(new NetflixTitle(title, type, description, releaseYear, ageCert,
							runtime, genres, prodCountries, seasons, imdbScore, imdbVotes, tmdbPopularity,
							tmdbScore));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File: " + filename + " not found");
		} 
		return titles;
	}


	/**
	 * Extracts a list of strings from a string that contains a list in
	 * square brackets, with each string in single quotes
	 * 
	 * @param str	the input string
	 * 
	 * @return	list of strings with the brackets and single quotes removed
	 */
	private static List<String> getList(String str) {
		
//		System.out.println("original str: " + str);
		
		// if quotes are there, remove them
		if (str.startsWith("\"")) {
			str = str.substring(1, str.length() - 1);
		}
		
		// remove brackets:
		str = str.substring(1, str.length() - 1);
//		System.out.println("str: " + str);
		return str.length() > 0 ?
				Stream.of(str.split(", "))
				.map(s -> s.substring(1, s.length()-1))
				.collect(Collectors.toList())
				: new ArrayList<String>();
	}
	
	
	/**
	 * Extract fields from a String corresponding to a row in the CSV file. 
	 * Handles fields surrounded by quotes.
	 * 
	 * @param row the text of the row
	 * @return a list of fields in the given row
	 */
	private static List<String> getFields(String row) {
		String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
		return Arrays.asList(tokens);
	}
}
