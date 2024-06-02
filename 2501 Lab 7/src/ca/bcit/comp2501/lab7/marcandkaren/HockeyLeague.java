package ca.bcit.comp2501.lab7.marcandkaren;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hockey league, including players and teams.
 * @author Marc André Baron-Campeau
 * @author Karen Lim
 * @version 1.0
 */
public class HockeyLeague
{
    private final List<Player> players;
    private final List<Team> teams;
    private final String leagueName;
    private final String country;
    private final String foundedYear;

    /**
     * Constructs a HockeyLeague object.
     * @param leagueName  the name of the league
     * @param country     the country of the league
     * @param foundedYear the year the league was founded
     */
    public HockeyLeague(final String leagueName,
                        final String country,
                        final String foundedYear)
    {
        this.leagueName = leagueName;
        this.country = country;
        this.foundedYear = foundedYear;
        this.players = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    /**
     * Adds a player to the league.
     * @param player the player to add
     */
    public void addPlayer(final Player player)
    {
        players.add(player);
    }

    /**
     * Adds a team to the league.
     * @param team the team to add
     */
    public void addTeam(final Team team)
    {
        teams.add(team);
    }

    /**
     * Gets the list of players in the league.
     * @return the list of players
     */
    public List<Player> getPlayers()
    {
        return players;
    }

    /**
     * Gets the list of teams in the league.
     * @return the list of teams
     */
    public List<Team> getTeams()
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
        for (final Player player : players)
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
        for (final Team team : teams)
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
    public static class Player
    {
        private static int idCounter = 1;
        private final int id;
        private final String name;
        private final int height;
        private final int weight;
        private final String birthDate;
        private final String shootingHand;
        private final String position;
        private String currentTeam;
        private final int lastYearScore;

        /**
         * Constructs a Player object.
         *
         * @param name         the name of the player
         * @param height       the height of the player
         * @param weight       the weight of the player
         * @param birthDate    the birthdate of the player
         * @param shootingHand the shooting hand of the player
         * @param position     the position of the player
         * @param currentTeam  the current team of the player
         * @param lastYearScore the last year score of the player
         */
        public Player(final String name,
                    final int height,
                    final int weight,
                    final String birthDate,
                    final String shootingHand,
                    final String position,
                    final String currentTeam,
                    final int lastYearScore)
        {
            this.id = idCounter++;
            this.name = name;
            this.height = height;
            this.weight = weight;
            this.birthDate = birthDate;
            this.shootingHand = shootingHand;
            this.position = position;
            this.currentTeam = currentTeam;
            this.lastYearScore = lastYearScore;
        }

        /**
         * Resets the player ID counter.
         */
        public static void resetIdCounter()
        {
            idCounter = 1;
        }

        /**
         * Displays the information of the player
         * @return the information of the player
         */
        public String displayInfo()
        {
            return "Player ID: " + id + "\n"
                    + "Name: " + name + "\n"
                    + "Height: " + height + " cm\n"
                    + "Weight: " + weight + " kg\n"
                    + "Birth Date: " + birthDate + "\n"
                    + "Shooting Hand: " + shootingHand + "\n"
                    + "Position: " + position + "\n"
                    + "Current Team: " + currentTeam + "\n"
                    + "Last Year Score: " + lastYearScore + "\n";
        }

        /**
         * Retires the player.
         */
        public void retirePlayer()
        {
            this.currentTeam = null;
        }

        /**
         * Gets the current team of the player.
         * @return the current team of the player
         */
        public String getCurrentTeam()
        {
            return currentTeam;
        }

        /**
         * Sets the current team of the player.
         * @param currentTeam the current team to set
         */
        public void setCurrentTeam(final String currentTeam)
        {
            this.currentTeam = currentTeam;
        }
    }

    /**
     * Represents a team in the hockey league.
     */
    public static class Team
    {
        private final String name;
        private final String city;
        private final String foundedYear;
        private final String leagueName;
        private final List<Player> players;

        /**
         * @param name        the name of the team
         * @param city        the city of the team
         * @param foundedYear the year the team was founded
         * @param leagueName  the league name the team belongs to
         */
        public Team(final String name,
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
        public void addPlayer(final Player player)
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
            for (final Player player : players)
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
        public List<Player> getPlayers()
        {
            return players;
        }
    }


    public static void main(final String[] args)
    {
        final HockeyLeague league = new HockeyLeague
                ("National Hockey League",
                 "USA",
                 "1917");

        final Player player1 = new Player
                ("Alexis Lafreniere",
                185,
                88,
                "2001-10-11",
                "left",
                "winger",
                "New York Rangers",
                57
        );

        final Team teamA = new Team("New York Rangers",
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
