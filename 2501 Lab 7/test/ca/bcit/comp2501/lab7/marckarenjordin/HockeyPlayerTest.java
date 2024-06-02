package ca.bcit.comp2501.lab7.marckarenjordin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HockeyPlayerTest
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
        assertEquals(1, p1.id);
        assertEquals(2, p2.id);
        HockeyPlayer.resetIdCounter();
        assertEquals(1, new HockeyPlayer("John Doe", 180,75,"2005-05-15","left","goalie",t1,20).id);
    }

    @Test
    void displayInfo()
    {
        assertEquals("Player ID: 1\nName: John Doe\nHeight: 180 cm\nWeight: 75 kg\nBirth Date: 2005-05-15\nShooting Hand: left\nPosition: left winger\nCurrent Team: Colorado Avalanche\nLast Year Score: 20\n", p1.displayInfo());
        assertEquals("Player ID: 2\nName: Jane Doe\nHeight: 190 cm\nWeight: 85 kg\nBirth Date: 2003-03-13\nShooting Hand: right\nPosition: goalie\nCurrent Team: Vancouver Canucks\nLast Year Score: 40\n", p2.displayInfo());
    }

    @Test
    void retirePlayer()
    {
        p1.retirePlayer();
        assertNull(p1.getCurrentTeam());
    }

    @Test
    void getCurrentTeam()
    {
        assertEquals(t1, p1.getCurrentTeam());
        p1.retirePlayer();
        assertEquals(null, p1.getCurrentTeam());
    }

    @Test
    void setCurrentTeam()
    {
        p1.setCurrentTeam(t2);
        assertEquals(t2, p1.getCurrentTeam());
    }

    @Test
    void getExpectedExceptionsName()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            p1 = new HockeyPlayer("John Doe___________________________________________", 180,75,"2005-05-15","left","left winger",t1,20);
        });
        assertTrue(ex.getMessage().equals("Name is too long."));
    }

    @Test
    void getExpectedExceptionsHeight()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            p1 = new HockeyPlayer("John Doe", -1,75,"2005-05-15","left","left winger",t1,20);
        });
        assertTrue(ex.getMessage().equals("Height must be a positive number greater than 0.0 cm."));
    }

    @Test
    void getExpectedExceptionsWeight()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            p1 = new HockeyPlayer("John Doe", 180,-1,"2005-05-15","left","left winger",t1,20);
        });
        assertTrue(ex.getMessage().equals("Weight must be a positive number greater than 0.0 kg."));
    }

    @Test
    void getExpectedExceptionsShootingHand()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            p1 = new HockeyPlayer("John Doe", 180,75,"2005-05-15","none","right winger",t1,20);
        });
        assertTrue(ex.getMessage().equals("Must be either Right or Left."));
    }

    @Test
    void getExpectedExceptionsPosition()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            p1 = new HockeyPlayer("John Doe", 180,75,"2005-05-15","left","coach",t1,20);
        });
        assertTrue(ex.getMessage().equals("Position must be one of the 6 positions: Goalie, Right Winger, Left Winger, Center, Right Defense, and Left Defense."));
    }

    @Test
    void getExpectedExceptionCurrentTeam()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            p1 = new HockeyPlayer("John Doe", 180,75,"2005-05-15","left","left winger",null,20);
        });
        assertTrue(ex.getMessage().equals("Must use an existing team."));
    }

    @Test
    void getExpectedExceptionsLastYearScore()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            p1 = new HockeyPlayer("John Doe", 180,75,"2005-05-15","left","left winger",t1,-1);
        });
        assertTrue(ex.getMessage().equals("Last year score must be greater or equal to 0."));
    }

}