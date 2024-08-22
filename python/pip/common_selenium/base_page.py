from selenium.webdriver.remote.webdriver import WebDriver
from selenium.webdriver.common.by import *
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as Expected
from typing import Callable
import abc


class BasePage(abc.ABC):
    ELEMENT_WAIT = 10
    BASE_URL = "https://the-internet.herokuapp.com/"

    driver: WebDriver

    def __init__(self, driver: WebDriver):
        self.driver = driver

    def get_clickable_element(self, selector):
        return WebDriverWait(self.driver, BasePage.ELEMENT_WAIT).until(Expected.element_to_be_clickable(selector))

    def get_present_element(self, selector):
        return WebDriverWait(self.driver, BasePage.ELEMENT_WAIT).until(Expected.presence_of_element_located(selector))

    @abc.abstractmethod
    def run_test(self, assert_provider: Callable):
        return
