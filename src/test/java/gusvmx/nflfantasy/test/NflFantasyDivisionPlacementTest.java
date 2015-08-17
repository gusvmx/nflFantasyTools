/**
 * 
 */
package gusvmx.nflfantasy.test;

import gusvmx.nflfantasy.NflFantasyDivisionPlacement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gus
 *
 */
public class NflFantasyDivisionPlacementTest {

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
}
