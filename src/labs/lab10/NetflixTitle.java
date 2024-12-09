package labs.lab10;

import java.util.List;

/*
 * Represents a Netflix title
 */
public class NetflixTitle {
	private String title;
	private NetflixTitleType type;
	private String description;
	private int releaseYear;
	private String ageCertification;
	private int runtime;
	private List<String> genres;
	private List<String> productionCountries;
	private int numSeasons;
	private double imdbScore;
	private int imdbVotes;
	private double tmdbPopularity;
	private double tmdbScore;


	/**
	 * Constructs a NetflixTitle
	 * 
	 * @param title
	 * @param type
	 * @param description
	 * @param releaseYear
	 * @param ageCertification
	 * @param runtime
	 * @param genres
	 * @param productionCountries
	 * @param numSeasons
	 * @param imdbScore
	 * @param imdbVotes
	 * @param tmdbPopularity
	 * @param tmdbScore
	 */
	public NetflixTitle(String title, NetflixTitleType type, String description, int releaseYear, 
			String ageCertification, int runtime, List<String> genres, List<String> productionCountries,
			int numSeasons, double imdbScore, int imdbVotes, double tmdbPopularity, double tmdbScore) {
		this.title = title;
		this.type = type;
		this.description = description;
		this.releaseYear = releaseYear;
		this.ageCertification = ageCertification;
		this.runtime = runtime;
		this.genres = genres;
		this.productionCountries = productionCountries;
		this.numSeasons = numSeasons;
		this.imdbScore = imdbScore;
		this.imdbVotes = imdbVotes;
		this.tmdbPopularity = tmdbPopularity;
		this.tmdbScore = tmdbScore;
	}

	public String getTitle() {
		return title;
	}
	
	public NetflixTitleType getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}
	
	public String getAgeCertification() {
		return ageCertification;
	}
	
	public int getRuntime() {
		return runtime;
	}
	
	public List<String> getGenres() {
		return genres;
	}
	
	public List<String> getProductionCountries() {
		return productionCountries;
	}
	
	public int getNumSeasons() {
		return numSeasons;
	}
	
	public double getImdbScore() {
		return imdbScore;
	}
	
	public int getImdbVotes() {
		return imdbVotes;
	}
	
	public double getTmdbPopularity() {
		return tmdbPopularity;
	}
	
	public double getTmdbScore() {
		return tmdbScore;
	}

	@Override
	public String toString() {
		return "Title: " + title + ", Type: " +  type + ", Description: " + description +
				", Release Year: " + releaseYear + ", Age Certification: " +  ageCertification +
				", Runtime: " + runtime + ", Genres: " + genres + ", Production Countries: " +
				productionCountries + ", Num Seasons: " +  numSeasons + ", IMDB Score: " + 
				imdbScore + ", IMDB Votes: " + imdbVotes + ", TMDB Popularity: " + 
				tmdbPopularity + ", TMDB Score: " + tmdbScore;
	}
	
	@Override
	public int hashCode() {
		return title.hashCode();
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof NetflixTitle) {
			NetflixTitle other = (NetflixTitle)otherObject;
			return this.title.equals(other.title) 
					&& this.type == other.type
					&& this.description.equals(other.description)
					&& this.releaseYear == other.releaseYear 
					&& this.ageCertification.equals(other.ageCertification)
					&& this.runtime == other.runtime
					&& this.genres.equals(other.genres)
					&& this.productionCountries.equals(other.productionCountries)
					&& this.numSeasons == other.numSeasons
					&& this.imdbScore == other.imdbScore
					&& this.imdbVotes == other.imdbVotes
					&& this.tmdbPopularity == other.tmdbPopularity
					&& this.tmdbScore == other.tmdbScore;
		}
		return false;
	}
}
