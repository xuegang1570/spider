package com.mzh.job;

import java.util.List;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

public class StackJob implements DataflowJob<String>{

	@Override
	public List<String> fetchData(ShardingContext shardingContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processData(ShardingContext shardingContext, List<String> data) {
		// TODO Auto-generated method stub
		
	}

}
