package edu.iis.mto.staticmock;

import edu.iis.mto.staticmock.reader.NewsReader;

public class FakeNewsReader implements NewsReader {

	@Override
	public IncomingNews read() {
		return new IncomingNewsBuilder().build();
	}

}
