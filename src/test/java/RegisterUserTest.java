import io.qameta.allure.junit4.DisplayName;
import junitparams.JUnitParamsRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.stellar.burgers.ui.model.LoginPage;
import org.stellar.burgers.ui.model.MainPage;
import org.stellar.burgers.ui.model.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static org.stellar.burgers.ui.Browser.browserChoice;
import static org.stellar.burgers.ui.Browser.closeNotChromeBrowser;
import static org.stellar.burgers.ui.generator.UserGenerator.*;

@RunWith(JUnitParamsRunner.class)
@DisplayName("Регистрация")
public class RegisterUserTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    String newEmail;
    @BeforeClass
    public static void beforeAll() {
        browserChoice();
    }
    @Before
    public void setUp() {
        mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        mainPage.clickSignInButton();
        loginPage = page(LoginPage.class);
        loginPage.clickRegisterLink();
        registrationPage = page(RegistrationPage.class);
        newEmail = getNewRandomEmail();
    }

    @After
    public void tearDown(){
        clearBrowserLocalStorage();
    }

    @AfterClass
    public static void afterAll() {
        closeNotChromeBrowser();
    }

    @Test
    @DisplayName("Регистрация с валидными данными")
    public void registerUserSuccessfully() {
        registrationPage.register(DEFAULT_NAME, newEmail, DEFAULT_PASSWORD);
        loginPage.login(newEmail, DEFAULT_PASSWORD);
        Assert.assertTrue(mainPage.checkIsCheckOutButtonEnabled());
    }
    @Test
    @DisplayName("Регистрация со слишком коротким паролем")
    public void registerUserWithShortPassword() {
        registrationPage.register(DEFAULT_NAME, newEmail, SHORT_PASSWORD);
        Assert.assertTrue(registrationPage.checkIsIncorrectPasswordTextVisible());
    }
}