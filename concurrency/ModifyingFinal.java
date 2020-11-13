import java.util.Arrays;

public class ModifyingFinal {

	private static final class ValueHolder<T> {

		private final T value;

		public ValueHolder(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}
	}

	public static void main(String[] args) {
		ValueHolder<String> stringValueHolder = new ValueHolder<>("Test value");
		System.out.println(stringValueHolder.getValue());

		Arrays.stream(stringValueHolder.getClass().getDeclaredFields()).forEach(field -> {
			if ("value".equals(field.getName())) {
				field.setAccessible(true);
				try {
					field.set(stringValueHolder, "Modified using reflection");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println(stringValueHolder.getValue());
	}
}
