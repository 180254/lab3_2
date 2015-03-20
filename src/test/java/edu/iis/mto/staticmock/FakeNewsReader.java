package edu.iis.mto.staticmock;

import edu.iis.mto.staticmock.reader.NewsReader;

public class FakeNewsReader implements NewsReader {

	@Override
	public IncomingNews read() {
		return new IncomingNewsBuilder()
				.withElem(new IncomingInfoBuilder().withSubscriptionType(SubsciptionType.A).build())
				.withElem(new IncomingInfoBuilder().withSubscriptionType(SubsciptionType.A).build())
				.withElem(new IncomingInfoBuilder().withSubscriptionType(SubsciptionType.B).build())
				.withElem(new IncomingInfoBuilder().withSubscriptionType(SubsciptionType.C).build())
				.withElem(new IncomingInfoBuilder().withSubscriptionType(SubsciptionType.NONE).build())
				.withElem(new IncomingInfoBuilder().withSubscriptionType(SubsciptionType.NONE).build())
				.build();
	}

}
