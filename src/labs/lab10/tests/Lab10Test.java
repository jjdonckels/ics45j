package labs.lab10.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import labs.lab10.*;

import org.junit.Before;
import org.junit.Test;


public class Lab10Test {
	
	private final double EPSILON = 1e-3;
	
	List<NetflixTitle> titleList1;
	List<NetflixTitle> titleList2;
	List<NetflixTitle> titleList3;
	List<NetflixTitle> titleList4;
	List<NetflixTitle> titleList5;
	List<NetflixTitle> titleList6;
	List<NetflixTitle> titleListBLANK;
	
	//This method will be executed before all the other methods.
	@Before
	public void before() {
		String path = "res/"; //<- Assign the path of the .csv files to this variable. Do not include the file name, 
								// it will be added below.
		titleList1 = NetflixTitlesReader.readFile(path + "titles.csv");
		titleList2 = NetflixTitlesReader.readFile(path + "titles2.csv");
		titleList3 = NetflixTitlesReader.readFile(path + "titles3.csv");
		titleList4 = NetflixTitlesReader.readFile(path + "titles4.csv");
		titleList5 = NetflixTitlesReader.readFile(path + "titles5.csv");
		titleList6 = NetflixTitlesReader.readFile(path + "titles6.csv");
		titleListBLANK = NetflixTitlesReader.readFile(path + "titlesBLANK.csv");
	}
	

	@Test
	public void problem1() {
		List<NetflixTitle> actual = NetflixTitlesStats.problem1_shortestRuntime(titleList1.stream());
		assertEquals(6, actual.size());
		assertEquals("Angry Birds Toons", actual.get(0).getTitle());
		assertEquals("Dance & Sing With True", actual.get(1).getTitle());
		assertEquals("Julie and the Phantoms", actual.get(2).getTitle());
		assertEquals("Larva", actual.get(3).getTitle());
		assertEquals("Pui Pui Molcar", actual.get(4).getTitle());
		assertEquals("Time to Dance", actual.get(5).getTitle());
		
		actual = NetflixTitlesStats.problem1_shortestRuntime(titleList2.stream());
		assertEquals(2, actual.size());
		assertEquals("Masha and the Bear", actual.get(0).getTitle());
		assertEquals("Shaun the Sheep", actual.get(1).getTitle());
		
		actual = NetflixTitlesStats.problem1_shortestRuntime(titleList3.stream());
		assertEquals(1, actual.size());
		assertEquals("Mighty Little Bheem: Kite Festival", actual.get(0).getTitle());
		
		actual = NetflixTitlesStats.problem1_shortestRuntime(titleListBLANK.stream());
		assertEquals(0, actual.size());
	}
	
	@Test
	public void problem2() {
		assertEquals(10, NetflixTitlesStats.problem2_mostGenresInOneTitle(titleList1.stream()));
		assertEquals(9, NetflixTitlesStats.problem2_mostGenresInOneTitle(titleList2.stream()));
		assertEquals(4, NetflixTitlesStats.problem2_mostGenresInOneTitle(titleList3.stream()));
		assertEquals(5, NetflixTitlesStats.problem2_mostGenresInOneTitle(titleList4.stream()));
		assertEquals(2, NetflixTitlesStats.problem2_mostGenresInOneTitle(titleList5.stream()));
		assertEquals(0, NetflixTitlesStats.problem2_mostGenresInOneTitle(titleList6.stream()));
		assertEquals(0, NetflixTitlesStats.problem2_mostGenresInOneTitle(titleListBLANK.stream()));
	}
	
	@Test
	public void problem3() {
		Map<String, Long> expected = new TreeMap<>();
		assertEquals(expected, NetflixTitlesStats.problem3_countTitlesByProductionCountry(titleListBLANK.stream())); // empty map
		
		expected.put("AR", 1L);
		expected.put("BE", 1L);
		expected.put("CL", 1L);
		expected.put("CN", 3L);
		expected.put("DE", 1L);
		expected.put("GB", 1L);
		expected.put("JP", 3L);
		expected.put("KR", 2L);
		expected.put("NL", 1L);
		expected.put("US", 6L);
		expected.put("ZA", 1L);
		assertEquals(expected, NetflixTitlesStats.problem3_countTitlesByProductionCountry(titleList4.stream()));
		
		expected.clear();
		expected.put("CL", 1L);
		expected.put("CN", 1L);
		expected.put("DE", 1L);
		expected.put("GB", 1L);
		expected.put("US", 1L);
		assertEquals(expected, NetflixTitlesStats.problem3_countTitlesByProductionCountry(titleList5.stream()));
		
		expected.clear();
		expected.put("CA", 1L);
		expected.put("CO", 1L);
		expected.put("US", 4L);
		assertEquals(expected, NetflixTitlesStats.problem3_countTitlesByProductionCountry(titleList6.stream()));
	}
	
