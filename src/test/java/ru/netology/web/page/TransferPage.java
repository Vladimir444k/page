package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement amount = $("[data-test-id=amount] input");
    private final SelenideElement from = $("[data-test-id=from] input");
    private final SelenideElement buttonTransfer = $("[data-test-id=action-transfer]");
    private final SelenideElement errorMassage = $("[data-test-if='error-message']");
    //public TransferPage() {
      //  transferHead.shouldBe(visible);
    //}
    public DashboardPage transfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeValidTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

    public void makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amount.setValue(amountToTransfer);
        from.setValue(cardInfo.getCardNumber());
        buttonTransfer.click();
    }

    public void getErrorMassage(String expectedText) {
        errorMassage.should(Condition.exactText(expectedText), Duration.ofSeconds(15))
                .should(Condition.visible);
    }
}