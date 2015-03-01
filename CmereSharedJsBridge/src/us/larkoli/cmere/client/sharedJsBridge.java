package us.larkoli.cmere.client;

import us.larkoli.cmere.shared.Card;

import com.google.gwt.core.client.EntryPoint;

public class sharedJsBridge implements EntryPoint {

	private final Card card = Card.FOUR;

	public void onModuleLoad() {
		exportShared(card);
	}

	private native void exportShared(Card card) /*-{
		var jsCard = card.@us.larkoli.cmere.shared.Card::toString()();

		$wnd.cmereShared = {
			test : "omg so shared right now!!",
			card : jsCard
		};
		if (typeof $wnd.cmereSharedLoaded === 'function') {
			$wnd.cmereSharedLoaded();
		}
	}-*/;
}
