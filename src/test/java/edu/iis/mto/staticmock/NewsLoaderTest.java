package edu.iis.mto.staticmock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import edu.iis.mto.staticmock.reader.NewsReader;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ConfigurationLoader.class, NewsReaderFactory.class })
public class NewsLoaderTest {

	NewsReaderFactory newsReaderFactory;
	ConfigurationLoader configurationLoader;
	Configuration configuration;
	NewsReader newsReader;

	@Before
	public void setUp() throws Exception {
		// given
		PowerMockito.mockStatic(ConfigurationLoader.class);
		PowerMockito.mockStatic(NewsReaderFactory.class);
		newsReaderFactory = Mockito.mock(NewsReaderFactory.class);
		configurationLoader = Mockito.mock(ConfigurationLoader.class);
		configuration = Mockito.mock(Configuration.class);
		newsReader = new FakeNewsReader();

		// static when
		Mockito.when(ConfigurationLoader.getInstance()).thenReturn(configurationLoader);
		Mockito.when(configurationLoader.loadConfiguration()).thenReturn(configuration);
		Mockito.when(NewsReaderFactory.getReader(Mockito.anyString())).thenReturn(newsReader);
	}

	@Test
	public final void testLoadNews_areIncomingNewsProperlySegragated() {
		// then
		NewsLoader newsLoader = new NewsLoader();
		PublishableNews publishableNews = newsLoader.loadNews();
		assertThat(publishableNews.getSubscribentContent().size(), is(4));
		assertThat(publishableNews.getPublicContent().size(), is(2));
	}

	@Test
	public final void testLoadNews_newsFaktoryReaderIsInvokedWithProperParameter() throws Exception {
		final String OWN_READER_TEST_TYPE = "OWN_TYPE";
		// when
		Mockito.when(configuration.getReaderType()).thenReturn(OWN_READER_TEST_TYPE);
		PowerMockito.whenNew(NewsReaderFactory.class).withNoArguments().thenReturn(newsReaderFactory);

		// then
		new NewsLoader().loadNews();
		PowerMockito.verifyStatic();
		NewsReaderFactory.getReader(OWN_READER_TEST_TYPE);

	}

}