	@Test
	public void problem4() {
		assertEquals(26.31578947368421, 
				NetflixTitlesStats.problem4_getPercentageOfGenre(titleList4.stream(), "drama"), 
				EPSILON);
		assertEquals(26.31578947368421, 
				NetflixTitlesStats.problem4_getPercentageOfGenre(titleList4.stream(), "comedy"),
				EPSILON); 
		assertEquals(0, 
				NetflixTitlesStats.problem4_getPercentageOfGenre(titleList5.stream(), "reality"),
				EPSILON); 
		assertEquals(33.33333333333333,
				NetflixTitlesStats.problem4_getPercentageOfGenre(titleList5.stream(), "animation"),
				EPSILON); 
		assertEquals(33.33333333333333,
				NetflixTitlesStats.problem4_getPercentageOfGenre(titleList5.stream(), "drama"),
				EPSILON); 
		assertEquals(66.66666666666666,
				NetflixTitlesStats.problem4_getPercentageOfGenre(titleList5.stream(), "comedy"),
				EPSILON); 
		assertEquals(0, 
				NetflixTitlesStats.problem4_getPercentageOfGenre(titleList6.stream(), "comedy"),
				EPSILON); 
		assertEquals(0, 
				NetflixTitlesStats.problem4_getPercentageOfGenre(titleListBLANK.stream(), "comedy"),
				EPSILON);
	}
	
	@Test
	public void problem5() {
		assertEquals("action, animation, comedy, crime, documentation, drama, family, history, horror, music, reality, romance, sport, thriller",
				NetflixTitlesStats.problem5_getGenres(titleList3.stream()));
		assertEquals("action, animation, comedy, crime, documentation, drama, family, fantasy, music, reality, romance, scifi, thriller",
				NetflixTitlesStats.problem5_getGenres(titleList4.stream()));
		assertEquals("animation, comedy, drama, music", 
				NetflixTitlesStats.problem5_getGenres(titleList5.stream()));
		assertEquals("", NetflixTitlesStats.problem5_getGenres(titleList6.stream())); // blank
		assertEquals("", NetflixTitlesStats.problem5_getGenres(titleListBLANK.stream())); // blank
	}
	
	@Test
	public void problem6() {
		Optional<NetflixTitle> result = 
				NetflixTitlesStats.problem6_getMostPopularTitle(titleList3.stream());
		assertTrue(result.isPresent());
		if (result.isPresent()) {
			NetflixTitle mostPopular = result.get();
			assertEquals("Alma Matters: Inside the IIT Dream", mostPopular.getTitle());
		}
		
		result = NetflixTitlesStats.problem6_getMostPopularTitle(titleList4.stream());
		assertTrue(result.isPresent());
		if (result.isPresent()) {
			NetflixTitle mostPopular = result.get();
			assertEquals("The Surgeon's Cut", mostPopular.getTitle());
		}
		
		result = NetflixTitlesStats.problem6_getMostPopularTitle(titleList5.stream());
		assertTrue(result.isPresent());
		if (result.isPresent()) {
			NetflixTitle mostPopular = result.get();
			assertEquals("Aziz Ansari: Right Now", mostPopular.getTitle());
		}
		
		result = NetflixTitlesStats.problem6_getMostPopularTitle(titleList6.stream());
		assertTrue(result.isPresent());
		if (result.isPresent()) {
			NetflixTitle mostPopular = result.get();
			/* when there are multiple maxes, the one returned is indeterminable, so 
			 will test for any one of them: */
			assertTrue(mostPopular.getTitle().equals("Mad Crazy Colombian Comedians") ||
					mostPopular.getTitle().equals("Plastic Cup Boyz: Laughing My Mask Off!") ||
					mostPopular.getTitle().equals("Ginny & Georgia - The Afterparty") ||
					mostPopular.getTitle().equals("The Circle: The Afterparty") ||
					mostPopular.getTitle().equals("Bling Empire - The Afterparty") ||
					mostPopular.getTitle().equals("Dad Stop Embarrassing Me - The Afterparty"));
		}
		
		result = NetflixTitlesStats.problem6_getMostPopularTitle(titleListBLANK.stream());
		assertFalse(result.isPresent());
	}
	
