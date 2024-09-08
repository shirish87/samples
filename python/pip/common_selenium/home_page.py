from .base_page import BasePage
from selenium.webdriver.remote.webdriver import WebDriver
from selenium.webdriver.common.by import *
from typing import Callable, Tuple, Any


class HomePage(BasePage):
    form_authentication_link: Tuple[str, str]
    checkboxes_link: Tuple[str, str]
    dropdown_link: Tuple[str, str]
    shadowdom_link: Tuple[str, str]
    draganddrop_link: Tuple[str, str]

    def __init__(self, driver: WebDriver, page_url=BasePage.BASE_URL):
        super().__init__(driver)
        driver.get(page_url)

        self.form_authentication_link = (By.LINK_TEXT, "Form Authentication")
        self.checkboxes_link = (By.LINK_TEXT, "Checkboxes")
        self.dropdown_link = (By.LINK_TEXT, "Dropdown")
        self.shadowdom_link = (By.LINK_TEXT, "Shadow DOM")
        self.draganddrop_link = (By.LINK_TEXT, "Drag and Drop")

    def run_test(self, assert_provider: Callable[..., Any]):
        pass

    def click_form_authentication(self):
        self.get_clickable_element(self.form_authentication_link).click()

    def click_checkboxes(self):
        self.get_clickable_element(self.checkboxes_link).click()

    def click_dropdown(self):
        self.get_clickable_element(self.dropdown_link).click()

    def click_shadowdom(self):
        self.get_clickable_element(self.shadowdom_link).click()

    def click_draganddrop(self):
        self.get_clickable_element(self.draganddrop_link).click()
