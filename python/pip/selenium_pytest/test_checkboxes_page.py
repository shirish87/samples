import pytest
from selenium import webdriver
from pip.common_selenium.home_page import HomePage
from pip.common_selenium.checkboxes_page import CheckboxesPage
from pip.common import assert_equals


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
