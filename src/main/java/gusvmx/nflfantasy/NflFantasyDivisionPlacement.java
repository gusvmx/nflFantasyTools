/**
 * 
 */
package gusvmx.nflfantasy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gus
 *
 */
public class NflFantasyDivisionPlacement {

	/**
	 * @param teamMembers The members in the fantasy league.
	 * @param divisions The divisions or groups in the fantasy league.
	 * @return The maximum number of members per division.
	 */
	public static int getMaxMembersPerDivision(final List<String> teamMembers,
			final List<String> divisions) {
		return (int) Math.ceil(teamMembers.size() * 1F / divisions.size());
	}

	/**
	 * @param teamMembers The members in the fantasy league.
	 * @param divisions The divisions or groups in the fantasy league.
	 * @return A list of available divisions to be picked out.
	 */
	public static List<String> getAvailableDivisions(final List<String> teamMembers,
			final List<String> divisions) {
		int maxMembersPerDivision = getMaxMembersPerDivision(teamMembers, divisions);
		List<String> availableDivisions = new ArrayList<String>();
		for (int i = 0; i < maxMembersPerDivision; i++) {
			availableDivisions.addAll(divisions);
		}
		return availableDivisions;
	}

}
