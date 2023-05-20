/*import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnitTests {
    @Test
    public void testLogin() {
        // Создаем экземпляр драйвера Chrome
        WebDriver driver = new ChromeDriver();

        // Открываем страницу входа в аккаунт
        driver.get("http://localhost:8080/login");

        // Находим поле ввода логина и вводим тестовые данные
        WebElement loginField = driver.findElement(By.id("username"));
        loginField.sendKeys("d");

        // Находим поле ввода пароля и вводим тестовые данные
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("d");

        // Нажимаем кнопку "Войти"
        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();

        // Проверяем, что после входа мы находимся на странице аккаунта
        WebElement accountPageTitle = driver.findElement(By.id("headerfortest"));
        Assert.assertEquals("Нам доверяют", accountPageTitle.getText());

        // Закрываем браузер
        driver.quit();
    }
}
*/