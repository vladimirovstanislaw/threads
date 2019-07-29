package executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class App {
	ArchiveSearcher search = new ArchiveSearcher() {

		public String search(String target) throws InterruptedException {
			// TODO Auto-generated method stub
			Thread.sleep(1);
			System.out.println("app class | search | anonimus class ArchiveSearcher | current thread name = " + Thread.currentThread().getName());
			return "result";
		}
	};
	ExecutorService exSer = new ForkJoinPool();

	void showSearch(final String target) throws InterruptedException {
		System.out.println("app class | show search | current thread name = " + Thread.currentThread().getName());
		Future<String> future = exSer.submit(new Callable<String>() {

			public String call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("app class | showSearch | anonimus class callable | current thread name = " + Thread.currentThread().getName());
				return search.search("blablabla");
			}
		});
		while (!future.isDone()) {
			System.out.println("app class | showSearch | !future.isDone() | current thread name = " + Thread.currentThread().getName());
			System.out.println("do rezultata");

		}
		try {
			System.out.println("app class | showSearch | future.isDone() | current thread name = " + Thread.currentThread().getName());
			System.out.println(future.get());
		} catch (ExecutionException ex) {
			System.out.println("pizdariki");
			return;
		}
	}

}
