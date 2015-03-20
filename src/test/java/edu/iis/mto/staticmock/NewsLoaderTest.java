package edu.iis.mto.staticmock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testLoadNews_areIncomingNewsProperlySegragated() {
		// given
		PowerMockito.mockStatic(ConfigurationLoader.class);
		PowerMockito.mockStatic(NewsReaderFactory.class);
		ConfigurationLoader configurationLoader = Mockito.mock(ConfigurationLoader.class);
		Configuration configuration = Mockito.mock(Configuration.class);

		NewsReader newsReader = new FakeNewsReader();

		// when
		Mockito.when(ConfigurationLoader.getInstance()).thenReturn(configurationLoader);
		Mockito.when(configurationLoader.loadConfiguration()).thenReturn(configuration);
		Mockito.when(NewsReaderFactory.getReader(Mockito.anyString())).thenReturn(newsReader);

		// then
		NewsLoader newsLoader = new NewsLoader();
		PublishableNews publishableNews = newsLoader.loadNews();
		assertThat(publishableNews.getSubscribentContent().size(), is(4));
		assertThat(publishableNews.getPublicContent().size(), is(2));
	}

}
