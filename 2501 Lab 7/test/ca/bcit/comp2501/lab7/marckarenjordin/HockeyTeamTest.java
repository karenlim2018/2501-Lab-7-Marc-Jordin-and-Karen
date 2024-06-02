package ca.bcit.comp2501.lab7.marckarenjordin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HockeyTeamTest
{
    private HockeyPlayer p1;
    private HockeyPlayer p2;
    private HockeyTeam   t1;
    private HockeyTeam   t2;
    private HockeyLeague l1;
    private HockeyLeague l2;

    @BeforeEach
    void setUp()
    {
        HockeyPlayer.resetIdCounter();
        HockeyTeam.resetIdCounter();
        HockeyLeague.resetIdCounter();
        l1 = new HockeyLeague("NHL", 1916);
        l2 = new HockeyLeague("Junior League", 1950);
        t1 = new HockeyTeam("Colorado Avalanche", "Denver", 1980, l1);
        t2 = new HockeyTeam("Vancouver Canucks", "Vancouver", 1985, l2);
        p1 = new HockeyPlayer("John Doe", 180,75,"2005-05-15","left","left winger",t1,20);
        p2 = new HockeyPlayer("Jane Doe", 190,85,"2003-03-13","right","goalie",t2,40);
    }

    @AfterEach
    void tearDown()
    {
        l1 = null;
        l2 = null;
        t1 = null;
        t2 = null;
        p1 = null;
        p2 = null;
    }

    @Test
    void resetIdCounter()
    {
        assertEquals(1, t1.id);
        assertEquals(2, t2.id);
        HockeyTeam.resetIdCounter();
        assertEquals(1, new HockeyTeam("Colorado Avalanche", "Denver", 1980, l1).id);
    }

    @Test
    void addPlayer()
    {
        t1.addPlayer(p1);
        assertEquals(p1, t1.getPlayersList().getFirst());
    }

    @Test
    void removePlayer()
    {
        t1.addPlayer(p1);
        t1.removePlayer(p1);
        assertEquals(0, t1.getPlayersList().size());
    }

    @Test
    void displayPlayersInfo()
    {
        t1.addPlayer(p1);
        t1.addPlayer(p2);
        assertEquals("Player ID: 1\n" +
                "Name: John Doe\n" +
                "Height: 180 cm\n" +
                "Weight: 75 kg\n" +
                "Birth Date: 2005-05-15\n" +
                "Shooting Hand: left\n" +
                "Position: left winger\n" +
                "Current Team: Colorado Avalanche\n" +
                "Last Year Score: 20\n" +
                "\n" +
                "Player ID: 2\n" +
                "Name: Jane Doe\n" +
                "Height: 190 cm\n" +
                "Weight: 85 kg\n" +
                "Birth Date: 2003-03-13\n" +
                "Shooting Hand: right\n" +
                "Position: goalie\n" +
                "Current Team: Colorado Avalanche\n" +
                "Last Year Score: 40\n" +
                "\n",
                t1.displayPlayersInfo());
    }

    @Test
    void getTeamName()
    {
        assertEquals("Colorado Avalanche", t1.getTeamName());
    }

    @Test
    void getPlayersList()
    {
        t1.addPlayer(p1);
        t1.addPlayer(p2);
        assertEquals(p1, t1.getPlayersList().getFirst());
        assertEquals(p2, t1.getPlayersList().get(1));
    }

    @Test
    void transferPlayer()
    {
        t1.addPlayer(p1);
        t2.addPlayer(p2);
        t2.transferPlayer(p2,t1);
        assertEquals(p2,t1.getPlayersList().get(1));
    }

    @Test
    void getExpectedExceptionsName()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            t1 = new HockeyTeam("Colorado Avalanche_________________________________", "Denver", 1980, l1);
        });
        assertTrue(ex.getMessage().equals("Name is too long."));
    }

    @Test
    void getCurrentLeague()
    {
        assertEquals(l1, t1.getCurrentLeague());
    }


    @Test
    void setCurrentLeague()
    {
        t1.setCurrentLeague(l2);
        assertEquals(l2,t1.getCurrentLeague());
    }

    @Test
    void getExpectedExceptionsCity()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            t1 = new HockeyTeam("Colorado Avalanche", "Denver_____________________________________________", 1980, l1);
        });
        assertTrue(ex.getMessage().equals("Name is too long."));
    }

    @Test
    void getExpectedExceptionsFoundationYear()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            t1 = new HockeyTeam("Colorado Avalanche", "Denver", 1874, l1);
        });
        assertTrue(ex.getMessage().equals("Team foundation year must be greater or equal to 1875."));
    }

    @Test
    void getExpectedExceptionsLeague()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            t1 = new HockeyTeam("Colorado Avalanche", "Denver", 1980, null);
        });
        assertTrue(ex.getMessage().equals("Must use an existing league."));
    }

    @Test
    void getExceptionTransferPlayer()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            t1.transferPlayer(p1, null);
        });
        assertTrue(ex.getMessage().equals("Must use an existing team."));

        ex = assertThrows(IllegalArgumentException.class, ()->{
            t1.transferPlayer(p2, t2);
        });
        assertTrue(ex.getMessage().equals("Player must be part of this team."));
    }

}