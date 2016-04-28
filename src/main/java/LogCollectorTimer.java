
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import constants.LogCollectorConstants;
import util.SigarUtil;

public class LogCollectorTimer extends TimerTask{
	
	private  Properties configProp = new Properties();
	
	// set this to application name
	final private static Logger logger = LoggerFactory.getLogger(LogCollectorConstants.APPLICATION_NAME);
	
	private static Executor pool = Executors.newFixedThreadPool(1);
	
	@Override
	public void run() {
		runLogCollector();
	}
	
	private void runLogCollector(){
		SigarUtil.logSystemInformation();
	}

	public static void main(String[] args) {
		LogCollectorTimer logCollectorTimerTask = new LogCollectorTimer();
		logCollectorTimerTask.loadProps();
		//int timeInterval=Integer.parseInt(logCollectorTimerTask.configProp.getProperty("time_interval"));
		int timeInterval=Integer.parseInt(args[0]);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(logCollectorTimerTask, LogCollectorConstants.FIRST_DELAY_TIME, 
				timeInterval);//run task after 60 seconds
	}
	
	public  void loadProps() {
        try {
        	 InputStream in = LogCollectorTimer.class.getClassLoader().getResourceAsStream("logcollector.properties");
        	 configProp.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
