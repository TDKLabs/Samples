from base_test import *
from optestplusplus import *
from page_properties import *

@on_platforms(browsers)
class CrossBrowsersDemo(BaseTest):

    @classmethod
    def setup_class(cls):
        BaseTest.setup_class()

    # verify page title
    def test_automation_practice(self):
    		#go_to(page_url)
    		#click_element(get_element_by_xpath(xpath_women_list))
    		#wait_for_page_to_settle()
    		
        self.driver.get(page_url)
        self.driver.find_element_by_xpath(xpath_women_list).click()
        wait_for_page_to_settle()
        #title = "I am a page title - Sauce Labs"
        #self.assertEqual(title, self.driver.title, "Title does not match!")


if __name__ == '__main__':
    unittest.main()
