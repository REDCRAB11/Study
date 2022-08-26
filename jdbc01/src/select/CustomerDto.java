package select;

public class CustomerDto {
	private int customer_no;
	private String customer_id;
	private String customer_phone;
	private String customer_regist;
	private String customer_purchase;
	private int customer_mileage;
	private String customer_grade;
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_regist() {
		return customer_regist;
	}
	public void setCustomer_regist(String customer_regist) {
		this.customer_regist = customer_regist;
	}
	public String getCustomer_purchase() {
		return customer_purchase;
	}
	public void setCustomer_purchase(String customer_purchase) {
		this.customer_purchase = customer_purchase;
	}
	public int getCustomer_mileage() {
		return customer_mileage;
	}
	public void setCustomer_mileage(int customer_mileage) {
		this.customer_mileage = customer_mileage;
	}
	public String getCustomer_grade() {
		return customer_grade;
	}
	public void setCustomer_grade(String customer_grade) {
		this.customer_grade = customer_grade;
	}
	@Override
	public String toString() {
		return "CustomerDto [customer_no=" + customer_no + ", customer_id=" + customer_id + ", customer_phone="
				+ customer_phone + ", customer_regist=" + customer_regist + ", customer_purchase=" + customer_purchase
				+ ", customer_mileage=" + customer_mileage + ", customer_grade=" + customer_grade + "]";
	}
	
	
}
