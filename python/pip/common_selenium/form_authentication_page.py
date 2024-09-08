from .base_page import BasePage
from selenium.webdriver.remote.webdriver import WebDriver
from selenium.webdriver.common.by import *
from selenium.webdriver.support.select import Select
from typing import Callable, Tuple, Any


class FormAuthenticationPage(BasePage):
    input_username: Tuple[str, str]
    input_password: Tuple[str, str]
    button_login: Tuple[str, str]

    def __init__(self, driver: WebDriver):
        super().__init__(driver)
        self.input_username = (By.ID, "username")
        self.input_password = (By.ID, "password")
        self.button_login = (By.CSS_SELECTOR, "button[type='submit']")

    def run_test(self, assert_provider: Callable[..., Any]):
        self.enter_text(self.input_username, "tomsmith")
        self.enter_text(self.input_password, "SuperSecretPassword!")
        self.get_clickable_element(self.button_login).click()
        assert_provider("You logged into a secure area!" in self.driver.page_source)

    def enter_text(self, input_selector, value: str):
        self.get_clickable_element(input_selector).send_keys(value)
