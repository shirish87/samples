import pytest
from selenium import webdriver
from pip.common_selenium.home_page import HomePage
from pip.common_selenium.shadowdom_page import ShadowDOMPage
from pip.common import assert_equals


@pytest.fixture
def driver():
    driver = webdriver.Chrome(options=webdriver.ChromeOptions())
    page = HomePage(driver)
    page.click_shadowdom()

    yield driver
    driver.quit()

def test_dropdown_page(driver):
    page = ShadowDOMPage(driver)
    page.run_test(assert_equals)
