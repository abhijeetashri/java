public class Escaping {

	private static class UnsafeStates {
		private static String[] states = { "Delhi", "Haryana", "Uttar Pradesh", "Telangana"};

		public String[] getStates() {
			return states;
		}
	}

	public static void main(String[] args) {
		UnsafeStates us = new UnsafeStates();
		String[] indianStates = us.getStates();
		Arrays.stream(indianStates).forEach(System.out::println);
		indianStates[0] = "I changed the value!";
		System.out.println("----------");
		Arrays.stream(indianStates).forEach(System.out::println);

		indianStates = us.getStates();
		System.out.println("----------");
		Arrays.stream(indianStates).forEach(System.out::println);

	}
}
