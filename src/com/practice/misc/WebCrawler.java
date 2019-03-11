package com.practice.misc;

public class WebCrawler {
	private static final int MAX_URL_QUEUE = 3000;
	private final Object lock = new Object();
	private List<Thread> threads;

	private int currentURLNum = 0;
	private final int MAXURL;
	private Queue<String> urlQqueue;

	private URLGroup crawledURLs;
	private WordExtractor words;

	public WebCrawler(String start, int max, int threads) {
		this.MAXURL = max;
		urlQqueue = new LinkedList<String>();
		urlQqueue.offer(start);
		this.threads = new ArrayList<Thread>();

		words = new WordExtractor();
		for (int i = 0; i < threads; i++) {
			this.threads.add(new Thread(new CrawlTask(this, words)));
		}
		crawledURLs = new URLGroup();
	}

	public void run() {
		for (Thread t : threads) {
			t.start();
		}
		boolean allThreadsDead = false;
		while (!allThreadsDead) {
			allThreadsDead = true;
			for (int i = 0; i < threads.size(); i++) {
				if (threads.get(i).isAlive()) {
					Thread.yield();
					i = 0;
					allThreadsDead = false;
				}
			}
		}
	}

	static class CrawlTask implements Runnable {
		private final WebCrawler bot;
		private final WordExtractor words;

		public CrawlTask(WebCrawler bot, WordExtractor words) {
			this.bot = bot;
			this.words = words;
		}

		@Override
		public void run() {
			URLGroup group = new URLGroup();
			while (bot.currentURLNum < bot.MAXURL) {
				String url = bot.urlQqueue.poll();
				if (url == null) {
					Thread.yield();
					continue;
				}
				Document doc = null;
				try {
					doc = bot.getDocument(url.toString(), 3000);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
				words.extractFromDocument(doc);
				List<String> urls = new LinkExtractor().extractFromDocument(doc).getCollectedURLs();

				synchronized (bot.lock) {
					bot.currentURLNum++;
					group.add(url);
					for (String u : urls) {
						if (bot.urlQqueue.size() > MAX_URL_QUEUE) {
							break;
						}
						bot.urlQqueue.offer(u);
					}
					System.out.println(bot.currentURLNum);
				}
			}
			for (String u : group.urls) {
				bot.crawledURLs.add(u);
			}
			System.out.println(Thread.currentThread() + " is done!");
		}

	}

	private Document getDocument(String url, int timeout) throws IOException {
		return Jsoup.connect(url).timeout(timeout).get();
	}

	// The Main Entry-point
	public static void main(String[] args) throws IOException { 
      String startingUrl = "http://en.wikipedia.org/wiki/Special:Random";

      WebCrawler bot = new WebCrawler(startingUrl, 50, 10);
      bot.run();
      bot.crawledURLs.printCrawled(System.out);
      bot.words.printTopWords(System.out, 30);
  }