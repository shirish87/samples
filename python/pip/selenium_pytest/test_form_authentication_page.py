import pytest
from selenium import webdriver
from pip.common_selenium.home_page import HomePage
from pip.common_selenium.form_authentication_page import FormAuthenticationPage
from pip.common import assert_equals


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
    driver.save_screenshot('/tmp/test_form_authentication_page.png')
