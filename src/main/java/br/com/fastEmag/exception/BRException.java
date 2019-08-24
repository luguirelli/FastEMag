package br.com.fastEmag.exception;

public class BRException extends RuntimeException {

	private static final long serialVersionUID = 4222272929494511256L;

	public BRException() {
		super();
	}

	public BRException(String message, Throwable cause) {
		super(message, cause);
	}

	public BRException(String message) {
		super(message);
	}

	public BRException(Throwable cause) {
		super(cause);
	}
}
