import os
import pytest
from selenium import webdriver
from ..common_selenium.home_page import HomePage
from ..common_selenium.shadowdom_page import ShadowDOMPage
from ..common import assert_equals


@pytest.fixture
def driver():
    driver = webdriver.Chrome(options=webdriver.ChromeOptions())
    page = HomePage(driver)
    page.click_shadowdom()

    yield driver
    driver.quit()

def test_shadowdom_page(driver):
    page = ShadowDOMPage(driver)
    page.run_test(assert_equals)

    if os.environ.get("SCREENSHOT", "0") == "1":
        driver.save_screenshot('/tmp/test_shadowdom_page.png')
