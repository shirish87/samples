import os
import pytest
from selenium import webdriver
from ..common_selenium.home_page import HomePage
from ..common_selenium.form_authentication_page import FormAuthenticationPage
from ..common import assert_equals


@pytest.fixture
def driver():
    driver = webdriver.Chrome(options=webdriver.ChromeOptions())
    page = HomePage(driver)
    page.click_form_authentication()

    yield driver
    driver.quit()

def test_form_authentication_page(driver):
    page = FormAuthenticationPage(driver)
    page.run_test(assert_equals)

    if os.environ.get("SCREENSHOT", "0") == "1":
        driver.save_screenshot('/tmp/test_form_authentication_page.png')
