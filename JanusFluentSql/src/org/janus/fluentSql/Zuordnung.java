package org.janus.fluentSql;

public class Zuordnung {

	Status vonStatus;
	String inMethode;
	Status nachStatus;
	String put;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((inMethode == null) ? 0 : inMethode.hashCode());
		result = prime * result
				+ ((vonStatus == null) ? 0 : vonStatus.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Zuordnung [vonStatus=" + vonStatus + ", inMethode=" + inMethode
				+ ", nachStatus=" + nachStatus + ", put=" + put + "]";
	}

	public Zuordnung(Status vonStatus, String inMethode, Status nachStatus,
			String put) {
		super();
		this.vonStatus = vonStatus;
		this.inMethode = inMethode;
		this.nachStatus = nachStatus;
		this.put = put;
	}

	public Zuordnung(Status vonStatus, String inMethode, Status nachStatus) {
		this(vonStatus, inMethode, nachStatus, null);
	}

	public Zuordnung(Status status, String inMethode, String put) {
		this(status, inMethode, status, put);
	}

	public Zuordnung(Status status, String inMethode) {
		this(status, inMethode, status, null);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zuordnung other = (Zuordnung) obj;
		if (inMethode == null) {
			if (other.inMethode != null)
				return false;
		} else if (!inMethode.equals(other.inMethode))
			return false;
		if (vonStatus == null) {
			if (other.vonStatus != null)
				return false;
		} else if (!vonStatus.equals(other.vonStatus))
			return false;
		return true;
	}

}
