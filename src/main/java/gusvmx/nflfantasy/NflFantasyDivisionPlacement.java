/**
 * 
 */
package gusvmx.nflfantasy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	/**
	 * @param elements The list of elements to choose from.
	 * @return A random element from the list.
	 */
	public static String getAndRemoveRandomElement(final List<String> elements) {
		if (elements.isEmpty()) {
			throw new IllegalArgumentException("List can't be empty.");
		}
		String element = null;
		int size = elements.size();
		int elementToRemove = 0;
		if (size > 1) {
			Random random = new Random();
			elementToRemove = random.nextInt(size);
		}
		element = elements.remove(elementToRemove);
		return element;
	}
	
	/**
	 * @param members The members in the fantasy league.
	 * @param divisions The divisions in the fantasy league.
	 * @return A list containing string showing what division a member belongs to.
	 */
	public static List<String> placeMembersAmongDivisions(final List<String> members, final List<String> divisions) {
		List<String> availableDivisions = NflFantasyDivisionPlacement.getAvailableDivisions(members, divisions);
		List<String> availableMembers = new ArrayList<String>(members);
		List<String> placement = new ArrayList<String>();
		int teamMembersSize = members.size();
		for (int i = 0; i < teamMembersSize; i++) {
			String teamMember = getAndRemoveRandomElement(availableMembers);
			String division = getAndRemoveRandomElement(availableDivisions);
			placement.add("Team '" + teamMember + "' goes to division '" + division + "'");
		}
		return placement;
	}

}
