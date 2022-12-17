package br.atos.xlo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	@Scheduled(cron = "*/30 * 20 * * *")
	public void funcionouScheduler() {
		System.out.println("oi, job!");
		
	}
	
	
}
