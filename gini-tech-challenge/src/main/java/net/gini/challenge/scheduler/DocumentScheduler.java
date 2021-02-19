package net.gini.challenge.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.gini.challenge.service.DocumentSchedulerService;


/**
 * DocumentScheduler class responsible to start scheduler with weekly rate and update document serial number. 
 */
@Component
@EnableScheduling
public class DocumentScheduler {

	@Autowired
	private DocumentSchedulerService documentSchedulerService;

	/**
	 * Method to trigger cron process to update document serial number
	 * this process will start in weekly asynchronously
	 *  this will start on every Monday at 1 am.
	 *  To test the functionality, please comment the uncommented scheduled annotation and comment out the commented 
	 *  scheduled annotation. this will execute in every 50 seconds with inital delay of 5 seconds.
	 */
	@Scheduled(cron = "0 0 1 * * MON")
	//@Scheduled(initialDelay = 5000, fixedRate = 50000)
	public void documentUpdaterJob(){
		documentSchedulerService.startDocumentUpdaterJobAsync();
	}
}
