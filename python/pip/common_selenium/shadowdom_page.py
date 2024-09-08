from .base_page import BasePage
from selenium.webdriver.remote.webdriver import WebDriver
from selenium.webdriver.common.by import *
from typing import Callable, Tuple, Any


class ShadowDOMPage(BasePage):
    shadow_host_element: Tuple[str, str]
    slot_element: Tuple[str, str]

    def __init__(self, driver: WebDriver):
        super().__init__(driver)
        self.shadow_host_element = (By.CSS_SELECTOR, "my-paragraph")
        self.slot_element = (By.CSS_SELECTOR, "slot")

    def run_test(self, assert_provider: Callable[..., Any]):
        assert_provider(self.get_shadow_dom_text(self.shadow_host_element, self.slot_element) == "My default text")

    def get_shadow_dom_text(self, shadow_host_element, slot_element):
        shadow_host = self.get_present_element(shadow_host_element)
        if not shadow_host.shadow_root:
            raise ValueError("Shadow root is null")

        return shadow_host.shadow_root.find_element(*slot_element).text
