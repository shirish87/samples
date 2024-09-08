from .base_page import BasePage
from selenium.webdriver.remote.webdriver import WebDriver
from selenium.webdriver.common.by import *
from selenium.webdriver.support.select import Select
from typing import Callable, Tuple, Any


class DropdownPage(BasePage):
    dropdown: Tuple[str, str]

    def __init__(self, driver: WebDriver):
        super().__init__(driver)
        self.dropdown = (By.ID, "dropdown")

    def run_test(self, assert_provider: Callable[..., Any]):
        self.select_option_by_value(self.dropdown, "1")
        assert_provider(self.get_selected_option(self.dropdown) == "Option 1")

        self.select_option_by_value(self.dropdown, "2")
        assert_provider(self.get_selected_option(self.dropdown) == "Option 2")

    def select_option_by_value(self, selector_select, value):
        select = self.get_clickable_element(selector_select)
        Select(select).select_by_value(value=value)

    def select_option_by_visible_test(self, selector_select, value):
        select = self.get_clickable_element(selector_select)
        Select(select).select_by_value(value=value)

    def get_selected_option(self, selector_select):
        select = self.get_clickable_element(selector_select)
        return Select(select).first_selected_option.text
