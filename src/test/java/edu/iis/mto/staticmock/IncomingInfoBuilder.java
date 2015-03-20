package edu.iis.mto.staticmock;

public class IncomingInfoBuilder {
	private String content;
	private SubsciptionType subscriptionType;

	public IncomingInfoBuilder() {
		content = "not important";
		subscriptionType = SubsciptionType.A;
	}

	public IncomingInfoBuilder(IncomingInfo bean) {
		this.content = bean.getContent();
		this.subscriptionType = bean.getSubscriptionType();
	}

	public IncomingInfoBuilder withContent(String content) {
		this.content = content;
		return this;
	}

	public IncomingInfoBuilder withSubscriptionType(SubsciptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
		return this;
	}

	public IncomingInfo build() {
		return new IncomingInfo(content, subscriptionType);
	}

}
