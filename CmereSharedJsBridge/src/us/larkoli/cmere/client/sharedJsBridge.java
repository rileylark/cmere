package us.larkoli.cmere.client;

import com.google.gwt.core.client.EntryPoint;

public class sharedJsBridge implements EntryPoint {

	public void onModuleLoad() {
		exportShared();
	}

	private native void exportShared() /*-{
		$wnd.cmereShared = "omg so shared right now";
		if (typeof $wnd.cmereSharedLoaded === 'function') {
			$wnd.cmereSharedLoaded();
		}
	}-*/;
}
