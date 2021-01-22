package elements;

public class Payment {
	
	public String code;
	public int amount;
	
	public Payment(String code, int amount) {
		super();
		this.code = code;
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}	
}
