package edu.iis.mto.staticmock;

import java.util.ArrayList;
import java.util.List;

public class IncomingNewsBuilder {
	private List<IncomingInfo> elems;

	public IncomingNewsBuilder() {
		elems = new ArrayList<IncomingInfo>();
	}

	public IncomingNewsBuilder(IncomingNews incomingNews) {
		elems = new ArrayList<IncomingInfo>();
		this.elems.addAll(incomingNews.elems());
	}

	public IncomingNewsBuilder withElem(IncomingInfo elem) {
		this.elems.add(elem);
		return this;
	}

	public IncomingNewsBuilder withElems(List<IncomingInfo> elems) {
		this.elems.addAll(elems);
		return this;
	}

	public IncomingNews build() {
		IncomingNews incomingNews = new IncomingNews();
		incomingNews.elems().addAll(this.elems);
		return incomingNews;
	}

}
