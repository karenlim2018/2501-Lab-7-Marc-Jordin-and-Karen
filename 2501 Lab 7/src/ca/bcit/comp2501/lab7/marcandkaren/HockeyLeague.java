package ca.bcit.comp2501.lab7.marcandkaren;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hockey league, including players and teams.
 *
 * @author Karen Lim
 * @author Marc André Baron-Campeau
 *
 * @version 1.0
 */
public class HockeyLeague
{
    private final List<HockeyPlayer> players;
    private final List<HockeyTeam> teams;
    private final String leagueName;
    private final String country;
    private final String foundedYear;

    /**
     * Constructs a HockeyLeague object.
     *
     * @param leagueName  the name of the league
     * @param country     the country of the league
     * @param foundedYear the year the league was founded
     */
    public HockeyLeague(final String leagueName,
                        final String country,
                        final String foundedYear)
    {
        this.leagueName  = leagueName;
        this.country     = country;
        this.foundedYear = foundedYear;
        this.players     = new ArrayList<>();
        this.teams       = new ArrayList<>();
    }

    /**
     * Adds a player to the league.
     * @param player the player to add
     */
    public void addPlayer(final HockeyPlayer player)
    {
        players.add(player);
    }

    /**
     * Adds a team to the league.
     * @param team the team to add
     */
    public void addTeam(final HockeyTeam team)
    {
        teams.add(team);
    }

    /**
     * Gets the list of players in the league.
     * @return the list of players
     */
    public List<HockeyPlayer> getPlayers()
    {
        return players;
    }

    /**
     * Gets the list of teams in the league.
     * @return the list of teams
     */
    public List<HockeyTeam> getTeams()
    {
        return teams;
    }

    /**
     * Displays information about all players in the league.
     * @return the information about all players
     */
    public String displayPlayersInfo()
    {
        final StringBuilder info = new StringBuilder();
        for (final HockeyPlayer player : players)
        {
            info.append(player.displayInfo()).append("\n");
        }
        return info.toString();
    }

    /**
     * Displays information about all teams in the league.
     * @return the information about all teams
     */
    public String displayTeamsInfo()
    {
        final StringBuilder info = new StringBuilder();
        for (final HockeyTeam team : teams)
        {
            info.append("Team Name: ").append(team.getName()).append("\n");
        }
        return info.toString();
    }

    /**
     * Gets the name of the league.
     * @return the league name
     */
    public String getLeagueName()
    {
        return leagueName;
    }

    /**
     * Represents a player in the hockey league.
     */

    /**
     * Represents a team in the hockey league.
     */


    public static void main(final String[] args)
    {
        final HockeyLeague league = new HockeyLeague
                ("National Hockey League",
                 "USA",
                 "1917");

        final HockeyPlayer player1 = new HockeyPlayer
                ("Alexis Lafreniere",
                185,
                88,
                "2001-10-11",
                "left",
                "winger",
                "New York Rangers",
                57
        );

        final HockeyTeam teamA = new HockeyTeam("New York Rangers",
                                    "New York",
                                    "1926",
                                    "National Hockey League");

        teamA.addPlayer(player1);
        league.addTeam(teamA);


        System.out.println("League Information:");
        System.out.println(league.displayTeamsInfo());
        System.out.println("Team Information:");
        System.out.println(teamA.displayPlayersInfo());
    }
}
