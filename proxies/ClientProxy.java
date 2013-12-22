package moreofeverything.proxies;

import moreofeverything.proxies.CommonProxy;

public class ClientProxy extends CommonProxy {
	/**
	 * This is require since the Client runs OVER Common Proxy, This needs to
	 * override
	 */
	@Override
	public void initRenderers() {

	}

	@Override
	public void initSounds() {

	}
}
