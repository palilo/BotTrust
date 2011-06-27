package palilo.codejam.test;

import org.junit.Assert;
import org.junit.Test;

import palilo.codejam.BotTrust;

public class BotTrustTest {
	
	@Test
	public void testOneCommandEach(){
		BotTrust bot = new BotTrust(2, "O 1 B 1");
		Assert.assertEquals("Expected: ", "2", bot.getSecondsToExecute());
	}
	
	@Test
	public void testTwoCommandsEachAlwaysForward(){
		BotTrust bot = new BotTrust(4, "O 2 B 1 B 2 O 4");
		Assert.assertEquals("Expected: ", "6", bot.getSecondsToExecute());
	}
		
	@Test
	public void testTwoCommandsOneAndOneCommandOtherAlwaysForward(){
		BotTrust bot = new BotTrust(3, "O 5 O 8 B 100");
		Assert.assertEquals("Expected: ", "100", bot.getSecondsToExecute());
	}
	
	@Test
	public void testTwoCommandsInOnlyOneBotAlwaysForward(){
		BotTrust bot = new BotTrust(2, "B 1 B 2");
		Assert.assertEquals("Expected: ", "3", bot.getSecondsToExecute());
	}
	
	@Test
	public void testTwoCommandsInOnlyOneBotBack(){
		BotTrust bot = new BotTrust(2, "B 2 B 1");
		Assert.assertEquals("Expected: ", "4", bot.getSecondsToExecute());
	}
	
	
	
}
