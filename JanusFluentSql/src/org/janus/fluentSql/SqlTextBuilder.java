package org.janus.fluentSql;

public class SqlTextBuilder {
	private StringBuilder text = new StringBuilder();
	private Status status;
	boolean hasCommas = true;

	public SqlTextBuilder(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public SqlTextBuilder setStatus(Status status) {
		this.status = status;
		return this;
	}

	protected SqlTextBuilder put(String text) {
		this.text.append(text);
		this.text.append(" ");
		return this;
	}

	@Override
	public String toString() {
		if (status.isComplete()) {
			return getTextAtTheEnd();
		} else {
			return fehler();
		}
	}

	public String getText() {
		return text.toString().trim();
	}

	protected String getTextAtTheEnd() {
		return getText();
	}

	protected String fehler() {
		throw new RuntimeException("nicht erlaubt");
	}

	protected SqlTextBuilder append(String beetween, Reduziert... fields) {
		int l = fields.length;
		for (Reduziert field : fields) {
			put(field.getText());
			l--;
			if (l > 0) {
				put(beetween);
			}
		}
		return this;
	}

	public static String getMethodName(int pos) {
		StackTraceElement trace[] = Thread.currentThread().getStackTrace();
		return trace[pos].getMethodName();
	}

	public void changeStatus() {
		changeStatus(null, 4);
	}

	public void changeStatus(String put) {
		changeStatus(put, 4);
	}

	public void changeStatus(String put, int pos) {
		String methode = getMethodName(pos);
		Zuordnung z = ZuordnungsListe.find(status, methode);
		if (z != null) {
			setStatus(z.nachStatus);
			String p = (put == null) ? z.put : put;
			if (p != null) {
				put(p);
			}
		}
	}

	protected String getKommaText() {
		return (status.hasCommas()) ? ", " : "";
	}
}
