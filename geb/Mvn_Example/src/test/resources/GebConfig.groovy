/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.os.ExecutableFinder


File findDriverExecutable() {
    def driverExecutable = new ExecutableFinder().find("geckodriver")
    new File(driverExecutable)
}

driver = {
    new FirefoxDriver()
}

baseUrl = "http://gebish.org"
