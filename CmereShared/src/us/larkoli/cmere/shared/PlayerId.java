package us.larkoli.cmere.shared;

public enum PlayerId {
	PLAYER_A, PLAYER_B;
	
	public PlayerId otherPlayer() {
		if (this.equals(PLAYER_A)) {
			return PLAYER_B;
		} else {
			return PLAYER_A;
		}
	}
}
