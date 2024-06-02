package ca.bcit.comp2501.lab7.marckarenjordin;

import java.util.ArrayList;

/**
 * Represents a hockey league, including players and teams.
 *
 * @author Karen Lim
 * @author Marc André Baron-Campeau
 * @author Jordin Pirooz
 *
 * @version 1.0
 */
public class HockeyLeague
{
            final int    id;
    private final String leagueName;
    private final int    leagueFoundationYear;
    private final ArrayList<HockeyTeam> teams;

    private static final int LEAGUE_NAME_LENGTH         = 50;
    private static final int LEAGUE_MIN_FOUNDATION_YEAR = 1875;
    private static       int LEAGUE_ID_COUNTER          = 1;

    /**
     * Creates a hockey league.
     *
     * @param leagueName           the name of the league
     * @param leagueFoundationYear the year the league was founded
     *
     * @throws IllegalArgumentException
     */
    public HockeyLeague(final String leagueName,
                        final int    leagueFoundationYear)
    throws IllegalArgumentException
    {
        if(leagueName.length() > LEAGUE_NAME_LENGTH)
        {
            throw new IllegalArgumentException("Name is too long.");
        }
        if(leagueFoundationYear < LEAGUE_MIN_FOUNDATION_YEAR)
        {
            throw new IllegalArgumentException("League foundation year must be greater or equal to " + LEAGUE_MIN_FOUNDATION_YEAR + ".");
        }

        this.id                   = LEAGUE_ID_COUNTER;
        this.leagueName           = leagueName;
        this.leagueFoundationYear = leagueFoundationYear;
        this.teams                = new ArrayList<>();

        LEAGUE_ID_COUNTER++;
    }

    /**
     * Resets the league ID counter.
     */
    public static void resetIdCounter()
    {
        LEAGUE_ID_COUNTER = 1;
    }

    /**
     * Gets the name of the league.
     *
     * @return the league name
     */
    public String getLeagueName()
    {
        return leagueName;
    }

    /**
     * Adds a team to the league.
     *
     * @param team the team to add
     */
    public void addTeam(final HockeyTeam team)
    {
        if(!teams.contains(team))
        {
            teams.add(team);
            team.setCurrentLeague(this);
        }
    }

    /**
     * Removes a team from the league.
     *
     * @param team the team to remove
     */
    public void removeTeam(final HockeyTeam team)
    {
        if(teams.contains(team))
        {
            team.leaveLeague();
            teams.remove(team);
        }
    }

    /**
     * Gets the list of teams in the league.
     *
     * @return the list of teams
     */
    public ArrayList<HockeyTeam> getTeamsList()
    {
        return teams;
    }
}
