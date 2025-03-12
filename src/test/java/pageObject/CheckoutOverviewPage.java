package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='summary_total_label']")
	WebElement totalPriceElement;
	@FindBy(id = "finish")
	WebElement finishBtn;

	// Method to get the final price displayed on the webpage
	public Double finalPrice() {
		String priceText = totalPriceElement.getText();
		priceText = priceText.substring(priceText.indexOf("$") + 1);
		return Double.parseDouble(priceText);
	}

	// Method to click on finish button
	public void clickOnFinish() {
		Actions action = new Actions(driver);
		action.moveToElement(finishBtn);
		action.perform();
		finishBtn.click();
	}
}