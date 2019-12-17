package imooclambda;

public class App5 {
	public static void main(String [] args) {
		IMarkUp mu = (message) -> System.out.println(message);
		mu.markUp("almbda!");
	}

}

interface IMarkUp {
	void markUp(String msg);
}