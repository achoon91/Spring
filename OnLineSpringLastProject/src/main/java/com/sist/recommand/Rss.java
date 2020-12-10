package com.sist.recommand;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlElement
public class Rss {
	private Channel channel=new Channel();

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
}
