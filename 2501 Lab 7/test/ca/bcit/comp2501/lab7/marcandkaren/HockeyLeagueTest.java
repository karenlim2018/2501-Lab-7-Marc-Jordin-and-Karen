package ca.bcit.comp2501.lab7.marcandkaren;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for HockeyLeague.
 * @author Marc André Baron-Campeau
 * @author Karen Lim
 * @version 1.0
 */
class HockeyLeagueTest
{
    private HockeyPlayer p1;
    private HockeyTeam t1;
    private HockeyLeague league1;

    @BeforeEach
    void setUp()
    {
        p1.resetIdCounter();

        p1 = new HockeyLeague.Player
                ("John Doe",
                180,
                75,
                "2005-05-15",
                "left",
                "forward",
                "Team A",
                20);

        t1 = new HockeyLeague.Team
                ("Team A",
                "Vancouver",
                "2000",
                "League 1");

        league1 = new HockeyLeague("League 1",
                                   "Canada",
                                   "2000");

        t1.addPlayer(p1);
        league1.addTeam(t1);
    }

    @AfterEach
    void tearDown()
    {

    }


    @Test
    void testPlayerInfoDisplay()
    {
        final String expectedOutput = "Player ID: 1\n"
                + "Name: John Doe\n"
                + "Height: 180 cm\n"
                + "Weight: 75 kg\n"
                + "Birth Date: 2005-05-15\n"
                + "Shooting Hand: left\n"
                + "Position: forward\n"
                + "Current Team: Team A\n"
                + "Last Year Score: 20\n";
        assertEquals(expectedOutput, p1.displayInfo());
    }

    @Test
    void testRetirePlayer()
    {
        p1.retirePlayer();
        assertNull(p1.getCurrentTeam());
    }


    @Test
    void testGetPlayerLeague()
    {
        assertEquals("Team A", p1.getCurrentTeam());
    }


    @Test
    void testTeamInfoDisplay()
    {
        final String expectedOutput = "Player ID: 1\n"
                + "Name: John Doe\n"
                + "Height: 180 cm\n"
                + "Weight: 75 kg\n"
                + "Birth Date: 2005-05-15\n"
                + "Shooting Hand: left\n"
                + "Position: forward\n"
                + "Current Team: Team A\n"
                + "Last Year Score: 20\n\n";
        assertEquals(expectedOutput, t1.displayPlayersInfo());
    }

    /**
     * Tests the league info display.
     */
    @Test
    void testLeagueInfoDisplay()
    {
        final String expectedOutput = "Team Name: Team A\n";
        assertEquals(expectedOutput, league1.displayTeamsInfo());
    }
}
