package edu.iis.mto.staticmock;

public class IncomingInfo {

	private String content;
	private SubsciptionType subscriptionType;

	public IncomingInfo(String content, SubsciptionType subscriptionType) {
		super();
		this.content = content;
		this.subscriptionType = subscriptionType;
	}

	public boolean requiresSubsciption() {
		return subscriptionType != SubsciptionType.NONE;
	}

	public String getContent() {
		return content;
	}

	public SubsciptionType getSubscriptionType() {
		return subscriptionType;
	}

}
