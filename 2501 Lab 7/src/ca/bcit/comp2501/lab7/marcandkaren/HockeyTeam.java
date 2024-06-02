package ca.bcit.comp2501.lab7.marcandkaren;

import java.util.ArrayList;
import java.util.List;

/**
 * A hockey team in a league.
 *
 * @author Marc André Baron-Campeau
 * @author Karen Lim
 *
 * @version 1.0
 */
public class HockeyTeam
{
    private final String name;
    private final String city;
    private final String foundedYear;
    private final String leagueName;
    private final List<HockeyPlayer> players;

    /**
     * @param name        the name of the team
     * @param city        the city of the team
     * @param foundedYear the year the team was founded
     * @param leagueName  the league name the team belongs to
     */
    public HockeyTeam(final String name,
                final String city,
                final String foundedYear,
                final String leagueName)
    {
        this.name = name;
        this.city = city;
        this.foundedYear = foundedYear;
        this.leagueName = leagueName;
        this.players = new ArrayList<>();
    }

    /**
     * Adds a player to the team.
     * @param player the player to add
     */
    public void addPlayer(final HockeyPlayer player)
    {
        players.add(player);
    }

    /**
     * Displays information about all players in the team.
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
     * Gets the name of the team.
     * @return the team name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the list of players in the team.
     * @return the list of players
     */
    public List<HockeyPlayer> getPlayers()
    {
        return players;
    }
}
