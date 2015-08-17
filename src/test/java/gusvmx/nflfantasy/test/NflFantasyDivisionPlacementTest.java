/**
 * 
 */
package gusvmx.nflfantasy.test;

import gusvmx.nflfantasy.NflFantasyDivisionPlacement;

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
}
