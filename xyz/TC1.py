from optestplusplus import *
from page_properties import *


class test_sample(WebBaseTest):

	""" Test case to navigate thru a web page: http://automationpractice.com """

	def test_add_item_to_cart(self):
		go_to(page_url)
		
		maximize_window()		
		click_element(get_element_by_xpath(xpath_women_list))
		wait_for_page_to_settle()
		
		wait_for_element_visible("xpath", xpath_tops_img, 60)
		click_element(get_element_by_xpath(xpath_tops_img))
		
		wait_for_page_to_settle()
		wait_for_element_visible("xpath", xpath_tshirts_img, 60)
		click_element(get_element_by_xpath(xpath_tshirts_img))
		
		
		wait_for_page_to_settle()	
		take_screenshot()
		
		
		
		
