from optestplusplus import *

# Run as: pytest test_sample.py

class test_sample(WebBaseTest):

	""" Test suite to exercise screenshot + page dump capabilities """

	# test_1: trigger false assertion and take screenshot + page source dump
	def test_1(self):
		go_to("http://automationpractice.com/index.php")
		
		click_element(get_element_by_xpath("//a[@title='Women']"))
		
		click_element(get_element_by_xpath("//a[@title='Tops']/img"))
		
		move_to_element(get_element_by_xpath("//img[@title='Faded Short Sleeve T-shirts']"))
		
		sleep(2)
		
		click_element(get_element_by_xpath("//ul[@class='product_list grid row']/li[1]//div[@class='right-block']//a[@title='Proceed to checkout']"))
		
		#click_element(get_element_by_xpath("//a[@title='Proceed to checkout']"))
		
		
