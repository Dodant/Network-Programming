package Chapter08;

public class ReturnDigestUserInterfaceB {
	public static void main(String[] args) throws InterruptedException {

		String fileName = "alphabet.txt";
		ReturnDigest thread = new ReturnDigest(fileName);
		thread.start();

		while (true) {
			Thread.sleep(4);
			System.out.println("hel");
			// Now print the result
			byte[] digest = thread.getDigest();
			if (digest != null) {
				for (byte dg : digest)
					System.out.print(dg + " ");
				System.out.println();
				break;
			}
		}
	}
}