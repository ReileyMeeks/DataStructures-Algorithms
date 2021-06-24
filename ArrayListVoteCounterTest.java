package votecounterproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @version Spring 2019
 * @author clatulip
 */
public class ArrayListVoteCounterTest {

    private ArrayListVoteCounter voteCounter;
    private SithSenateMember sithSenateMember;

    @Before
    public void setUp() throws Exception {
        voteCounter = new ArrayListVoteCounter();
        sithSenateMember = new SithSenateMember("Vader");
        /*
        Data Legend:
            [0] = "Darth Sidius"
            [1] = "Darth Maul"
            [2] = "Darth Vader"
            [3] = "Darth Plagueis"
         */
    }

    @Test
    public void recordVote() {
        // assert both the votes and spoiled votes lists are empty.

        // now, record some votes for one of the candidates. Use the legend 
        // above for clarification
        // using the getSithSenateMemberVotes method, make sure your candidate 
        // actually recieved their votes
        // assert that the size of the votes list has increased.
        assertEquals(voteCounter.getVotes().size(), 0);
        assertEquals(voteCounter.getSpoiledVotes().size(), 0);

        for (int i = 0; i < 100; i++) {
            voteCounter.recordVote(sithSenateMember.getFullName());

            assertEquals(voteCounter.getSithSenateMemberVotes(sithSenateMember.getFullName()), i + 1);
            assertEquals(voteCounter.getVotes().size(), i + 1);
        }
    }
}
