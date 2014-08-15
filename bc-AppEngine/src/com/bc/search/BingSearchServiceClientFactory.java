package com.bc.search;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.bc.search.impl.BingSearchJsonClientImpl;

/**
 * A factory for creating BingSearchServiceClient objects.
 */
public class BingSearchServiceClientFactory {

    /** The task executor. */
    private ExecutorService taskExecutor = Executors.newCachedThreadPool();
    
    /**
     * Instantiates a new bing search service client factory.
     */
    private BingSearchServiceClientFactory() {}

    /**
     * Sets the task executor.
     * 
     * @param taskExecutor the new task executor
     */
	public void setTaskExecutor(ExecutorService taskExecutor) {
        this.taskExecutor = taskExecutor;
	}

    /**
     * New instance.
     * 
     * @return the bing search service client factory
     */
    public static BingSearchServiceClientFactory newInstance() {
        return new BingSearchServiceClientFactory();
    }
    
    /**
     * Creates a new BingSearchServiceClient object.
     * 
     * @return the bing search client
     */
    public BingSearchClient createBingSearchClient() {
    	BingSearchClient client = new BingSearchJsonClientImpl();
    	((BingSearchJsonClientImpl) client).setTaskExecutor(taskExecutor);
    	return client;
    }
}
