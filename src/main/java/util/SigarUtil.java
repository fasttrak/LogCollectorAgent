package util;

import java.math.BigDecimal;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetConnection;
import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import constants.LogCollectorConstants;

public class SigarUtil {

	// set this to application name
	final private static Logger logger = LoggerFactory.getLogger(LogCollectorConstants.APPLICATION_NAME);

	private static Sigar sigar = new Sigar();

	public static void logSystemInformation() {
		Mem memory = null;
		try {
			memory = sigar.getMem();
			/*logger.info(new StringBuilder(SigarConstants.ACTUAL_TOTAL_FREE_SYSTEM_MEMORY).append(Long.toString(memory.getActualFree() / 1024 / 1024)).toString());
			logger.info(new StringBuilder(SigarConstants.ACTUAL_TOTAL_USED_SYSTEM_MEMORY).append(Long.toString(memory.getFree() / 1024 / 1024)).toString());
			logger.info(new StringBuilder(SigarConstants.TOTAL_FREE_SYSTEM_MEMORY).append(Long.toString(memory.getRam() / 1024 / 1024)).toString());
			logger.info(new StringBuilder(SigarConstants.SYSTEM_RANDOM_ACCESS_MEMORY).append(Long.toString(memory.getTotal() / 1024 / 1024)).toString());
			logger.info(new StringBuilder(SigarConstants.TOTAL_USED_SYSTEM_MEMORY).append(Long.toString(memory.getUsed() / 1024 / 1024)).toString());*/
			NetInterfaceConfig  netInterfaceConfig=sigar.getNetInterfaceConfig();
			String systemIPAddress=netInterfaceConfig.getAddress();
			BigDecimal usedMemoryPercentageBD=new BigDecimal(memory.getUsedPercent());
			String usedMemoryPercentage=usedMemoryPercentageBD.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
			BigDecimal usedCPUPercentageBD=new BigDecimal(sigar.getCpuPerc().getCombined()*100);
			String usedCPUPercentage=usedCPUPercentageBD.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
			logger.info(systemIPAddress+","+usedCPUPercentage+","+usedMemoryPercentage);
		} catch (SigarException se) {
			se.printStackTrace();
		}
	}

}
