package BusinessLogic;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Models.Buyer;
import Models.SoldProduct;

class SellerTest {

	Seller seller = new Seller();
	
	Buyer buyer = new Buyer("Miguel Jordan","12345678", "mail@mail.com", "Av. America", "Money", "123456");
	
	SoldProduct soldProduct = new SoldProduct("descripcion del producto", (float) 40.5, 1,"cash");
	
	
	@Test
	void saveReceiptTest() throws IOException, GeneralSecurityException, Exception {
		assertTrue(seller.saveReceipt(buyer, soldProduct));
	}

	@Test
	void getReceiptTest() throws Exception {
		System.out.println(seller.getReceipt("Miguel Jordan"));
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date currentDate = new Date();
        String stringDate = formatter.format(currentDate);
        
		assertEquals("{SoldDate="+ stringDate +", UnitPrice=40.5, Email=mail@mail.com,"
				+ " Description=descripcion del producto, Address=Av. America,"
				+ " Ci=12345678, FullName=Miguel Jordan, Currency=cash, "
				+ "PaymentMethod=Money, Quantity=1, CreditCardNumber=XX3456}",
				seller.getReceipt("Miguel Jordan").toString());

	}
}
