require 'rubygems'
require 'headless'
require 'minitest/autorun'
require 'selenium-webdriver'

class GoogleTest < MiniTest::Test
  def setup
    @headless = Headless.new
    @headless.start
    @driver = Selenium::WebDriver.for :firefox
  end
 
  def test_post
    @driver.navigate.to "http://www.google.com"
    element = @driver.find_element(:name, 'q')
    element.send_keys "BrowserStack"
    element.submit
    puts "title: #{@driver.title}"
    #assert_equal(@driver.title, "BrowserStack - Google Search")
  end
 
  def teardown
    @driver.quit
    @headless.destroy
  end
end

