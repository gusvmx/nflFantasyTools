/**
 * 
 */
package gusvmx.nflfantasy.test;

import gusvmx.nflfantasy.NflFantasyDivisionPlacement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author gus
 *
 */
public class NflFantasyDivisionPlacementTest {

	/***/
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	/***/
	@Test
	public final void getMaxMembersPerDivisionWhenDivisionWillNotBeEven() {
		List<String> teamMembers = Arrays.asList(
				"Team1", 
				"Team2",
				"Team3");
		List<String> divisions = Arrays.asList(
				"Div1",
				"Div2");
		Assert.assertEquals(2, NflFantasyDivisionPlacement.getMaxMembersPerDivision(teamMembers, divisions));
	}
	
	/***/
	@Test
	public final void getMaxMembersPerDivisionWhenDivisionWillBeEven() {
		List<String> teamMembers = Arrays.asList(
				"Team1", 
				"Team2",
				"Team3",
				"Team4");
		List<String> divisions = Arrays.asList(
				"Div1",
				"Div2");
		Assert.assertEquals(2, NflFantasyDivisionPlacement.getMaxMembersPerDivision(teamMembers, divisions));
	}
	
	/***/
	@Test
	public final void getAvailableDivisions() {
		List<String> teamMembers = Arrays.asList(
				"Team1", 
				"Team2",
				"Team3",
				"Team4");
		List<String> divisions = Arrays.asList(
				"Div1",
				"Div2");
		List<String> availableDivisions = NflFantasyDivisionPlacement.getAvailableDivisions(teamMembers, divisions);
		Assert.assertEquals(4, availableDivisions.size());
		Assert.assertEquals("Div1", availableDivisions.get(0));
		Assert.assertEquals("Div1", availableDivisions.get(2));
	}
	
	/***/
	@Test
	public final void getAndRemoveRandomElementFromList() {
		List<String> teamMembers = new ArrayList<String>();
		teamMembers.add("Team1");
		teamMembers.add("Team2");
		teamMembers.add("Team3");
		teamMembers.add("Team4");
		String member = NflFantasyDivisionPlacement.getAndRemoveRandomElement(teamMembers);
		Assert.assertEquals(3, teamMembers.size());
		Assert.assertFalse(teamMembers.contains(member));
	}
	
	/***/
	@Test
	public final void getAndRemoveRandomElementFromListOfOneElement() {
		List<String> teamMembers = new ArrayList<String>();
		teamMembers.add("Team1");
		String member = NflFantasyDivisionPlacement.getAndRemoveRandomElement(teamMembers);
		Assert.assertEquals("Team1", member);
		Assert.assertTrue(teamMembers.isEmpty());
	}
	
	/***/
	@Test
	public final void getAndRemoveRandomElementFromEmptyList() {
		expectedException.expect(IllegalArgumentException.class);
		List<String> teamMembers = new ArrayList<String>();
		NflFantasyDivisionPlacement.getAndRemoveRandomElement(teamMembers);
	}
	
	/***/
	@Test
	public final void placeMembersWithinDivision() {
		List<String> TEAM_MEMBERS = Arrays.asList(
				"Caballos cimarron", 
				"Los arrolladores",
				"Elmer Homero",
				"Alquimistas",
				"Ke PANDA jada",
				"Stalkers",
				"Rush",
				"BILLieverS",
				"Dime Vaquero",
				"White Hawk Brotherhood",
				"35ers",
				"Tang");
		List<String> DIVISIONS = Arrays.asList(
				"Receta de la abuela",
				"Manos de mantequilla",
				"Hormigas tackleadoras");
		List<String> result = NflFantasyDivisionPlacement.placeMembersAmongDivisions(TEAM_MEMBERS, DIVISIONS);
		Assert.assertEquals(12, result.size());
	}
	
	/***/
	@Test
	public final void placeMembersWithinDivisionWhenDivisionsAreNotEven() {
		List<String> TEAM_MEMBERS = Arrays.asList(
				"Caballos cimarron", 
				"Los arrolladores",
				"Elmer Homero",
				"Alquimistas",
				"Ke PANDA jada",
				"Stalkers",
				"Rush",
				"BILLieverS",
				"Dime Vaquero",
				"Tang");
		List<String> DIVISIONS = Arrays.asList(
				"Receta de la abuela",
				"Manos de mantequilla",
				"Hormigas tackleadoras");
		List<String> result = NflFantasyDivisionPlacement.placeMembersAmongDivisions(TEAM_MEMBERS, DIVISIONS);
		Assert.assertEquals(10, result.size());
	}
}
