package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:${environment}.properties"})
public interface Environment extends Config{
	
	@Key("appUrl")
	String appUrl();
	
	@Key("db.url")
	String getDBHostName();
	
	@Key("db.username")
	String getDBUsername();
	
	@Key("db.password")
	String getDBPassword();
}
