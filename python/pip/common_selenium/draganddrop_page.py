from pip.common_selenium.base_page import BasePage
from selenium.webdriver.remote.webdriver import WebDriver
from selenium.webdriver.common.by import *
from selenium.webdriver import ActionChains
from typing import Callable, Tuple, Any


class DragAndDropPage(BasePage):
    source: Tuple[str, str]
    target: Tuple[str, str]

    def __init__(self, driver: WebDriver):
        super().__init__(driver)
        self.source = (By.ID, "column-a")
        self.target = (By.ID, "column-b")

    def run_test(self, assert_provider: Callable[..., Any]):
        ActionChains(self.driver).drag_and_drop(
            self.get_present_element(self.source), self.get_present_element(self.target)
        ).perform()
        assert_provider(self.get_result(self.target) == "A")

    def get_result(self, selector):
        return self.get_present_element(selector).text
