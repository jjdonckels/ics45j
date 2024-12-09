package labs.lab10;

/**
 * an enum of types for NetflixTitles
 */
public enum NetflixTitleType {
	
	SHOW("SHOW"), MOVIE("MOVIE");
	
	private String typeStr;
	
	private NetflixTitleType(String s) {
		typeStr = s;
	}
	
	@Override
	public String toString() {
		return typeStr;
	}
	
	/**
	 * Gets the type associated with the given string
	 * 
	 * @param s	input string
	 * 
	 * @return	the associated NetflixTitleType
	 */
	public static NetflixTitleType getType(String s) {
		if (s.equals(SHOW.toString())) {
			return SHOW;
		}
		else if (s.equals(MOVIE.toString())) {
			return MOVIE;
		}
		else {
			return null;
		}
	}
}