from .base_page import BasePage
from selenium.webdriver.remote.webdriver import WebDriver
from selenium.webdriver.common.by import *
from selenium.webdriver.support import expected_conditions as Expected
from typing import Callable, Tuple, Any


class CheckboxesPage(BasePage):
    checkbox1: Tuple[str, str]
    checkbox2: Tuple[str, str]

    def __init__(self, driver: WebDriver):
        super().__init__(driver)
        self.checkbox1 = (By.XPATH, "//form[@id='checkboxes']/input[1]")
        self.checkbox2 = (By.XPATH, "//form[@id='checkboxes']/input[2]")

    def run_test(self, assert_provider: Callable[..., Any]):
        # Check the first checkbox
        self.check_checkbox(self.checkbox1)
        assert_provider(self.is_checkbox_checked(self.checkbox1))

        # Uncheck the first checkbox
        self.uncheck_checkbox(self.checkbox1)
        assert_provider(not self.is_checkbox_checked(self.checkbox1))

        # Check the second checkbox
        self.check_checkbox(self.checkbox2)
        assert_provider(self.is_checkbox_checked(self.checkbox2))

        # Uncheck the first checkbox
        self.uncheck_checkbox(self.checkbox2)
        assert_provider(not self.is_checkbox_checked(self.checkbox2))

    def is_checkbox_checked(self, selector_checkbox):
        return self.get_clickable_element(selector_checkbox).is_selected()

    def check_checkbox(self, selector_checkbox):
        elem = self.get_clickable_element(selector_checkbox)
        if not self.is_checkbox_checked(elem):
            elem.click()

    def uncheck_checkbox(self, selector_checkbox):
        elem = self.get_clickable_element(selector_checkbox)
        if self.is_checkbox_checked(elem):
            elem.click()
