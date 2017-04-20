import time

page_url = "http://automationpractice.com/index.php"

# Home page tabs
women_txt = "Women"
dresses_txt = "Dresses"
tshirts_txt = "T-shirts"

# Women-Menu
tops_txt = "Tops"

# xpaths
xpath_women_list = "//a[@title='Women']"
xpath_tops_img = "//a[@title='Tops']/img"
xpath_tshirts_img = "//div[@class='subcategory-image']/a[@title='T-shirts']/img"


def wait_for_page_to_settle():
	time.sleep(2)
