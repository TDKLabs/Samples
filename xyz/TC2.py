from optestplusplus import *

# Run as: pytest test_sample.py

class test_sample(WebBaseTest):

	""" Test suite to exercise screenshot + page dump capabilities """

	# test_1: trigger false assertion and take screenshot + page source dump
	def test_1(self):
		go_to("http://automationpractice.com/index.php")
		
		click_element(get_element_by_xpath("//a[@title='Women']"))
		
		wait_for_element_visible("xpath", "//a[@title='Tops']/img", 10)
		click_element(get_element_by_xpath("//a[@title='Tops']/img"))
		
		take_screenshot("Click_On_Tops")
		
		#move_to_element(get_element_by_xpath("//img[@title='Faded Short Sleeve T-shirts']"))
		wait_for_element_visible("xpath", "//img[@title='Faded Short Sleeve T-shirts']", 10)
		scroll_to_element(get_element_by_xpath("//img[@title='Faded Short Sleeve T-shirts']"))
		
		take_screenshot("Scroll_To_Faded_Short_Sleeve")
		
		#sleep(2)
		
		#click_element(get_element_by_xpath("//ul[@class='product_list grid row']/li[1]//div[@class='right-block']//a[@title='Proceed to checkout']"))
		
		#click_element(get_element_by_xpath("//a[@title='Proceed to checkout']"))
		
		
