import pytest
from selenium import webdriver
from pip.common_selenium.home_page import HomePage
from pip.common_selenium.draganddrop_page import DragAndDropPage
from pip.common import assert_equals


@pytest.fixture
def driver():
    driver = webdriver.Chrome(options=webdriver.ChromeOptions())
    page = HomePage(driver)
    page.click_draganddrop()

    yield driver
    driver.quit()

def test_dropdown_page(driver):
    page = DragAndDropPage(driver)
    page.run_test(assert_equals)
