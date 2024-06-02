package ca.bcit.comp2501.lab7.marckarenjordin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for HockeyLeague.
 *
 * @author Marc André Baron-Campeau
 * @author Karen Lim
 * @author jordin Pirooz
 *
 * @version 1.0
 */
class HockeyLeagueTest
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
        assertEquals(1, l1.id);
        assertEquals(2, l2.id);
        HockeyLeague.resetIdCounter();
        assertEquals(1, new HockeyLeague("Major League", 1950).id);
    }

    @Test
    void getLeagueName()
    {
        assertEquals("NHL", l1.getLeagueName());
    }

    @Test
    void addTeam()
    {
        l1.addTeam(t2);
        assertEquals(t2, l1.getTeamsList().getLast());
    }

    @Test
    void removeTeam()
    {
        l1.addTeam(t1);
        l1.addTeam(t2);
        assertEquals(2, l1.getTeamsList().size());
        l1.removeTeam(t2);
        assertEquals(t1, l1.getTeamsList().getFirst());
    }

    @Test
    void getTeamsList()
    {
        l1.addTeam(t1);
        l1.addTeam(t2);
        assertEquals(t1, l1.getTeamsList().getFirst());
        assertEquals(t2, l1.getTeamsList().get(1));
    }
}
