package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String string) {
		accountNo = string;
		System.out.println(string + " 계좌가 개설 되었습니다.");
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void save(int i) {
		System.out.println(getAccountNo() + "에 " + i  + "만원이 입금되었습니다.");
		balance += i;
		
	}

	public void deposit(int i) {
		System.out.println(getAccountNo() + "에 " + i  + "만원이 출금되었습니다.");
		balance -= i;
		
		
	}
	
	
	
	
}
