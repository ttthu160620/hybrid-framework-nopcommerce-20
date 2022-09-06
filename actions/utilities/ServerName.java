package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:${serverName}.properties"})
public interface ServerName extends Config{
	
	@Key("appUrl")
	String appUrl();
	
	@Key("db.url")
	String getDBHostName();
	
	@Key("db.username")
	String getDBUsername();
	
	@Key("db.password")
	String getDBPassword();
}
