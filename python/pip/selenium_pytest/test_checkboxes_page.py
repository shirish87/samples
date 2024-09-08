import pytest
from selenium import webdriver
from ..common_selenium.home_page import HomePage
from ..common_selenium.checkboxes_page import CheckboxesPage
from ..common import assert_equals


@pytest.fixture
def driver():
    driver = webdriver.Chrome(options=webdriver.ChromeOptions())
    page = HomePage(driver)
    page.click_checkboxes()

    yield driver
    driver.quit()

def test_checkboxes_page(driver):
    page = CheckboxesPage(driver)
    page.run_test(assert_equals)
    driver.save_screenshot('/tmp/test_checkboxes_page.png')
