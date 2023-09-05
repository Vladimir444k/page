package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class TransferPage {
    private SelenideElement sumField = $("div[data-test-id=amount] input");
    private SelenideElement accountField = $("span[data-test-id=from] input");
    private SelenideElement topUpButton = $("button[data-test-id=action-transfer]");
    private SelenideElement errorNotification = $("[data-test-id = error-notification]");

    @SneakyThrows
    public DashboardPage successfulTopUp(String sum, String cardNum) {
        sumField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        sumField.setValue(sum);
        accountField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        accountField.setValue(cardNum);
        sleep(5000);
        topUpButton.click();
        return new DashboardPage();
    }

    public void unsuccessfulTopUp(String sum, String cardNum) {
        sumField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        sumField.setValue(sum);
        errorNotification.shouldBe(visible);
    }
}