	@Test
	public void problem7() {
		assertEquals(8.072916666666666, NetflixTitlesStats.problem7_getAverageNumSeasons(titleList2.stream()),
				EPSILON);
		assertEquals(1.0, NetflixTitlesStats.problem7_getAverageNumSeasons(titleList3.stream()),
				EPSILON);
		assertEquals(1.4545454545454546, NetflixTitlesStats.problem7_getAverageNumSeasons(titleList4.stream()),
				EPSILON);
		assertEquals(0.0, NetflixTitlesStats.problem7_getAverageNumSeasons(titleList5.stream()),
				EPSILON);
		assertEquals(1.0, NetflixTitlesStats.problem7_getAverageNumSeasons(titleList6.stream()),
				EPSILON);
		assertEquals(0.0, NetflixTitlesStats.problem7_getAverageNumSeasons(titleListBLANK.stream()),
				EPSILON);
	}
	
	@Test
	public void problem8() {
		List<String> actual = NetflixTitlesStats.problem8_getTitlesReleasedInYears(titleList1.stream(), 1940, 1950);
		assertEquals(1, actual.size());
		assertEquals("Five Came Back: The Reference Films", actual.get(0));
		
		actual = NetflixTitlesStats.problem8_getTitlesReleasedInYears(titleList1.stream(), 1940, 1960);
		assertEquals(7, actual.size());
		assertEquals("Cairo Station", actual.get(0));
		assertEquals("Dark Waters", actual.get(1));
		assertEquals("Five Came Back: The Reference Films", actual.get(2));
		assertEquals("Singapore", actual.get(3));
		assertEquals("The Blazing Sun", actual.get(4));
		assertEquals("Ujala", actual.get(5));
		assertEquals("White Christmas", actual.get(6));
		
		actual = NetflixTitlesStats.problem8_getTitlesReleasedInYears(titleList2.stream(), 1987, 1987);
		assertEquals(6, actual.size());
		assertEquals("Eddie Murphy Raw", actual.get(0));
		assertEquals("Fireman Sam", actual.get(1));
		assertEquals("Full Metal Jacket", actual.get(2));
		assertEquals("Muqaddar Ka Faisla", actual.get(3));
		assertEquals("Sam Kinison: Breaking the Rules", actual.get(4));
		assertEquals("Strange Voices", actual.get(5));
		
		actual = NetflixTitlesStats.problem8_getTitlesReleasedInYears(titleList3.stream(), 1987, 1987);
		assertEquals(0, actual.size());
		
		actual = NetflixTitlesStats.problem8_getTitlesReleasedInYears(titleList5.stream(), 1900, 3000);
		assertEquals(3, actual.size());
		assertEquals("Aziz Ansari: Right Now", actual.get(0));
		assertEquals("Nobody Knows I'm Here", actual.get(1));
		assertEquals("Pets United", actual.get(2));
		
		actual = NetflixTitlesStats.problem8_getTitlesReleasedInYears(titleListBLANK.stream(), 1987, 1987);
		assertEquals(0, actual.size());
	}
	
	@Test
	public void problem9() {
		assertEquals("A River Runs Through It", NetflixTitlesStats.problem9_getFirstTitleContainingStringInDescription(titleList2.stream(), "love").getTitle());
		assertEquals("A Faraway Land", NetflixTitlesStats.problem9_getFirstTitleContainingStringInDescription(titleList3.stream(), "love").getTitle());
		assertEquals("My First First Love", NetflixTitlesStats.problem9_getFirstTitleContainingStringInDescription(titleList4.stream(), "love").getTitle());
		assertNull(NetflixTitlesStats.problem9_getFirstTitleContainingStringInDescription(titleList5.stream(), "love"));
		assertNull(NetflixTitlesStats.problem9_getFirstTitleContainingStringInDescription(titleListBLANK.stream(), "love"));
	}
	
	@Test
	public void problem10() {
		assertEquals(51, NetflixTitlesStats.problem10_countDuplicateTitles(titleList1.stream()));
		assertEquals(2, NetflixTitlesStats.problem10_countDuplicateTitles(titleList2.stream()));
		assertEquals(0, NetflixTitlesStats.problem10_countDuplicateTitles(titleList3.stream()));
		assertEquals(0, NetflixTitlesStats.problem10_countDuplicateTitles(titleListBLANK.stream()));
	}
}
