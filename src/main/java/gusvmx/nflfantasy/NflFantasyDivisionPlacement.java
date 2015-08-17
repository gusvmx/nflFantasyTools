/**
 * 
 */
package gusvmx.nflfantasy;

import java.util.List;

/**
 * @author gus
 *
 */
public class NflFantasyDivisionPlacement {

	public static int getMaxMembersPerDivision(List<String> teamMembers,
			List<String> divisions) {
		return (int) Math.ceil(teamMembers.size() * 1F / divisions.size());
	}

}
